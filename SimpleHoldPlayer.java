/**
 * Kaydee Gilson
 * Final Project
 * SimpleHoldPlayer Class: This class holds the auto isRolling method that uses the best hold value found in the simulations class.
 */

public class SimpleHoldPlayer extends PigPlayer {
  
  //instance data
  private int holdValue;
  public static final int HOLDVALUE = 25;
  
  //constructors
  
  //default constructor
  public SimpleHoldPlayer() {
    super("player");
    this.holdValue = HOLDVALUE;
  }
  
  //constructor with name
  public SimpleHoldPlayer(String name) {
    super(name);
    this.holdValue = HOLDVALUE;
  }
  
  //constructor with name and holdValue
  public SimpleHoldPlayer(String name, int holdValue) {
    super(name);
    this.holdValue = holdValue;
  }
  
  //automated isRolling method
  public boolean isRolling(int turnTotal, int opponentScore) {
    if (this.won() == false && (turnTotal + this.getScore()) < PigGame.GOAL) { 
      if (turnTotal < holdValue) {
        return true;  
      }
      else {
        return false;
      }
    }
    else {
      return false;
    }
  }
  
}