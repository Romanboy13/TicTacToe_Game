import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
/*necessary components are imported */

public class TicTacEvent implements ItemListener, ActionListener, Runnable {
    // TicTacEvent implements classes needed in TicTac
    TicTac gui;
    // TicTac stored as gui for easy access
    Thread playing;
    ImageIcon a = new ImageIcon("torontorock.jpg");
    // a is new ImageIcon type, initialized to store torontorock.jpg
    ImageIcon b = new ImageIcon("buffalobandits.jpg");
    // b is new ImageIcon type, initialized to store buffalobandits.jpg
    int clicks = 0;
    // clicks is integer variable type, initialized to store 0
    int win = 0;
    // win is integer variable type, initialized to store 0
    int[][] check = new int[3][3];
    // check is an array of int, 3 by 3
    int rockWins =0;
    // rockWins is integer type, initialized to store 0
     int banditWins=0;
     // banditWins is integer type, initialized to store 0
     int numberOfTies = 0;
     //numberOfTies is integer type, initialized to store 0


    public TicTacEvent (TicTac in){
        // TicTacEvent is public method with TicTac imported

        gui = in;
        // imports gui (where TicTac is stored)
        for (int row=0; row<=2; row++){
           for (int col=0; col<=2; col++){
               check[row][col]=0;
               // check array stores 0
           }
       }

    }
    public void actionPerformed (ActionEvent event) {

       String command = event.getActionCommand();
       // command is string type, stores action command value

       if (command.equals("Play")) {
           // if command is "Play", then startPlaying method is called
           startPlaying();
       }
       if (command.equals("1")) {
           // if command is "1" then b1 method is called
           b1();
       }
       if (command.equals("2")) {
           // if command is "2" then b2 method is called
           b2();
       }
       if (command.equals("3")) {
           // if command is "3" then b3 method is called
           b3();
       }
       if (command.equals("4")) {
           // if command is "4" then b4 method is called
           b4();
       }
       if (command.equals("5")) {
           // if command is "5" then b5 method is called
           b5();
       }
       if (command.equals("6")) {
           // if command is "6" then b6 method is called
           b6();
       }
       if (command.equals("7")) {
           // if command is "7" then b7 method is called
           b7();
       }
       if (command.equals("8")) {
           // if command is "8" then b8 method is called
           b8();
       }
       if (command.equals("9")) {
           // if command is "9" then b9 method is called
           b9();
       }
       if (command.equals("Reset")){
           // if command is "Reset" then TicTacReset method is called
           TicTacReset();
       }
    }
    void b1() {
        // b1 method contains following code
            clicks = clicks + 1;
            // clicks increases by 1
    if ((clicks%2)==1){
        // if clicks divided by 2 returns 1 remainder, then...
                gui.boxes[0][0].setIcon(a);
                // the specified box in gui stores Icon a
    check[0][0] = 1;
    // check for the specified box stores 1
            } else {
                // if clicks divided by 2 returned no remainder, then...
                gui.boxes[0][0].setIcon(b);
                // the specified box in gui shows Icon b
    check[0][0] = 2;
    // check for the specified box stores 2
            }
    winner();
    // calls winner method
        }
    void b2() {
            clicks = clicks + 1;
    if ((clicks%2)==1){
                gui.boxes[0][1].setIcon(a);
    check[0][1] = 1;
            } else {
                gui.boxes[0][1].setIcon(b);
    check[0][1] = 2;
            }
    winner();
    }
    void b3() {
            clicks = clicks + 1;
    if ((clicks%2)==1){
                gui.boxes[0][2].setIcon(a);
    check[0][2] = 1;
            } else {            gui.boxes[0][2].setIcon(b);
    check[0][2] = 2;
            }
    winner();
        }
    void b4() {
            clicks = clicks + 1;
    if ((clicks%2)==1){
                gui.boxes[1][0].setIcon(a);
    check[1][0] = 1;
            } else {
                gui.boxes[1][0].setIcon(b);
    check[1][0] = 2;
            }
    winner();
        }
    void b5() {
            clicks = clicks + 1;
    if ((clicks%2)==1){
                gui.boxes[1][1].setIcon(a);
    check[1][1] = 1;
            } else {
                gui.boxes[1][1].setIcon(b);
    check[1][1] = 2;
            }
    winner();
        }
    void b6() {
            clicks = clicks + 1;
    if ((clicks%2)==1){
                gui.boxes[1][2].setIcon(a);
    check[1][2] = 1;
            } else {
                gui.boxes[1][2].setIcon(b);
    check[1][2] = 2;
            }
            winner();
        }
    void b7() {
            clicks = clicks + 1;
    if ((clicks%2)==1){
                gui.boxes[2][0].setIcon(a);
    check[2][0] = 1;
            } else {
                gui.boxes[2][0].setIcon(b);
    check[2][0] = 2;        }
    winner();
        }
    void b8() {
            clicks = clicks + 1;
    if ((clicks%2)==1){
                gui.boxes[2][1].setIcon(a);
    check[2][1] = 1;
            } else {
                gui.boxes[2][1].setIcon(b);
    check[2][1] = 2;
            }
    winner();
        }
    void b9() {
            clicks = clicks + 1;
    if ((clicks%2)==1){
                gui.boxes[2][2].setIcon(a);
    check[2][2] = 1;
            } else {
                gui.boxes[2][2].setIcon(b);
    check[2][2] = 2;
            }
    winner();
        }
void startPlaying() {
        playing = new Thread(this);
        playing.start();
        gui.play.setEnabled(false);
    }

