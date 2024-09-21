package Library;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import jdbc.JbdcConnection;

public class Library implements ILibrary{

	  @Override
	    public void addUser(User user) {
	        String sql = "INSERT INTO users(name) VALUES(?)";
	        try (Connection con = JbdcConnection.getConnection();
	             PreparedStatement ps = con.prepareStatement(sql)) {
	             
	            ps.setString(1, user.getName());
	            ps.executeUpdate();
	            System.out.println("User added successfully :" +user.getName());

	        } catch (SQLException e) {
	            System.out.println("User insertion failed: " + e.getMessage());
	        }
	    }
	  
	  @Override
	    public void addBook(String title, String author) {
	        String sql = "INSERT INTO books (title, author, isAvailable, dueDate) VALUES (?, ?, ?, ?)";
	        try (Connection con = JbdcConnection.getConnection();
	             PreparedStatement ps = con.prepareStatement(sql)) {
	             
	            ps.setString(1, title);
	            ps.setString(2, author);
	            ps.setBoolean(3, true);  
	            ps.setDate(4, null);     
	            ps.executeUpdate();
	            System.out.println("Book added successfully :"+ title+" , "+author );

	        } catch (SQLException e) {
	            System.out.println("Book addition failed: " + e.getMessage());
	        }
	    }

	@Override
	public void listBooks() {
		String sql = "SELECT id , title , author, isAvailable, dueDate FROM books";
		try( Connection con = JbdcConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs =	ps.executeQuery();){
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String author = rs.getString("author");
				boolean isAvailable  = rs.getBoolean("isAvailable");
				String dueDate = rs.getString("dueDate");
				
				System.out.println("The id of  book is : "+id+" .The title of the book is :"+title+" , and the author of the book is :"+author+
						". The  book is available :" + isAvailable + " , DueDate is :" +dueDate);
			}
		}catch(SQLException e) {
			System.out.println("somthing went wrong during fetching the list of book"+e.getMessage());
		}
	}

	@Override
	public void borrowBook(int userId, int BookId, LocalDate deuDate) {
		String updateBooksql = "UPDATE books SET isAvailable = false where id = ?";
		String insertUserBooksql = "INSERT INTO user_books (user_id, book_id,dueDate) VALUES(?,?,?)";
		
		try(Connection con = JbdcConnection.getConnection();
			PreparedStatement updateBookps  = con.prepareStatement(updateBooksql);
			PreparedStatement insertUserBookps  = con.prepareStatement(insertUserBooksql);){
			
			updateBookps.setInt(1, BookId);
			updateBookps.executeUpdate();
			
			insertUserBookps.setInt(1,userId);
			insertUserBookps.setInt(2,BookId);
			insertUserBookps.setDate(3 , Date.valueOf(deuDate));
			insertUserBookps.executeUpdate();
			
			System.out.println("book is borrowed by the user succefully");

		}catch(SQLException e) {
			System.out.println("somthing went wrong while borrowing book :"+e.getMessage());
		}
	}

	@Override
	public void returnBook(int userId, int bookId) {
		String updateBooksql = "UPDATE books SET isAvailable = TRUE where id = ?";
		
		try(Connection con = JbdcConnection.getConnection();
				PreparedStatement updateBookps  = con.prepareStatement(updateBooksql);){
				
				updateBookps.setInt(1, bookId);
				updateBookps.executeUpdate();
				
				System.out.println("book is reurnde by the user");

			}catch(SQLException e) {
				System.out.println("somthing went wrong while returning book :"+e.getMessage());
			}
	}

//	@Override
//	public void updateUser(int userId, String newName) {
//		// TODO Auto-generated method stub
//		
//	}

//	@Override
//	public void updateBook(int bookId, String newTitle, String newAuthor, boolean isAvailable, LocalDate newDueDate) {
//		// TODO Auto-generated method stub
//		
//	}

	
}
