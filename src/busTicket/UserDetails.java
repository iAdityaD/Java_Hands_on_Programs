package busTicket;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import ticketPrice.Billing;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.*;
import java.text.ParseException;

public class UserDetails { 
	
	JFrame f= new JFrame("BUS TICKET BOOKING WINDOW"); 
	JFrame billframe;
	JLabel title, name, email, mobile, from, to,time,date,tickets; 

	JTextField tnam, tem,tnt;
	JTextArea bill;
	JButton submit,view,cancel,close,book;
	JFormattedTextField dat,tmb;
	MaskFormatter mf,mbf;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public UserDetails() { 
	
		JComboBox tfrm, tto,tti; 
		 
		Container c= f.getContentPane();
		c.setBackground(Color.cyan);
		
		title = new JLabel("BUS TICKET BOOKING");
		title.setFont(new Font("Verdana", Font.BOLD, 22));
		title.setBounds(200,0,300,50);
		name = new JLabel("NAME:");
		name.setBounds(50, 50, 100, 30);
		email = new JLabel("EMAIL :");
		email.setBounds(50, 100, 100, 30);
		mobile = new JLabel("MOBILE.NO:");
		mobile.setBounds(50, 150, 100, 30);
		date = new JLabel("DATE [DD/MM/YYYY]:");
		date.setBounds(50, 200, 200, 30);
		from = new JLabel("FROM:");
		from.setBounds(50, 250, 100, 30);
		to = new JLabel("TO:");
		to.setBounds(50, 300, 100, 30);
		time = new JLabel("TIME:");
		time.setBounds(50, 350, 100, 30); 
		tickets = new JLabel("NO. OF TICKETS:");
		tickets.setBounds(50, 400, 120,30);
		
		billframe = new JFrame("Billing");
		billframe.setBounds(300,100,300,200);
		billframe.setLayout(null);
		billframe.setBackground(Color.white);
	
		tnam = new JTextField(); 
		tem = new JTextField(); 
		
		try {
			mbf = new MaskFormatter("#########");
		} catch (ParseException e2) {
			e2.printStackTrace();
		}
		mbf.setPlaceholderCharacter('#');
		tmb = new JFormattedTextField(mbf);
		tmb.setColumns(9);
		
		try {
			mf = new MaskFormatter("##-##-####");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		mf.setPlaceholderCharacter('#');
		dat = new JFormattedTextField(mf);
		dat.setColumns(12);
		
		tnt = new JTextField();
		String s1[] = { " ", "CHENNAI", "BANGULORE", "HYDERABAD", "VIZAG"};
		String s2[] = { " ", "8:00", "11:00", "14:00","16:00", "19:00", "22:00" };
		tfrm = new JComboBox(s1); 
		tto = new JComboBox(s1); 
		tti = new JComboBox(s2); 
		
		tnam.setBounds(300, 50, 150, 30);
		tem.setBounds(300, 100, 200, 30);
		tmb.setBounds(300, 150, 150, 30);
		dat.setBounds(300, 200, 150, 30);
		tnt.setBounds(300, 400,150,30);
		tfrm.setBounds(300, 250, 140, 30); 
		tto.setBounds(300, 300, 140, 30);
		tti.setBounds(300, 350, 140, 30);
		
		
		submit = new JButton("Submit"); 
		submit.setBounds(50, 600, 150, 30);
		submit.setEnabled(false);
		close = new JButton("CLOSE"); 
		close.setBounds(500, 600, 100, 30); 
		view = new JButton("VIEW TICKETs PRICE"); 
		view.setBounds(250, 600, 200, 30);
		
		
		book = new JButton("Book"); 
		book.setBounds(50,100,100,30);
		billframe.add(book);
		cancel = new JButton("cancel"); 
		cancel.setBounds(150, 100, 100, 30);
		billframe.add(cancel);
		billframe.setVisible(false);
		
		submit.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
					String tick = tnt.getText(); 
					String from = (String) tfrm.getSelectedItem(); 
					String to = (String) tto.getSelectedItem();
					displaybill(from,to,tick);
					billframe.setVisible(true);
			} 
		});
		close.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				f.dispose(); 
			} 
		}); 
		
		cancel.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				billframe.dispose(); 
			} 
		}); 
		book.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				billframe.dispose();
				JOptionPane.showMessageDialog(f,"Your Tickets are Successfully booked");
			} 
		}); 
		view.addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent e) { 
					try {
						String ntick = tnt.getText(); 
						String from = (String) tfrm.getSelectedItem(); 
						String to = (String) tto.getSelectedItem();
						Billing order = new Billing(from,to,ntick);
						float total = order.amount();
							JOptionPane.showMessageDialog(f,"Tickect Cost(including 5% tax):" + total);
							submit.setEnabled(true);
					}
					catch(Exception ae) {
						JOptionPane.showMessageDialog(f,"Please Enter the No of tickets"); 
					}
				}
		});
		f.addWindowListener(new WindowAdapter() { 
			public void windowClosing(WindowEvent e) { 
				System.exit(0); 
			} 
		}); 
		f.add(title); f.add(name); f.add(tnam);f.add(tem); f.add(email); f.add(tmb); 
		f.add(mobile); f.add(tfrm); f.add(from); f.add(tto); f.add(to); f.add(dat);f.add(tnt);
		f.add(time);f.add(date);f.add(tickets);f.add(tti);f.add(submit); f.add(view); f.add(close);
		f.setLayout(null); 
		f.setSize(700, 800); 
		f.setVisible(true); 
	} 
	public void displaybill(String from,String to,String tickets) { 
		Billing order = new Billing(from,to,tickets);
		float total = order.amount();
		String tot= Float.toString(total);
		bill = new JTextArea();
		bill.setBounds(50,20,200,100);
		bill.setText(from+"----->"+to+"\nThe Tickets price: "+tot);
		billframe.add(bill);
		
	}
	public static void main(String args[]) { 
		new UserDetails(); 
	}
} 