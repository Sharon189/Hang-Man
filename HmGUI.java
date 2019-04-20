import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;

public class HmGUI extends JPanel {


//    public  String wordToShow;
//    public TextField userInput;

//    public void panel() {
//
//
//        //Background
//        JPanel p = new JPanel();
//        p.setBackground(Color.cyan);
//
//
//        //Word to show.
//        JLabel WordLabel = new JLabel("Guess The word is: "+wordToShow);
//        WordLabel.setBounds(20,20,300,50);
//
//        //adding the components above.
//        MainFrame.add(WordLabel);
//        MainFrame.add(p);
//
//        MainFrame.setVisible(true);
//    }



    int stage=0;
    public void nextStage()
    {
        stage++;
    }

    public void printStage()
    {
        System.out.println("Your stage number is:"+stage);
    }

    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g);
        g2.setStroke(new BasicStroke(5,BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));
        g2.setColor(Color.BLACK);
        g.drawLine(330, 10, 330, 50); // upper Cable of Human.
        g.drawLine(230, 10, 330, 10); // main stand to upper cable stand.
        g.drawLine(230, 10, 230, 300); // main stand.
        g.drawLine(220, 300, 350, 300); // bottom line(Base).

        if (stage==1)
        {
            //draws the head
            g2.setStroke(new BasicStroke(3,BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));
            Ellipse2D.Double head = new Ellipse2D.Double(25, 30, 50, 50);
            g2.draw(head);
        }

        else if (stage==2)
        {
            //draws the body
            g.drawLine(50, 80, 50, 180);
        }
        else if (stage==3)
        {
            //draws the left arm
            g.drawLine(10, 150, 50, 100);
        }
        else if (stage==4)
        {
            //draws the right arm
            g.drawLine(50, 100, 90, 150);
        }
        else if (stage==5)
        {
            //draws the left leg
            g.drawLine(30, 250, 50, 180);
        }
        else if (stage==6)
        {
            //draws the right leg
            g.drawLine(50, 180, 70, 250);
        }
        else if (stage==7)
        {
            //draws the left eye
            Ellipse2D.Double lefteye = new Ellipse2D.Double(40, 50, 1, 1);
            g2.draw(lefteye);
            g2.fill(lefteye);
        }
        else if (stage==8)
        {
            //draws the right eye
            Ellipse2D.Double righteye = new Ellipse2D.Double(58, 50, 1, 1);
            g2.draw(righteye);
            g2.fill(righteye);
        }
        else if (stage==9)
        {
            //draws the mouth
            Arc2D.Double mouth = new Arc2D.Double(40.00, 50.00, 20.00, 20.00, 180.00, 190.00, Arc2D.OPEN);
            g2.draw(mouth);
        }
    }


}

