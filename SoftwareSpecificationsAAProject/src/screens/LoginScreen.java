/*
 * PLEASE KEEP TRACK!!!!!!!!!!!!!!!!!!!
 * Author(s): Program Pilots
 * Version: 0.1 
 * Last Updated: 3/6/2018 @1:17AM
 */
package screens;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

//Jpanel for the login screen
public class LoginScreen extends JPanel {

  //for the mid of the panel; handles user info
  JPanel loginStuff;
  JLabel title;
  JLabel user;
  JLabel password;
  JTextField userText;
  JTextField passwordText;

  //for the bottom of the panel; store the buttons
  JPanel buttonPanel;
  JButton login;
  JButton managerLogin;

  public LoginScreen() {
    super();
    
    //top for the title, mid for the user fields, bottom for the buttons
    this.setLayout(new GridLayout(3, 1));
    //title stuff
    title = new JLabel("American Airlines Login", SwingConstants.CENTER);
    this.add(title);

    /* tried adding a plane image, didn't work so well */
    // Icon aaplane = new
    // ImageIcon(getClass().getResource("boeing-737-american-airlines.top.jpg"));
    // homeImage = new JLabel(aaplane);
    // background = new JLayeredPane();
    // this.add(background);
    // background.add(homeImage, new Integer(0), 0);

    //user info stuff
    loginStuff = new JPanel();
    userText = new JTextField();
    passwordText = new JTextField();
    user = new JLabel("User", SwingConstants.CENTER);
    password = new JLabel("Password", SwingConstants.CENTER);
    //top-left = user; top-right = userText; bottom-left = password; bottom-right = passwordText
    loginStuff.setLayout(new GridLayout(2, 2));
    loginStuff.add(user);
    loginStuff.add(userText);
    loginStuff.add(password);
    loginStuff.add(passwordText);
    this.add(loginStuff);

    //button stuff
    login = new JButton("Login");
    managerLogin = new JButton("Manager");
    login.addActionListener(new ButtonHandler());
    managerLogin.addActionListener(new ButtonHandler());
    buttonPanel = new JPanel(new FlowLayout());
    buttonPanel.add(login);
    buttonPanel.add(managerLogin);
    this.add(buttonPanel);
  }

  /*
   * Will compare what was entered in the text fields
   * to a given file. If a match is found, proceed to the next guis.
   * Otherwise, end the program
   */
  private class ButtonHandler implements ActionListener {

    /*
     * The file is implied and is assumed to already exist.
     * Currently there is no file generation in the event the file doesn't exist
     */
    File employeeList = new File("blah.txt");
    Scanner names; //scanner for the above file

    // handle button event
    @Override
    public void actionPerformed(ActionEvent event) {

      String typedUser = userText.getText(); //string for the user in the text field
      String typedPassword = passwordText.getText(); //string for the password in the text field
      //System.out.println(typedUser + " " + typedPassword); debugging only
      try {
        names = new Scanner(employeeList); //add the file to the scanner
      } catch (FileNotFoundException e) {
        System.out.println("File not found!");
        System.exit(1); //end the program if the file isn't found
      }

      //initialize values for comparasion
      String txtUser = ""; //string for the username in the txt file
      String txtPassWord = ""; //string for the password in the txt file
      boolean match = false;

      //start the comparison
      try {
        while (names.hasNextLine() && !match) {

          /*
           * File format is as follows:
           * U::username_example P::password_example
           */
          txtUser = names.nextLine();
          txtUser = txtUser.substring(3); //cut off the U::
          txtPassWord = txtUser.replaceAll("\\D+ P::", ""); //remove the username for the password string
          txtUser = txtUser.replaceFirst(" P::\\D+", ""); //remove the password for the username string
          
          //lowercase all 4 fields for comparison's sake; we don't want caps to matter
          txtPassWord = txtPassWord.toLowerCase();
          txtUser = txtUser.toLowerCase();
          typedUser = typedUser.toLowerCase();
          typedPassword = typedPassword.toLowerCase();

          //System.out.println(txtUser); more debugging
          //System.out.println(txtPassWord);
          if (typedUser.equals(txtUser) && typedPassword.equals(txtPassWord)) {
            //System.out.println("We got a match!");
            match = true;
          } else {
            //System.out.println("Failure...");
          }
        }
      } catch (Exception e) { //in the event something goes wrong with the file reading
        names.close(); //save the file from corruption
      }

      names.close(); //still save the file, because we won't need it at this point
      if (match) { //look! I don't use match == true. BE HAPPY!
        if (event.getSource() == login) { //differentiate between a match from login and manager login
          CentralFrame.changeScreen(1); //switch to the employee gui
        } else { //if it makes it this far, and the event wasn't from login, it must be from manager
          CentralFrame.changeScreen(2); //or the manager gui
          /* note that currently the same comparision is used for both manager and employee.
           * We should probably change that.
           */
        }
      } else {
        System.out.println("Invalid username or password!");
        System.exit(0); //currently, the program ends upon a failed entry. We should probably change this
      }
    }
  }
}
