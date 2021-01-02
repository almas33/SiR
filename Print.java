import java.util.ArrayList;

import javax.swing.*; 

public class Print extends JFrame{
    private static final long serialVersionUID = 1L;
    String str;
    ArrayList<JTextField> tf= new ArrayList<JTextField>();
    
    Print(String str)
    {
        super("Print :- ");
        String[] words=str.split(" ");
        int y=0;
        
        setSize(600,700);  
        setLayout(null);  
        setVisible(true); 
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        for(String s: words)
        {
            JTextField tfe = new JTextField();
            y+=50;
            tfe.setBounds(0,y,100,50);  
            tfe.setEditable(false); 
            add(tfe);
            tfe.setText(s);
        }
    }

}
