package Library;

import java.time.LocalDate;

public interface ILibrary {

	void addUser(User name);
	void addBook(String title, String author);
	void listBooks();
	void borrowBook(int userId, int BookId, LocalDate deuDate);
	void returnBook(int userId, int bookId);
//    void updateUser(int userId, String newName);
//	void updateBook(int bookId, String newTitle, String newAuthor, boolean isAvailable, LocalDate newDueDate);
}
