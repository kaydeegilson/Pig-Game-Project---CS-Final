import java.lang.Math;

/**
 * Kaydee Gilson
 * Final Project
 * Die Class: this class controls the die in the pig game.
 **/

public class Die
{
  private int sides;  //instance variable
  
  //default constructor
  public Die() {
    sides = 6;
  }
  
  //constructor
  public Die(int sides) {
    this.sides = sides;
  }
  
  //first roll method that assumes a six sided die
  public static int roll() {
    int min = 1;
    int max = 6;
    int rollValue = min + (int)(Math.random() * ((max - min) + 1));
    return rollValue;
  }
  
  //method that sets the number of sides of the die to a valid number
  public void setSides(int numberOfSides) {
    if (numberOfSides > 0) {
      sides = numberOfSides;
    }
  }
  
  //method that returns the number of sides of the die
  public int getSides() {
    return sides;
  }
  
  //second roll method that can have a special die with as many sides as we want
  public int rollDie()  {
    int min = 1;
    int rollValue = min + (int)(Math.random() * ((sides - min) + 1));
    return rollValue;
  }
  
}