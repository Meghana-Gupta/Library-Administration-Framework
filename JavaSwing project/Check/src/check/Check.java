package check;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JFrame;
public class Check extends JFrame implements ActionListener {
    JLabel a;
    JButton btn1,b2,b3,b4;
    JPasswordField p1;
    Check() {
        setTitle("Login Form");
        setSize(1365,770);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a=new JLabel("Welcome to library");
        a.setBounds(500,200,500,60);
        a.setFont(new Font("serif",Font.BOLD,40));
        a.setForeground(Color.MAGENTA);
        btn1 = new JButton("ACCOUNT");
        btn1.setActionCommand("account");
        b2 = new JButton("STATUS");
        b2.setActionCommand("Status");
        b3 = new JButton("ADMIN");
        b4= new JButton("Return");
        b4.setActionCommand("Return");
        b3.setActionCommand("Admin");  
        btn1.setBounds(650,420,100,50);
        b2.setBounds(450,420,100,50);
        b3.setBounds(850,420,100,50);  
        b4.setBounds(600,620,100,50);
        add(btn1);
        add(a);
        add(b2);
        add(b3);
        add(b4);
        btn1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        setVisible(true);
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {   
        if (e.getActionCommand() == "account")
            new Deatils();
        else if(e.getActionCommand() == "Status")
            new Status();
        else if(e.getActionCommand() =="Admin")
            new Admin();
        else if(e.getActionCommand() =="Return")
           new Return1();
    }
    public static void main(String args[]) {
         new Check();
    }
}
