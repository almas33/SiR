import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class AddDetails extends JFrame implements ActionListener
{
    private static final long serialVersionUID = 1L;
    JLabel l1;
    JLabel l2;
    JLabel l3;
    JTextField tf1; 
    JTextField tf2;
    JTextField tf3; 
    JButton b;
    
    AddDetails()
    {
    	super("Add Details of Student :- ");  
    	
        l1=new JLabel("Name ");  
        l1.setBounds(50,70,150,20);
        l2=new JLabel("R. No ");  
        l2.setBounds(50,100,150,20);
        l3=new JLabel("CPI ");  
        l3.setBounds(50,130,150,20);

        tf1=new JTextField();  
        tf1.setBounds(150,70,200,20);
        tf2=new JTextField();  
        tf2.setBounds(150,100,200,20);
        tf3=new JTextField();  
        tf3.setBounds(150,130,200,20);  
          
        b=new JButton("Submit");  
        b.setBounds(50,200,80,30); 
        
        b.addActionListener(this); 
        
        add(l1);
        add(l2);
        add(l3);  
        add(tf1);
        add(tf2);
        add(tf3);  
        add(b);

        setSize(600,700);  
        setLayout(null);  
        setVisible(true); 
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e){ 
    	
        String name=tf1.getText();  
        String rno = tf2.getText();
        String cpi=tf3.getText();
        Details de=new Details(name,rno,cpi);

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
            
            a.add(de);

            for(Details det : a)
                out.writeObject(det);
            
            out.close();
            fout.close();
           }
           catch (IOException i) {
               i.printStackTrace();
         }
    }  

}
