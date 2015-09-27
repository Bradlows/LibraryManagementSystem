package librarymanagementsystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

  public class LibraryManagementSystem {
    
         public static void main(String[] args) throws IOException {

         int loginConfirmation = 0;
         int LibrarianChoice;
         Librarian[] LibrarianObject = new Librarian[50];
         Books[] BooksObject = new Books[100];
         Student[] StudentObject = new Student[100];
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int BorrowBooksMax = 5;  
        
        
         System.out.println("Enter the number of Librarians working for this library");
         int LibrarianCount = Integer.parseInt(br.readLine());

      
         for(int i=1;i<=LibrarianCount;i++)
         {
         System.out.println("Librarian "+ i+":");
         LibrarianObject[i] = new Librarian();
         LibrarianObject[i].LibrarianDetails();
         }
    
         System.out.println("Enter the number of students");
         int StudentCount = Integer.parseInt(br.readLine());
        
         for(int i=1;i<=StudentCount;i++)
         {
         System.out.println("Student "+ i+":");
         StudentObject[i] = new Student();
         System.out.println("Enter the student ID:");
         String StudentTempID = br.readLine();
         StudentObject[i].StudentDetails(StudentTempID);
         }
        

         System.out.println("Enter the number of different books in the library");
         int BooksCount = Integer.parseInt(br.readLine());
        
          for(int i=1;i<=BooksCount;i++)
         {
         System.out.println("Book "+ i+":");   
         BooksObject[i] = new Books();
         System.out.println("Enter the ISBN:");
         String BooksTempID = br.readLine();
         BooksObject[i].BooksDetails(BooksTempID);
         } 
            Librarian:
             do
             {
             System.out.println("Enter your Librarian-ID");
             String inputLibrarianID = br.readLine();
             System.out.println("Enter your password");
             String inputLibrarianPassword = br.readLine();
             for(int i=1;i<=LibrarianCount;i++)
             {
              if( inputLibrarianID.equals(LibrarianObject[i].LibrarianID)&&inputLibrarianPassword.equals(LibrarianObject[i].LibrarianPassword))
              {
                 System.out.println("Login Succesful!!");
                 loginConfirmation = 1;
                 Librarian_choice:
                 do{
                 System.out.println("1 - Lending Books");
                 System.out.println("2 - Returning Books");
                 System.out.println("3 - Enter new students");
                 System.out.println("4 - Enter new Books");
                 System.out.println("5 - Details of a Student");
                 System.out.println("6-  Details of a Book");
                 System.out.println("7 - Details of a Librarian");
                 System.out.println("8 - SignOut? OR Not " +LibrarianObject[i].LibrarianName+ " ?");
                 System.out.println("9 - Exit from the program");
                 System.out.println("Enter your choice");
                 LibrarianChoice = Integer.parseInt(br.readLine());
                 switch(LibrarianChoice)
                 {
                      case 1 : { 
                                System.out.println("Enter the Student-ID of the borrower");
                                String inputStudentID = br.readLine();
                                for(int j=1;j<=StudentCount;j++)
                                {
                                 if(inputStudentID.equals(StudentObject[j].StudentID))
                                  {
                                   System.out.println("Enter the Number of books, the student is going borrow");
                                   int BooksBorrowCount = Integer.parseInt(br.readLine());
                                   if((StudentObject[j].BooksBorrowedCount+BooksBorrowCount)<BorrowBooksMax){
                                       System.out.println("The sudent has "+StudentObject[j].BooksBorrowedCount+" in his/her account");
                                       System.out.println("Student can take "+(BorrowBooksMax - StudentObject[j].BooksBorrowedCount)+" books");
                                       if(BooksBorrowCount>(BorrowBooksMax - StudentObject[j].BooksBorrowedCount)) BooksBorrowCount = BorrowBooksMax - StudentObject[j].BooksBorrowedCount;
                                       for(int k=1;k<=BooksBorrowCount;k++)
                                       {
                                        System.out.println("Enter the book ISBN");
                                        String inputBooksID = br.readLine();
                                        for(int c=1;c<=BooksCount;c++)
                                        {
                                        if(inputBooksID.equals(BooksObject[c].BooksID))
                                        {
                                            StudentObject[j].Bookspush(BooksObject[c].BooksID,inputLibrarianID);
                                            BooksObject[c].BooksNo--;    
                                        } 
                                        }
                                        }
                                        System.out.println("The books in "+StudentObject[j].StudentID+"'s account are:");
                                        StudentObject[j].PrintBooks();
                                        }
                                    }
                                }
                                continue Librarian_choice;
                                }
                                
                      case 2:   {
                                int ReturnBookChoice = 0;
                                System.out.println("Enter the Student-ID"); 
                                String inputStudentID = br.readLine();
                                for(int j=1;j<=StudentCount;j++)
                                {
                                 if(inputStudentID.equals(StudentObject[j].StudentID))
                                        {
                                          do{  
                                          System.out.println("Enter the book ISBN which is being returned by the student");
                                          String ReturnBooksID = br.readLine();
                                          StudentObject[j].BooksRemove(ReturnBooksID);
                                          if(StudentObject[j].BooksBorrowedCount!=0) {
                                          System.out.println("Returning any more books?");
                                          System.out.println("1 - Yes");
                                          System.out.println("2 - No");
                                          ReturnBookChoice = Integer.parseInt(br.readLine());
                                          }
                                          else System.out.println("All books returned!!");
                                          break;
                                          }
                                          while(ReturnBookChoice!=2);
                                        }
                                }
                                }
                                continue Librarian_choice;
                      case 3:   {
                                int NewStudentChoice;
                                do{
                                 System.out.println("Enter the new Student ID");
                                 String newStudentID = br.readLine();
                                 for(int j=1;j<=StudentCount;j++)
                                 {
                                 if(newStudentID.equals(StudentObject[j].StudentID))
                                 {
                                   System.out.println("Already Registered Student!!!");  
                                 }
                                 else
                                 {
                                    System.out.println("Enter the details of the new student:");
                                    StudentCount = StudentCount+1;
                                    StudentObject[StudentCount] = new Student();
                                    StudentObject[StudentCount].StudentDetails(newStudentID);
                                    break;
                                 }
                                 }
                                 System.out.println("Any new student enteries?");
                                 System.out.println("1 - Yes");
                                 System.out.println("2 - No");
                                 NewStudentChoice = Integer.parseInt(br.readLine());
                                }
                                while(NewStudentChoice!=2);
                                continue Librarian_choice;
                                }
                                
                      case 4:   {
                                 
                                 int NewBooksChoice = 0;
                                 BooksReEntry:
                                 
                                 do{    
                                 System.out.println("Enter the new Book-ID");
                                 String newBookID = br.readLine();
                                 for(int j=1;j<=StudentCount;j++)
                                 {
                                 if(newBookID.equals(BooksObject[j].BooksID))
                                 {
                                   System.out.println("Already existing Book!!!");
                                   System.out.println("Do you want to increase the number of books in the library?");
                                   System.out.println("1 - Yes");
                                   System.out.println("2 - No");
                                   int BookNumChoice = Integer.parseInt(br.readLine());
                                    if(BookNumChoice == 1) {
                                        System.out.println("Enter the Quantity");
                                        BooksObject[j].BooksNo = Integer.parseInt(br.readLine());
                                        continue Librarian_choice;
                                    }
                                    else if(BookNumChoice == 2)
                                        continue Librarian_choice; 
                                 }
                                      else
                                 {
                                    BooksCount = BooksCount+1;
                                    BooksObject[BooksCount] = new Books();
                                    BooksObject[BooksCount].BooksDetails(newBookID);
                                    break;
                                    
                                 }
                                 }
                                 System.out.println("Any new Books enteries?");
                                 System.out.println("1 - Yes");
                                 System.out.println("2 - No");
                                 NewBooksChoice = Integer.parseInt(br.readLine());
                                }
                                while(NewBooksChoice!=2);
                                continue Librarian_choice;
                                }
                                
                      case 5:   {
                                 System.out.println("Enter the Student-ID");
                                 String wantedStudentID = br.readLine();
                                 for(int j=1;j<=StudentCount;j++)
                                 {
                                 if(wantedStudentID.equals(StudentObject[j].StudentID))
                                 {
                                     System.out.println("Name: "+StudentObject[j].StudentName);
                                     System.out.println("Added on: \n"+"Date: "+StudentObject[j].studentAddedDate+"\nTime: "+ StudentObject[j].studentAddedTime);
                                     System.out.println("Borrowed Books:");
                                     StudentObject[j].PrintBooks();
                                 }
                                 }
                                continue Librarian_choice;
                                }
                      case 6:   {
                                 System.out.println("Enter the Book-ID");
                                 String wantedBooksID = br.readLine();
                                 for(int j=1;j<=BooksCount;j++)
                                 {
                                 if(wantedBooksID.equals(BooksObject[j].BooksID))
                                 {
                                     
                                     System.out.println("Name: "+BooksObject[j].BooksName);
                                     System.out.println("Author: "+BooksObject[j].BooksAuthor);
                                     System.out.println("Quantity: "+BooksObject[j].BooksNo);
                                     System.out.println("Added on: \n"+"Date: "+BooksObject[j].bookAddedDate+"\nTime: "+ BooksObject[j].bookAddedTime);
                                 }
                                }
                                continue Librarian_choice;
                                } 
                      case 7:   {
                                 System.out.println("Enter the Librarian-ID");
                                 String wantedLibrarianID = br.readLine();
                                 for(int j=1;j<=LibrarianCount;j++)
                                 {
                                 if(wantedLibrarianID.equals(LibrarianObject[j].LibrarianID))
                                 {
                                     
                                     System.out.println("Name: "+LibrarianObject[j].LibrarianName);
                                     System.out.println("Appointed on: \n"+"Date: "+LibrarianObject[j].LibrarianAddedDate+"\nTime: "+ LibrarianObject[j].LibrarianAddedTime);
                                }
                                }
                                 continue Librarian_choice;
                                } 
                      case 8:   {
                                 System.out.println("Signed Out from "+LibrarianObject[i].LibrarianName);
                                 loginConfirmation = 0;
                                 continue Librarian;
                                }
                 } 
                }while(LibrarianChoice!=9);    
             } 
              else
              {    
                  System.out.println("Password/Username Mis-match");
                  continue Librarian;
              }
            }
        } while(loginConfirmation!=1); 
    }  
}     
