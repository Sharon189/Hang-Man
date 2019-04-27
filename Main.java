import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Main extends JPanel{


    public static void main(String[] arg) throws IOException {



        //Main Frame of the game!
        // -> Hang-Man Game.
        JFrame frame = new JFrame("Hang-Man Game");         //new frame with the title "Hang-Man Game"
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //when user push the X button it will be EXIT.
        frame.setSize(1150, 400);                    // frame size.



        //Create new ObjActionListener Object
        // -> for get user input from buttons and add it to frame.
        ObjActionListener buttonsAndLabel =  new ObjActionListener(); // init the first word the user can see ( all blanks).
        frame.add(buttonsAndLabel,BorderLayout.NORTH);                                              // show the buttons and label!



        //Create new hangMen Object
        // -> to update stage level of the game.
        // -> Hang-Man Graphics and add it to frame:            //(0|0)   when user miss a word then hang man will be crated.
        HmGUI hangMen = new HmGUI();                            // -|-
        //frame.add(hangMen);                                   //  /\





        frame.setVisible(true);                                //Let's start the party - show the frame...!


        //test
        while (hangMen.stage<10){
            hangMen.nextStage();
            hangMen.printStage();
            frame.add(hangMen);


        }



    }



}
