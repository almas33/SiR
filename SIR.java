import javax.swing.*;
import java.awt.event.*; 
import java.awt.Color;

public class SIR extends JFrame implements ActionListener{
    
    private static final long serialVersionUID = 1L;
    JLabel l; 
    JButton b1;
    JButton b2;
    
    SIR()
    {
    	super("Student Information Record");  
    	
        l=new JLabel("Choose your designation :-");  
        l.setBounds(100,70,150,20);    
          
        b1=new JButton("Admin");  
        b1.setBounds(100,150,80,30);
        b1.setBackground(Color.YELLOW);
        b2=new JButton("User");
        b2.setBounds(100,250,80,30);
        b2.setBackground(Color.CYAN); 
        
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
    public void actionPerformed(ActionEvent e){ 
    	
        if(e.getSource()==b1){
            new Admin();
        }
        else{
            new User();
        } 
    }  

	public static void main(String[] args) 
	{
		new SIR();
	}

}
