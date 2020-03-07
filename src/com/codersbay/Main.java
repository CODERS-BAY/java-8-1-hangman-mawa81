package com.codersbay;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int maxFails = 10;
        int maxTrys = 15;
        int countTrys = maxTrys;
        int countFails = 0;

        introAnimation();

        List<String> hangMan = getHangManDesignPattern();
        String word = getWordFromConsoleInput();
        char[] guess = getGuessAsStars(word).toCharArray();

        while (true) {
            drawThisDesignPattern(hangMan);
            if (countTrys > 0 && countFails < maxFails && !String.valueOf(guess).equals(word)) {
                System.out.println("Word: " + String.valueOf(guess).toUpperCase() + "\t\t" + "Trys left: " + countTrys);
                String guessCharacter = getGuessCharacter();
                countTrys--;

                if (word.contains(guessCharacter) && !String.valueOf(guess).contains(guessCharacter)) {
                    writeGuessedCharacterToGuessCharArray(word, guess, guessCharacter);
                    System.out.println("\nExcellent! You have found a letter!");

                } else if (String.valueOf(guess).contains(guessCharacter)) {
                    System.out.println("\nHey! You have already found this letter!");
                } else {
                    countFails++;
                    updateHangmanOnFails(hangMan, countFails);
                    System.out.println("\nSorry! Wrong letter!");
                }

            } else if (String.valueOf(guess).equals(word)) {
                System.out.println("      " + String.valueOf(guess).toUpperCase() + " is the correct word!!!");
                System.out.println("\n\tYOU WIN!!! GRATULATIONS!!!!");
                System.out.println("\nWanna play a new Game? ([y]es,[n]o): ");
                NewStartorExitDialog newStartorExitDialog = new NewStartorExitDialog(maxTrys, countTrys, countFails, hangMan, word, guess).invoke();

            } else {
                System.out.println("\n\tGAME OVER");
                System.out.println("\nWanna play a new Game? ([y]es,[n]o): ");
                NewStartorExitDialog newStartorExitDialog = new NewStartorExitDialog(maxTrys, countTrys, countFails, hangMan, word, guess).invoke();

            }
        }
    }

    private static void exitGame() {
        System.out.println("Bye, Bye!");
        System.exit(0);
    }

    private static void updateHangmanOnFails(List<String> hangMan, int countFails) {
        switch (countFails) {
            case 1:
                hangMan.set(1, "     |/      |\n");
                break;
            case 2:
                hangMan.set(2, "     |      (\n");
                break;
            case 3:
                hangMan.set(2, "     |      (_\n");
                break;
            case 4:
                hangMan.set(2, "     |      (_)\n");
                break;
            case 5:
                hangMan.set(3, "     |      \\|\n");
                break;
            case 6:
                hangMan.set(3, "     |      \\\n");
                break;
            case 7:
                hangMan.set(3, "     |      \\|/\n");
                break;
            case 8:
                hangMan.set(4, "     |       |\n");
                break;
            case 9:
                hangMan.set(5, "     |      / \n");
                break;
            case 10:
                hangMan.set(5, "     |      / \\\n");
                break;
            default:
                System.out.println("fault");
        }
    }

    private static void drawThisDesignPattern(List<String> hangMan) {
        for (String element : hangMan) {
            System.out.print(element);
        }
    }

    private static List<String> getHangManDesignPattern() {
        List<String> hangMan = new ArrayList<String>();
        hangMan.add("      _______\n");
        hangMan.add("     |/\n");
        hangMan.add("     |\n");
        hangMan.add("     |\n");
        hangMan.add("     |\n");
        hangMan.add("     |\n");
        hangMan.add("     |\n");
        hangMan.add("  ___|____________________________\t");
        return hangMan;
    }

    private static void writeGuessedCharacterToGuessCharArray(String word, char[] guess, String guessCharacter) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guessCharacter.charAt(0)) {
                guess[i] = word.charAt(i);
            }

        }
    }

    private static String getGuessCharacter() {
        Scanner scan = new Scanner(System.in);
        System.out.print("\nGuess a letter: ");
        return String.valueOf(scan.next().charAt(0));
    }

    private static String getGuessAsStars(String word) {
        String guess = "";
        for (char eachChar : word.toCharArray()) {
            guess += "*";
        }
        return guess;
    }

    private static String getWordFromConsoleInput() {
        Scanner scan = new Scanner(System.in);
        String word = "";
        System.out.println("Please enter a word: ");
        if (!scan.hasNextInt()) {

            word += scan.next();
        }
        return word;
    }

    private static void introAnimation() {
        int count = 0;
        char[] intro = "Hi! LET'S PLAY HANGMAN!".toCharArray();
        for (char element : intro)
            System.out.println(" ".repeat(count += 5) + element);
        System.out.println();
    }

    private static class NewStartorExitDialog {
        private int maxTrys;
        private int countTrys;
        private int countFails;
        private List<String> hangMan;
        private String word;
        private char[] guess;

        public NewStartorExitDialog(int maxTrys, int countTrys, int countFails, List<String> hangMan, String word, char... guess) {
            this.maxTrys = maxTrys;
            this.countTrys = countTrys;
            this.countFails = countFails;
            this.hangMan = hangMan;
            this.word = word;
            this.guess = guess;
        }

        public int getCountTrys() {
            return countTrys;
        }

        public int getCountFails() {
            return countFails;
        }

        public List<String> getHangMan() {
            return hangMan;
        }

        public String getWord() {
            return word;
        }

        public char[] getGuess() {
            return guess;
        }

        public NewStartorExitDialog invoke() {
            Scanner scan = new Scanner(System.in);
            String newStartOrExit = String.valueOf(scan.next().charAt(0));
            if (newStartOrExit.equals("y")) {
                countTrys = maxTrys;
                countFails = 0;
                hangMan = getHangManDesignPattern();
                word = getWordFromConsoleInput();
                guess = getGuessAsStars(word).toCharArray();
            } else if (newStartOrExit.equals("n")) {
                exitGame();
            }
            return this;
        }
    }
}
