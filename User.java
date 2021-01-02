import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class User extends JFrame implements ActionListener
{
    private static final long serialVersionUID = 1L;
	JLabel l;  
    JButton b1;
    JButton b2;
    
    User()
    {
    	super("User menu :- ");  
    	
        l=new JLabel("Please select an item :- ");  
        l.setBounds(50,70,150,20);
          
        b1=new JButton("View Details by Rno.");  
        b1.setBounds(50,150,400,70);
        b2=new JButton("View Details by Name");  
        b2.setBounds(50,250,400,70);
        
        b1.addActionListener(this);
        b2.addActionListener(this); 
        
        
        
        add(l);    
        add(b1);
        add(b2);
        
        setSize(600,700);  
        setLayout(null);  
        setVisible(true); 
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e) {
        try{ 
            String str;
            Socket socket = new Socket("localhost",8080); 
            DataInputStream input=new DataInputStream(socket.getInputStream());  
            DataOutputStream output=new DataOutputStream(socket.getOutputStream());
            if(e.getSource()==b1){
                output.writeUTF("byrno");
                str=input.readUTF();
            }
            else{
                output.writeUTF("byname");
                str=input.readUTF();
            }
            new Print(str);
            output.close();  
            socket.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
      

}
