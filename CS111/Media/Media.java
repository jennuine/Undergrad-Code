//Media.java
//cs111 jqnguyen

public abstract class Media {

    private String title;
    private Artist majorArtist;
    private int numPlays;
    private int playTime;

    /**preconditions: tit is a valid String, art is a valid Artist, time is a valid integer
       postconditions: tit => title, art => majorArtist, time => playTime, numPlays starts at zero
       @param tit -- the title
       @param art -- the major artist
       @param time -- the playing time
       responses -- error terminate*/
    public Media(String tit, Artist art, int time) {
	title = tit;
	majorArtist = art;
	playTime = time;
	numPlays = 0;
    }
    /**Function that will return Media type in subclasses
       preconditions: must be of type Media
       postconditions: will return Media type as a String
       responses -- error terminate*/
    public abstract String getType();

    /**preconditions: must be of type Media, valid title, valid playtime
       postconditions: will increment number of plays for media, as well as print out title and playtime
       responses -- error terminate*/
    public void playMedia() {
	numPlays++;
        System.out.print("\n\nNow Playing: \n\t\tTitle: " + title + "\n\t\tPlay Time: " + playTime);
    }

    /**preconditions: type Media, valid title
     postconditions: will return String title
    responses -- error terminate*/
    public String getTitle() {
	return title;
    }

    /**preconditions: type Media, valid titlePlayTime
     postconditions: will return int playtime
    responses -- error terminate*/
    public int getPlayTime() {
	return playTime;
    }

    /**preconditions: type Media, valid major artist
       postconditions: will return artist major artist information
       responses -- error terminate*/
    public Artist getMajorArtist() {
	return majorArtist;
    }

    /**preconditions: type Media, valid number of plays
     postconditions: will return int number of plays
    responses -- error terminate*/
    public int getNumPlays() {
	return numPlays;
    }

    /**preconditions: type Media, valid title, valid majorArtist, valid playTime, valid numPlays
       postconditions: will return String of title, majorArtist, playTime, and numPlays
       responses -- error terminate*/
    public String toString() {
	return ("\nTitle: " + title + "\nMajor Artist: " + majorArtist + "\nPlay Time: " + playTime + "\nTotal Number of Plays: " + numPlays);
    }
}
