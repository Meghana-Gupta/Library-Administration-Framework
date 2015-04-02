package check;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JFrame;
public class Deatils1 extends JFrame implements ActionListener{
    JLabel a;
    JTextField d;
    JButton btn1,b2,b3,b4,b5;
    JPasswordField p1;
    String s;
    Deatils1(int i)
    {
        s = String.valueOf(i);
        setTitle("Book Bank");
        setSize(1365,770);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a=new JLabel("Welcome");
        a.setBounds(600,80,500,60);
      a.setFont(new Font("serif",Font.BOLD,40));
        //a.setFont(new Font("serif",Font.PLAIN,10));
        a.setForeground(Color.pink);
        btn1 = new JButton("VIEW BOOKS");
        btn1.setActionCommand("view");
        b2 = new JButton("GET BOOKS");
        b2.setActionCommand("get");
        b3 = new JButton("RETURN");
        b3.setActionCommand("return");  
       // b4 = new JButton("FINANCE");
        //b4.setActionCommand("finance");
        b5=new JButton("SEARCH BOOKS");
        b5.setActionCommand("search books");
        btn1.setBounds(500,180,250,50);
        b2.setBounds(500,280,250,50);
        b3.setBounds(500,380,250,50);
        //b4.setBounds(500,480,250,50);
        b5.setBounds(500,480,250,50);
        d=new JTextField(s);
        add(btn1);
        add(a);
        add(b2);
        add(b3);
        //add(b4);
        add(b5);
        add(d);
        setVisible(true);
        btn1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b5.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {   
        if (e.getActionCommand() == "view")
            view();
        else if(e.getActionCommand() == "get")
               new Get(s);
          
        else if(e.getActionCommand() == "return")
            new Return1();
        //    System.out.println("hi");
         else if(e.getActionCommand() == "search books")
                new View1(s);
    }
    public void view()
    {
     try{  
          Class.forName("oracle.jdbc.driver.OracleDriver");
          Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","megs");
          Statement stmt=conn.createStatement();
          PreparedStatement ps = conn.prepareStatement("select bookid,bookname,edition,author,availability from book");
          ResultSet rs = ps.executeQuery();
          int i=0;
          JFrame a=new JFrame();
          while(rs.next()){
              String s1=rs.getString(1);
              String s2=rs.getString(2);
              String s3=rs.getString(3);
              String s4=rs.getString(4);
              String s5=rs.getString(5);
              a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              a.setBackground(Color.yellow);
              a.setLayout(null);
              a.setSize(1375,770);
              JLabel b=new JLabel("BOOK ID");
              b.setBounds(50,80,150,30);
              b.setFont(new Font("serif",Font.BOLD,30));
              a.add(b);
              JLabel c=new JLabel("BOOK NAME");
              c.setBounds(200,80,200,30);
              c.setFont(new Font("serif",Font.BOLD,30));
              JLabel d=new JLabel();
              JLabel f=new JLabel("EDITION");
              f.setBounds(450,80,150,30);
              f.setFont(new Font("serif",Font.BOLD,30));
              b=new JLabel("AUTHOR");
              b.setBounds(600,80,150,30);
              b.setFont(new Font("serif",Font.BOLD,30));
              a.add(b);
              d.setText(String.valueOf(s1));
              d.setBounds(50,170+i,200,30);
              d.setFont(new Font("serif",Font.BOLD,30));
              JLabel h=new JLabel("AVAILABILITY");
              h.setBounds(825,80,200,30);
              h.setFont(new Font("serif",Font.BOLD,30));
              a.add(h);
              JLabel e=new JLabel();
              e.setBounds(200,170+i,200,30);
              e.setFont(new Font("serif",Font.BOLD,30));
              e.setText(s2);
              a.add(e);
              JLabel g=new JLabel();
              g.setText(s3);
              g.setBounds(450,170+i,200,30);
              g.setFont(new Font("serif",Font.BOLD,30));
              a.add(b);
              a.add(c);
              a.add(d);
              JLabel j=new JLabel();
              j.setBounds(600,170+i,200,30);
              j.setFont(new Font("serif",Font.BOLD,30));
              j.setText(s4);
              a.add(j);
              JLabel k=new JLabel();
              k.setBounds(825,170+i,200,30);
              k.setFont(new Font("serif",Font.BOLD,30));
              k.setText(s5);
              a.add(k);
              a.add(g);
              a.add(f);
              a.add(j);
              a.setVisible(true);
              i=i+30;
          }
          
          
          stmt.close();
     }
      
      catch(SQLException se)
        {
            System.out.println(se.getMessage());
             JOptionPane.showMessageDialog(null, "BOOK IS NOT AVAILABLE");
        }

     catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Please verify your Connection");
            System.out.println(e.getMessage());
        }   
    }        
    
}
    
    
    
