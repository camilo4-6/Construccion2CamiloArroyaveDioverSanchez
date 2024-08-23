/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClubProject;

import app.config.MYSQLConnection;

/**
 *
 * @author Camilo
 */
public class App {
    public static void main(String[] args) {
        // TODO code application logic here]

        MYSQLConnection connection = new MYSQLConnection();
        try {
            connection.getConnection();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("sfd");
        }

    }

}

