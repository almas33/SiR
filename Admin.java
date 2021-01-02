import javax.swing.*;
import java.awt.event.*;

public class Admin extends JFrame implements ActionListener
{
    private static final long serialVersionUID = 1L;
	JLabel l;  
    JButton b1;
    JButton b2;
    JButton b3;
    
    Admin()
    {
    	super("Admin menu :- ");  
    	
        l=new JLabel("Please select an item :- ");  
        l.setBounds(50,70,150,20);
          
        b1=new JButton("Add Details");  
        b1.setBounds(50,150,200,70);
        b2=new JButton("Delete Details");  
        b2.setBounds(50,250,200,70);
        b3=new JButton("Modify Details");  
        b3.setBounds(50,350,200,70);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this); 
        
        
        
        add(l);    
        add(b1);
        add(b2);
        add(b3);
        
        setSize(600,700);  
        setLayout(null);  
        setVisible(true); 
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e){ 
    	
        if(e.getSource()==b1){
            new AddDetails();
        }
        else if(e.getSource()==b2){
            new DeleteDetails();
        } 
        else{
            new ModifyDetails();
        }
    }  

}
