package check;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JFrame;
public class Insert extends JFrame implements ActionListener{
    JLabel a,b,c;
    JButton b1,b2;
    JTextField t1,t2,t3,t4,t5,t6;
    Insert()
    {
        setTitle("Library Management");
        setSize(1365,770);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a=new JLabel("BOOK ID");
        a.setBounds(500,80,150,30);
        a.setFont(new Font("serif",Font.BOLD,30));
        add(a);
        t1=new JTextField();
        t1.setBounds(730,80,200,30);
        add(t1);
        b=new JLabel("BOOK NAME");
        b.setBounds(500,180,200,30);
        b.setFont(new Font("serif",Font.BOLD,30));
        add(b);
        t2=new JTextField();
        t2.setBounds(730,180,200,30);
        add(t2);
        c=new JLabel("EDITION");      
        c.setBounds(500,280,150,30);
        c.setFont(new Font("serif",Font.BOLD,30));
        add(c);
        t3=new JTextField();
        t3.setBounds(730,280,200,30);
        add(t3);
        a=new JLabel("AUTHOR");
        a.setBounds(500,380,150,30);
        a.setFont(new Font("serif",Font.BOLD,30));
        add(a);
        t4=new JTextField();
        t4.setBounds(730,380,200,30);
        add(t4);
        b=new JLabel("LOCATION");
        b.setBounds(500,480,200,30);
        b.setFont(new Font("serif",Font.BOLD,30));
        add(b);
        t5=new JTextField();
        t5.setBounds(730,480,200,30);
        add(t5);
        c=new JLabel("AVAILABILITY");      
        c.setBounds(500,580,250,30);
        c.setFont(new Font("serif",Font.BOLD,30));
        add(c);
        t6=new JTextField();
        t6.setBounds(730,580,200,30);
        add(t6);
        b1=new JButton("ENTER");
        b1.setActionCommand("enter");
        b1.setBounds(600,680,100,50);
        add(b1);
        b2=new JButton("HOME");
        b2.setActionCommand("home");
        b2.setBounds(750,680,100,50);
        add(b2);
        b1.addActionListener(this);
        b2.addActionListener(this);
        setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand()=="home")
            new Check();
        else
            insert();
    }
    public void insert()
    {
         String str1="",str2="",str3="",str4="",str5="",str6="";
        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection cnt=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "kannan03");
            Statement stmt=cnt.createStatement();
            try{
            str1=t1.getText();
            str2=t2.getText();
            str3=t3.getText();
            str4=t4.getText();
            str5=t5.getText();
            str6=t6.getText();
            }
            catch(Exception e){
              if (str1.equals(null))
                  str1="";
              if (str2.equals(null))
                  str2 = "";
              if (str3.equals(null))
                  str3 = "";
              
              if(str4.equals(null))
                  str4="";
              if(str5.equals(null))
                  str5="";
              
          }
            stmt.executeUpdate("insert into book(bid,bname,edition,author,location,availablity) values ("+str1+",'"+str2+"','"+str3+"','"+str4+"','"+str5+"','"+str6+"')"); 
        }
        catch(SQLException se)
        {
             
             System.out.println(se.getMessage());
        }

     catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Please verify your Connection");
            System.out.println(e.getMessage());
        }
     }
    }        
    

