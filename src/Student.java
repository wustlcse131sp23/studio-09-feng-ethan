

public class Student {
	private String firstName;
	private String lastName;
	private int studentID;
	private int attemptedCredits;
	private int passingCredits;
	private double totalGradeQualityPoints;
	private double bearBucksBalance;


	public Student(String firstName, String lastName, int studentID) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentID = studentID;
		this.attemptedCredits = 0;
		this.passingCredits = 0;
		this.totalGradeQualityPoints = 0;
		this.bearBucksBalance = 0;
	}
	/**
	 * 
	 * @return full name of the student
	 */
	public String getFullName() {
		return firstName + " " + lastName;
	}
	/**
	 * 
	 * @return student's id
	 */
	public int getId() {
		return studentID;
	}
/**
 * 
 * @param grade
 * @param credits
 * sums total quality points, attempted credits, and determines if credits are passing credits
 */
	public void submitGrade(double grade, int credits) {
		totalGradeQualityPoints += grade*credits;
		attemptedCredits += credits;
		if (grade >= 1.7) {
			passingCredits += credits;
		}
	}
/**
 * 
 * @return class standing based on number of passing credits
 */
	public String getClassStanding() {
		if (passingCredits<30) {
			return "First Year";
		}
		else if (passingCredits >= 30 && passingCredits <60) {
			return "Sophomore";
		}
		else if (passingCredits >= 60 && passingCredits < 90) {
			return "Junior";
		}
		else {
			return "Senior";
		}
	}

/**
 * 
 * @return total attempted credits
 */
	public int getTotalAttemptedCredits() {
		return attemptedCredits;
	}
/**
 * 
 * @return total passing credits
 */
	public int getTotalPassingCredits() {
		return passingCredits;
	}
/**
 * 
 * @return calculates student's GPA  
 */
	public double calculateGradePointAverage() {
		return totalGradeQualityPoints/attemptedCredits; 
	}
/**
 * 
 * @return determines if student is eligible for PhiBetaKappa based on credits taken and GPA
 */
	public boolean isEligibleForPhiBetaKappa() {
		if (passingCredits >= 98 && calculateGradePointAverage() >= 3.60) {
			return true;
		}
		else if (passingCredits >= 75 && calculateGradePointAverage() >= 3.80) {
			return true;
		}
		else {
			return false;
		}
	}
/**
 * 
 * @param amount
 * @return new bear bucks balance after depositing
 */
	public double depositBearBucks(double amount) {
		bearBucksBalance += amount;
		return bearBucksBalance;
	}
/**
 * 
 * @param amount
 * @return new bear bucks balance after deducting
 */
	public double deductBearBucks(double amount) {
		bearBucksBalance -= amount;
		return bearBucksBalance;
	}
/**
 * 
 * @return bear bucks balance
 */
	public double getBearBucksBalance() {
		return bearBucksBalance;
	}
/**
 * 
 * @return amount of money refunded after fee deduction, sets balance back to zero
 */
	public double cashOutBearBucks() {
		if (bearBucksBalance > 10.00) {
			double balance = bearBucksBalance;
			bearBucksBalance = 0;
			return balance - 10;
		}
		else {
			bearBucksBalance = 0;
			return 0;
		}
	}
/**
 * 
 * @param firstName
 * @param otherParent
 * @param isHyphenated
 * @param id
 * @return creates a student legacy based on how last name is spelled, also transfers parent bear bucks into account
 */
	public Student createLegacy(String firstName, Student otherParent, boolean isHyphenated, int id) {
		Student legacy;
		if (isHyphenated == false) {
			legacy = new Student(firstName, this.lastName, id);
		}
		else {
			legacy = new Student(firstName, this.lastName + "-" + otherParent.lastName, id);
		}
		legacy.depositBearBucks(this.cashOutBearBucks() + otherParent.cashOutBearBucks());
		return legacy;

	}
/**
 * @return student full name and id
 */
	public String toString() {
		return getFullName() + getId();
	}


}
