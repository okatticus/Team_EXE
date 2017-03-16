/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gametry;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.*;
/*
 *
 * @author Apoorva
 */
public class GameClass implements ActionListener,Runnable{


TextField t1;
//Thread t;
JPanel  jp;
int a,b,c,d,e,ans,sol;
int level=1,Max=8;
JLabel jl,j1,j2,jname;
ImageIcon i1,i2,i3,i4,i5;
JButton b1,b2,b3,b4,b5,but;
GridBagLayout gridbag;
GridBagConstraints gbc;
GameClass() throws IOException 
{

jp=new JPanel();
jl=new JLabel();
t1=new TextField("Answer");
//t=new Thread(this);
jname=new JLabel("MEMORY GAME");
gridbag=new GridBagLayout();
gbc=new GridBagConstraints();
gbc.anchor=GridBagConstraints.NORTH;
InputStream input1 = getClass().getResourceAsStream("/resources/a.png");
InputStream input2 = getClass().getResourceAsStream("/resources/b.png");
InputStream input3 = getClass().getResourceAsStream("/resources/c.png");
InputStream input4 = getClass().getResourceAsStream("/resources/d.png");
InputStream input5 = getClass().getResourceAsStream("/resources/e.png");
//ImageIcon icon = new ImageIcon(ImageIO.read(input));
i1=new ImageIcon(ImageIO.read(input1));
i2=new ImageIcon(ImageIO.read(input2));
i3=new ImageIcon(ImageIO.read(input3));
i4=new ImageIcon(ImageIO.read(input4));
i5=new ImageIcon(ImageIO.read(input5));
but=new JButton("Submit");
but.setBackground(new java.awt.Color(255, 255, 255));
but.setFont(new java.awt.Font("Tahoma", 0, 18)); 
but.setForeground(new java.awt.Color(102, 0, 0));
//t.start();
jp.setSize(860, 620);//our standard game pannel size
jp.setOpaque(false);//to make buttons transparent
        
jp.setVisible(true);
}

synchronized public void run()
{
	a=0;b=0;c=0;d=0;e=0;
	for(int i=0;i<Max;i++)
	{
		if(i%2==0)
		{
                int rand=(int)(Math.random()*3)+1;
		switch(rand)
		{
			case 1:
			b1=new JButton("",i1);
			gbc.gridx=4;
			gbc.gridy=4;
			gridbag.setConstraints(b1,gbc);	
			jp.add(b1);
			jp.revalidate();
			//jp.add(jl);
			a++;
			break;
			case 2:
			b2=new JButton("",i2);
			b++;
			gbc.gridx=4;
			gbc.gridy=4;
			gridbag.setConstraints(b2,gbc);
			jp.add(b2);			
			jp.revalidate();
			break;
			case 3:
			b3=new JButton("",i3);
			c++;	
			gbc.gridx=4;
			gbc.gridy=4;
			gridbag.setConstraints(b3,gbc);	
			jp.add(b3);
			jp.revalidate();
			break;
		}}
		if(i%2!=0)
		{int rand=(int)(Math.random()*2)+1;
			switch(rand)
			{case 1:
			b4=new JButton("",i4);
			d++;	
			gbc.gridx=4;
			gbc.gridy=4;
			gridbag.setConstraints(b4,gbc);	
			jp.add(b4);
			jp.revalidate();
			break;
			case 2:
			b5=new JButton("",i5);
			e++;	
			gbc.gridx=4;
			gbc.gridy=4;
			gridbag.setConstraints(b5,gbc);		
			jp.add(b5);
			jp.revalidate();
			break;}
	}
		try {
			TimeUnit.SECONDS.sleep(1);
			}
		catch (InterruptedException e)
		{
				//;
		}
		jp.removeAll();
	}
	
	int sol=(int)(Math.random()*5)+1;
	j2=new JLabel("Enter no. of times this image appeared");
        j2.setFont(new java.awt.Font("Tahoma", 0, 18));
	switch(sol)
	{case 1:b5=new JButton("",i1);
	ans=a;
	break;
	case 2:b5=new JButton("",i2);
	ans=b;
	break;
	case 3:b5=new JButton("",i3);
	ans=c;
	break;
	case 4:b5=new JButton("",i4);
	ans=d;
	break;
	case 5:b5=new JButton("",i5);
	ans=e;
	break;
	}
	gbc.gridx=0;
	gbc.gridy=0;
	gridbag.setConstraints(j2,gbc);
	jp.add(j2);
        gbc.gridx=100;
	gbc.gridy=0;
	gridbag.setConstraints(t1,gbc);
	gbc.gridx=140;
	gbc.gridy=0;
	gridbag.setConstraints(but,gbc);
        jp.add(but);
        jp.add(t1);	
        gbc.gridx=0;
	gbc.gridy=200;
	gridbag.setConstraints(b5,gbc);
	jp.add(b5);
	jp.revalidate();
	but.addActionListener(this);
}

public void actionPerformed(ActionEvent ae)
{
	Object ob;
	ob=ae.getSource();
	if (but==ob){
		//Button listener
	String input=t1.getText();
	if (ans==Integer.parseInt(input))
        {
           switch(level)
	{case 1:{
            JOptionPane.showMessageDialog(null,"Congratulations.You won level 1.","Level 1 won.",1);
            //level2();
           /* try {
			TimeUnit.SECONDS.sleep(1);
			}
		catch (InterruptedException e)
		{
				//;
		}
            Max=12;
            Thread lvl2=new Thread(this);
           lvl2.start();
            level=2;*/
            break;
	}
        case 2:{
            jp.removeAll();
           
            JOptionPane.showMessageDialog(null,"Congratulations.You won the game.\n"+
                    "Press NEXT to proceed further.","Won",1);
         
            level=3;
        break;}}}
	else
	{
            jp.remove(but);
            jp.remove(j2);
            jp.remove(b5);
            jp.remove(t1);
            Max=8;
            JOptionPane.showMessageDialog(null,"Your answer is incorrect.\n"+
                    "Press RETRY button to try again.","Lost",0);
            level=1;
            
	}	
	jp.repaint();
	jp.revalidate();
	
	}
}
}


