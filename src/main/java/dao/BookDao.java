package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import constants.Status;
import dto.BookDto;
import dto.RentalDto;
import dto.StudentDto;
import service.BookException;

public class BookDao {
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {// Connection 객체
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/bms?user=root&password=aA!123456";
		Connection conn = DriverManager.getConnection(url);
		
		return conn;
	}
	
	public void register(BookDto book) {// 추가
		String sql = "INSERT INTO bms_info (bookNm, publisher, author) VALUES (?, ?, ?)";
		
		try(Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setString(1, book.getBookNm());
			pstmt.setString(2, book.getPublisher());
			pstmt.setString(3, book.getAuthor());
			
			pstmt.executeUpdate();
			
		} catch(ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
			throw new BookException("등록에 실패하였습니다.");
			
		}
		
	}
	
	public void st_register(StudentDto student) {// 추가
		String sql = "INSERT INTO student (student_name) VALUES (?)";
		
		try(Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setString(1, student.getStudent_name());
			
			pstmt.executeUpdate();
			
		} catch(ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
			throw new BookException("등록에 실패하였습니다.");
			
		}
		
	}
	
	public void update(BookDto book) {// 수정
		String sql = "UPDATE bms_info " + 
				 " SET " +
				 " bookNm = ?, " +
				 " publisher = ?, " +
				 " author = ? " +
				 " WHERE book_number = ?";
		
		try(Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setString(1, book.getBookNm());
			pstmt.setString(2, book.getPublisher());
			pstmt.setString(3, book.getAuthor());
			pstmt.setInt(4, book.getBook_number());
			
			pstmt.executeUpdate();
			
		} catch(ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
			throw new BookException("수정에 실패하였습니다.");
			
		}
		
	}
	
	public void rental(BookDto book, StudentDto student) {// 대여
		String sql = "UPDATE bms_info " + 
				 " SET " +
				 " status = ? " +
				 " WHERE book_number = ?";
		
		String sql1 = "INSERT INTO rental_status (book_num, bookNm, publisher, author, student_name) VALUES (?, ?, ?, ?, ?)";
		
		String sql2 = "UPDATE student " + 
				 " SET " +
				 " rental_count = ? " +
				 " WHERE student_name = ?";
		
		try(Connection conn = getConnection();
				PreparedStatement book_info = conn.prepareStatement(sql);
				PreparedStatement rental_status = conn.prepareStatement(sql1);
				PreparedStatement student_count = conn.prepareStatement(sql2)) {
			
			book_info.setString(1, "RENTAL");
			book_info.setInt(2, book.getBook_number());
			
			book_info.executeUpdate();
			
			rental_status.setInt(1, book.getBook_number());
			rental_status.setString(2, book.getBookNm());
			rental_status.setString(3, book.getPublisher());
			rental_status.setString(4, book.getAuthor());
			rental_status.setString(5, student.getStudent_name());
			
			rental_status.executeUpdate();
			
			student_count.setInt(1, (student.getRental_count() + 1));
			student_count.setString(2, student.getStudent_name());
			
			student_count.executeUpdate();
			
		} catch(ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
			
			throw new BookException("책 대여에 실패하였습니다.");
			
		}
		
	}
	
	public void returnBook(BookDto book, StudentDto student) {// 반납
		String sql = "UPDATE bms_info " + 
				 " SET " +
				 " status = ? " +
				 " WHERE book_number = ?";
		
		String sql1 = "DELETE FROM rental_status WHERE book_num = ?;";
		
		try(Connection conn = getConnection();
				PreparedStatement book_info = conn.prepareStatement(sql);
				PreparedStatement rental_status = conn.prepareStatement(sql1)) {
			
			book_info.setString(1, "RETURN");
			book_info.setInt(2, book.getBook_number());
			
			book_info.executeUpdate();
			
			rental_status.setInt(1, book.getBook_number());
			
			rental_status.executeUpdate();
			
			
		} catch(ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
			
			throw new BookException("책 반납에 실패하였습니다.");
			
		}
		
	}
	
	
	public void delete(BookDto book) {// 추가
		
		delete(book.getBook_number());
		
	}
	
	public void delete(int id) {// 삭제
		String sql = "DELETE FROM bms_info WHERE book_number = ?";
		
		try(Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setInt(1, id);
			
			pstmt.executeUpdate();
			
		} catch(ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
			throw new BookException("삭제에 실패하였습니다.");
			
		}
		
	}
	
