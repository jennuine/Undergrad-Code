//CD.java
import java.util.Arrays;

public class CD extends Audio {
    
    private String[] tracks;
    private int numTracks;

    //default constructor
    public CD() {
	super();
	numTracks = 1;
	tracks = new String[numTracks];
	tracks[0] = "TRACK";
    }
    
    //constructor
    public CD(String tit, Artist art, int time, int numMems, Artist[] mems, Artist prod, int numT, String[] tr) {
	super(tit, art, time, numMems, mems, prod);
	numTracks = numT;
	tracks = new String[numTracks];
	tracks = tr;
    } 

    public String getType() {
	return (super.getType() + ": CD");
    }

    public void playMedia() {
	super.playMedia();
    }

    public String toString() {
	return (super.toString() + "Number of Tracks: " + numTracks 
		+ "\nTracks: " + Arrays.toString(tracks) + "\n");
    }
}
