import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Contact {
	JFrame frame, frame1;
	JLabel l1, l2;
	JButton b1, b2, b3, b4;
	JTextField t1, t2;
	JDBCClass jdbc;

	public Contact() {
		jdbc = new JDBCClass();
		frame = new JFrame("Contact Management System");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("Image1.jpg"));
		b1 = new JButton("Create Contact");
		b2 = new JButton("Fetch Contact");
		b3 = new JButton("Delete Contact");
		b4 = new JButton("Update Contact");
		b1.setBounds(150, 100, 200, 50);
		b2.setBounds(150, 200, 200, 50);
		b3.setBounds(150, 300, 200, 50);
		b4.setBounds(150, 400, 200, 50);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createContact();
			}
		});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fetch();
			}
		});
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
			}
		});
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});
		frame.add(b1);
		frame.add(b2);
		frame.add(b3);
		frame.add(b4);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setSize(500, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	void update()
	{
		frame.setVisible(false);
		JFrame ff = new JFrame("Update Contact");
		ff.setLayout(null);
		frame.setVisible(false);
		JLabel a = new JLabel("Contact Name:"),a1=new JLabel("Updated Contact Name:"),a2=new JLabel("Updated Mobile No.:");
		a.setBounds(75, 100, a.getPreferredSize().width, a.getPreferredSize().height);
		JButton f=new JButton("Update Contact");
		JTextField t=new JTextField(),t1=new JTextField(),t2=new JTextField();
		a1.setBounds(75, 150, a1.getPreferredSize().width, a1.getPreferredSize().height);
		a2.setBounds(75, 200, a2.getPreferredSize().width, a2.getPreferredSize().height);
		t.setBounds(250,100,150,20);
		t1.setBounds(250,150,150,20);
		t2.setBounds(250,200,150,20);
		f.setBounds(150,250,f.getPreferredSize().width,f.getPreferredSize().height);
		f.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String aa=new String(jdbc.updateContact(t.getText(),t1.getText(),t2.getText()));
				ff.remove(a);
				ff.remove(f);
				ff.remove(t);
				ff.remove(a1);
				ff.remove(a2);
				ff.remove(t1);
				ff.remove(t2);
				ff.setVisible(false);
				ff.setVisible(true);
				showUpdate(ff, aa,t.getText());
			}
		});
		ff.setSize(500, 500);
		ff.setVisible(true);
		ff.add(a);
		ff.add(f);
		ff.add(t);
		ff.add(a1);
		ff.add(a2);
		ff.add(t1);
		ff.add(t2);
		ff.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
	void showUpdate(JFrame f,String a,String b)
	{
		JLabel x = new JLabel(b+" :"+a);
		x.setBounds(160, 100, x.getPreferredSize().width, x.getPreferredSize().height);
		JButton bb = new JButton();
		bb.setText("Go To Contact Management System");
		bb.setBounds(125, 200, bb.getPreferredSize().width, bb.getPreferredSize().height);
		bb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				frame.setVisible(true);
			}
		});
		f.setLayout(null);
		f.setSize(500, 500);
		f.setVisible(true);
		f.add(x);
		f.add(bb);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	void createContact() {
		JButton b = new JButton("SAVE");
		frame.setVisible(false);
		frame1 = new JFrame("Create Contact");
		frame1.setLayout(null);
		l1 = new JLabel("Contact Name:");
		l2 = new JLabel("Mobile No.:");
		t1 = new JTextField();
		t2 = new JTextField();
		l1.setBounds(0, 100, 100, 50);
		l2.setBounds(0, 150, 100, 50);
		t1.setBounds(150, 115, 200, 20);
		t2.setBounds(150, 165, 200, 20);
		b.setBounds(150, 200, 100, 50);
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (t1.getText().trim().equals("") || t2.getText().trim().equals("")) {
					b.disable();
				} else {
					jdbc.saveConatct(t1.getText(), t2.getText());
					frame1.setVisible(false);
					doneWork();
				}
			}
		});
		frame1.add(l1);
		frame1.add(t1);
		frame1.add(t2);
		frame1.add(b);
		frame1.add(l2);
		frame1.setSize(500, 500);
		frame1.setVisible(true);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	void delete()
	{
		frame.setVisible(false);
		JFrame ff = new JFrame("Delete Contact");
		ff.setLayout(null);
		frame.setVisible(false);
		JLabel a = new JLabel("Contact Name:");
		a.setBounds(75, 100, a.getPreferredSize().width, a.getPreferredSize().height);
		JButton f=new JButton("Delete Contact");
		JTextField t=new JTextField();
		t.setBounds(180,100,150,20);
		f.setBounds(150,200,f.getPreferredSize().width,f.getPreferredSize().height);
		f.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String aa=new String(jdbc.deleteContact(t.getText()));
				ff.remove(a);
				ff.remove(f);
				ff.remove(t);
				ff.setVisible(false);
				ff.setVisible(true);
				showDeletion(ff, aa,t.getText());
			}
		});
		ff.setSize(500, 500);
		ff.setVisible(true);
		ff.add(a);
		ff.add(f);
		ff.add(t);
		ff.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	void showDeletion(JFrame f,String a,String b)
	{
		JLabel x = new JLabel(b+" :"+a);
		x.setBounds(160, 100, x.getPreferredSize().width, x.getPreferredSize().height);
		JButton bb = new JButton();
		bb.setText("Go To Contact Management System");
		bb.setBounds(125, 200, bb.getPreferredSize().width, bb.getPreferredSize().height);
		bb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				frame.setVisible(true);
			}
		});
		f.setLayout(null);
		f.setSize(500, 500);
		f.setVisible(true);
		f.add(x);
		f.add(bb);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	void fetch() {
		frame.setVisible(false);
		JFrame ff = new JFrame("Fetch Contact");
		ff.setLayout(null);
		JLabel a = new JLabel("Contact Name:");
		a.setBounds(75, 100, a.getPreferredSize().width, a.getPreferredSize().height);
		JButton f=new JButton("Fatch Contact");
		JTextField t=new JTextField();
		t.setBounds(180,100,150,20);
		f.setBounds(150,200,f.getPreferredSize().width,f.getPreferredSize().height);
		f.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String aa=new String(jdbc.fetchContact(t.getText()));
				ff.remove(a);
				ff.remove(f);
				ff.remove(t);
				ff.setVisible(false);
				ff.setVisible(true);
				showInfo(ff, aa,t.getText());
			}
		});
		ff.setSize(500, 500);
		ff.setVisible(true);
		ff.add(a);
		ff.add(f);
		ff.add(t);
		ff.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	void showInfo(JFrame f,String a,String b)
	{
		JLabel x = new JLabel(b+" :"+a);
		x.setBounds(160, 100, x.getPreferredSize().width, x.getPreferredSize().height);
		JButton bb = new JButton();
		bb.setText("Go To Contact Management System");
		bb.setBounds(125, 200, bb.getPreferredSize().width, bb.getPreferredSize().height);
		bb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				frame.setVisible(true);
			}
		});
		f.setLayout(null);
		f.setSize(500, 500);
		f.setVisible(true);
		f.add(x);
		f.add(bb);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	void doneWork() {
		JLabel x = new JLabel("Contact Saved");
		x.setBounds(200, 100, x.getPreferredSize().width, x.getPreferredSize().height);
		JButton bb = new JButton();
		bb.setText("Go To Contact Management System");
		bb.setBounds(125, 200, bb.getPreferredSize().width, bb.getPreferredSize().height);
		JFrame f = new JFrame("Contact Saved");
		bb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				frame.setVisible(true);
			}
		});
		f.setLayout(null);
		f.setSize(500, 500);
		f.setVisible(true);
		f.add(x);
		f.add(bb);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		Contact a = new Contact();
	}
}
