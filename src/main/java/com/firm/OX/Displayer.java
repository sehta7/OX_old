package com.firm.OX;

/**
 * Shows communicates on console
 *
 * @author Ola Podorska
 */
class Displayer {

    private Language language;

    Displayer(Language language) {
        this.language = language;
        language.loadLanguage();
    }

    void displayQuestionAboutPlayer(){
        System.out.println(language.getSentence("player"));
    }

    void displayQuestionAboutBoardSize(){
        System.out.println(language.getSentence("size"));
    }

    void displayQuestionAboutCharacter(){
        System.out.println(language.getSentence("character"));
    }

    void displayQuestionWhoStarts(){
        System.out.println(language.getSentence("who_starts"));
    }

    void displayGameStart(){
        System.out.println(language.getSentence("start"));
    }

    void displayScores(Player player){
        System.out.print(player + " " + language.getSentence("score")  + " " + player.checkPoints());
    }

    void displayWhoWin(Player player){
        System.out.print(language.getSentence("win") + " " + player);
    }

    void displayNewRound(){
        System.out.println(language.getSentence("round"));
    }

    void displayQuestionAboutField(){
        System.out.println(language.getSentence("field"));
    }

    void displayDraw(){
        System.out.println(language.getSentence("draw"));
    }

    void displaySeparator(){
        System.out.println(language.getSentence("separator"));
    }

    void displayBoardSizeError() {
        System.out.println(language.getSentence("bad_size"));
    }

    public void displayChosenFieldError() {
        System.out.println(language.getSentence("bad_field"));
    }
}
