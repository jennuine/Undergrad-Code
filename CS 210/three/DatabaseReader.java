/**
 * @author Jenn Nguyen
 * DatabaseReader.java
 */
package three;

import database.Database;
import one.AllExceptions;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.FileNotFoundException;
import java.io.IOException;


/**
 * Reads a stored database in a XML file
 */
public class DatabaseReader {
	private String tName, fName, fType = "";
	private boolean tableName, field, fieldName, fieldType, fieldValue= false;
	private int num;

	/**
	 * Parses the XML file
	 * @param str the string filename
	 * @throws SAXException
	 * @throws IOException
	 */
	public void saxReader(String str) throws SAXException, IOException
	{
		XMLReader reader = XMLReaderFactory.createXMLReader();
		reader.setContentHandler(new DatabaseContentHandler());

		reader.parse(str);
	}

	/**
	 * Handles the XML file's data to store in the Database
	 */
	private class DatabaseContentHandler extends DefaultHandler
	{

		/**
		 * When at the start of the qualified element sets boolean variable to true 
		 */
		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException 
		{	
			if (qName.equals("TABLENAME")) tableName = true;
			else if (qName.equals("FIELD")) field = true;
			else if (qName.equals("FIELDNAME")) fieldName = true;
			else if (qName.equals("FIELDTYPE")) fieldType = true;
			else if (qName.equals("VALUE")) fieldValue = true;
		}

		/**
		 * When at the end of the qualified element sets boolean variable to false
		 */
		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException
		{
			if (qName.equals("TABLENAME")) tableName = false;
			else if (qName.equals("FIELD")) field = false;
			else if (qName.equals("FIELDNAME")) fieldName = false;
			else if (qName.equals("FIELDTYPE")) fieldType = false;
			else if (qName.equals("VALUE")) fieldValue = false;
		}

		/**
		 * Stores the characters in the correct variable location and creates the tables
		 */
		@Override
		public void characters(char[] ch, int start, int length) throws SAXException
		{
			String str = new String(ch, start, length);

			if (tableName) 
			{
				tName = str;
				try { Database.getDB().addTable(str); }
				catch (AllExceptions | FileNotFoundException e) { System.out.println("<<XML>> " + e.getMessage()); }
			}
			else if (field)
			{
				if (fieldName) fName = str;
				else if (fieldType)
				{
					fType = str;
					try { if (!str.equals("char")) 
						Database.getDB().getTable(tName).addField(fType, fName); } 
					catch (AllExceptions e) { System.out.println("<<XML>> " + e.getMessage()); }
				}
				else if (fieldValue) 
				{
					num = Integer.parseInt(str);
					try { Database.getDB().getTable(tName).addField(fType + "(" + num + ")", fName); } 
					catch (AllExceptions e) { System.out.println("<<XML>> " + e.getMessage()); }
				}
			}
		}
	}
}
