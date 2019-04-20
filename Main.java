import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class Main {

    public static JFrame MainFrame;
    public void MainFrameConf(){

        //Main Frame of the game.
        //setLayout(new BorderLayout());
        MainFrame = new JFrame("HandMan Game");
        MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainFrame.setSize(600, 500);

        //Create new Object and add to mainFrame.
        HmGUI g = new HmGUI();
        //HmGUI.panel();
        MainFrame.add(g);
        MainFrame.setVisible(true);
    }



    public static void main(String[] arg) throws IOException  {




        String secretWord = new FileRead().ReadFromFile(); //Get secret word from a "Word.txt" file.
        System.out.println("The Word is: "+secretWord); //Print the word for programmer debug.
        int secretWordLength = secretWord.length();  //Get the length of the word.

        String blank = "_ "; // Used to hide a word.
        String word2 = new String(""); // temporary save the updated word (with some Correct characters).

        int guessCount = 10; //Attempts.

        ArrayList<String>answers = new ArrayList<String>(); //creates reference to empty structure that will contain references.
        char blanks[]=new char[secretWordLength]; //creates an array with the same number of terms as the length of the word.
        for (int i=0; i<secretWordLength; i++)//fills the array with blanks corresponding to the length of the word.
                    blanks[i] = '_'; //Default : all the words are blank.


        HmGUI y = new HmGUI();
        new InputTextField();

        InputTextField inputOfUser =  new InputTextField();


        while (true)
        {
//            String letter = JOptionPane.showInputDialog(
//                    "Guess a letter! You have "+guessCount+
//                            " guesses."+"\n"+answers+"\n"+
//                            Arrays.toString(blanks).replace(",", " ").replace("[","").replace("]","")); //Prints a space
           String letter = inputOfUser.inputNo;
           if (letter==null) {
               System.out.println("The letter is: " + letter + " ,ShoutDown..."); //if Null think****************************************<-
                break;
           }
               char letterChar = letter.charAt(0); //converts string letter to char letterchar
            int idx = 0;
            boolean found = false;
            answers.add(letter); //adds the string to the arraylist answers

            while (idx >= 0 && idx < secretWordLength) //idx is greater than or equal to 0 but less than the length of the word
            {
                //System.out.println("idx = " + idx);
                idx = secretWord.indexOf(letter, idx); //idx is the index of "letter" in "secretWord" and finds all instances of the letter
                //System.out.println("idx = " + idx + ", guesscount = " + guesscount);
                if (idx != -1) //if idx is not -1 (the letter exists in the secretWord)
                {
                    found = true;
                    blanks[idx] = letterChar; //sets the term in the array equal to the letter
                    idx += 1; //idx=idx+1
                }
                else
                {
                    guessCount = guessCount - 1;
                    y.nextStage();
                    y.printStage();
                    MainFrame.add(y);
                    //MainFrame.setLayout(null);
                    MainFrame.setVisible(true);
                    break;
                }
            }

            if (found)
            {
                JOptionPane.showMessageDialog(null, Arrays.toString(blanks).replace(",", " ").replace("[","").replace("]","")+"\n"+"You found a letter!"+"\n"+answers);
            }
            else
            {
                JOptionPane.showMessageDialog(null, Arrays.toString(blanks).replace(",", " ").replace("[","").replace("]","")+"\n"+"That letter is not in the word! Guess again!"+"\n"+answers);

                if (guessCount == 0)
                {
                    JOptionPane.showMessageDialog(null, "Sorry, you're all out of guesses. The answer was '"+secretWord+".' Thanks for playing!");
                    break;
                }
            }

            char [] lettersArray = secretWord.toCharArray(); //converts secretWord to array of chars

            if (Arrays.equals(blanks, lettersArray))//compares array of blanks to array of letters
            {
                JOptionPane.showMessageDialog(null, "You guessed the word! Thanks for playing!");
                break;
            }
        }
    }





    }

