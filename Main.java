
/*
  This file is not part of your project.
  It is here to demonstrate a helper method you should use
  to check your code against the output test.

  The output test compares actual results to expected results,
  but struggles to account for expected RANDOM results.

  ...thus this helper method suspends the random behavior.
*/

class Main {

  public static final int[] TESTNUMS = {55,56,11};

  public static void main(String[] args) {
    System.out.println();
    System.out.println("This file demonstrates the test number generator");
    System.out.println("that will help you pass the tests.");
    System.out.println("You may use the \"randTester()\" in your code");
    System.out.println("to prove your conditional logic.");

    System.out.println();
    System.out.println("The test assumes the following 3 numbers:");
    
    for(int i = 1; i <= 3; i++){
      System.out.println(randTester(i));
    }
    System.out.println();
  }

  // This method takes a game counter, starting at 1 
  // and uses that number to chose from a constant set of 3
  // presumed guess answers that match the output test.
  // use this method to pass your tests, then swap it for 
  // a method that produces an actual random number.
  public static int randTester(int gameCount ){
    return TESTNUMS[(gameCount-1)%3];
  }
}