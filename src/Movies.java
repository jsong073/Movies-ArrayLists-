/*
This program will do the following:
1. Receive the names of the user's favorite movies and store them in a list
2. Alphabetize and print out the list
3. Suggest a movie for the user to watch by randomly selecting a movie from the list

Process:
1. Initialize variables:
    a. "ArrayList<String> favoriteMovies" to store the user's favorite movies
    b. "Scanner input" to receive a response from the user
    c. "boolean hasQuit" to check if the user has typed "q"/"Q" during the loop
    d. "Random random" to randomly select a movie for the user to watch
    e. "int randomMovieSelect" to store the randomly generated number
    f. "String userResponse" to store the user's response
2. WHILE hasQuit is false
        Ask user for a favorite movie using the Scanner
        Store response in userReponse
        IF userReponse equals "q" or "Q" THEN
            set hasQuit to true
        ELSE
            add userResponse to favoriteMovies
        ENDIF
    ENDWHILE
3. Use the Collections.sort method to sort the list of movies in alphabetical order
4. Print out the list of movies
5. Set randomMovieSelect equal to a randomly generated number between 0 and the size of the favoriteMovies list
6. Print out the movie name located at the index number stored in randomMovieSelect
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class Movies {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> favoriteMovies = new ArrayList<String>();
        Random random = new Random();
        boolean hasQuit = false;
        int randomMovieSelect = 0;
        String userResponse = "";

        System.out.print("Hey! Enter one of your favorite movies: ");
        userResponse = input.nextLine();
        if (userResponse.equalsIgnoreCase("q")) {
            hasQuit = true;
        } else {
            favoriteMovies.add(userResponse);
        }
        while (hasQuit == false) {
            System.out.print("Enter another one of your favorite movies, or type \"q\" to quit: ");
            userResponse = input.nextLine();
            if (userResponse.equalsIgnoreCase("q")) {
                hasQuit = true;
            } else {
                favoriteMovies.add(userResponse);
            }
        }




        if (favoriteMovies.size() > 0) {
            Collections.sort(favoriteMovies);
            System.out.println("Here's a list of your favorite movies in alphabetical order: ");
            System.out.print(favoriteMovies.toString());
            System.out.println();
            //sets up a random number within the size of the list and uses it to suggest a movie
            randomMovieSelect = random.nextInt(favoriteMovies.size());
            System.out.println("I think you should watch " + favoriteMovies.get(randomMovieSelect));
        }

    }
}
