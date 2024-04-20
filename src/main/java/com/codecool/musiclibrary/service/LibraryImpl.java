package com.codecool.musiclibrary.service;

import com.codecool.musiclibrary.model.Song;

import java.util.*;
import java.util.stream.Collectors;

public class LibraryImpl implements Library {
    private Song[] musicList;
    private static Logger logger = null;


    public LibraryImpl(Song[] musicList, Logger logger) {
        this.musicList = musicList;
        this.logger = logger;
    }

    public LinkedList<Song> transformToList(Song[] normalList) {
        LinkedList<Song> linkedList
                = new LinkedList(Arrays.asList(normalList));
        return linkedList;
    }

    public static void addToList(List<Song> list, Song newSong) {
        list.add(newSong);
        logger.logInfo(newSong.title() + " by " + newSong.artist() + " added to the playlist!");
    }

    public static void viewList(List<Song> list) {
        list.sort((a, b) -> a.artist().compareTo(b.artist()));
        for (Song song : list) {
            logger.logInfo(String.format(song.title() + " by " + song.artist() + '(' + song.lengthInSeconds() + " seconds" + ')'));
        }
    }

    public void searchSong(List<Song> list, String artist) {
        logger.logInfo(list.stream()
                .filter(c -> c.artist().toLowerCase().contains(artist.toLowerCase())).collect(Collectors.toList()).toString());
    }

    public static void removeFromList(List<Song> list, String title) {
        LinkedList<Song> filtered
                = new LinkedList(list.stream()
                .filter(c -> c.title().toLowerCase().contains(title.toLowerCase())).collect(Collectors.toList()));
        if (filtered.size() == 1) {
            Song toBeRemoved = filtered.get(0);
            list.remove(toBeRemoved);
            System.out.println(toBeRemoved.title() + " by " + toBeRemoved.artist() + " was removed from the playlist!");
        } else {
            System.out.println("Be more specific next time!");
        }
    }

    public static void emptyList(List<Song> list) {
        list.clear();
    }
}
