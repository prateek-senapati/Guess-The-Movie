import java.io.FileNotFoundException;
import java.lang.Math;
import java.io.File;
import java.util.Scanner;
import java.util.Arrays;
import java.lang.StringBuilder;

class GuessTheMovie {

    // Method to randomly select a movie from a given list of movies
    char[] randomMovieSelection() throws FileNotFoundException {
        File file = new File("movies.txt");
        Scanner input = new Scanner(file);
        int numberOfMovies = 0, i = 0;
        while(input.hasNextLine()) {
            input.nextLine();
            numberOfMovies++;
        }
        String[] listOfMovies = new String[numberOfMovies];
        File movies = new File("movies.txt");
        Scanner fileScanner = new Scanner(movies);
        while(fileScanner.hasNextLine()) {
            listOfMovies[i] = fileScanner.nextLine();
            i++;
        }
        int randomMovieIndex = (int)(Math.random() * listOfMovies.length);
        return listOfMovies[randomMovieIndex].toCharArray();
    }

    // Method to check whether the guess made is right or wrong and perform actions accordingly
    int checkLetterGuess(char[] randomMovie, char[] userGuess, StringBuilder wrongLettersRecord, char userLetterInput) {
        int i, returnValue = 0;
        String str = "" + userLetterInput;
        char[] original = Arrays.copyOf(userGuess, userGuess.length);
        for(i = 0; i < randomMovie.length; ++i) {
            if(randomMovie[i] == userLetterInput)
                userGuess[i] = userLetterInput;
        }
        if(Arrays.equals(original, userGuess) && !(wrongLettersRecord.toString().contains(str)) && !((new String(userGuess)).contains(str))) {
            wrongLettersRecord.append(userLetterInput);
            wrongLettersRecord.append(',');
            wrongLettersRecord.append(' ');
            returnValue = -1;
        }
        return returnValue;
    }
}