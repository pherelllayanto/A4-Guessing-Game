
//  Pherell Layanto
//  A4: Guessing Game
//  Period 4
//  10 / 29 / 21

/*
User inputs integers to try and guess random integer. When user is done playing game results are printed.
*/  

import java.util.Scanner;
import java.util.Random;

class GuessingGame {
  
  public static final int[] TESTNUMS = {55,56,11};
  public static final int MAXNUM = 100+1;
  
  public static void main(String[] args) {
    // intiailize Scanner, Random
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();
    
    // sets variables
    int finalcounter = 0;
    int gamecounter = 0;
    int bestgame = 1;
    int counter = 0;
    int randnum = randgen(rand, MAXNUM);

    haiku();
    counter = LowerHigher(counter, randnum, sc);
    finalcounter += counter;
    gamecounter += 1;
    bestgame = counter;
    counter = 0;
    char playChoice = playAgain(sc);

    // what to do when user wants to play again
    while(playChoice == 'y' || playChoice == 'Y') {
      randnum = randgen(rand, MAXNUM);
      counter = LowerHigher(counter, randnum, sc);
      finalcounter += counter;

      // sets bestgame to last game's counter if 
      // last game's counter is less than current
      // bestgame
      if(counter < bestgame) {
        bestgame = counter;
      }
      gamecounter += 1;
      counter = 0;
      playChoice = playAgain(sc);
    }
    
    // what to do when user does not want to play again
    if(playChoice != 'y' || playChoice != 'Y') {
      results(finalcounter, gamecounter, bestgame);
    }
  }
  
  // prints haiku
  public static void haiku() {
    System.out.println();
    System.out.println("Pretty please end my pain.");
    System.out.println("I was typed using a chromebook,");
    System.out.println("It's epicly super weak.");
    System.out.println();
  }

  // makes random num
  public static int randgen(Random rand, int MAXNUM) {
    int randnum = rand.nextInt(MAXNUM);
    
    // choose another number if randnum is 0
    if(randnum == 0) {
      randnum = rand.nextInt(MAXNUM);
    }
    return randnum;
  }

  // what prints when lower/higher 
  public static int LowerHigher(int counter, int randnum, Scanner user) {
    System.out.println("I'm thinking of a number between 1 and 100...");

    // does first guess
    System.out.print("  Your guess? ");
    int guess = user.nextInt();
    counter++;

    // runs while guess is not correct
    while(guess != randnum) {

      // prints higher/lower hint
      if(guess < randnum) {
        System.out.println("  It's higher.");
      } if(guess > randnum) {
        System.out.println("  It's lower.");
      }

      // lets user guess again
      System.out.print("  Your guess? ");
      guess = user.nextInt();      
      counter++;

    }

    // user guesses num correctly in one try
    if(counter == 1 & guess == randnum) {
      System.out.println("  You got it right in " + counter + " guess!");
    
    // when user gets num correctly in more than one try
    } else if(guess == randnum) {
      System.out.println("  You got it right in " + counter + " guesses!");
    }
    return counter;
  }

  // asks user if want to play again
  public static char playAgain(Scanner user) {
    System.out.print("  Do you want to play again? ");
    char choice = user.next().charAt(0);
    System.out.println();
    return choice;
  }

  // calcs/prints overall results
  public static void results(int totalguesses, int totalgames, int bestgame) {

    // turns total guesses and total games into doubles
    // for Guesses/game
    double doubletotalguesses = totalguesses;
    double doubletotalgames = totalgames;

    // calcs Guesses/game
    double avg = doubletotalguesses/doubletotalgames;

    // prints overall results
    System.out.println("Overall results:");
    System.out.printf("Total games   = " + totalgames);
    System.out.println();
    System.out.printf("Total guesses = " + totalguesses);
    System.out.println();
    System.out.printf("Guesses/game  = " + avg);
    System.out.println();
    System.out.printf("Best game     = " + bestgame);
    System.out.println();
  }

  public static int randTester(int gameCount ){
    return TESTNUMS[(gameCount-1)%3];
  }

}