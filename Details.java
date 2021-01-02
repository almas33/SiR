import java.io.*;

class Details implements Serializable {
	
    private static final long serialVersionUID = 1L;
    String name;
    String rno;
    String cpi;
	
	Details(String name, String rno,String cpi ) {
        this.name = name;  
        this.rno = rno;
        this.cpi=cpi;
	}
}
