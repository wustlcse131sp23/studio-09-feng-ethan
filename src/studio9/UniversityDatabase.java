package studio9;

import java.util.HashMap;
import java.util.Map;

import assignment7.Student;

public class UniversityDatabase {
	//TODO: Complete this class according to the studio instructions
	private final Map<String, Student> database;
	
	public UniversityDatabase() {
		this.database = new HashMap<>();
	}
	
	public void addStudent(String accountName, Student student) {
		database.put(accountName, student);
	}

	public int getStudentCount() {
		return database.size();
	}

	public String lookupFullName(String accountName) {
		if (database.get(accountName) == null) {
			return null;
		}
		else {
			return database.get(accountName).getFullName();
		}
	}

	public double getTotalBearBucks() {
		double total = 0;
		for (String accountName: database.keySet()) {
			double addition = database.get(accountName).getBearBucksBalance();
			total += addition;
		}
		return total;
	}
}
