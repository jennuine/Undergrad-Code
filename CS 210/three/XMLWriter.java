/**
 * @author Jenn Nguyen
 * XMLWriter.java
 */
package three;

import database.Database;

import java.io.*;

/**
 * Creates a XML file
 */
public class XMLWriter {
	private String xml;

	/**
	 * Creates a XML from the database
	 */
	public XMLWriter() 
	{
		xml = Database.getDB().toXML();
	}

	/**
	 * Creates an XML file containing the data from the database
	 * @param str the string filename
	 * @throws IOException 
	 */
	public void write(String str) throws IOException 
	{		
		new File("Database/XML").mkdir();

		PrintWriter out = new PrintWriter(new FileOutputStream("Database/XML/" + str));
		out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		out.println("<!DOCTYPE TABLES SYSTEM \"database.dtd\">");
		out.println(xml);

		out.close();	
		
		writeDTD();
	}
	
	/**
	 * Creates a DTD file
	 * @throws FileNotFoundException 
	 */
	public void writeDTD() throws FileNotFoundException 
	{
		PrintWriter dtdOut = new PrintWriter(new FileOutputStream("Database/XML/database.dtd"));
		dtdOut.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<!ELEMENT DATABASE (TABLE*)>");
		dtdOut.println("<!ELEMENT TABLE (TABLENAME*)>\n<!ELEMENT TABLENAME (#PCDATA)>");
		dtdOut.println("<!ELEMENT FIELD (FIELDTYPE,FIELDNAME)>\n<!ELEMENT FIELDTYPE (VALUE)>\n<!ELEMENT FIELDTYPE (#PCDATA)>");
		dtdOut.println("<!ELEMENT FIELDNAME (#PCDATA)>\n<!ATTLIST DATABASE");
		dtdOut.println("\tTABLENAME CDATA #REQUIRED\n\tFIELDTYPE CDATA #REQUIRED\n\tFIELDNAME CDATA #REQUIRED\n\t>");
		dtdOut.close();
	}
}