	public List<BookDto> getsBook() {
		List<BookDto> books = new ArrayList<>();
		
		String sql = "SELECT * FROM bms_info";
		
		try(Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				books.add(new BookDto(
							rs.getInt("book_number"),
							rs.getString("bookNm"),
							rs.getString("publisher"),
							rs.getString("author"),
							Enum.valueOf(Status.class, rs.getString("status"))
						));
				
			}
			
			rs.close();
		} catch(ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
			throw new BookException("리스트 가져오기에 실패하였습니다.");
			
		}
		
		return books;
	}
	
	public BookDto get(int id) {// 작업 조회
		BookDto book = null;
		
		String sql = "SELECT * FROM bms_info WHERE book_number = ?";
		
		try(Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				book = new BookDto(
						rs.getInt("book_number"),
						rs.getString("bookNm"),
						rs.getString("publisher"),
						rs.getString("author"),
						Enum.valueOf(Status.class, rs.getString("status"))
						);
			}
			
			rs.close();
		} catch(ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
			throw new BookException("리스트 가져오기에 실패하였습니다.");
			
		}
		
		return book;
	}
	
	public StudentDto getStudent(String student_name) {
		StudentDto student = null;
		
		String sql = "SELECT * FROM student WHERE student_name = ?";
		
		try(Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setString(1, student_name);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				student = new StudentDto(
						rs.getInt("student_id"),
						rs.getString("student_name"),
						rs.getInt("rental_count")
						);
			}
			
			rs.close();
		} catch(ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
			throw new BookException("리스트 가져오기에 실패하였습니다.");
			
		}
		
		return student;
	}
	
	public List<RentalDto> getsRental() {
		List<RentalDto> rentals = new ArrayList<>();
		
		String sql = "SELECT * FROM rental_status";
		
		try(Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				LocalDateTime rental_date = null;
				Timestamp _rental_date = rs.getTimestamp("rental_date");
				if(_rental_date != null) {
					rental_date = _rental_date.toLocalDateTime();
				}
				
				String date_format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(rental_date);
				
				RentalDto dto = new RentalDto(rs.getInt("book_num"),
						rs.getString("bookNm"),
						rs.getString("publisher"),
						rs.getString("author"),
						date_format,
						rs.getString("student_name"));
				
				
				rentals.add(dto);
				
				
				
			}
			
			rs.close();
		} catch(ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
			throw new BookException("리스트 가져오기에 실패하였습니다.");
			
		}
		
		return rentals;
	}
	
	public List<StudentDto> getsStudent() {
		List<StudentDto> student = new ArrayList<>();
		
		String sql = "SELECT * FROM student";
		
		try(Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				student.add(new StudentDto(
							rs.getInt("student_id"),
							rs.getString("student_name"),
							rs.getInt("rental_count")
						));
				
			}
			
			rs.close();
		} catch(ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
			throw new BookException("리스트 가져오기에 실패하였습니다.");
			
		}
		
		return student;
	}
	
	public List<RentalDto> getSolo(String name) {
		List<RentalDto> solo = new ArrayList<>();
		
		String sql = "SELECT * FROM rental_status WHERE student_name LIKE '%" + name + "%'";
		
		try(Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				LocalDateTime rental_date = null;
				Timestamp _rental_date = rs.getTimestamp("rental_date");
				if(_rental_date != null) {
					rental_date = _rental_date.toLocalDateTime();
				}
				
				String date_format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(rental_date);
				
				solo.add(new RentalDto(
							rs.getInt("book_num"),
							rs.getString("bookNm"),
							rs.getString("publisher"),
							rs.getString("author"),
							date_format,
							rs.getString("student_name")
						));
				
			}
			
			rs.close();
		} catch(ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
			throw new BookException("리스트 가져오기에 실패하였습니다.");
			
		}
		
		return solo;
	}
	
	public List<BookDto> serachBook(String select, String bookNm) {
		List<BookDto> books = new ArrayList<>();
		
		String sql = "SELECT * FROM bms_info WHERE " + select + " LIKE '%" + bookNm + "%'";
		
		try(Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				books.add(new BookDto(
							rs.getInt("book_number"),
							rs.getString("bookNm"),
							rs.getString("publisher"),
							rs.getString("author"),
							Enum.valueOf(Status.class, rs.getString("status"))
						));
				
			}
			
			rs.close();
		} catch(ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
			throw new BookException("검색에 실패하였습니다.");
			
		}
		
		return books;
	}

}
