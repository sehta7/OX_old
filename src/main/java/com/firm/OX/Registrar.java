package com.firm.OX;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


/**
 * Save moves in file
 *
 * @author Ola Podorska
 */
class Registrar {

    private File file;
    private GameOptions gameOptions;

    Registrar(GameOptions gameOptions){
        this.gameOptions = gameOptions;
        createFileForGame();
    }

    void saveMove(String move){
        try(FileWriter fr = new FileWriter(file, true)){
            fr.write("<--- Next move --->");
            fr.write(System.getProperty("line.separator"));
            fr.write(move);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createFileForGame(){
        try {
            String name = gameOptions.sizeOfBoard() + "_" + gameOptions.numberOfCharacters();
            file = new File(gameOptions.getPath() + name + ".txt");
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
