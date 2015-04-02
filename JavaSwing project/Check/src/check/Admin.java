package check;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JFrame;
public class Admin extends JFrame implements ActionListener{
    JLabel a,b,c;
    JPasswordField p1;
    JTextField t1,t2,t3;
    JButton btn1;
    Admin()
    {
        setTitle("Library Management");
        setSize(1365,770);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a=new JLabel("******ADMIN-LOGIN******");
        a.setBounds(500,100,500,60);
        a.setFont(new Font("serif",Font.BOLD,40));
        a.setForeground(Color.MAGENTA);
        add(a);
        a=new JLabel("USER NAME");
        a.setBounds(470,185,200,30);
        a.setFont(new Font("serif",Font.BOLD,30));
        add(a);
        t1=new JTextField();
        t1.setBounds(680,185,200,30);
        add(t1);
        b=new JLabel("PASSWORD");
        b.setBounds(470,220,200,30);
        b.setFont(new Font("serif",Font.BOLD,30));
        add(b);
        p1 = new JPasswordField();
        p1.setBounds(680,220,200,30);
        add(p1);
        btn1 = new JButton("Submit");
        btn1.setActionCommand("Submit");
        btn1.setBounds(620,320,130,30);
        btn1.addActionListener(this);
        add(btn1);
        btn1 = new JButton("HOME");
        btn1.setActionCommand("Home");
        btn1.setBounds(760,320,130,30);
        add(btn1);
        btn1.addActionListener(this);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand()=="Submit")
            check();
        else 
            new Check();
    }
    public void check()
    {
        String str1="",str2="";
        str1=t1.getText();
        str2=p1.getText();
        if(str1.equals("arun") || str1.equals("arun"))
        {
            new Admin1();
        }
    }        
}

