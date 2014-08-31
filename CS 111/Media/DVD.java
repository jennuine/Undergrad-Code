//DVD.java
import java.util.Arrays;

public class DVD extends Video {
    
    private String[] specialFeatures;
    private int numFeatures;
    private double widescreenFormat;
    private boolean TVFormat; //true if HD, false if not
    private String[] soundOptions;
    private int numSoundOptions;

    //default constructor
    public DVD() {
	super();
	numFeatures = 1;
	specialFeatures = new String[numFeatures];
	specialFeatures[0] = "SPECIAL FEATURE";
	widescreenFormat = 0.0;
	TVFormat = false;
	numSoundOptions = 1;
	soundOptions = new String[numSoundOptions];
	soundOptions[0] = "SOUND OPTIONS";
    }

    public DVD(String tit, Artist art, int time, int numAct, Artist[] actors, Artist direct, String rate, int numF, String[] specF, double wide, boolean format, int numS, String[] sOpt) {
	super(tit, art, time, numAct, actors, direct, rate);
	numFeatures = numF;
	specialFeatures = new String[numFeatures];
	specialFeatures = specF;
	widescreenFormat = wide;
	TVFormat = format;
	numSoundOptions = numS;
	soundOptions = new String[numSoundOptions];
	soundOptions = sOpt;
    }

    public String getType() {
	return (super.getType() + ": DVD");
    }
    
    public void playMedia() {
	super.playMedia();
    }

    public String toString() {
	return (super.toString() + "Number of Special Features: " + numFeatures
		+ "\nSpecial Features: " + Arrays.toString(specialFeatures)
		+ "\nWidescreen Format: " + widescreenFormat
		+ "\nTV Format: " + TVFormat
		+ "\nNumber of Sound Options: " + numSoundOptions
		+ "\nSound Options: " + Arrays.toString(soundOptions) + "\n");
    }
    
    public DVD getDVD() {
	return (new DVD());
    }
}
