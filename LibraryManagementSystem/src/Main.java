import java.time.LocalDate;
import java.util.Scanner;

import Library.Library;
import Library.User;
import jdbc.JbdcConnection;

public class Main {

	public static void main(String[] args) {
		JbdcConnection.getConnection();
		Scanner scanner = new Scanner(System.in);
		
		Library library = new Library();
		boolean running = true;
		
		 while (running) {
	            System.out.println("\n--- Library Management System ---");
	            System.out.println("1. Add User");
	            System.out.println("2. Add Book");
	            System.out.println("3. List Books");
	            System.out.println("4. Borrow Book");
	            System.out.println("5. Return Book");
	            System.out.println("6. Exit");

	            int choice = scanner.nextInt();
	            scanner.nextLine(); 

	            switch (choice) {
	                case 1:
	                    System.out.print("Enter user name: ");
	                    String userName = scanner.nextLine();
	                    User user = new User(0, userName);
	                    library.addUser(user);
	                    break;
	                case 2:
	                    System.out.print("Enter book title: ");
	                    String title = scanner.nextLine();
	                    System.out.print("Enter book author: ");
	                    String author = scanner.nextLine();
	                    library.addBook(title, author);
	                    break;
	                case 3:
	                    library.listBooks();
	                    break;
	                case 4:
	                    System.out.print("Enter user ID: ");
	                    int userId = scanner.nextInt();
	                    System.out.print("Enter book ID: ");
	                    int bookId = scanner.nextInt();
	                    System.out.print("Enter due date (YYYY-MM-DD): ");
	                    String dueDate = scanner.next();
	                    library.borrowBook(userId, bookId, LocalDate.parse(dueDate));
	                    break;
	                case 5:
	                    System.out.print("Enter user ID: ");
	                    userId = scanner.nextInt();
	                    System.out.print("Enter book ID: ");
	                    bookId = scanner.nextInt();
	                    library.returnBook(userId, bookId);
	                    break;
	                case 6:
	                    System.out.println("Exiting...");
	                    scanner.close();
	                    return;
	                default:
	                    System.out.println("Invalid choice. Try again.");
	            }
	    }
		 scanner.close();
    }
		
}


