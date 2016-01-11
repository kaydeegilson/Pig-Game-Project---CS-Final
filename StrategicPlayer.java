/**
 * Kaydee Gilson
 * Final Project
 * StrategicPlayer Class: This class tries to win in five scoring turns. 
 * It is very similar to FourTurnsPlayer, but it has a better chance at winning quicker.
 */

public class StrategicPlayer extends PigPlayer {
  
  //instance data
  private int holdValue;
  private int rolls = 5;
  
  //default constructor
  public StrategicPlayer() {
    super("player");
  }
  
  //constructor with name
  public StrategicPlayer(String name) {
    super(name);
  }
  
  //reset
  public void reset() {
    super.reset();
    rolls = 5;
  }
  
  //automated isRolling method that tries to win in five turns
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
