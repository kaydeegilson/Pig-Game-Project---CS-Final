/**
 * Kaydee Gilson
 * Final Project
 * FourTurnsPlayer: this class tries to win in four scoring turns.
 */

public class FourTurnsPlayer extends PigPlayer {
  
  //instance data
  private int holdValue;
  private int rolls = 4;
  
  //default constructor
  public FourTurnsPlayer() {
    super("player");
  }
  
  //constructor with name
  public FourTurnsPlayer(String name) {
    super(name);
  }
  
  //reset
  public void reset() {
    super.reset();
    rolls = 4;
  }
  
  //automated isRolling method that tries to win in four turns
  public boolean isRolling(int turnTotal, int opponentScore) {
    
    int pointsToGo = PigGame.GOAL - getScore();   //calculates points left to go until you win
    holdValue = pointsToGo/rolls;                 //calculates the next hold value for whatever roll you're on
    
    if (rolls != 0 && turnTotal < holdValue) {    //checks if the turnTotal is less than the current holdValue & if there are rolls left
      return true;
    }
    else {
      rolls--;
      return false;
    }
    
  }
  
}