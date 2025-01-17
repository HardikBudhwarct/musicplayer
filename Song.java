import java.time.LocalDate;
import java.util.*;

class Song {
    private String name;
    private String artist;
    private Map<LocalDate, Integer> playCountByDate;
    private int totalPlayCount;

    public Song(String name, String artist) {
        if (name == null || name.isEmpty() || artist == null || artist.isEmpty()) {
            throw new IllegalArgumentException("Song name and artist cannot be null or empty.");
        }
        this.name = name;
        this.artist = artist;
        this.playCountByDate = new HashMap<>();
        this.totalPlayCount = 0;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public Map<LocalDate, Integer> getPlayCountByDate() {
        return new HashMap<>(playCountByDate);  
    }

    public int getTotalPlayCount() {
        return totalPlayCount;
    }

    public int getPlayCountForDate(LocalDate date) {
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }
        return playCountByDate.getOrDefault(date, 0);
    }

    public void incrementPlayCount(LocalDate date) {
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }
        playCountByDate.merge(date, 1, Integer::sum);
        totalPlayCount++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return Objects.equals(name, song.name) && Objects.equals(artist, song.artist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, artist);
    }

    @Override
    public String toString() {
        return "Song{" +
                "name='" + name + '\'' +
                ", artist='" + artist + '\'' +
                ", totalPlayCount=" + totalPlayCount +
                '}';
    }
}
