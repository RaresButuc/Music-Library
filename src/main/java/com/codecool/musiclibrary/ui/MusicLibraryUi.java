package com.codecool.musiclibrary.ui;

import com.codecool.musiclibrary.Application;
import com.codecool.musiclibrary.model.Song;
import com.codecool.musiclibrary.service.LibraryImpl;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MusicLibraryUi {

    private static LibraryImpl libraryImpl = null;
    private static List<Song> library;

    public MusicLibraryUi(LibraryImpl libraryImpl,List<Song> library) {
        this.libraryImpl = libraryImpl;
        this.library = library;
    }

    public void run() {
        displayWelcomeMessage();

        int code = 0;

        while (code != 6) {
            displayMenu();
            code = getCode();

            switch (code) {
                case 1 -> addSong();
                case 2 -> viewLibrary();
                case 3 -> searchSongs();
                case 4 -> removeSong();
                case 5 -> clearData();
                case 6 -> {}
                default -> System.out.println("Please try again!");
            }
        }
    }

    private static void displayWelcomeMessage() {
        System.out.println("Welcome to Codecool Music Library.");
    }

    private static void displayMenu() {
        System.out.println("1 - Add Song");
        System.out.println("2 - View Library");
        System.out.println("3 - Search Songs");
        System.out.println("4 - Remove Song");
        System.out.println("5 - Clear Library");
        System.out.println("6 - Exit");
    }

    private static int getCode() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static String getInfo() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static void addSong() {
        System.out.println("Enter the title of the song:");
        String title = getInfo();
        System.out.println("Enter the author of the song:");
        String author = getInfo();
        System.out.println("Enter the duration of the song in seconds:");
        int seconds = getCode();
        Song toAdd = new Song(title, author, seconds);
        libraryImpl.addToList(library, toAdd);
    }

    private static void viewLibrary() {
        libraryImpl.viewList(library);
    }

    private static void searchSongs() {
        System.out.println("Enter the name of an artist:");
        libraryImpl.searchSong(library, getInfo());
    }

    private static void removeSong() {
        System.out.println("Please write the title of the Song to be Removed");
        String title = getInfo();
        libraryImpl.removeFromList(library, title);
    }

    private static void clearData() {
        libraryImpl.emptyList(library);
    }
}

