package check;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JFrame;
public class Deatils extends JFrame implements ActionListener{
    JLabel a;
    
    JTextField t1;
    JButton btn1;
    JPasswordField p1;
    Connection conn;
    Deatils()
    {
        
        setTitle("****BOOK BANK****");
        setSize(1365,770);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a=new JLabel("LOGIN");
        a.setBounds(600,100,500,60);
        a.setFont(new Font("serif",Font.BOLD,40));
        a.setForeground(Color.red);
        
        add(a);
        a=new JLabel("Student Id");
        a.setBounds(470,185,200,30);
        a.setFont(new Font("serif",Font.BOLD,30));
        add(a);
        t1=new JTextField();
        t1.setBounds(680,185,200,30);
        add(t1);
        a=new JLabel("Password");
        a.setBounds(470,220,200,30);
        a.setFont(new Font("serif",Font.BOLD,30));
        add(a);
        p1 = new JPasswordField();
        p1.setBounds(680,220,200,30);
        add(p1);
        btn1 = new JButton("Login");
        btn1.setActionCommand("Login");
        btn1.setBounds(620,320,130,30);
        btn1.addActionListener(this);
        add(btn1);
        btn1 = new JButton("Register");
        btn1.setActionCommand("New");
        btn1.setBounds(760,320,130,30);
        add(btn1);
        btn1.addActionListener(this);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand() == "Login")
            insert();
            //new Deatils1(5);
        else if(e.getActionCommand() == "New")
            new Lend();
    }
public void insert()
    { int n=0;
           String str1="",str2="";
        try {
            JFrame f1 = new JFrame();
            JLabel l, lo;
            str1 = t1.getText();
            int j=Integer.parseInt(str1);
            char[] p = p1.getPassword();
            str2 = new String(p);
            n=Integer.parseInt(str1);
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "megs");
            PreparedStatement ps = conn.prepareStatement("select userid from user1 where userid=? and password=?");
            ps.setString(1, str1);
            ps.setString(2, str2);
           ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                new Deatils1(rs.getInt(1));

            } else {
                JOptionPane.showMessageDialog(null, "Incorrect id or password");

            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
public static void main(String args[]) {
         new Deatils();
    }
    }
    

