import java.net.*;
import java.util.ArrayList;
import java.io.*;  

class Server 
{
	public static void main(String args[]) throws Exception 
	{
		ServerSocket Server = new ServerSocket(8080);
		
		System.out.println("Waiting for client to connect...");
		
		Socket connection = Server.accept();
		
		System.out.println("Connected ");
		
		DataInputStream input=new DataInputStream(connection.getInputStream());
		DataOutputStream output=new DataOutputStream(connection.getOutputStream());
		
        String str=input.readUTF();
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
          catch (EOFException eof) {
            System.out.println(" .... End of File ... ");  
          } catch (FileNotFoundException e) {
            e.printStackTrace();
          } catch (IOException e) {
            e.printStackTrace();
          } catch (ClassNotFoundException e) {
            e.printStackTrace();
          }
        
        StringBuilder det=new StringBuilder();

        if(str.equals("byname")){
            for(Details de:a)
            {
                det.append(de.name);
                det.append("-");
                det.append(de.cpi);
                det.append(" ");
            }
        }
        else{
            for(Details de:a)
            {
                det.append(de.rno);
                det.append("-");
                det.append(de.cpi);
                det.append(" ");
            }
        }
        System.out.println(det);
        output.writeUTF("Details:- " +det);
        output.flush();
		input.close();
		connection.close();
		Server.close();
	}
}

