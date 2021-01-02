import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class DeleteDetails extends JFrame implements ActionListener
{
    private static final long serialVersionUID = 1L;
    JLabel l1;
    JTextField tf1; 
    JButton b;
    
    DeleteDetails()
    {
    	super("Delete Details of Student :- ");  
    	
        l1=new JLabel("R. No ");  
        l1.setBounds(50,70,150,20);

        tf1=new JTextField();  
        tf1.setBounds(150,70,200,20);  
          
        b=new JButton("Submit");  
        b.setBounds(50,200,80,30); 
        
        b.addActionListener(this); 
        
        add(l1);  
        add(tf1);  
        add(b);

        setSize(600,700);  
        setLayout(null);  
        setVisible(true); 
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e){ 
    	
        String rno = tf1.getText();

        ArrayList<Details> a= new ArrayList<Details>();

        try {
            FileInputStream fin = new FileInputStream("D:\\Details.ser");
            ObjectInputStream in = new ObjectInputStream(fin);
            Details d;
            
            while (true) {
            d = (Details) in.readObject();
            a.add(d); 
            }
                     
          }
          catch (Exception eof) {
          }

        try {
            FileOutputStream fout = new FileOutputStream("D:\\Details.ser");
            ObjectOutputStream out = new ObjectOutputStream(fout);

            for(Details det : a)
                if(!det.rno.equals(rno))
                    out.writeObject(det);
            
            out.close();
            fout.close();
           }
           catch (IOException i) {
               i.printStackTrace();
         }
    }  

}
