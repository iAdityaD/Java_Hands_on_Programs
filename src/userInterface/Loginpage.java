package userInterface;


import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public abstract class Loginpage  implements ActionListener, KeyListener{
	
	JFrame login;
	JButton[] b = new JButton[2];
	Loginpage(){
		login= new JFrame("Login Page");
		b[0] = new JButton("Login");
		login.add(b[1]);
	}
	
	
	
	

}
