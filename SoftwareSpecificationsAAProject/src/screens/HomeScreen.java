/*
 * PLEASE KEEP TRACK!!!!!!!!!!!!!!!!!!!
 * Author(s): Program Pilots
 * Version: 0.1 
 * Last Updated: 3/6/2018 @1:20AM
 */
package screens;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

//Employee HomeScreen; allows for the toggling of the various subscreens via tabs
public class HomeScreen extends JPanel {

  public HomeScreen() {

    this.setLayout(new BorderLayout());
    /*
     * The tabbed pane allows for the tabs. Each tab represents a section of the homescreen
     * for various functionality
     * Currently: two tabs exist for the sake of existing. They don't have any functionality atm
     */
    JTabbedPane awed = new JTabbedPane();

    JPanel juan = new JPanel(); //most original name. Also immune to deportation
    juan.add(new JButton("rawr")); //test only
    awed.addTab("test", juan); //more test
    awed.addTab("testC", new MainScreen()); //test to generate a mainScreen component tab. It worked
    this.add(awed); //add the tabs to this container
    this.setBackground(Color.WHITE); //white background for clarity
  }
}
