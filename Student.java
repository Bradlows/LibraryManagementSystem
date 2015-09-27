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
class Student {
    LocalDate studentAddedDate;
    LocalTime studentAddedTime;
    int BorrowLoopCount = 0;
    LocalTime[] studentBorrowTime = new LocalTime[10];
    LocalDate[] studentBorrowDate = new LocalDate[10];
    String[] Bookstack = new String[10];
    String[] studentBorrowLibrarian = new String[10];
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String StudentName,StudentID; int BooksBorrowedCount = 0;
    void StudentDetails(String SStudentID) throws IOException{
        studentAddedDate = LocalDate.now();
        studentAddedTime = LocalTime.now();
        StudentID = SStudentID;
        System.out.println("Enter the student name:");
        StudentName = br.readLine();
    }  
    void Bookspush(String inputStack,String inputLibrarian) throws IOException
    {
        BooksBorrowedCount = BooksBorrowedCount + 1;
        studentBorrowDate[BooksBorrowedCount] = LocalDate.now();
        studentBorrowTime[BooksBorrowedCount] = LocalTime.now();
        studentBorrowLibrarian[BooksBorrowedCount] = inputLibrarian;
        Bookstack[BooksBorrowedCount] = inputStack;
    }
    void BooksRemove(String removeBook) throws IOException
    {
        BorrowLoopCount++;
        for(int i=1;i<=BooksBorrowedCount;i++)
        {
           if(Bookstack[i].equals(removeBook))
           {
               for(int j=i;j<=BooksBorrowedCount;j++) 
               {
                   if(j!=BooksBorrowedCount)
                   {
                       Bookstack[j] = Bookstack[j+1];   
                   }
                  BooksBorrowedCount--; 
               }
           }
        }
    }        

    void PrintBooks() {
        if(BooksBorrowedCount == 0)
        {
            System.out.println("No Books Borrowed!!!");
        }
        else
        {
        System.out.println("BookID     Book Date       Book Time     Librarian who issued");
        for(int i=1;i<=BooksBorrowedCount;i++) {
            System.out.print(Bookstack[i]+"     ");
            System.out.print(studentBorrowDate[i]+"     ");
            System.out.print(studentBorrowTime[i]+"     ");
            System.out.print(studentBorrowLibrarian[i]+"     ");
            System.out.println("");
           }
        }
    }
}  
