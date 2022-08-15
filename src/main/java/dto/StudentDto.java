package dto;

public class StudentDto {
	
	private int student_id;
	private String student_name;
	private int rental_count;
	
	public StudentDto() {
	}
	
	public StudentDto(int student_id, String student_name, int rental_count) {
		this.student_id = student_id;
		this.student_name = student_name;
		this.rental_count = rental_count;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public int getRental_count() {
		return rental_count;
	}

	public void setRental_count(int rental_count) {
		this.rental_count = rental_count;
	}

	@Override
	public String toString() {
		return "StudentDto [student_id=" + student_id + ", student_name=" + student_name + ", rental_count="
				+ rental_count + "]";
	}
	
	

}
