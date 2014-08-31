//MediaLib.java
//CS111 jqnguyen
//application class
import java.util.Scanner;
import java.util.ArrayList;

public class MediaLib {

    public static Scanner input = new Scanner(System.in);
    public static ArrayList<Media> collection = new ArrayList<Media>();
   
    public static void main(String[] args) {
	
	boolean result = false;

       	while(!result) {
	    menu();
	    int option = input.nextInt();

	    switch (option) {
	    case 1:
	        pl("\n\n\t\t~ Creating a New DVD to Add to Media ~\n");
		DVD newDVD = createDVD();
		collection.add(newDVD);
		
		hitEnter();
		break;
	    case 2: 
	        pl("\n\n\t\t~ Creating a New CD to Add to Media ~\n");
		CD newCD = createCD();
		collection.add(newCD);

		hitEnter();
		break;
	    case 3:
		pl("\n\n\t\t~ Creating a New VHS to Add to Media ~\n");
		VHS newVHS = createVHS();
		collection.add(newVHS);

		hitEnter();
		break;
	    case 4:
		pl("\n\n\t\t~ Creating a New Cassette to Add to Media ~\n");
		Cassette newCassette = createCassette();
		collection.add(newCassette);

		hitEnter();
		break;
	    case 5:  
		if (collection.isEmpty())
		    pl("\nThe Media is empty! Add some stuff!");

		else {
		    pl("\nAll the Media in the Collection:\n");
		    for (Media stuff : collection) {
			pl("In Slot #" + collection.indexOf(stuff) + "\n<< " + stuff.getType() + " >>");
			pl("Title: " + stuff.getTitle() + "\nPlay Time: " + stuff.getPlayTime() + " minutes");
			pl("Total number of plays: " + stuff.getNumPlays() + "\n"); }
		}//else
		hitEnter();
		break;
	    case 6:
		listMedia();
		hitEnter();
		break;
	    case 7:        
	        listMA();
		hitEnter();
		break;
	    case 8:
		chooseMedia();
		hitEnter();
		break;
	    case 9:
		listPlays();
		hitEnter();
		break;
	    case 10:
		pl("\n\tGoodbye!   ｡・ﾟﾟ・(＞Ｏ＜)・ﾟﾟ・｡   Come back soon!\n\n");
		result = false;
		System.exit(0);
		break;
	    default: 
		pl("\n  ARGH!\n\t (╯°□°)╯︵ ┻━┻ \n\t\tTHAT WAS AN INVALID SELECTION!\n\t\t\tPlease try again");
		hitEnter();
		break;
	    }//switch
	}//while
    }//main

    public static boolean checkDVD() {
	for (Media media : collection) {if (media instanceof DVD) return true;} return false; }

    public static boolean checkCD() {
	for (Media media : collection) {if (media instanceof CD) return true;} return false; }

    public static boolean checkVHS() {
	for (Media media : collection) {if (media instanceof VHS) return true;} return false; }

    public static boolean checkCas() {
	for (Media media : collection) {if (media instanceof Cassette) return true;} return false; }
  
    public static void printDVD() {
	if (!checkDVD()) pl("Sorry there are no DVDs");
	else {
	    pl("- Your DVDs -\n");
	    for (Media media : collection) 
		if (media instanceof DVD) pl("In Slot " + collection.indexOf(media) + ": " + media.getTitle() + "\n"); }
    }

    public static void printCD() { 
	if (!checkCD()) pl("Sorry there are no CDs");
	else {
	    pl("- Your CDs -\n");
	    for (Media media : collection) 
		if (media instanceof CD) pl("In Slot " + collection.indexOf(media) + ": " + media.getTitle() + "\n"); }
    }

    public static void printVHS() { 
	if (!checkVHS()) pl("Sorry there are no VHSes");
	else {
	    pl("- Your VHSes -\n");
	    for (Media media : collection) 
		if (media instanceof VHS) pl("In Slot " + collection.indexOf(media) + ": " + media.getTitle() + "\n"); }
    }
    
    public static void printCas() {
	if (!checkCas()) pl("Sorry there are no Cassettes");
	else {
	    pl("- Your Cassettes -\n");
	    for (Media media : collection) 
		if (media instanceof Cassette) pl("In Slot " + collection.indexOf(media) + ": " + media.getTitle() + "\n"); }
    }

