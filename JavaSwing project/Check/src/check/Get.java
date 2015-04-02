package check;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JFrame;
public class Get extends JFrame implements ActionListener{
   String a1;
   JLabel a,button,next,bid,bt;
    JTextField t1,t2,t3,t4;
    JComboBox jb; 
    JButton button1,button2;
 Get(String s)
 {
           a1=s;
           setTitle("Book Bank");
           setSize(1365,770);
           setBackground(Color.red);
           setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

           setLayout(null);

           a = new JLabel("Enter the required BookId");
           a.setBounds(600,50,600,40);
           a.setFont(new Font("serif",Font.BOLD,40));
           a.setForeground(Color.red);
           add(a);
           bt=new JLabel("BOOK ID");
           bt.setBounds(470,275,200,30);
           add(bt);
           t4=new JTextField();
           t4.setBounds(700,275,200,30);
           add(t4);
           button1=new JButton("ENTER");
           button1.setActionCommand("enter");
           button1.setBounds(700,480,100,50);
           add(button1);
           button2=new JButton("HOME");
           button2.setActionCommand("home");
           button2.setBounds(750,480,100,50);
           //add(button2);
           setVisible(true);
           button1.addActionListener(this);
           button2.addActionListener(this);
        
     
 }

    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getActionCommand()=="home")
        {
            new Deatils();
            
        }
         else
         {
             get();
         }    
         
        
    }
    public void get()
    {
        String str1="",str2="",str3="",str4="",str5="",str="issued",s1,s2,s3,s4,s5,s6="",s7="";
        int ent=0,ent1=0;
        try{  
          Class.forName("oracle.jdbc.driver.OracleDriver");
          Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","megs");
          Statement stmt=conn.createStatement();
          str1=t4.getText();
          ent=Integer.parseInt(str1);
          ent1=Integer.parseInt(a1);
          System.out.println(ent);
           PreparedStatement ps0 = conn.prepareStatement("select  availability from book where bookid="+ent);
           ResultSet rs0 = ps0.executeQuery();
           if(rs0.next()){
               System.out.println(ent);
               System.out.println(rs0.getString(1));
           if(rs0.getString(1).equals("not issued"))
           {    System.out.println("1:"+rs0.getString(1));
           PreparedStatement ps = conn.prepareStatement("select userid,username,to_char(issuedate,'dd-mon-yy'),to_char(duedate,'dd-mon,yy') from user1 where userid="+ent1);
           ResultSet rs = ps.executeQuery();
        
           if(rs.next()){
               
               System.out.println("2:"+rs0.getString(1));
               System.out.println(ent);
          s1=rs.getString(1);
          System.out.println("s1"+ent);
          s2=rs.getString(2); 
          s3=rs.getString(3);
          System.out.println("s2"+ent);
          s4=rs.getString(4);
          System.out.println("s3"+ent);
          
  
          
          
           PreparedStatement ps3 = conn.prepareStatement("select bookname from book where bookid="+ent);
           ResultSet rs3 = ps3.executeQuery();
        /*  PreparedStatement ps1 = conn.prepareStatement("select sysdate,sysdate+15 from dual");
           ResultSet rs1 = ps1.executeQuery();
           if(rs1.next()){
               
               s6=rs1.getString(1);
              s7=rs1.getString(2);
              System.out.println("s4"+ent);
              stmt.executeUpdate("update user1 set issuedate='"+s6+"' where userid= "+ent1+" and bookid= "+ent);
               System.out.println("s4"+ent);
              JOptionPane.showMessageDialog(null,"BOOK IS ISSUED");
           }*/
           if(rs3.next())
           {
               System.out.println("s5"+ent);
               System.out.println("3:"+rs0.getString(1));
             s5=rs3.getString(1);
            
            stmt.executeUpdate("insert into user2(userid,username,bookname) values ("+s1+",'"+s2+"','"+s5+"')"); 
            stmt.executeUpdate("update book set availability='"+str+"' where  bookid= "+ent);  
            System.out.println(s3);
           }
            System.out.println("ddf");
            
           }    
           
           
           
           }         
           
          else
              JOptionPane.showMessageDialog(null,"BOOK IS NOT AVAILABLE");
          stmt.close();
           }   
        }
      catch(SQLException se)
        {
             JOptionPane.showMessageDialog(null, "BOOK IS NOT AVAILABLE");
             System.out.println(se.getMessage());
             
        }

     catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Please verify your Connection");
            System.out.println(e.getMessage());
        }
    }        
 
}
