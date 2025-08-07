import java.util.*;

public class Q5_ShufflePlaylist {
    static List<String> shuffle(List<String> songs) {
        List<String> shuffled = new ArrayList<>(songs);
        Collections.shuffle(shuffled);
        return shuffled;
    }

    public static void main(String[] args) {
        List<String> songs = Arrays.asList("song1", "song2", "song3", "song4");
        List<String> playlist = shuffle(songs);
        System.out.println("Shuffled playlist: " + playlist);
    }
}