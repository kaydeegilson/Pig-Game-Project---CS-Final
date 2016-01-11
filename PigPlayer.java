/**
 * Kaydee Gilson
 * Final Project
 * PigPlayer Class: this class controls the player playing the pig game. It is the parent of multiple child classes.
 */

public abstract class PigPlayer {
  
  //instance variables
  private String name;
  private int currentScore;
  private int totalWon;
  
  //constructor that takes a name as a String
  public PigPlayer(String name) {
    this.name = name;
  }
  
  //Method that sets the name of the player.
  public void setName(String name) {
    this.name = name;
  }
  
  //Method that returns the name of the player.
  public String getName() {
    return name;
  }
  
  //Method that prepares the player for a new game by setting the score to 0.
  public void reset() {
    currentScore = 0;
  }
  
  //Method that adds the turn total to the player's score. 
  //It also increments the number of wins if the player's score is now greater than or equal to the goal.
  public void addPoints(int turnTotal) {
    currentScore = currentScore + turnTotal;
    if (currentScore >= PigGame.GOAL) {
      totalWon++;
    }
  }
  
  //public boolean won() - returns true if this player has won the game (reached the GOAL)
  public boolean won() {
    if (currentScore >= PigGame.GOAL) {
      return true;
    }
    else {
      return false;
    }
  }
  
  //public int getScore() - returns the player's current score
  public int getScore() {
    return currentScore;  
  }
  
  //public int getWinRecord() - returns the number of games this player has won
  public int getWinRecord() {
    return totalWon;
  }
  
  //public String toString() - returns a String with the player's name and score
  public String toString() {
    return "Player's name: " + name + " \nScore: " + currentScore;
  }
  
  //abstract method
  //This abstract method will return whether or not the player wants to roll the die.
  public abstract boolean isRolling(int turnTotal, int opponentScore);
  
  /**
   //main method
   public static void main(String[] args) {
   
   PigPlayer player = new PigPlayer("Kaydee");
   
   //method testing
   player.setName("Tyler");
   System.out.println(player.getName());
   player.reset();
   player.addPoints(99);
   System.out.println(player.won());
   System.out.println(player.getScore());
   System.out.println(player.getWinRecord());
   System.out.println(player);
   
   }
   
   **/
  
  
  
}