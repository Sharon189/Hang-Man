import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputTextField extends Frame implements ActionListener {


    TextField userInput;
    String inputNo;
    Button cmdOK;

    public void TextFieldConf(){

        //User Char input.
        userInput = new TextField();
        userInput.setBounds(20,120, 150,50);
        Main.MainFrame.add(userInput);
        userInput.addActionListener(this);

        //OK Button to Enter user char.
        cmdOK = new Button("OK");
        cmdOK.setBounds(100,400,100,20);
        Main.MainFrame.add(cmdOK);
        cmdOK.addActionListener(this);

        setVisible(true);
    }




    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==cmdOK)
            inputNo = userInput.getText();
        else
            inputNo = "N";
        System.out.println("The user input is : "+inputNo);

        //tf3.setText(result);


    }

}