/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tri
 */
public class Job {
	private String companyName;
	private String recruiterName;
	private double miles;
	private double offerReceived;
	private int state;
	private static int numJobs=0;

	// Construct a default Job object.
	public Job() {
//		this(null, null, 0, 0);
		++numJobs;
	}

	// Construct a Job object with a specified company name, recruiter name, number of miles away from home, and offer received. 
	public Job(String companyName, String recruiterName, double miles, double offerReceived) {
		this.companyName = companyName;
		this.recruiterName = recruiterName;
		this.miles = miles;
		this.offerReceived = offerReceived;
		++numJobs;
	}

	// Return number of jobs created
	public static int getNumJobs() {
		return numJobs;
	}

	// Return company name.
	public String getCompanyName() {
		return this.companyName;
	}

	// Set company name.
	public boolean setCompanyName(String companyName) {
		if (companyName.equals("")) {
			return false;
		}
		else {
			this.companyName = companyName;
			return true;
		}
	}

	// Return recruiter name.
	public String getRecruiterName() {
		return this.recruiterName;
	}

	// Set recruiter name.
	public boolean setRecruiterName(String recruiterName) {
		if (recruiterName.equals("")) {
			return false;
		}
		else {
			this.recruiterName = recruiterName;
			return true;
		}
	}

	// Return number of miles away from home.
	public double getMiles() {
		return this.miles;
	}

	// Set number of miles away from home.
	public boolean setMiles(double miles) {
		if (miles > 0) {
			this.miles = miles;
			return true;
		}
		else {
			return false;
		}
	}

	// Return offer received.
	public double getOfferReceived() {
		return this.offerReceived;
	}

	// Set offer received.
	public boolean setOfferReceived(double offerReceived) {
		if (offerReceived >= 0) {
			this.offerReceived = offerReceived;
			return true;
		}
		else {
			return false;
		}
	}

	public int getState() {
		return state;
	}

	public boolean setState(int state) {
		if (state > 0 && state<5) {
			this.state = state;
			return true;
		}
		else {
			return false;
		}
	}

}

