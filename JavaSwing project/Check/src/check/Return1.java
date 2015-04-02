package check;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JFrame;
import check.Deatils1;
public class Return1 extends JFrame implements ActionListener{
JLabel a,button,next,bid;

    JTextField t1,t2,t3;
    JComboBox jb;
    String s[]={"Select ","maths","tamil"}; 
    JButton button1,button2;
    Return1(){
           setTitle("Book Bank");
           setSize(1365,770);
           setBackground(Color.red);
           setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           setLayout(null);
           a = new JLabel("Enter");
           a.setBounds(600,50,300,30);
           a.setFont(new Font("serif",Font.BOLD,40));
           a.setForeground(Color.red);
           add(a);
           button = new JLabel("userid");
           button.setBounds(470,100,200,200);
           button.setFont(new Font("serif",Font.BOLD,30));
           add(button);
           t1=new JTextField();
           t1.setBounds(700,200,200,30);
           add(t1);
           a=new JLabel("bookid");
           a.setBounds(470,250,200,30);
           a.setFont(new Font("serif",Font.BOLD,30));
           add(a);
           t2=new JTextField();
           t2.setBounds(700,250,200,30);
           add(t2);
           next=new JLabel("return date");
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
         //  add(button2);
           setVisible(true);
           button1.addActionListener(this);
           button2.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand()=="enter")
        {
            System.out.println();
            update1();
        }
        else if(e.getActionCommand()=="home")
            new Deatils();
        
    }
  public void update1()
    {
        
        String str1="",str2="",str3="",str4="not issued";
        int in1=0,in2=0;
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection cnt=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "megs");
            Statement stmt=cnt.createStatement();
            try{
            str1=t1.getText();
            str2=t2.getText();
            str3=t3.getText();
            System.out.println("t1:"+str1+"t2:"+str2+"t3:"+str3);
            in1=Integer.parseInt(str1);
            in2=Integer.parseInt(str2);
            }
            catch(Exception e){
              if (str1.equals(null))
                  str1="";
              if (str2.equals(null))
                  str2 = "";
              if (str3.equals(null))
                  str3 = "";        
          }
         stmt.executeUpdate("update user1 set returndate='"+str3+"' where userid="+in1+" and bookid= "+in2+" ");
         stmt.executeUpdate("update book set availability='"+str4+"' where bookid="+in2);
        PreparedStatement ps = cnt.prepareStatement("select returndate-duedate from user1 where userid="+in1+"");
        // ps.setInt(5, in1);
        // ps.setInt(2, in2);
         System.out.println("hi");
         ResultSet rs = ps.executeQuery();
         int a=0;
         //int a1=0;
 int val=0;
         if(rs.next()){
        System.out.println("hello");
         String s1=rs.getString(1);
         a=Integer.parseInt(s1);
         System.out.println("dd");
         if(a>0){
          val=(a)*1;
          
         //JOptionPane.showMessageDialog(val,"Please verify your Connection");
         stmt.executeUpdate("update user1 set fine="+val+" where userid= "+in1+" and bookid="+in2+"");
         }
         else
           stmt.executeUpdate("update user1 set fine="+val+" where userid= "+in1+" and bookid="+in2+"");  
            }
         stmt.close();
        }
        catch(SQLException se)
        {
             
             System.out.println(se.getMessage());
        }

     catch(Exception e)
        {
            //JOptionPane.showMessageDialog(null,"Please verify your Connection");
            System.out.println(e.getMessage());
        }
     }
    }        

