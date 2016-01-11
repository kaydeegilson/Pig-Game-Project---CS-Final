/**
 * Kaydee Gilson
 * Final Project
 * WatchOpponentPlayer: strategy that watches opponent's score closely and makes decisions based off that
 */

public class WatchOpponentPlayer extends PigPlayer {
  
  //instance data
  private int closeToWin = 74;
  private int holdValue = 19;
  private int divideAmount = 42;
  
  //constructors
  
  //default constructor
  public WatchOpponentPlayer() {
    super("player");  
  }
  
  //constructor with name
  public WatchOpponentPlayer(String name) {
    super(name);
    this.holdValue = holdValue;
  }
  
  //constructor with name, holdValue, and divideAmount
  public WatchOpponentPlayer (String name, int closeToWin, int holdValue, int divideAmount) {
    super(name);
    this.closeToWin = 74;
    this.holdValue = 19;
    this.divideAmount = 42;
  }
  
  //automated isRolling method that closely watches opponent
  public boolean isRolling(int turnTotal, int opponentScore) {
    
    int difference = opponentScore - getScore();
    int updatedHoldValue = holdValue + (difference / divideAmount);
    
    if (turnTotal + this.getScore() < PigGame.GOAL) {                      //if nobody has won &&
      if (this.getScore() >= closeToWin || opponentScore >= closeToWin) {    //if someone is close to winning
        return true;
      }
      if (turnTotal < updatedHoldValue) {           //if turnTotal has not yet reached the determined hold value for this turn
        return true;
      }
    }
    
    return false;
    
  }
  
}