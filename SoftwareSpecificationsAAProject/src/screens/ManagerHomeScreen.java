/*
 * PLEASE KEEP TRACK!!!!!!!!!!!!!!!!!!!
 * Author(s): Program Pilots
 * Version: 0.1 
 * Last Updated: 3/6/2018 @1:24AM
 */
package screens;

import java.awt.Color;

/*
 * HomeScreen for the manager. Currently is identical to the employee in nearly
 * everyway, hence why it extends HomeScreen
 */
public class ManagerHomeScreen extends HomeScreen {
  
  public ManagerHomeScreen() {
    super(); //first do whatever HomeScreen's constructor does
    
    this.setBackground(Color.RED); //makes the background red to prove there is a difference
  }
}
