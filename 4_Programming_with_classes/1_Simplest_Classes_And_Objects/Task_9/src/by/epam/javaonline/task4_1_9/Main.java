package by.epam.javaonline.task4_1_9;

public class Main {

	public static void main(String[] args) {
		
		Book book_1 = new Book();
		System.out.println(book_1.bookInfo());
		
		book_1.setTitle("The Knight of the swords");
		book_1.addAuthors("Michael Moorcock", "David McCall Johnston");
		book_1.setPublisher("Berkley Medallion");
		book_1.setPublishYear("1971");
		book_1.setPageNum("176");
		book_1.setPrice("57$");
		book_1.setBinding("Softcover");
		System.out.println(book_1.bookInfo());
		
		book_1.setAuthor("Joe Abercrombie", 1);
		System.out.println(book_1.bookInfo());
		
		book_1.removeAuthor(1);
		System.out.println(book_1.bookInfo());
		
		Book book_2 = new Book("The Blade Itself", "Gollancz(UK)", "2006", "434", "90 £", "Hardcover", "Joe Abercrombie");
		Book book_3 = new Book("Before They Are Hanged", "Gollancz(UK)", "2007", "398", "86 £", "Hardcover", "Joe Abercrombie");
		Book book_4 = new Book("Last Argument of Kings", "Gollancz(UK)", "2008", "478", "95 pounds sterling", "Hardcover", "Joe Abercrombie");
		Book book_5 = new Book("THE RED KNIGHT", "Gollancz(UK)", "2022", "278", "95 £", "Hardcover", "Miles Cameron");
		Book book_6 = new Book("THE FALL OF DRAGONS", "Pyr Books(USA)", "2017", "243", "50 dollars", "Hardcover", "Miles Cameron", "J.R.R.Martin");
		Book book_7 = new Book("Flowers for Algernon", "Harcourt(USA)", "1959", "198", "45 dollars", "Softcover", "Daniel Keyes");
		
		BookStore store = new BookStore();
		store.getBooks().add(book_1);
		store.getBooks().add(book_2);
		store.getBooks().add(book_3);
		store.getBooks().add(book_4);
		store.getBooks().add(book_5);
		store.getBooks().add(book_6);
		store.getBooks().add(book_7);
		
		System.out.println("\n\nBOOKS AVAILABLE IN STORE:");
		store.showBooks();
		
		String author = "Miles Cameron";
		System.out.println("\n\nBOOKS BY AUTHOR: " + author);
		store.showBooksByAuthor(author);
		
		String publisher = "Gollancz(UK)";
		System.out.println("\n\nBOOKS BY PUBLISHER: " + publisher);
		store.showBooksByPublisher(publisher);
		
		String year = "2000";
		System.out.println("\n\nBOOKS PUBLISHED AFTER " + year + " year");
		store.showBooksByPublishYear(year);
	}

}