    public static void listPlays() {
	if (collection.isEmpty()){ pl("Sorry, there is no media in the collection");}
	else {
	    pl("\n\n\t~ Which Media# would you like to view? ~\n\t\t(1) - DVD\n\t\t(2) - CD\n\t\t(3) - VHS\n\t\t(4) - Cassette");
	    int choice = takeInputInt();
	    switch(choice) {
	    case 1: 
		if (!checkDVD()) { pl("Sorry there are no DVDs"); break;}
		else {
		    pl("- The Total Number of Plays for Each DVD -\n");
		    for (Media media : collection) 
			if (media instanceof DVD) 
			    pl(media.getTitle() + " played " + media.getNumPlays() + "x\n"); break; }
	    case 2: 
		if (!checkCD()) { pl("Sorry there are no CDs"); break;}
		else {
		    pl("- The Total Number of Plays for Each CD -\n");
		    for (Media media : collection) 
			if (media instanceof CD) 
			    pl(media.getTitle() + " played " + media.getNumPlays() + "x\n"); break;}
	    case 3: 
		if (!checkVHS()) { pl("Sorry there are no VHSes"); break;}
		else {
		    pl("- The Total Number of Plays For Each VHS -\n");
		    for (Media media : collection) 
			if (media instanceof CD) 
			    pl(media.getTitle() + " played " + media.getNumPlays() + "x\n"); break;}
	    case 4:
		if (!checkCas()) { pl("Sorry there are no Cassettes"); break;}
		else {
		    pl("- The Total Number of Plays For Each Cassette -\n");
		    for (Media media : collection) 
			pl(media.getTitle() + " played " + media.getNumPlays() + "x\n"); break;}
	    default: pl("Invalid option"); break;
	    }//switch
	}//else
    }//listPlays
    
    public static void listMedia() {
	if (collection.isEmpty()) pl("Sorry, there is no media in the collection"); 	
	else {
	    pl("\n\n\t~ Which Media# would you like to view? ~\n\t\t(1) - DVD\n\t\t(2) - CD\n\t\t(3) - VHS\n\t\t(4) - Cassette");
	    int choice = takeInputInt();
	    switch(choice) {
	    case 1: printDVD(); break;
	    case 2: printCD(); break;
	    case 3: printVHS(); break;
	    case 4: printCas(); break;
	    default: pl("Sorry that was an invalid choice"); break; }
	}//switch
    }//listMedia

    public static void listMA() {
	if (collection.isEmpty()){ pl("Sorry, there is no media in the collection");}
	else {
	    pl("\n\n\t~ Which Media# would you like to view? ~\n\t\t(1) - DVD\n\t\t(2) - CD\n\t\t(3) - VHS\n\t\t(4) - Cassette");
	    int choice = takeInputInt();
	    switch(choice) {
	    case 1: 
		if (!checkDVD()) { pl("Sorry there are no DVDs"); break;}
		else {
		    pl("- Major Artists in DVDs -\n");
		    for (Media media : collection) 
			if (media instanceof DVD) 
			    pl(media.getMajorArtist()); break; }
	    case 2: 
		if (!checkCD()) { pl("Sorry there are no CDs"); break;}
		else {
		    pl("- Major Artists in CDs -\n");
		    for (Media media : collection) 
			if (media instanceof CD) 
			    pl(media.getMajorArtist()); break;}
	    case 3: 
		if (!checkVHS()) { pl("Sorry there are no VHSes"); break;}
		else {
		    pl("- Major Artists in VHSes -\n");
		    for (Media media : collection) 
			if (media instanceof CD) 
			    pl(media.getMajorArtist()); break;}
	    case 4:
		if (!checkCas()) { pl("Sorry there are no Cassettes"); break;}
		else {
		    pl("- Major Artists in Cassettes -\n");
		    for (Media media : collection) 
			pl(media.getMajorArtist()); break;}
	    default: pl("Invalid option"); break;
	    }//switch
	}//else
    }//listPlays
    

