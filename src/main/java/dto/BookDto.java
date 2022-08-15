package dto;

import java.time.LocalDateTime;

import constants.Status;

public class BookDto {
	
	private int book_number;
	private String bookNm;
	private String publisher;
	private String author;
	private Status status;
	
	 public BookDto() {
	}


	public BookDto(int book_number, String bookNm, String publisher, String author, Status status) {
		this.book_number = book_number;
		this.bookNm = bookNm;
		this.publisher = publisher;
		this.author = author;
		this.status = status;
	}


	public int getBook_number() {
		return book_number;
	}


	public void setBook_number(int book_number) {
		this.book_number = book_number;
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


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "BookDto [book_number=" + book_number + ", bookNm=" + bookNm + ", publisher=" + publisher + ", author="
				+ author + ", status=" + status + "]";
	}
	
	 

}
