import java.awt.event.*;
import javax.swing.*;
import java.util.concurrent.TimeUnit;
import java.awt.*;
class GameTry   implements ActionListener,Runnable 
{
JFrame jf;
TextField t1;
Thread t;
JPanel  jp;
int a,b,c,d,e,ans,sol;
JLabel jl,j1,j2;
Icon i1,i2,i3,i4,i5;
JButton b1,b2,b3,b4,b5,but;
GameTry()
{
jf=new JFrame();
jp=new JPanel();
jl=new JLabel();
t1=new TextField();
t=new Thread(this);
i1=new ImageIcon("a.png");
i2=new ImageIcon("b.png");
i3=new ImageIcon("c.png");
i4=new ImageIcon("d.png");
i5=new ImageIcon("e.png");
but=new JButton("Submit");
jf.add(jp);
t.start();
jf.setSize(860,620);
jf.setVisible(true);
jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);}
synchronized public void run()
{
	a=0;b=0;c=0;d=0;e=0;
	for(int i=0;i<8;i++)
	{
		if(i%2==0)
		{int rand=(int)(Math.random()*2);
		switch(rand)
		{
			case 0:
			b1=new JButton("",i1);
			jp.add(b1);
			jp.revalidate();
			//jp.add(jl);
			a++;
			break;
			case 1:
			b2=new JButton("",i2);
			b++;	
			jp.add(b2);
			jp.revalidate();
			break;
			case 2:
			b3=new JButton("",i3);
			c++;	
			jp.add(b3);
			jp.revalidate();
			break;
		}}
		if(i%2!=0)
		{int rand=(int)(Math.random()*1)+3;
			switch(rand)
			{case 3:
			b4=new JButton("",i4);
			d++;	
			jp.add(b4);
			jp.revalidate();
			break;
			case 4:
			b5=new JButton("",i5);
			e++;	
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
	
	int sol=(int)(Math.random()*4);
	j2=new JLabel("Enter no. of times this image appeared");
	switch(sol)
	{case 0:b5=new JButton("",i1);
	ans=a;
	break;
	case 1:b5=new JButton("",i2);
	ans=b;
	break;
	case 2:b5=new JButton("",i3);
	ans=c;
	break;
	case 3:b5=new JButton("",i4);
	ans=d;
	break;
	case 4:b5=new JButton("",i5);
	ans=e;
	break;
	}
	jp.add(j2);
	jp.add(b5);
	jp.add(t1);
    jp.add(but);
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
		jp.removeAll();
		b5=new JButton("You Won!!!!!!!!!");
	}
	else
	{
		jp.removeAll();
		b5=new JButton("Incorrect Answer");
	}	
	jp.repaint();
	jp.revalidate();
	jp.add(b5);
	}
}
public static void main(String args[])
{
	new GameTry();	
}}