    public static void chooseMedia() {
	pl("\n\n\t~ Which Media#  would you like to play? ~\n\t\t(1) - DVD\n\t\t(2) - CD\n\t\t(3) - VHS\n\t\t(4) - Casette");
	int choice = takeInputInt();
	int option = 0;

	switch (choice) {
	case 1: 
	    if (!checkDVD()) {pl("Sorry there are no DVDs"); break;}
	    else printDVD();

	    pl("\nEnter the slot number of the DVD you would like to play");
	    option = takeInputInt(); 
		   
	    for (Media media: collection)
		if (media instanceof DVD)
		    if (option == collection.indexOf(media)) { 
			(collection.get(option)).playMedia(); break;
		    } else pl("Sorry, that was an invalid option"); break;
	case 2: 
	    if (!checkCD()) {pl("Sorry there are no CDs"); break;}
	    else printCD();
	    
	    pl("\nEnter the slot number of the CD you would like to play");
	    option = takeInputInt();
	    
	    for (Media media: collection)
		if (media instanceof CD)
		    if (option == collection.indexOf(media)) { 
			(collection.get(option)).playMedia(); 
		    } else pl("Sorry, that was an invalid option"); break;
	case 3:
	    if (!checkVHS()) {pl("Sorry there are no VHSes"); break;}
	    else printVHS();
		
	    pl("\nEnter the slot number of the VHS you would like to play");
	    option = takeInputInt();
		   
	    for (Media media: collection)
		if (media instanceof VHS)
		    if (option == collection.indexOf(media)) { 
			(collection.get(option)).playMedia(); 
		    } else pl("Sorry, that was an invalid option"); break;
	case 4: 
	    if (!checkCas()) {pl("Sorry there are no Cassettes"); break;}
	    else printCas();
		
	    pl("\nEnter the slot number of the Cassette you would like to play");
	    option = takeInputInt();
		   
	    for (Media media: collection)
		if (media instanceof VHS)
		    if (option == collection.indexOf(media)) { 
			(collection.get(option)).playMedia(); 
		    } else pl("Sorry, that was an invalid option"); break;
	  
	default: pl("That was an invalid option."); break; }//switch
    }//chooseMedia

    public static DVD createDVD() {
	pl("Please enter the following. . .\nThe Title:");
	input.nextLine();
	String title = input.nextLine();
	pl("The Playing Time: (minutes only)");
	int pTime = takeInputInt();
	pl("\nNow Enter the Details of the Major Artist");
	Artist artist = createArtist();	
	pl("\nNow Enter the Details of the Director");	
	Artist director = createArtist();
	pl("The Rating:");
	String rating = takeInputString();
	pl("The WideScreen Format:");
	double wSFormat = takeInputDouble();
	    
	boolean tvFormat = false;
	boolean answer = false;
	while (!answer) {
	    pl("The TV Format:\n\tIs it in HD or Regular? (Enter \"y\" for yes or \"n\" for no)");
	    String letter = input.next();
	    if (letter.equals("y")) {
		tvFormat = true;
		answer = true;
	    } else if (letter.equals("n")) {
		tvFormat = false;
		answer = true;
	    } else pl("Invalid input please try again.\n");
	}//while
	
	pl("\nNow Enter the Details of the Special Features\nThe Number of Special Features:");
	int numSF = takeInputInt();
	
	String[] sFeatures = new String[numSF];
	input.nextLine();
	for (int i = 0; i < sFeatures.length; i++) {
	    pl("Enter the details of Special Feature #" + (i+1));
	    String details = input.nextLine();
	    sFeatures[i] = details; }//for
	
	pl("\nNow Enter the Details of the Sound Options\nThe Number of Sound Items");
	int sound = takeInputInt();
	
	String[] sOpt = new String[sound];
	input.nextLine();
	for (int i = 0; i < sOpt.length; i++) {
	    pl("Enter the details of of Sound Option #" + (i+1) + ":");
	    String details = input.nextLine();
	    sOpt[i] = details; }//for

	pl("\nNow Enter the Details of the Supporting Actors\nThe Number of Actors");
	int numAct = takeInputInt();

	Artist[] actors = new Artist[numAct];
	for (int i = 0; i < actors.length; i++) {
	    pl("The Details of Actor #" + (i+1) + ":");
	    Artist newActor = createArtist();
	    actors[i] = newActor;
	    System.out.println(); }//for
	return (new DVD(title, artist, pTime, numAct, actors, director, rating, numSF, sFeatures, wSFormat, tvFormat, sound, sOpt));
    }//end createDVD

