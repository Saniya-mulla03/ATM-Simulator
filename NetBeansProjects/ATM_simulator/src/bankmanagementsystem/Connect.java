package bankmanagementsystem;
import java.sql.*;
public class Connect {
    Connection c;
    Statement s;
    public Connect(){
        try{
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem","root","admin");
            s = c.createStatement();
        }
        catch(Exception e){
            System.out.println(e);
        }
    } 
}
