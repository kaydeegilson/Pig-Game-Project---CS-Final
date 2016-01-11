import java.util.Scanner;

/**
 * Kaydee Gilson
 * Final Project
 * UserPigPlayer Class: this class determines if the user wants to roll or hold and returns the turn total.
 */

public class UserPigPlayer extends PigPlayer
{
  //instance data
  private Scanner keyboard;
  
  //constructors
  public UserPigPlayer(String name ) {
    super(name);
    
    keyboard = new Scanner(System.in);
  }
  
  //methods
  
  //isRolling method that prints turn total and finds out if the user wants to hold or roll
  public boolean isRolling(int turnTotal, int opponentScore) {
    System.out.println("Turn total: " + turnTotal);
    System.out.println("Press enter to roll, anything else to hold.");
    String ch = keyboard.nextLine();
    
    if (ch.length() == 0) {
      return true; //user wants to roll
    }
    else { 
      return false; //user wants to hold
    }        
  }
  
  
  
  //main method
  public static void main(String[] args) {
    
    UserPigPlayer player = new UserPigPlayer("Kaydee");
    
    while (player.isRolling(0,0)) {
    }
    
    //method testing
    //System.out.println(player.isRolling(8, 10));
    
  }
  
  
}