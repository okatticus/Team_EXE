package gametry;

import java.io.IOException;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Apoorva
 */
 public class MainPannel  extends javax.swing.JFrame  implements ActionListener
 {  //  CardLayout card;
     GridBagLayout gbl;
     GridBagConstraints gbc;
     JPanel top,left,right;
     JButton help,next,retry;
 public MainPannel() throws IOException{
        top=new JPanel();
       /* card=new CardLayout();
        top.setLayout(card);*/
        add(top);
        left=new JPanel();
        right=new JPanel();
        gbl=new GridBagLayout();
        gbc=new GridBagConstraints();
        gbc.anchor=GridBagConstraints.NORTH;
        gbc.gridx=0;
	gbc.gridy=4;
        gbl.setConstraints(left,gbc);	
        top.add(left);
        gbc.gridx=864;
	gbc.gridy=4;
        gbl.setConstraints(right,gbc);
        top.add(right);
        help=new JButton("Help");
        help.setBackground(new java.awt.Color(255, 255, 255));
        help.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        help.setForeground(new java.awt.Color(102, 0, 0));
        retry=new JButton("Retry");
        retry.setBackground(new java.awt.Color(255, 255, 255));
        retry.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        retry.setForeground(new java.awt.Color(102, 0, 0));
        next=new JButton("Next");
        next.setBackground(new java.awt.Color(255, 255, 255));
        next.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        next.setForeground(new java.awt.Color(102, 0, 0));
        game = new GameClass();
        Thread tr=new Thread(game);
           tr.start();
        left.add(game.jp);
        right.add(help);
        right.add(retry);
        right.add(next);
        help.addActionListener(this);
        retry.addActionListener(this);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        left.setSize(860,620);
        right.setSize(60,620);
        setSize(1024,620);
        setResizable(true);
        setVisible(true);
        pack();
    }
    
   public void actionPerformed(ActionEvent ae) //throws IOException
   {
       Object ob;
	ob=ae.getSource();
	if(ob==help)
        {
            JOptionPane.showMessageDialog(null,"*Memory Game*"+
                    "\nThere are 2 levels.\n"
                    +"Count the number of times each image occurs ,"+
                    "then answer the question that follows.\n"
                    +"*Type a digit as answer in the text field ahead.*","HELP",
                    2);
        }
        else if(ob==retry)
        {
            game.Max=12;
            left.remove(game.jp);
            repaint();
          
           /*left.add(game.jp);
           left.revalidate();
           game.run();//start()left.add(game.jp);*/
           Thread tr=new Thread(game);
           tr.start();
            left.add(game.jp);
           left.revalidate();
         }
        else// if(ob==next)
        {
            game.Max=12;
            left.remove(game.jp);
            //top.removeAll();
            repaint();
           Thread tr=new Thread(game);
           tr.start();
            left.add(game.jp);
           left.revalidate();
        }
   }

public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        

    }

    //my variables
    GameClass game;
}

