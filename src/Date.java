public class Date {
	private int day;
	private int month;
	private int year;
	private int[] maxDaysByMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private int[] maxDaysByMonthLEAP = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private String[] intToStringMonth = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};
	
	public Date(int day, int month, int year) {
		if (!checkDateValid(day, month, year)) {
			throw new RuntimeException("invalid date");
		}
		
		this.day = day; //From 1 to 31
		this.month = month; //From 1 to 12
		this.year = year; //Most years are valid
	}
	
	private boolean checkDateValid(int day, int month, int year) {
		//Check if valid month
		if (month < 1 || month > 12) {
			return false;
		}
		
		//Check if day exceeds month normal days
		if((year % 400 == 0) || (year % 100 != 0) && (year % 4 == 0)) {
			//Leap Year
			if (day > maxDaysByMonthLEAP[month - 1] || day < 1) {
				return false;
			}
	    }
	    else {
	    	//Not Leap Year
	    	if (day > maxDaysByMonth[month - 1] || day < 1) {
				return false;
			}
	    }
		
		return true;
	}
	
	public String toString() {
		return String.valueOf(this.day) + " " + intToStringMonth[this.month - 1] + " " + String.valueOf(this.year);
	}
}
