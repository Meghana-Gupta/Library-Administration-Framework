package check;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JFrame;
public class Admin1 extends JFrame implements ActionListener{
    JLabel a;
    JButton b1,b2;
    Admin1()
    {
        setTitle("Library Management System");
        setSize(1365,770);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a=new JLabel(" Welcome ");
        a.setBounds(600,200,500,60);
        a.setFont(new Font("serif",Font.BOLD,40));
        a.setForeground(Color.MAGENTA);
        b1 = new JButton("Insert Book");
        b1.setActionCommand("Book");
        b2 = new JButton("Student Details");
        b2.setActionCommand("Student");  
        b1.setBounds(300,420,200,50);
        b2.setBounds(750,420,200,50);
        add(a);
        add(b1);
        add(b2);
        b1.addActionListener(this);
        b2.addActionListener(this);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand()=="Book")
           new Insert();
        if(e.getActionCommand()=="Student")
        {
            student();
        }
    }
    public void student()
    {
       String str1="",str2="",str3="";
        int in1=0,in2=0;
        try
        {
         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
         Connection cnt=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "kannan03");
         Statement stmt=cnt.createStatement();
         PreparedStatement ps = cnt.prepareStatement("select sid,sname,dment,bname,issued_date,return_date,fine from student");
         ResultSet rs = ps.executeQuery();
         int i=0;
        
        JFrame a=new JFrame();
          
          while(rs.next()){
              String s1=rs.getString(1);
              String s2=rs.getString(2);
              String s3=rs.getString(3);
              String s4=rs.getString(4);
              String s5=rs.getString(5);
              String s6=rs.getString(6);
              String s7=rs.getString(7);
              a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              a.setBackground(Color.yellow);
              a.setLayout(null);
              a.setSize(1375,770);
              JLabel b=new JLabel("STU ID");
              b.setBounds(50,80,150,30);
              b.setFont(new Font("serif",Font.BOLD,30));
              a.add(b);
              JLabel c=new JLabel("STU NAME");
              c.setBounds(200,80,200,30);
              c.setFont(new Font("serif",Font.BOLD,30));
              JLabel d=new JLabel();
              JLabel f=new JLabel("DMENT");
              f.setBounds(450,80,150,30);
              f.setFont(new Font("serif",Font.BOLD,30));
              b=new JLabel("BOOK NAME");
              b.setBounds(600,80,200,30);
              b.setFont(new Font("serif",Font.BOLD,30));
              a.add(b);
              d.setText(String.valueOf(s1));
              d.setBounds(50,170+i,200,30);
              d.setFont(new Font("serif",Font.BOLD,30));
              JLabel h=new JLabel("I_DATE");
              h.setBounds(825,80,200,30);
              h.setFont(new Font("serif",Font.BOLD,30));
              a.add(h);
              h=new JLabel("R_DATE");
              h.setBounds(1100,80,250,30);
              h.setFont(new Font("serif",Font.BOLD,30));
              a.add(h);
              h=new JLabel("FINE");
              h.setBounds(1300,80,250,30);
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
              JLabel l=new JLabel();
              l.setBounds(1100,170+i,200,30);
              l.setFont(new Font("serif",Font.BOLD,30));
              l.setText(s6);
              JLabel m=new JLabel();
              m.setBounds(1300,170+i,200,30);
              m.setFont(new Font("serif",Font.BOLD,30));
              m.setText(s7);
              a.add(l);
              a.add(j);
              a.add(m);
             
              /*e=new JLabel();
              e.setBounds(700,170+i,200,30);
              e.setFont(new Font("serif",Font.BOLD,30));
              e.setText(s6);
              a.add(e);*/
              a.setVisible(true);
              i=i+30;
          }
          
          
          stmt.close();
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

