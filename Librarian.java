/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagementsystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Vinu
 */

class Librarian {
    
    LocalDate LibrarianAddedDate;
    LocalTime LibrarianAddedTime;
    String LibrarianName,LibrarianID,LibrarianPassword;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    void LibrarianDetails() throws IOException 
    {   
        LibrarianAddedDate = LocalDate.now();
        LibrarianAddedTime = LocalTime.now();
        System.out.println("Enter the name:");
        LibrarianName = br.readLine();   
        System.out.println("Enter the Librarian-ID:");
        LibrarianID = br.readLine();
        System.out.println("Enter a password");
        String LibrarianNewPassword = br.readLine();
        System.out.println("Re-Enter the password");
        String LibrarianRePassword = br.readLine();
        if(LibrarianRePassword.equals(LibrarianNewPassword))
        {
            System.out.println("Sign-Up Successful!");
            LibrarianPassword = LibrarianNewPassword;
        }
        else
        {
            System.out.println("Password Mis-match");
            System.out.println("Enter the details again...");
            LibrarianDetails();
        }
    }        
}

