package by.epam.javaonline.task4_1_9;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Objects;

/* 9. Создать класс Book, спецификация которого приведена ниже. 
 * Определить конструкторы, set- и get- методы и метод toString(). 
 * Создать второй класс, агрегирующий массив типа Book, с подходящими 
 * конструкторами и методами. Задать критерии выбора данных и вывести 
 * эти данные на консоль.
 * Book: id, название, автор(ы), издательство, год издания, количество
 * страниц, цена, тип переплета.
 *  Найти и вывести:
 *   a) список книг заданного автора;
 *   b) список книг, выпущенных заданным издательством;
 *   c) список книг, выпущенных после заданного года.*/

public class Book {
	
	private static int counter = 0;
	private int id;
	private String title;
	private List<String> authors;
	private String publisher;
	private String publishYear;
	private String pageNum;
	private String price;
	private String binding;
	
	{
		title = "Undefined";
		authors = new ArrayList<>();
		publisher = "Undefined";
		publishYear = "0";
		pageNum = "0";
		price = "0";
		binding = "Undefined";
	}
	
	public Book() {
		counter++;
		id = counter;
	}
	
	public Book(String title, String publisher, String publishYear, String pageNum, String price, String binding, String...authors) {
		counter++;
		id = counter;
		
		this.title = titleCheck(title);
		this.publisher = publisherCheck(publisher);
		this.publishYear = publishYearCheck(publishYear);
		this.pageNum = pageNumCheck(pageNum);
		this.price = priceCheck(price);
		this.binding = bindingCheck(binding);
		addAuthors(authors);
	}
	

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String[] getAuthors() {
		
		if(authors.isEmpty()) {
			String[] a ={"Undefined"};
			return a;
		}
		
		String[] a = new String[authors.size()];
		return authors.toArray(a);
	}
	
	public String getAuthor(int index) {
		
		if(authors.isEmpty()) {
			return "Undefined";
		}
		
		if(index >= authors.size()) {
			return authors.get(authors.size() - 1);
		}
		return authors.get(index);
	}

	public String getPublisher() {
		return publisher;
	}

	public String getPublishYear() {
		return publishYear;
	}

	public String getPageNum() {
		return pageNum;
	}

	public String getPrice() {
		return price;
	}

	public String getBinding() {
		return binding;
	}

	public void setTitle(String title) {
		this.title = titleCheck(title);
	}

	public void setPublisher(String publisher) {
		this.publisher = publisherCheck(publisher);
	}

	public void setPublishYear(String publishYear) {
		this.publishYear = publishYearCheck(publishYear);
	}

	public void setPageNum(String pageNum) {
		this.pageNum = pageNumCheck(pageNum);
	}

	public void setPrice(String price) {
		this.price = priceCheck(price);
	}

	public void setBinding(String binding) {
		this.binding = bindingCheck(binding);
	}
	
	public void setAuthor(String author, int index) {
		if(index < authors.size()) {
			authors.set(index, authorCheck(author));
		} 
	}
	
	public void addAuthors(String...authors) {
		for(int i = 0; i < authors.length; i++) {
			this.authors.add(authorCheck(authors[i]));
		}
	}
	
	public void removeAuthor(int index) {
		if(index < authors.size()) {
			authors.remove(index);
		} 		
	}
	
	public String bookInfo() {
		
		try(Formatter form = new Formatter()){
			
			int width;
			String hat;
			String title;
			String publisher;
			String publishYear;
			String pageNum;
			String price;
			String binding;
			StringBuilder authors = new StringBuilder();
			StringBuilder line = new StringBuilder();
			String[] str;
			
			hat = "Book id: " + this.id;
			title = "Title: \"" + this.title + "\"";
			publisher = "Publisher: " + this.publisher;
			publishYear = "Published in: " + this.publishYear;
			pageNum = "Number of pages: " + this.pageNum;
			price = "Price: " + this.price;
			binding = "Binding: " + this.binding;
			
			authors.append("Authors: ");
			
			if(!this.authors.isEmpty()) {
				
				for(String author: this.authors) {
					authors.append(author + ", ");
				}
				authors.delete(authors.length()- 2, authors.length());
				
			} else {
				authors.append("Undefined");
			}
			
			str = new String[]{hat,title,authors.toString(),publisher,publishYear,pageNum,price,binding};
			width = str[0].length();
			
			for(int i = 0; i < str.length; i++) {
				if(str[i].length() > width) {
					width = str[i].length();
				}
			}
			
			for(int i = 1; i <= width + 2; i++) {
				line.append("_");
			}
			
			form.format(" %s\n" +
						"| %-" + width + "s |\n" +
						"| %-" + width + "s |\n" +
						"| %-" + width + "s |\n" +
						"| %-" + width + "s |\n" +
						"| %-" + width + "s |\n" +
						"| %-" + width + "s |\n" +
						"| %-" + width + "s |\n" +
						"| %-" + width + "s |\n" +
						"|%-" + width + "s|" 
						,line,hat,title,authors,publisher,publishYear,pageNum,price,binding,line);
			
			return form.toString();
		}
	}
	
	private static String stringCheck(String line, String pattern, String elseReturn) {
		
		if(line == null || line == "") {
			return elseReturn;
		}
		
		if(line.matches(pattern)) {
			return line;
		} else {
			return elseReturn;
		}
	}
	
	private static String titleCheck(String title) {
		String pattern = ".+";
		return stringCheck(title, pattern, "Undefined");
	}
	
	private static String publisherCheck(String publisher) {
		String pattern = ".+";
		return stringCheck(publisher, pattern, "Undefined");
	}
	
	private static String publishYearCheck(String publishYear) {
		String pattern = "(0|[1-9]\\d{0,3})";
		return stringCheck(publishYear, pattern, "0");
	}
	
	private static String pageNumCheck(String pageNum) {
		String pattern = "[1-9]\\d*";
		return stringCheck(pageNum, pattern, "0");
	}
	
	private static String priceCheck(String price) {
		String pattern = "(0|[1-9]\\d*)(\\s?[^\\s^\\d]+)+";
		return stringCheck(price, pattern, "0");
	}
	
	private static String bindingCheck(String binding) {
		String pattern = "(([A-Za-z]|')+\\s?)+";
		return stringCheck(binding, pattern, "Undefined");
	}
	
	private static String authorCheck(String author) {
		String pattern = "(([\\w]|'|\\.)+\\s?)+";
		return stringCheck(author, pattern, "Undefined");
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [id=" + id + ", title=" + title + ", authors=" + authors + ", publisher=" + publisher
				+ ", publishYear=" + publishYear + ", pageNum=" + pageNum + ", price=" + price + ", binding=" + binding
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(authors, binding, id, pageNum, price, publishYear, publisher, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(authors, other.authors) && Objects.equals(binding, other.binding)
				&& Objects.equals(pageNum, other.pageNum) && Objects.equals(price, other.price)
				&& Objects.equals(publishYear, other.publishYear) && Objects.equals(publisher, other.publisher)
				&& Objects.equals(title, other.title);
	}
	
	
}
