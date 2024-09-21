package Library;

import java.io.Serializable;
import java.time.LocalDate;

public class Book implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private int id ;
	private Book title;
	private Book author;
	private boolean isAvailable;
	private LocalDate dueDate;
	
	public Book(int id, Book title, Book author) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.isAvailable = true;
		this.dueDate = null;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Book getTitle() {
		return title;
	}

	public void setTitle(Book title) {
		this.title = title;
	}

	public Book getAuthor() {
		return author;
	}

	public void setAuthor(Book author) {
		this.author = author;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
