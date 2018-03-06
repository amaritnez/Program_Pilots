/*
 * PLEASE KEEP TRACK!!!!!!!!!!!!!!!!!!!
 * Author(s): Program Pilots
 * Version: 0.1 
 * Last Updated: 3/6/2018 @12:58AM
 */
package screens;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * Central Frame class. Designed to harbor the logic for switching between guis
 */
public class CentralFrame extends JFrame {

  private static CardLayout deck;
  private static JPanel hand;
  
  public CentralFrame() {
    super("American Airlines"); //set title
    /*
     * Create a "stack" of cards. The cards represent the various
     * guis. Toggle through the stack to toggle through the various guis and show
     * the one we want
     */
    hand = new JPanel(new CardLayout()); //represents the current gui to be shown
    deck = new CardLayout(); //represents all the guis stored in the layout
    hand.setLayout(deck);
    
    LoginScreen LS = new LoginScreen(); //initial login screen
    HomeScreen HS = new HomeScreen(); //main screen for employees
    ManagerHomeScreen MHS = new ManagerHomeScreen(); //main screen for managers
    /*
     * Here's the order for the deck:
     * 0: login
     * 1: employee homescreen
     * 2: manager homescreen
     */
    hand.add(LS, "Homescreen");
    hand.add(HS, "HomeScreen");
    hand.add(MHS, "ManagerHomeScreen");
    this.add(hand); //add the hand to this frame
  }
  
  //loops through the deck until it reaches the desired hand based on it's position above
  public static void changeScreen(int position) {
    for (int switchCount = 0; switchCount < position; switchCount++) {
      deck.next(hand); //cycles to the next hand. Defaults at the starting hand upon first running the program
    }
  }
  
//main method: starts everything
  public static void main(String[] args) {
    CentralFrame main = new CentralFrame(); //creates the central frame to run everything
    main.setDefaultCloseOperation(EXIT_ON_CLOSE); //exit the program on closing the gui
    main.setVisible(true); //make the gui visible to human scrubs
    main.setSize(800, 600); //random size for the gui
  }
}
