package gametry;

import java.io.IOException;
import java.util.*;
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
     JButton help,next,retry,but;
     JLabel b_Image;
 public MainPannel() throws IOException{
        top=new JPanel();
       /* card=new CardLayout();
        top.setLayout(card);*/
        add(top);
        left=new JPanel();
        right=new JPanel();
        //right.setBackground(new java.awt.Color(255, 0, 100));
       /*   b_Image = new JLabel();
          b_Image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/aaback.jpg"))); 
        add(b_Image);
        b_Image.setBounds(0, 0, 860, 620);*/
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
        but=new JButton("Submit");
        but.setBackground(new java.awt.Color(255, 255, 255));
        but.setFont(new java.awt.Font("Tahoma", 0, 18)); 
        but.setForeground(new java.awt.Color(102, 0, 0));
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
        right.add(but);
        right.add(help);
        right.add(retry);
        right.add(next);
        but.addActionListener(this);
        help.addActionListener(this);
        retry.addActionListener(this);
        next.addActionListener(this);
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
        else if(ob==next)
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

        else if (but==ob){
		//Button listener
	String input=game.t1.getText();
	if (game.ans==Integer.parseInt(input))
        {
           switch(game.level)
	{case 1:{
            JOptionPane.showMessageDialog(null,"Congratulations.You won level 1.\nClick the NEXT button for level 2","Level 1 won.",1);
            //level2();
           
            break;
	}
        case 2:{
            game.jp.removeAll();
           
            JOptionPane.showMessageDialog(null,"Congratulations.You won the game.\n"+
                    "Press NEXT to proceed further.","Won",1);
         
            game.level=3;
        break;}}}
	else
	{
            game.jp.remove(but);
            game.jp.remove(game.j2);
            game.jp.remove(game.b5);
            game.jp.remove(game.t1);
            game.Max=8;
            JOptionPane.showMessageDialog(null,"Your answer is incorrect.\n"+
                    "Press RETRY button to try again.","Lost",0);
            game.level=1;
            
	}	
	game.jp.repaint();
	game.jp.revalidate();
	
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