    public static CD createCD() {
	pl("Please enter the following. . .\nThe Album Title:");
	input.nextLine();
	String title = input.nextLine();
	pl("The Total Album Playing Time: (minutes only)");
	int pTime = takeInputInt();	
	pl("\nNow Enter the Details of the Major Artist");
	Artist artist = createArtist();
	pl("\nNow Enter the Details of the Producer");
	Artist producer = createArtist();
	pl("\nNow Enter the Details of the Tracks\nThe Number of Items:");
	int numTracks = takeInputInt();
	
	String[] trackDetails = new String[numTracks];
	Double[] trackMins = new Double[numTracks];
	input.nextLine();
	for (int i = 0; i < trackDetails.length; i++) {
	    pl("The Details/Title of Track #" + (i+1) + ":");
	    String details = input.nextLine();
	    trackDetails[i] = details;
	    System.out.println();
	    
	    pl("The Play Time of Track #" + (i+1) + " as 00.00 (minutes.seconds):");
	    double mins = takeInputDouble();
	    trackMins[i] = mins;
	    System.out.println();
	    input.nextLine(); }//for

	pl("\nNow Enter the Details of the Group Members\nThe Number of Members:");
	int numMems = input.nextInt();

	Artist[] mems = new Artist[numMems];
	for (int i = 0; i < mems.length; i++) {
	    pl("The Details of Member #" + (i+1) + ":");
	    Artist newMem = createArtist();
	    mems[i] = newMem;
	    System.out.println(); }//for
	return (new CD(title, artist, pTime, numMems, mems, producer, numTracks, trackDetails));
    }//end createCD

    public static VHS createVHS() {
	pl("Please enter the following. . .\nThe Title:");
	input.nextLine();
	String title = input.nextLine();
	pl("The Playing Time: (minutes only)");
	int pTime = takeInputInt();
	pl("The Rating:");
	String rating = takeInputString();
	pl("\nNow Enter the Details of the Major Artist");
	Artist artist = createArtist();
	pl("\nNow Enter the Details of the Director");
	Artist director = createArtist();
	pl("\nNow Enter the Details of the Supporting Actors\nThe Number of Actors");
	int numAct = takeInputInt();

	Artist[] actors = new Artist[numAct];
	for (int i = 0; i < actors.length; i++) {
	    pl("The Details of Actor #" + (i+1) + ":");
	    Artist newActor = createArtist();
	    actors[i] = newActor;
	    System.out.println(); }//for

	pl("Now Enter the Number of Trailers");
	int numT = takeInputInt();

	String[] trailers = new String[numT];
	for (int i = 0; i < trailers.length; i++) {
	    pl("The details for Trailer #" + (i+1) + ":");
	    String details = input.nextLine();
	    trailers[i] = details;
	    System.out.println();
	    input.nextLine(); }//for
	return (new VHS(title, artist, pTime, numAct, actors, director, rating, numT, trailers));
    }//end createVHS

    public static Cassette createCassette() {
	pl("Please enter the following. . .\nThe Title:");
	input.nextLine();
	String title = input.nextLine();
	pl("The Playing Time:");
	int pTime =takeInputInt();
	pl("\nNow Enter the Details of the Major Artist");
	Artist artist = createArtist();
	pl("\nNow Enter the Details of the Producer:");
	Artist producer = createArtist();
	pl("\nNow Enter the Details of the Songs\nThe Number of Songs:");
	int numSongs = takeInputInt();

	String[] songs = new String[numSongs];
	Double[] songMins = new Double[numSongs];
	input.nextLine();
	for (int i = 0; i < songs.length; i++) {
	    pl("The Title of Song #" + (i+1) + ":");
	    songs[i] = input.nextLine();
	    System.out.println();
	    
	    pl("The Play Time of Song #" + (i+1) + " as 00.00 (minutes.seconds):");
	    songMins[i] = takeInputDouble();
	    System.out.println();
	    input.nextLine(); }//for

	pl("\nNow Enter the Details of the Group Members\nThe Number of Members:");
	int numMems = takeInputInt();

	Artist[] mems = new Artist[numMems];
	for (int i = 0; i < mems.length; i++) {
	    pl("The Details of Member #" + (i+1) + ":");
	    Artist newMem = createArtist();
	    mems[i] = newMem;
	    System.out.println(); }//for
	return (new Cassette(title, artist, pTime, numMems, mems, producer, numSongs, songs));
    }//end createCassette

