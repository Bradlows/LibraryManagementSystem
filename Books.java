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
class Books {
    LocalDate bookAddedDate;
    LocalTime bookAddedTime;
    String BooksID,BooksName,BooksAuthor;
    int BooksNo;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
    void BooksDetails(String BBooksID) throws IOException{
        
        bookAddedDate = LocalDate.now();
        bookAddedTime = LocalTime.now();

        BooksID = BBooksID;
        System.out.println("Enter the name of the book:");
        BooksName = br.readLine();
        System.out.println("Author:");
        BooksAuthor = br.readLine();
        System.out.println("Number of copies of this book in the Library");
        BooksNo = Integer.parseInt(br.readLine());        
    }
}
