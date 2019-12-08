import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.lang.Math;
import java.lang.StringBuilder;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i, wrongLetters = 0, scoreModifier;
        char guess;
        String movieWithUnderscores;
        StringBuilder wrongLettersRecord = new StringBuilder();
        GuessTheMovie movie = new GuessTheMovie();
        try {
            char[] randomMovie = movie.randomMovieSelection();
            char[] userGuess = new char[randomMovie.length];
            for(i = 0; i < userGuess.length; ++i)
                userGuess[i] = '_';
            movieWithUnderscores = new String(randomMovie);
            movieWithUnderscores = movieWithUnderscores.replaceAll(" ", "_");
            while(wrongLetters > -10) {
                System.out.println("You are guessing(" + randomMovie.length + " characters): " + new String(userGuess));
                System.out.println("You have guessed (" + Math.abs(wrongLetters) + ") wrong letters: " + wrongLettersRecord);
                System.out.print("Guess a letter: ");
                guess = scanner.next().charAt(0);
                scoreModifier = movie.checkLetterGuess(randomMovie, userGuess, wrongLettersRecord, guess);
                wrongLetters += scoreModifier;
                if(wrongLetters == -10)
                    System.out.println("You have run out of guesses! Sorry :( You LOSE... The movie was '" + new String(randomMovie) + "'.");
                if(Arrays.equals(movieWithUnderscores.toCharArray(), userGuess)) {
                    System.out.println("Yay! You have guessed the movie right :) You WIN.... The movie was '" + new String(randomMovie) + "'.");
                    break;
                }
            }

        } catch(FileNotFoundException exception) {
            System.out.println("ERROR! File not found...");
        }
    }
}