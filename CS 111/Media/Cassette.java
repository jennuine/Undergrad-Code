//Cassette.java
import java.util.Arrays;

public class Cassette extends Audio {
    
    private String[] songs;
    private int numSongs;

    //default constructor
    public Cassette() {
	super();
	numSongs = 1;
	songs = new String[numSongs];
	songs[0] = "SONG";
    }

    //constructor
    public Cassette(String tit, Artist art, int time, int numMems, Artist[] mems, Artist prod, int numS, String[] s) {
	super(tit, art, time, numMems, mems, prod);
	numSongs = numS;
	songs = new String[numSongs];
	songs = s;
    }

    public String getType() {
	return (super.getType() + ": Cassette");
    }
    
    public void playMedia() {
	super.playMedia();
    }

    public String toString() {
	return (super.toString() + "Number of Songs: " + numSongs
		+ "\nSongs: " + Arrays.toString(songs) + "\n");
    }
}
