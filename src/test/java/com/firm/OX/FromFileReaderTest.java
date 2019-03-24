package com.firm.OX;

import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.testng.Assert.*;

public class FromFileReaderTest {

    @Test
    public void testIfReaderFromFileAssignPlayer() {
        Player readPlayer = new Player();
        try {
            File file = new File("C:\\Users\\Olka\\Desktop\\test_player.txt");
            Reader reader = new FromFileReader(new GameOptions(), file);
            readPlayer = reader.readPlayer();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Player player = new Player("name");
        assert (player.equals(readPlayer)) : "Reader doesn't see player";
    }

    @Test
    public void testIfReaderFromFileAssignSize() {
        Size readSize = new Size();
        try {
            File file = new File("C:\\Users\\Olka\\Desktop\\test_size.txt");
            Reader reader = new FromFileReader(new GameOptions(), file);
            readSize = reader.readSize();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Size size = new Size(10, 10);
        assert (size.equals(readSize)) : "Reader doesn't see size";
    }

    @Test
    public void testIfReaderFromFileAssignCharactersNumber() {
        int readCharacter = 0;
        try {
            File file = new File("C:\\Users\\Olka\\Desktop\\test_characters.txt");
            Reader reader = new FromFileReader(new GameOptions(), file);
            readCharacter = reader.readNumberOfCharacters();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assert (readCharacter == 10) : "Reader doesn't see number of winning characters";
    }

    @Test
    public void testIfReaderFromFileAssignPosition() {
        Position readPosition = new Position("new");
        try {
            File file = new File("C:\\Users\\Olka\\Desktop\\test_position.txt");
            Reader reader = new FromFileReader(new GameOptions(), file);
            readPosition = reader.readPosition();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Position position = new Position(5, 0);
        assert (position.equals(readPosition)) : "Reader doesn't see position";
    }

    @Test(expectedExceptions = FileNotFoundException.class)
    public void testIfThrowExceptionWhenLackOfFile() throws FileNotFoundException {
        File file = new File("C:\\Users\\Olka\\Desktop\\test.txt");
        Reader reader = new FromFileReader(new GameOptions(), file);
    }
}