    public static Artist createArtist() {
	pl("Their Firstname and Lastname:");
	String first = takeInputString();
	String last = takeInputString();
	pl("Their Birth Month: (as double digits)");
	int month = takeInputInt();
	pl("Their Birth Day: (as double digits)");
	int day = takeInputInt();
	pl("Their Birth Year: (the full 4 digit year)");
	int year = takeInputInt();
	pl("Twitter:");
	String twitter = takeInputString();
	pl("URL:");
	String uRL = takeInputString();
	 
	return (new Artist(last, first, new Date(month, day, year), twitter, uRL));
    }//end createArtist
    
    public static void menu() {
	System.out.printf("%-10s", "\n ------------------------------------------------------------------ \n");
	System.out.printf("%-10s %58s", "|","|\n");
	System.out.printf("%-10s %58s", "|","|\n");
	System.out.printf("%-13s %s %13s", "|","(~◕ヮ◕)~  WELCOME GOOD LOOKING! ~(◕ヮ◕~) ","|\n");
	System.out.printf("%-10s %58s", "|","|\n");
	System.out.printf("%-6s %5s %10s", "|","♪ ~(･o･)~ ♪ (/･o･)/ ♪ ~(･o･)~ ♪ \\(･o･\\) ♪ ~(･o･)~ ♪","|\n");
	System.out.printf("%-10s %58s", "|","|\n");
	System.out.printf("%-10s %s %10s", "|","Please choose a number from the following menu:","|\n");
	System.out.printf("%-10s %58s", "|","|\n");
	System.out.printf("%-10s", "|------------------------------------------------------------------|\n");
	System.out.printf("%-10s %58s", "|","|\n");
	System.out.printf("%-10s %5s %41s", "|","(1) - Create DVD","|\n");
	System.out.printf("%-10s %5s %41s", "|","(2) - Create CD ","|\n");
	System.out.printf("%-10s %5s %41s", "|","(3) - Create VHS","|\n");
	System.out.printf("%-10s %5s %37s", "|","(4) - Create Casette","|\n");
	System.out.printf("%-10s %5s %34s", "|","(5) - Display All Media","|\n");
	System.out.printf("%-10s %5s %12s", "|","(6) - Display All Data for a Particular Media","|\n");
	System.out.printf("%-10s %5s %23s", "|","(7) - Display Data of Major Artist","|\n");
	System.out.printf("%-10s %42s %15s", "|","of a Particular Media","|\n");
	System.out.printf("%-10s %5s %28s", "|","(8) - Play a Particular Media","|\n");
	System.out.printf("%-10s %5s %10s", "|","(9) - Get Number of Plays of a Particular Media","|\n");
	System.out.printf("%-10s %5s %46s", "|","(10) - EXIT","|\n");
	System.out.printf("%-10s %58s", "|","|\n");
	System.out.printf("%-10s", " ------------------------------------------------------------------ \n");
    }//menu
    
    public static void pl(Object words) { System.out.println(words); }
   
    public static void p(Object words) { System.out.print(words); }
    
    public static void hitEnter() {
	pl("\n\n~ Hit enter to return to the menu");
	new Scanner(System.in).nextLine(); }

    public static int takeInputInt() {
	boolean option = false;
	int a = 0;

	while(!option) {
	    try {
		String word = input.next();
		a = Integer.parseInt(word);
		option = true;
	    } catch (Exception e) {
		System.out.println("\nSorry, that is an invalid number.  Please try again");}
	}//while
	System.out.println();
	return a;
    }//takeIntputInt

    public static double takeInputDouble() {
	boolean option = false;
	double b = 0;

	while(!option) {
	    try {
		String word = input.next();
		b = Double.parseDouble(word);
		option = true;

	    } catch (Exception e) {
		System.out.println("\nSorry, that is an invalid input.  Please try again");}
	}//while
	System.out.println();
	return b;
    }//takeInputDouble

    public static String takeInputString() {
	boolean option = false;
	String word = null;

	while(!option) {
	    try {
		word = input.next();
		option = true;
	    } catch (Exception e) {
		System.out.println("That is an invalid input.  Please try again"); }//try/catch
	}//while
	System.out.println();
	return word;
    }//takeInputString
}//end MediaLib
