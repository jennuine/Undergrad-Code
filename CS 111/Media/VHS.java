//VHS.java
import java.util.Arrays;

public class VHS extends Video {
    
    private String[] trailers;
    private int numTrailers;

    //default constructor
    public VHS() {
	super();
	numTrailers = 1;
	trailers = new String[numTrailers];
	trailers[0] = "TRAILER";
    }

    //constructor
    public VHS(String tit, Artist art, int time, int numAct, Artist[] actors, Artist direct, String rate, int numT, String[] t) {
	super(tit, art, time, numAct, actors, direct, rate);
	numTrailers = numT;
	trailers = new String[numTrailers];
	trailers = t;
    }

    public String getType() {
	return (super.getType() + ": VHS");
    }

    public void playMedia() {
	super.playMedia();
    }

    public String toString() {
	return (super.toString() + "Number of Trailers: " + numTrailers
		+ "\nTrailers: " + Arrays.toString(trailers) + "\n");
    }
}
