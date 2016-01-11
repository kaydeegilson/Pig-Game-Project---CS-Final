/**
 * Kaydee Gilson
 * Final Project
 * Simulations Class: runs multiple simulations testing the various pig player strategies
 */

public class Simulations {
  
//////////////////////////////////// method for figuring out how high an advantage the first player has ////////////////////////////////////
  public static void firstAdvantage(long simulations) {
    
    //creates two computer players
    SimpleHoldPlayer player1 = new SimpleHoldPlayer("Player 1");
    SimpleHoldPlayer player2 = new SimpleHoldPlayer("Player 2");
    
    //loops through the designated amount of simulations
    for (int i = 0; i < simulations; i++) {
      PigGame game1 = new PigGame(player1, player2);
      game1.playGame();
    }
    
    //calculates player 1's advantage
    double advantage = (100.0 * player1.getWinRecord() / simulations) - (100.0 * player2.getWinRecord() / simulations);
    
    //print statements for win records and player 1's advantage
    System.out.println("Number of Player 1 wins: " + player1.getWinRecord());
    System.out.println("Number of Player 2 wins: " + player2.getWinRecord());
    System.out.println("Player 1 advantage: " + advantage + "%");
    //5-6.5% advantage on average
    
  }
  
//////////////////////////////////// method for splitting who goes first and calculating first player's advantage ////////////////////////////////////
  public static double comparePlayers(long simulations, PigPlayer first, PigPlayer second) { 
    
    //loops through the designated amount of simulations
    for (int i = 0; i < simulations; i++) {
      if (simulations % 2 == 0) {
        PigGame game1 = new PigGame(first, second);
        game1.playGame();
      }
      else {
        PigGame game1 = new PigGame(first, second);
        game1.playGame();
      }
    }
    
    //calculates player 1's advantage
    double advantage = (first.getWinRecord() / (double) simulations);
    
    //print statements for win records and player 1's advantage
//    System.out.println("Number of Player 1 wins: " + first.getWinRecord());
//    System.out.println("Number of Player 2 wins: " + second.getWinRecord());
//    System.out.println("Difference: " + (first.getWinRecord() - second.getWinRecord()));
//    System.out.println("Player 1 advantage: " + advantage + "%");
    
    return advantage;
  }
  
////////////////////////////////////// method for figuring out the best hold value to use for SimpleHoldPlayer ////////////////////////////////////
  //best hold value on average is 25
  public static void bestHoldValue() {
    
    SimpleHoldPlayer player1;
    SimpleHoldPlayer player2;
    double largest = 0;
    int holdValue = 0;
    
    for (int smaller = 17; smaller < 30; smaller++) {
      for (int larger = 17; larger < 30; larger++) {
        player1 = new SimpleHoldPlayer("Player 1", smaller);
        player2 = new SimpleHoldPlayer("Player 2", larger);
        double value = comparePlayers(100000, player1, player2);
        
        if (value > largest) {
          largest = value;
          holdValue = smaller;
        }
      }
    }
    System.out.println("Hold value: " + holdValue);
    
  }
  
//////////////////////////////////// compares FourTurnsPlayer to SimpleHoldPlayer //////////////////////////////////// 
  public static void fourToSimple() {
    
    for (int i = 0; i < 4; i++) {
      FourTurnsPlayer player1 = new FourTurnsPlayer("Player 1");      
      SimpleHoldPlayer player2 = new SimpleHoldPlayer("Player 2", 25);
      System.out.println(Simulations.comparePlayers(10000, player1, player2));
    }
  }
  
//////////////////////////////////// findGoodWatchValues for WatchOpponentPlayer ////////////////////////////////////  
  public static void findGoodWatchValues() {
    
    double best = .5;
    double bestI = 0;    //closeToWin
    double bestJ = 0;    //holdValue
    double bestK = 0;    //divideAmount
    
    //for (int i = 5; i < 50; i++) 
    for (int j = 5; j < 50; j++) 
      for (int k = 5; k < 50; k++) {
      WatchOpponentPlayer watch = new WatchOpponentPlayer("watch", 74, j, k); //(String name, int closeToWin, int holdValue, int divideAmount)
      SimpleHoldPlayer hold = new SimpleHoldPlayer("hold at 25", 25);
      double result = comparePlayers(10000, watch, hold);
      if (result > best) {
        bestI = 74;
        bestJ = j;
        bestK = k;
        best = result;
        System.out.println(bestI + ", " + bestJ + ", " + bestK + " gives win record: " + best);
      }
    }
    
    System.out.println("\n\noptimal:");
    System.out.println(bestI + ", " + bestJ + ", " + bestK + " gives win record: " + best);
    
  }
  
//////////////////////////////////// compares StrategicPlayer to SimpleHoldPlayer //////////////////////////////////// 
  public static void strategicToSimple() {
    for (int i = 0; i < 4; i++) {
      StrategicPlayer player1 = new StrategicPlayer("Player 1");      
      SimpleHoldPlayer player2 = new SimpleHoldPlayer("Player 2", 25);
      System.out.println(Simulations.comparePlayers(100000, player1, player2));
    }
  }  
  
//////////////////////////////////// compares StrategicPlayer to FourTurnsPlayer //////////////////////////////////// 
  public static void strategicToFour() {
    for (int i = 0; i < 4; i++) {
      StrategicPlayer player1 = new StrategicPlayer("Player 1");      
      FourTurnsPlayer player2 = new FourTurnsPlayer("Player 2");
      System.out.println(Simulations.comparePlayers(10000, player1, player2));
    }
  }  
  
//////////////////////////////////// compares StrategicPlayer to StrategicPlayer //////////////////////////////////// 
  public static void strategicToStrategic() {
    for (int i = 0; i < 4; i++) {
      StrategicPlayer player1 = new StrategicPlayer("Player 1");      
      StrategicPlayer player2 = new StrategicPlayer("Player 2");
      System.out.println(Simulations.comparePlayers(10000, player1, player2));
    }
  }   
  
//////////////////////////////////// compares all strategies against eachother ////////////////////////////////////
  public static void compareStrategies() {
    
    for (int i = 0; i < 1; i++) {
      
      //SimpleHoldPlayer against all other strategies
      System.out.println("Simple vs Four: " + Simulations.comparePlayers(100000, new SimpleHoldPlayer("Player 1"), new FourTurnsPlayer("Player 2")));
      System.out.println("Simple vs Watch: " + Simulations.comparePlayers(100000, new SimpleHoldPlayer("Player 1"), new WatchOpponentPlayer("Player 3")));
      System.out.println("Simple vs Strategic: " + Simulations.comparePlayers(100000, new SimpleHoldPlayer("Player 1"), new StrategicPlayer("Player 4")));
      
      //FourTurnsPlayer against all other strategies
      System.out.println("Four vs Simple: " + Simulations.comparePlayers(100000, new FourTurnsPlayer("Player 2"), new SimpleHoldPlayer("Player 1")));
      System.out.println("Four vs Watch: " + Simulations.comparePlayers(100000, new FourTurnsPlayer("Player 2"), new WatchOpponentPlayer("Player 3")));
      System.out.println("Four vs Strategic: " + Simulations.comparePlayers(100000, new FourTurnsPlayer("Player 2"), new StrategicPlayer("Player 4")));
      
      //WatchOpponentPlayer against all other strategies
      System.out.println("Watch vs Simple: " + Simulations.comparePlayers(100000, new WatchOpponentPlayer("Player 3"), new SimpleHoldPlayer("Player 1")));
      System.out.println("Watch vs Four: " + Simulations.comparePlayers(100000, new WatchOpponentPlayer("Player 3"), new FourTurnsPlayer("Player 2")));
      System.out.println("Watch vs Strategic: " + Simulations.comparePlayers(100000, new WatchOpponentPlayer("Player 3"), new StrategicPlayer("Player 4")));
      
      //StrategicPlayer against all other strategies
      System.out.println("Strategic vs Simple: " + Simulations.comparePlayers(100000, new StrategicPlayer("Player 4"), new SimpleHoldPlayer("Player 1")));
      System.out.println("Strategic vs Four: " + Simulations.comparePlayers(100000, new StrategicPlayer("Player 4"), new FourTurnsPlayer("Player 2")));
      System.out.println("Strategic vs Watch: " + Simulations.comparePlayers(100000, new StrategicPlayer("Player 4"), new WatchOpponentPlayer("Player 3")));
    }
  }
  
  
//////////////////////////////////// main method ////////////////////////////////////  
  public static void main(String[] args) { 
    
    //firstAdvantage(100000);
    
    //SimpleHoldPlayer player1 = new SimpleHoldPlayer("KD");
    //SimpleHoldPlayer player2 = new SimpleHoldPlayer("TY");
    
    //comparePlayers(20, player1, player2);
    
    //bestHoldValue();
    
    //fourToSimple();
    
    //watchToSimple();
    
    //findGoodWatchValues();
    
    //strategicToSimple();
    
    //strategicToFour();
    
    compareStrategies();
  }
  
}