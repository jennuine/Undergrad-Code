//Vido.java
import java.util.Arrays;

public abstract class Video extends Media {

    private Artist[] supportingActors;
    private int numActors;
    private Artist director;
    private String rating;

    //default constructor
    public Video() {
	super();
	numActors = 1;
	supportingActors = new Artist[numActors];
	supportingActors[0] = new Artist();
	director = new Artist();
	rating = "NR";
    }

    //constructor
    public Video(String tit, Artist art, int time, int numAct, Artist[] actors, Artist direct, String rate) {
	super(tit, art, time);
	numActors = numAct;
	supportingActors = new Artist[numActors];
	supportingActors = actors;
	director = direct;
	rating = rate;
    }
    
    public String getType() {
	return ("VIDEO");
    }

    public void playMedia() {
	super.playMedia();
	System.out.println("\t\t\tRating: " + rating);
    }

    public String toString() {
	return (super.toString() + "Number of Actors: " + numActors 
		+ "\nSupporting Actors: " + Arrays.toString(supportingActors) 
		+ "\nDirector: " + director
		+ "\nRating: " + rating + "\n");
    }
}
