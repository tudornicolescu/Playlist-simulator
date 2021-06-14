package software.academy;

import java.util.Iterator;
import java.util.LinkedList;

public class Album {

    private String title;
    private LinkedList<Song> songs = new LinkedList<>();

    public Album (String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void addSong (String title, int duration) {
        Song song = new Song(title, duration);
        if(!songInAlbum(song)) {
            songs.add(song);
        }
        else {
            System.out.println("Song already exists in the album " + this.title);
        }
    }

    public boolean songInAlbum (Song song) {
        Iterator<Song> i = songs.iterator();
        while(i.hasNext()) {
            if (i.next().songExists(song)) {
                return true;
            }
        }
        return false;
    }

    private Song findSong(String title) {
        for(Song checkedSong: this.songs) {
            if(checkedSong.getTitle().equals(title)) {
                return checkedSong;
            }
        }
        return null;
    }

    public void viewAlbum () {
        if(songs.isEmpty()) {
            System.out.println("No songs in the album " + this.title);
        } else {
            int songNumber = 0;
            Iterator<Song> i = songs.iterator();
            System.out.println(this.title + ":");
            while (i.hasNext()) {
                songNumber++;
                System.out.println(songNumber + ". " + i.next().getTitle());
            }
        }
        System.out.println("=================");
    }
    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList) {
        int index = trackNumber -1;
        if((index >= 0) && (index <= this.songs.size())) {
            playList.add(this.songs.get(index));
            return true;
        }
        System.out.println("The album " + this.getTitle() +  " does not have a track " + trackNumber);
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playList) {
        Song checkedSong = findSong(title);
        if(checkedSong != null) {
            playList.add(checkedSong);
            return true;
        }
        System.out.println("The song " + title + " is not in the album " + this.getTitle());
        return false;
    }
}
