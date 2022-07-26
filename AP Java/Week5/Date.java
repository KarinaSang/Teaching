package week5;

public class Date {
	private String month;
	private int day;
	private int year;
	
	public Date(String month, int day, int year) {
		this.month = month;
		this.day = day;
		this.year = year;
	}
	
	public int getDay() {
		return day;
	}
	
	public String getMonth() {
		return month;
	}
	
	public int getYear() {
		return year;
	}
	
	public void changeDate(String month, int day, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public String toString() {
		return year + " " + month + " " + day;
	}
	
//	public boolean equals(Date other) {
//		if (this.getDay() == other.getDay() 
//				&& this.getYear() == other.getYear()
//				&& this.getMonth().equals(other.getMonth())) {
//			return true;
//		}
//		
//		return false;
//	}

}
