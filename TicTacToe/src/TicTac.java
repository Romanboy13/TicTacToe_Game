
/*
 Programmer: Ryan Holinshead
 Date: November 13, 2012
 Program Name: Tic Tac
 Program Description: This program uses buttons and methods to create a working Tic-Tac-Toe game which keeps score and can be reset.
 */

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
/*necessary components are imported */

public class TicTac extends JFrame {


    
    TicTacEvent tictac = new TicTacEvent(this);
    //TicTacEvent class stored within tictac, allows importing
     JPanel row1 = new JPanel();
     // creates new JPanel called row1 which is initialized to store null
     JButton[ ][ ] boxes = new JButton [3][3];
     // initializes array of JButtons, 3 by 3 (9 total) named boxes
     JButton play = new JButton ("Play");
     // sets new JButton, called play, to show the word "Play"
     JButton reset = new JButton ("Reset");
     // sets new JButton, called reset, to show the word "Reset"
     ImageIcon space2image = new ImageIcon("torontorock1.jpg");
     // space1image is ImageIcon type, stores image torontorock1.jpg
     ImageIcon space1image = new ImageIcon("buffalobandits1.jpg");
     // space2image is ImageIcon type, stores image buffalobandits1.jpg
     JButton space2 = new JButton (space2image);
     // sets new JButton, called space2, to show space2image
     JButton space1 = new JButton (space1image);
     // sets new JButton, called space1, to show space1image
    JTextField blank1 = new JTextField();
    JTextField blank2 = new JTextField();
    // initializes blank1 and blank2 as JTextField types storing no text
     JOptionPane win = new JOptionPane("Winner");
     //sets new JOptionPane, called win, to be called "Winner"
     ImageIcon back = new ImageIcon("NLLCardBack.jpg ");
     // sets back ImageIcon type to store NLLCardBack.jpg

     public TicTac() {
         //methof TicTac is public
        super ("Tic Tac Toe");
        // the pane will say Tic Tac Toe
        setSize (500,700);
        // size of pane set to 500 by 700
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // sets program to close when close button is pressed
        FlowLayout layout = new FlowLayout();
        // layout is FlowLayout
        setLayout(layout);
        int name = 0;
        // name is integer type initialized as to store 0
        String newname;
        // newname is String variable type

        GridLayout layout1 = new GridLayout(5, 3, 10, 10);
        // sets aspects of layout1
        row1.setLayout(layout1);
        // sets layout for row1
        for (int x=0; x<=2; x++){
            for (int y=0; y<=2; y++){
                name = name + 1;
                newname = Integer.toString(name);
                boxes[x][y] = new JButton(newname);
                boxes[x][y].setIcon(back);
                row1.add(boxes[x][y]);
                /* all boxes are added to row 1 via for loops*/
            }
        }
        row1.add(blank1);
        row1.add(play);
        row1.add(blank2);
        row1.add(space2);
        row1.add(reset);
        row1.add(space1);
        /* blank1, play, blank2, space2, reset and space1 are added to row1*/
        add (row1);
        // row1 is added to pane
        play.addActionListener(tictac);
        // adds action listener to play
        reset.addActionListener(tictac);
        // adds action listener to reset
        

        for (int x=0; x<=2; x++){
            for (int y=0; y<=2; y++){
                boxes[x][y].addActionListener(tictac);
                /* action listeners are added to all the boxes */
            }
        }

        setVisible(true);
        // sets pane visible
}
public static void main(String[] arguments){
        	TicTac frame = new TicTac();
}

}


