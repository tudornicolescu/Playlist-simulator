package software.academy;

public class Song {

    private String title;
    private int duration;

    public Song(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public boolean songExists (Song song) {
        if (song.title.equals(this.title)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return this.title + ": " + this.duration;
    }
}
