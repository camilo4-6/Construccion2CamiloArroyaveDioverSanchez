/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clubproject;
import app.config.MYSQLConnection;

public class ClubProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here]

        MYSQLConnection connection = new MYSQLConnection();
	try {
            connection.getConnection();
            
	} catch (Exception e) {
        	System.out.println(e.getMessage());
	}
        

     

    }
        
    
    
}
