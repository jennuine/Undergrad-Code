//Artist.java

public class Artist {
    private String last;
    private String first;
    private Date birthdate;
    private String twitter;
    private String url;

    //default constructor
    public Artist() {
	birthdate = new Date();
	last = "LAST";
	first = "FIRST";
	twitter = "#TWITTER";
	url = "URL";
    }

    //constructor
    public Artist(String lastName, String firstName, Date dob, String twit, String u) {
	last = lastName;
	first = firstName;
	birthdate = dob;
	twitter = twit;
	url = u;
    }

    public String toString() {
	return ("\nFirstname: " + first + "\nLastname: " + last + "\nBirthdate: "
		+ birthdate + "\nTwitter: " + twitter + "\nURL: " + url);
    }
}
