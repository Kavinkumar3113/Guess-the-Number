package com;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GuessTheNumber {
    static int count=0;
    public static void main(String[] args) {
        Random rand=new Random();
        int randno=rand.nextInt(100);
  
        JFrame frame = new JFrame("Guess the Number");

     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
      frame.setSize(800,800);

 
      JPanel panel = new JPanel();
      panel.setLayout(new GridLayout(10,10));

      
      JLabel displayLabel = new JLabel("Press a button within 5 chance", JLabel.CENTER);
      displayLabel.setPreferredSize(new Dimension(300, 50)); 
      displayLabel.setBackground(Color.YELLOW);
      displayLabel.setFont(new Font("Arial", Font.BOLD, 34));
      displayLabel.setForeground(new Color(139, 69, 19));
      displayLabel.setOpaque(true);
      frame.add(displayLabel, "North"); 


      
      for (int i = 1; i <= 100; i++) {
          JButton button = new JButton(String.valueOf(i));
          button.setBackground(Color.CYAN); 
          button.setForeground(Color.RED);
          button.setFont(new Font("Arial", Font.BOLD, 40));
          button.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
            	
            	
            	  if(count<5)
            	  {
            		  int number =Integer.parseInt(button.getText());
            	  if(randno+1==number)
            		  displayLabel.setText("You won the Game!");
            	  else if(randno+1<number)
                    displayLabel.setText("Your number is lesser than you guessed Try again!");
            	  else
            		  displayLabel.setText("Your number is greater than you guessed Try again!");
            	      
            	  count++;
            	  }
            	  else
            		  displayLabel.setText("You lose the game");
              }
          });
          panel.add(button); 
      }

      frame.add(panel); 
     frame.setVisible(true);
    }
}

