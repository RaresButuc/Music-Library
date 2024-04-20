package com.codecool.musiclibrary.service;

import com.codecool.musiclibrary.model.Song;

import java.util.LinkedList;

public interface Library {
    LinkedList<Song> transformToList(Song[] normalList);
}
