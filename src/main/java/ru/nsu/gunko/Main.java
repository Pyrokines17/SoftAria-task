package ru.nsu.gunko;

public class Main {
    public static void main(String[] args) {
        PageStates pageStates = DataInitializer.initializeData();
        String fullName = "Ivan Ivanov";

        String letter = LetterWriter.writeLetter(pageStates, fullName);
        System.out.println(letter);
    }
}