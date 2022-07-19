package by.epam.javaonline.task4_1_9;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BookStore {
	
	private final List<Book> books = new ArrayList<>();
	
	public BookStore() {
		
	}

	public List<Book> getBooks() {
		return books;
	}
	
	public void showBooks() {
		for(Book book: books) {
			System.out.println(book.bookInfo());
		}
	}
	
	public void showBooksByAuthor(String author) {
		
		if(author == null) {
			System.out.println("Wrong arguement!");
			return;
		}
		
		String[] authors;
		
		for(Book book: books) {
			
			authors = book.getAuthors();
			
			for(String writer: authors) {
				if(writer.compareToIgnoreCase(author) == 0) {
					System.out.println(book.bookInfo());
					break;
				}
			}
		}
	}
	
	public void showBooksByPublisher(String publisher) {
		
		if(publisher == null) {
			System.out.println("Wrong arguement!");
			return;
		}
		
		for(Book book: books) {
			if(book.getPublisher().compareToIgnoreCase(publisher) == 0) {
				System.out.println(book.bookInfo());
			}
		}
	}
	
	public void showBooksByPublishYear(String start) {
		
		if(start == null || !start.matches("(0|[1-9]\\d{0,3})")) {
			System.out.println("Wrong arguement!");
			return;
		}
		
		int year = Integer.valueOf(start);
		
		for(Book book: books) {
			if(Integer.valueOf(book.getPublishYear()) >= year) {
				System.out.println(book.bookInfo());
			}
		}
		
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [books=" + books + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(books);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookStore other = (BookStore) obj;
		return Objects.equals(books, other.books);
	}
}