    public void itemStateChanged(ItemEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void run() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    void winner() {
        // winner method contains the following code....
    for (int x=0; x<=2; x++){
        // check for wins vertically
            if ((check[x][0]==check[x][1])&&(check[x][0]==check[x][2])) {
                // checks the boxes to determine whether a team has won (3 cards in a row are equal)
                if (check[x][0]==1) {
                    JOptionPane.showMessageDialog(null, "Toronto Rock is the winner");
                    // if check for the boxes stores 1, then the message "Toronto Rock ... " appears
                    win = 1;
                    // win stores 1
                    rockWins++;
                    // rockWins increases by 1
                } else if (check[x][0]==2){
                    JOptionPane.showMessageDialog(null, "Buffalo Bandits is the winner");
                    // if check for the boxes stores 2, then the message "Buffalo Bandits ..." appears
                    win = 1;
                    // wins stores 1
                    banditWins++;
                    //banditWins increases by 1
                }
                }
        }
     for (int x=0; x<=2; x++){
     // check for wins horizontally
            if ((check[0][x]==check[1][x])&&(check[0][x]==check[2][x])) {
                if (check[0][x]==1) {
                    JOptionPane.showMessageDialog(null, "Toronto Rock is the winner");
                    win = 1;
                    rockWins++;
                } else if (check[0][x]==2) {
                    JOptionPane.showMessageDialog(null, "Buffalo Bandits is the winner");
                    win = 1;
                    banditWins++;
                }
            }
        }
     if (((check[0][0]==check[1][1])&&(check[0][0]==check[2][2]))||
                ((check[2][0]==check[1][1])&&(check[1][1]==check[0][2]))){
     // check for wins vertically
            if (check[1][1]==1) {
                JOptionPane.showMessageDialog(null, "Toronto Rock is the winner");
                win = 1;
                rockWins++;
            } else if (check[1][1]==2) {
                JOptionPane.showMessageDialog(null, "Buffalo Bandits is the winner");
                win = 1;
                banditWins++;
            }
        }
    if ((clicks==9) && (win==0)) {
        // if all the cards have been flipped, but nobody has won,
            JOptionPane.showMessageDialog(null, "The game is a tie");
            // the message "The game is a tie" appears
            numberOfTies ++;
            // the numberOfTies increases by 1
        }
 gui.blank1.setText("Rock Wins: " + "\n" +Integer.toString(rockWins) + "\n" + "     Ties: " + Integer.toString(numberOfTies));
 // sets what text appears in blank1 of TicTac
 gui.blank2.setText("Bandits Wins: " + Integer.toString(banditWins)+ "\n" + "     Ties: " + Integer.toString(numberOfTies));
 //sets what text appears in blank2 of TicTac
}
  

        public void TicTacReset() {
            // TicTacResetMethod includes the follwing code...
     for (int x=0; x<=2; x++){
        for (int y=0; y<=2; y++){
        gui.boxes[x][y].setIcon(gui.back);
        // boxes in gui are set to icon 'back'
        check[x][y]=0;
        // check stores 0
    }
    }
         clicks=clicks-clicks ;
         // clicks becomes 0
         win = win-win;
         // win becomes 0

    }
    }



