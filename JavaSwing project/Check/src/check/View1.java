package check;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JFrame;
public class View1 extends JFrame implements ActionListener{
    JLabel a,button,next,bid;
    JTextField t1,t2,t3;
    JComboBox jb; 
    JButton button1,button2;
    View1(String i){
           setTitle("Book Bank");
           setSize(1365,770);
           setBackground(Color.blue);
           setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

           setLayout(null);

           a = new JLabel(" Enter");
           a.setBounds(600,50,300,30);
           a.setFont(new Font("serif",Font.BOLD,40));
           a.setForeground(Color.red);
           add(a);
           button = new JLabel("Book Name");
           button.setBounds(470,100,200,200);
           button.setFont(new Font("serif",Font.BOLD,30));
           add(button);
           t1=new JTextField();
           t1.setBounds(700,185,200,30);
           add(t1);
           a=new JLabel("Author Name");
           a.setBounds(470,250,200,30);
           a.setFont(new Font("serif",Font.BOLD,30));
           add(a);
           t2=new JTextField();
           t2.setBounds(700,250,200,30);
           add(t2);
           next=new JLabel("EDITION");
           next.setBounds(470,325,200,25);
           next.setFont(new Font("serif",Font.BOLD,30));
           add(next);
           t3=new JTextField();
           t3.setBounds(700,325,200,30);
           add(t3);
           button1=new JButton("ENTER");
           button1.setActionCommand("enter");
           button1.setBounds(600,480,100,50);
           add(button1);
           button2=new JButton("HOME");
           button2.setActionCommand("home");
           button2.setBounds(750,480,100,50);
           add(button2);
           setVisible(true);
           button1.addActionListener(this);
           button2.addActionListener(this);
        
    }     

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand()=="home")
            new Deatils();
        else
        {
            String str1="",str2="",str3="",str4="",str5="";
      int ent=0,ent1=0;
     try{  
          Class.forName("oracle.jdbc.driver.OracleDriver");
          Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","megs");
          Statement stmt=conn.createStatement();
          try {
          str1=t1.getText();
          str2=t2.getText(); 
          str3=t3.getText();
          if(str3!=null)
              ent=Integer.parseInt(str3);
          }
          catch(Exception ee){
              if (str1.equals(null))
                  str1="";
              if (str2.equals(null))
                  str2 = "";
              if (str3.equals(null))
                  str3 = "";
              if(str4.equals(null))
                  str4="";
          }
          PreparedStatement ps = conn.prepareStatement("select bookid,bookname,edition,author,availability from book where bookname=? or author=? or edition=?");
          ps.setString(1, str1);
          ps.setString(2, str2);
          ps.setInt(3, ent);
          ResultSet rs = ps.executeQuery();
          int i=0;
          JFrame a=new JFrame();
          
          while(rs.next()){
              String s1=rs.getString(1);
              String s2=rs.getString(2);
              String s3=rs.getString(3);
              String s4=rs.getString(4);
              String s5=rs.getString(5);
            //  String s6=rs.getString(6);
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
              h.setBounds(825,80,250,30);
              h.setFont(new Font("serif",Font.BOLD,30));
              a.add(h);
              JLabel ee=new JLabel();
              ee.setBounds(200,170+i,200,30);
              ee.setFont(new Font("serif",Font.BOLD,30));
              ee.setText(s2);
              a.add(ee);
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
              l.setBounds(1000,170+i,200,30);
              l.setFont(new Font("serif",Font.BOLD,30));
            //  l.setText(s6);
             // a.add(l);
              a.add(j);
             
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
             JOptionPane.showMessageDialog(null, "BOOK IS NOT AVAILABLE");
        }

     catch(Exception ef)
        {
            JOptionPane.showMessageDialog(null,"Please verify your Connection");
            System.out.println(ef.getMessage());
        }
        }    
    }
    
}
