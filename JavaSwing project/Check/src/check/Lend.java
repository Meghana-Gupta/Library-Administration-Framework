package check;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JFrame;
public class Lend extends JFrame implements ActionListener{
    JLabel a,b,c,d;
    JTextField t1,t2,t3,t4;
    JButton button1;
    JPasswordField p1,p2;
    Lend()
    {
        setTitle("Book Bank");
        setSize(1365,770);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a=new JLabel("Registration");
        a.setBounds(500,100,500,60);
        a.setFont(new Font("serif",Font.BOLD,40));
        a.setForeground(Color.red);
        add(a);
        c= new JLabel(" New User Name");
        c.setBounds(400,100,300,200);
        c.setFont(new Font("serif",Font.BOLD,30));
        add(c);
        a=new JLabel("New User Id");
        a.setBounds(400,250,300,30);
        a.setFont(new Font("serif",Font.BOLD,30));
        add(a);
        b=new JLabel("Phone Number");
        b.setBounds(400,320,300,30);
        b.setFont(new Font("serif",Font.BOLD,30));
        add(b);
        //b=new JLabel("Course");
        //b.setBounds(470,380,200,30);
        //b.setFont(new Font("serif",Font.BOLD,30));
        //a/dd(b);
        b=new JLabel(" Create Password");
        b.setBounds(400,370,300,30);
        b.setFont(new Font("serif",Font.BOLD,30));
        add(b);
        p1 = new JPasswordField();
        p1.setBounds(730,370,200,30);
        add(p1);
        /*b=new JLabel("Confirm Password");
        b.setBounds(470,510,240,30);
        b.setFont(new Font("serif",Font.BOLD,30));
        add(b);
        p2 = new JPasswordField();
        p2.setBounds(730,510,200,30);
        add(p1);*/
        button1=new JButton("ENTER");
        button1.setActionCommand("enter");
        button1.setBounds(600,580,100,50);
        button1.addActionListener(this);
        add(button1);
        t1=new JTextField();
        t1.setBounds(730,185,200,30);
        add(t1);
        t2=new JTextField();
        t2.setBounds(730,250,200,30);
        add(t2);
        t3=new JTextField();
        t3.setBounds(730,325,200,30);
        add(t3);
        
        setVisible(true);           
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand()=="enter")
            new_ac();
    }
    public void new_ac()
    {
        String str1="",str2="",str3="",str4="";
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection cnt=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "megs");
            Statement stmt=cnt.createStatement();
            try{
            str1=t1.getText();
            str2=t2.getText();
            str3=t3.getText();
            str4=new String(p1.getPassword());
            
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
             
              
          }
            int ent=Integer.parseInt(str2);
            stmt.executeUpdate("insert into newuser values ("+ent+",'"+str1+"','"+str3+"','"+str4+"')");
           // JOptionPane.showMessageDialog(null, "your accont is successfully  created");
 
        }
        catch(SQLException se)
        {
             //JOptionPane.showMessageDialog(null, "BOOK IS NOT AVAILABLE");
             System.out.println(se.getMessage());
        }

     catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Please verify your Connection");
            System.out.println(e.getMessage());
        }
     }
    }   
        
    

