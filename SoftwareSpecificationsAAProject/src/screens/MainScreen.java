/*
 * PLEASE KEEP TRACK!!!!!!!!!!!!!!!!!!!
 * Author(s): Program Pilots
 * Version: 0.1 
 * Last Updated: 3/6/2018 @1:22AM
 */
package screens;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

//first screen that pops-up for the homescreen. Should have the calender
public class MainScreen extends JPanel {

  public MainScreen() {
    this.setLayout(new GridBagLayout()); //gridbag layout to allow for some customization of positioning
    GridBagConstraints constraint = new GridBagConstraints();
    
    //simply makes the label take up the whole screen
    constraint.fill = GridBagConstraints.HORIZONTAL;
    constraint.gridx = 0;
    constraint.gridy = 0;
    
    JLabel test = new JLabel("meowith"); //a label to show this container exists
    this.add(test, constraint); //add the label
  }
}
