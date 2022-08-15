package dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RentalDto {
	
	private int book_num;
	private String bookNm;
	private String publisher;
	private String author;
	private LocalDateTime rental_date;
	private String student_name;
	private String date_format;
	
	public RentalDto() {
	}

	public RentalDto(int book_num, String bookNm, String publisher, String author, LocalDateTime rental_date, String student_name) {
		this.book_num = book_num;
		this.bookNm = bookNm;
		this.publisher = publisher;
		this.author = author;
		this.rental_date = rental_date;
		this.student_name = student_name;
	}
	
	public RentalDto(int book_num, String bookNm, String publisher, String author, String date_format, String student_name) {
		this.book_num = book_num;
		this.bookNm = bookNm;
		this.publisher = publisher;
		this.author = author;
		this.date_format = date_format;
		this.student_name = student_name;
	}

	public String getDate_format() {
		return date_format;
	}

	public void setDate_format(String date_format) {
		this.date_format = date_format;
	}

	public int getBook_num() {
		return book_num;
	}

	public void setBook_num(int book_num) {
		this.book_num = book_num;
	}

	public String getBookNm() {
		return bookNm;
	}

	public void setBookNm(String bookNm) {
		this.bookNm = bookNm;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public LocalDateTime getRental_date() {
		return rental_date;
	}

	public void setRental_date(LocalDateTime rental_date) {
		this.rental_date = rental_date;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	@Override
	public String toString() {
		return "RentalDto [book_num=" + book_num + ", bookNm=" + bookNm + ", publisher=" + publisher + ", author="
				+ author + ", rental_date=" + rental_date + ", student_name=" + student_name + "]";
	}

	
	

}
