import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        MusicPlayer player = new MusicPlayer();

        try {
            player.addSong("Blinding Skies", "John Doe");
            player.addSong("Golden Hour", "Jane Smith");
            player.addSong("Nightfall", "John Doe");
            player.addSong("Electric Dreams", "The Horizon");
            player.addSong("Moonlit Road", "The Horizon");
            player.addSong("Starlight", "The Horizon");
            System.out.println("Songs added successfully!");
        } catch (IllegalArgumentException e) {
            System.err.println("Error adding songs: " + e.getMessage());
        }

        System.out.println("\nPlaying songs...");
        for (int i = 0; i < 5; i++) player.playSong("Blinding Skies", "John Doe");
        for (int i = 0; i < 3; i++) player.playSong("Golden Hour", "Jane Smith");
        for (int i = 0; i < 7; i++) player.playSong("Electric Dreams", "The Horizon");
        for (int i = 0; i < 2; i++) player.playSong("Moonlit Road", "The Horizon");

        System.out.println("\nAll songs by John Doe:");
        System.out.println(player.getAllSongsByArtist("John Doe"));

        System.out.println("\nAll songs by The Horizon:");
        System.out.println(player.getAllSongsByArtist("The Horizon"));

        System.out.println("\nTop 10 songs ever:");
        System.out.println(player.getTopTenSongsEver());

        System.out.println("\nTop 10 songs by John Doe:");
        System.out.println(player.getTopTenSongsByArtist("John Doe"));

        LocalDate today = LocalDate.now();
        System.out.println("\nTop 10 songs for today (" + today + "):");
        System.out.println(player.getTopTenSongsByDate(today));

        System.out.println("\nSongs played less than 3 times:");
        System.out.println(player.getSongsPlayedLessThan(3));

        System.out.println("\nTesting error handling:");
        try {
            player.addSong(null, "Artist");
        } catch (IllegalArgumentException e) {
            System.out.println("Successfully caught null song name: " + e.getMessage());
        }

        try {
            player.addSong("Song", "");
        } catch (IllegalArgumentException e) {
            System.out.println("Successfully caught empty artist name: " + e.getMessage());
        }

        System.out.println("\nTrying to play non-existent song:");
        player.playSong("Non-existent Song", "Unknown Artist");
    }
}
