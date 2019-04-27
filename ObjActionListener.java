import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ObjActionListener extends JPanel implements ActionListener {

    private String letter, secretWord;
    private Button[] buttons;
    JLabel WordLabel;
    int secretWordLength, guessCount;
    char blanks[];
    boolean p;
    public void repaintHM(boolean b){  p=b;  }



    //Constructors!
    public ObjActionListener() throws IOException {

        // -> init Parameters:
        secretWord = new FileRead().ReadFromFile();             //Get secret word from a "Word.txt" file.
        secretWordLength = secretWord.length();                  //Get the length of the word.
        String blank = "_ ";                                    // Used to hide a word.
        String word2 = new String("");                   // temporary save the updated word (with some Correct characters).
        guessCount = 10;                                        //Attempts.
        char FirstBlanks[] = new char[secretWordLength];        //creates an array with the same number of terms as the length of the word.
        System.out.println("Secret word is : "+secretWord);


        //Create the first label to show user
        // ->Blank label _,_,_...word.len..._,_,_
        for (int i = 0; i < secretWordLength; i++)                  //fills the array with blanks corresponding to the length of the word.
            FirstBlanks[i] = '_';                                   //Default : all the words are blank.
        StringBuilder sb = new StringBuilder();                     //Convert char array to string with ','.
        for (int i = 0; i < secretWordLength; i++) {                //append blanks to sb - corresponding to word len.
            sb.append(FirstBlanks[i]);                              //append "_"
            sb.append(',');                                         //append ","
        }
        sb.deleteCharAt(secretWordLength + (secretWordLength - 1)); //Remove last character (",") of a StringBuilder.
        String blankString = new String(sb);
        blanks = FirstBlanks;


        //init label //
        // -> to show the user the word he has guess currently.
        WordLabel = new JLabel();
        WordLabel.setText("Guess The word : " + blankString);
        this.add(WordLabel);


        //init the buttons//.
        // -> for User input purpose.
        char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'
                , 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q'
                , 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        buttons = new Button[26];
        for (int i = 0; i < 26; ++i) {
            buttons[i] = new Button(Character.toString(letters[i])); //need to convert char to String first
            buttons[i].addActionListener(this);
            this.add(buttons[i]);
        }



        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        ArrayList<String> answers = new ArrayList<String>();                  //creates reference to empty structure that will contain references.




        //if there are any changes in:
        // Buttons:
        for (int i = 0; i < 26; ++i) {
            if (e.getSource() == buttons[i]) {
                letter = buttons[i].getLabel();
                System.out.println("Button Pressed: " + letter);


                int idx = 0;
                char letterChar = letter.charAt(0);                    //converts string letter to char letterchar.
                boolean found = false;
                answers.add(letter);                                   //adds the char\letter to the arraylist answers
                int FoundOnce=0;
                    while (0 <= idx && idx < secretWordLength && guessCount>0)            //if idx is greater than or equal to 0 but less than the length of the word then:
                    {
                        idx = secretWord.indexOf(letterChar, idx);     //idx is the index of "letter" in "secretWord" and finds all instances of the letter
                        if (idx != -1)                                 //if idx is not -1 (=if the letter exists in the secretWord)
                        {
                            found = true;
                            blanks[idx] = letterChar;                  //sets the term in the array equal to the letter
                            idx++;
                            System.out.println("Correct!,index="+idx);
                            FoundOnce++;
                        }
                        else if (idx==-1 && FoundOnce==0){              //  if idx is  -1 (=if the letter char is'nt exist in the word.)
                            //Create new hangMen Object
                            // -> to update stage level of the game(head,hand,body and legs etc).
                            HmGUI y = new HmGUI();
                            y.nextStage();                              //stage+1
                            y.printStage();                             // print in the terminal the stage value.
                            y.setLayout(null);
                            add(y);
                            setVisible(true);
                            guessCount = guessCount - 1;                // start from 10 (10 Down to 0).
                            System.out.println("Wrong!, LeftGuesses:"+guessCount);
                            FoundOnce =0;
                            break;
                        }
                    }

                if (found)
                {
                    String FoundStr = Arrays.toString(blanks).replace(",", " ").replace("[", "").replace("]", "") + "   " + "You found a letter!" + "   " + answers;
                    WordLabel.setText("Guess The word : " +FoundStr);
                }
                else
                {
                    String NotFoundStr = Arrays.toString(blanks).replace(",", " ").replace("[", "").replace("]", "") + "   " + "That letter is not in the word! Guess again!" + "   " + answers;
                    WordLabel.setText("Guess The word : " +NotFoundStr);

                    if (guessCount == 0)
                    {
                        String gameOverStr = "Sorry, you're all out of guesses. Thanks for playing! ,  The answer was: " + secretWord;
                        WordLabel.setText(gameOverStr);
                        break;
                    }
                }

                char[] lettersArray = secretWord.toCharArray();                     //converts secretWord to array of chars

                if (Arrays.equals(blanks, lettersArray))                            //compares array of blanks to array of letters
                {
                    WordLabel.setText("You guessed the word! Thanks for playing!");
                    break;
                }


                }
            }

        }



}

