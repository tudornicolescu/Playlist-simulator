package software.academy;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        ArrayList<Album> albums = new ArrayList<>();

        Album firstAlbum = new Album("Nightfall in Middle-Earth");
        albums.add(firstAlbum);

        Album secondAlbum = new Album("V: The New Mythology Suite");
        albums.add(secondAlbum);

        Album thirdAlbum = new Album("Fear of the Dark");
        albums.add(thirdAlbum);

        firstAlbum.addSong("War of Wrath", 108);
        firstAlbum.addSong("Into the Storm", 264);
        firstAlbum.addSong("Lammoth", 28);
        firstAlbum.addSong("Nightfall", 333);
        firstAlbum.addSong("The Minstrel", 32);
        firstAlbum.addSong("The Curse of Feanor", 341);

        secondAlbum.addSong("Prelude", 67);
        secondAlbum.addSong("Evolution (The Grand Design)", 320);
        secondAlbum.addSong("Fallen", 350);

        thirdAlbum.addSong("Be Quick or Be Dead", 203);
        thirdAlbum.addSong("From Here to Eternity", 237);
        thirdAlbum.addSong("Afraid to Shoot Strangers", 416);
        thirdAlbum.addSong("Fear is the Key", 334);
        thirdAlbum.addSong("Childhood's End", 280);

        Album fourthAlbum = new Album("Memories of a Time to Come");
        albums.add(fourthAlbum);

        LinkedList<Song> playList = new LinkedList<Song>();
        albums.get(0).addToPlayList("Nightfall", playList);
        albums.get(2).addToPlayList("Afraid to Shoot Strangers", playList);
        albums.get(1).addToPlayList("Fallen", playList);
        albums.get(0).addToPlayList(5, playList);
        albums.get(1).addToPlayList(2, playList);
        albums.get(2).addToPlayList(1, playList);
        albums.get(2).addToPlayList(4, playList);

        play(playList);
    }

    private static void play(LinkedList<Song> playList) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();
        if(playList.size() == 0) {
            System.out.println("No songs in playlist");
            return;
        } else {
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }

        while(!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch(action) {
                case 0:
                    System.out.println("Playlist complete.");
                    quit = true;
                    break;
                case 1:
                    if(!forward) {
                        if(listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().toString());
                    } else {
                        System.out.println("We have reached the end of the playlist");
                        forward = false;
                    }
                    break;

                case 2:
                    if(forward) {
                        if(listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("We are at the start of the playlist");
                        forward = true;
                    }
                    break;
                case 3:
                    if(forward) {
                        if(listIterator.hasPrevious()) {
                            System.out.println("Now replaying " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("We are at the start of the list");
                        }
                    } else {
                        if(listIterator.hasNext()) {
                            System.out.println("Now replaying " + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("We have reached the end of the list");
                        }
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;

                case 6:
                    if(playList.size() >0) {
                        listIterator.remove();
                        if(listIterator.hasNext()) {
                            System.out.println("Now playing " + listIterator.next());
                        } else if(listIterator.hasPrevious()) {
                            System.out.println("Now playing " + listIterator.previous());
                        }
                    }
                    break;

            }
        }
    }

    private static void printMenu() {
        System.out.println("Available actions:\npress");
        System.out.println("0 - to quit\n" +
                "1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - to replay the current song\n" +
                "4 - list songs in the playlist\n" +
                "5 - print available actions.\n" +
                "6 - delete current song from playlist");

    }


    private static void printList(LinkedList<Song> playList) {
        Iterator<Song> iterator = playList.iterator();
        System.out.println("================================");
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("================================");
    }

}
