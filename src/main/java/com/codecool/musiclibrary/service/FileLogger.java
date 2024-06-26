package com.codecool.musiclibrary.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class FileLogger implements Logger {

    private final String logFile;

    public FileLogger(String logFile) {
        this.logFile = logFile;
    }

    @Override
    public void logInfo(String message) {
        logMessage(message, "INFO");
    }

    @Override
    public void logError(String message) {
        logMessage(message, "ERROR");
    }

    private void logMessage(String message, String type) {
        String entry = String.format("[%s] %s: %s", LocalDateTime.now(), type, message);
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(logFile, true)))) {
            out.println(entry);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
