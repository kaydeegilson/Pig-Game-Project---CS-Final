import java.util.Scanner;

/**
 * Kaydee Gilson
 * Final Project
 * PigGame Class: this class contains the methods that actually play the game of pig.
 */

public class PigGame {
  
  //instance data
  private PigPlayer player1;
  private PigPlayer player2;
  public static final int GOAL = 100;
  public static boolean verbose = false;
  
  //constructors
  //a default constructor that creates two UserPigPlayers (Player 1 and Player 2)
  public PigGame() {
    player1 = new UserPigPlayer("Player 1");
    player2 = new UserPigPlayer("Player 2");
  }
  
  //a constructor that takes two Strings, and creates two UserPigPlayers with those two Strings as the names
  public PigGame(String player1, String player2) {
    this.player1 = new UserPigPlayer(player1);
    this.player1 = new UserPigPlayer(player1);
  }
  
  //a constructor that takes two PigPlayers
  public PigGame(PigPlayer player1, PigPlayer player2) {
    this.player1 = player1;
    this.player2 = player2;
  }
  
  //resets the two PigPlayers
  public void reset() {
    player1.reset();
    player2.reset();
  }
  
  //////////////////// playTurn method ////////////////// 
  //The playTurn method returns the turn total rolled (0 if 1 was rolled, or the turn total if the player chose to stop rolling.
  public static int playTurn(PigPlayer player, PigPlayer opponent) {
    
    int turnTotal = 0;
    
    while (player.isRolling(turnTotal, opponent.getScore()) == true) { 
      int value = Die.roll();
      if (verbose == true) {
        System.out.println("Roll: " + value);
      }
      
      if (value == 1) {
        return 0;
      }
      else {
        turnTotal = turnTotal + value;
      }
      
    }
    if (verbose == true) {
      System.out.println();
    }
    
    return turnTotal;
  }
  
//////////////////////////////////// playGame method ////////////////////////////////////
//plays an entire game of Pig, where each PigPlayer gets a turn until one player wins
  public void playGame() {
    
    int turnTotal = 0;
    int currentTurn = 1;
    
    reset();
    
    while (player1.won() == false && player2.won() == false) {
      
      //print score of first player
      if (verbose == true) {
        System.out.println(player1.getName() + "'s score: " + player1.getScore());
      }
      
      //print score of second player
      if (verbose == true) {
        System.out.println(player2.getName() + "'s score: " + player2.getScore());
        System.out.println();
      }
      
      //determines whose turn it is and adds their points to the score
      if (currentTurn == 1) {
        player1.addPoints(playTurn(player1, player2));
        currentTurn++;
        if (verbose == true) {
          System.out.println("It is " + player2.getName() + "'s turn.");
        }
      }
      else {
        player2.addPoints(playTurn(player2, player1));
        currentTurn--;
        if (verbose == true) {
          System.out.println("It is " + player1.getName() + "'s turn.");
        }
      }
    }
    
    //determines if somebody wins
    if (player1.won() == true) {
      if (verbose == true) {
        System.out.println(player1.getName() + " wins!");
      }
    }
    else if (player2.won() == true) {
      if (verbose == true) {
        System.out.println(player2.getName() + " wins!");
      }
    }
    
  }
  
  
//////////////////////////////////// UserVsUser Method ////////////////////////////////////
  public static void userVsUser() {
    
    System.out.println("Let's play Pig!");
    System.out.println("Two players race to reach 100 points.");
    System.out.println("Each turn, a player repeatedly rolls a die until either a 1 is rolled or");
    System.out.println("the player holds and scores the sum of the rolls (i.e. the turn total).");
    System.out.println("When given a choice to roll or hold, please type enter to roll, anything else to hold.");
    System.out.println();
    
    //take in and record first name using setName
    Scanner keyboard;
    System.out.println("What's the first player's name?");
    keyboard = new Scanner(System.in);
    String firstPlayerName = keyboard.nextLine();
    UserPigPlayer firstPlayer = new UserPigPlayer(firstPlayerName);
    firstPlayer.setName(firstPlayerName);
    
    //take in and record second name using setName
    System.out.println("What's the second player's name? ");
    keyboard = new Scanner(System.in);
    String secondPlayerName = keyboard.nextLine();
    UserPigPlayer secondPlayer = new UserPigPlayer(secondPlayerName);
    secondPlayer.setName(secondPlayerName);
    
    PigGame game1;
    
    //calculate who will go first
    if (Math.random() > .5) {
      System.out.println(firstPlayer.getName() + ", you will go first");
      game1 = new PigGame(firstPlayer, secondPlayer);
    }
    else {
      System.out.println(secondPlayer.getName() + ", you will go first");
      game1 = new PigGame(secondPlayer, firstPlayer);
    }
    game1.playGame();
    
  }
  
  
//////////////////////////////////// UserVsComputer Method ////////////////////////////////////
  public static void userVsComputer() {
    
    System.out.println("Let's play Pig!");
    System.out.println("You will race the computer to reach 100 points.");
    System.out.println("Each turn, you will roll a die until either a 1 is rolled or");
    System.out.println("you choose to hold and then your score will be added to the sum of the rolls (i.e. the turn total).");
    System.out.println("When given a choice to roll or hold, please type enter to roll, anything else to hold.");
    System.out.println();  
    
    //take in and record first name using setName
    Scanner keyboard;
    System.out.println("What's your name?");
    keyboard = new Scanner(System.in);
    String firstPlayerName = keyboard.nextLine();
    UserPigPlayer firstPlayer = new UserPigPlayer(firstPlayerName);
    firstPlayer.setName(firstPlayerName);
    
    //creates computer player
    //SimpleHoldPlayer computer = new SimpleHoldPlayer("Computer");
    FourTurnsPlayer computer = new FourTurnsPlayer("Computer");
    
    PigGame game1;
    
    //calculate who will go first
    if (Math.random() > .5) {
      System.out.println(firstPlayer.getName() + ", you will go first");
      game1 = new PigGame(firstPlayer, computer); 
    }
    else {
      System.out.println("The computer will go first.");
      game1 = new PigGame(computer, firstPlayer);
    }
    
    game1.playGame();
    
  }
  
//////////////////////////////////// computerVsComputer Method ////////////////////////////////////
  public static void computerVsComputer() {
    
    if (verbose == true) {System.out.println("Let's play Pig!");}
    
    //creates two computer players
    SimpleHoldPlayer player1 = new SimpleHoldPlayer("Player 1");
    SimpleHoldPlayer player2 = new SimpleHoldPlayer("Player 2");
    
    PigGame game1;
    
    //calculate who will go first
    if (Math.random() > .5) {
      if (verbose == true) {System.out.println(player1.getName() + ", you will go first");}
      game1 = new PigGame(player1, player2); 
    }
    else {
      if (verbose == true) {System.out.println(player2.getName() + ", you will go first");}
      game1 = new PigGame(player2, player1);
    }
    
    game1.playGame();
    
  }
  
//////////////////////////////////// Main Method //////////////////////////////////// 
  public static void main(String[] args) { 
    
    //userVsUser();
    userVsComputer();
    //computerVsComputer();
    
  }
  
}
