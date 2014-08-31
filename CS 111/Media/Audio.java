//Audio.java
import java.util.Arrays;

public abstract class Audio extends Media {
    
    private Artist[] groupMembers;
    private int numMembers;
    private Artist producer;

    //default constructor
    public Audio() {
	super();
	numMembers = 1;
	groupMembers = new Artist[numMembers];
	groupMembers[0] = new Artist();
	producer = new Artist();
    }
    
    //constructor
    public Audio(String tit, Artist art, int time,  int numMems, Artist[] mems, Artist prod) {
	super(tit, art, time);
	numMembers = numMems;
	groupMembers = new Artist[numMembers];
	groupMembers = mems;
	producer = prod;
    }

    public String getType() {
	return ("AUDIO");
    }

    public void playMedia() {
	super.playMedia();
    }

    public String toString() {
	return (super.toString() + "Number of Members: " + numMembers 
		+ "\nGroup Members " + Arrays.toString(groupMembers) 
		+ "\nProducer: " + producer + "\n");
    }
}
