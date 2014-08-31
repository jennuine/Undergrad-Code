import java.util.Scanner;

public class Playlist {
	public static void main(String [] args) {
		Scanner input = new Scanner(System.in);
		
		String playlist = null;
		String artistName = null;
		String albumName = null;
		String songTitle = null;
		int firstDash = 0;
		int secondDash = 0;

		System.out.println("What's your favorite song? \n\tPlease enter also the artist and the album name in the following format:");
		System.out.println("\t\tArtist - Album - Song");
		playlist = input.nextLine();
		
		firstDash = playlist.indexOf('-');
		secondDash = playlist.lastIndexOf('-');
		
		artistName = playlist.substring(0, firstDash - 1);
		albumName = playlist.substring(firstDash + 2, secondDash - 1);
		songTitle = playlist.substring(secondDash + 2);
		
		System.out.println("\nArtist: " + artistName);
		System.out.println(" Album: " + albumName);
		System.out.println("  Song: " + songTitle);
		
		
	}
}
