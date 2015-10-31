/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tri
 */
import javax.swing.JOptionPane;
public class JobTracker {
	public static void main (String [] args) {
		int x = 0;
		int option=0;
		final int LENGTH = 50;
		Job[] status = new Job[LENGTH];
		JobTracker jobTracker = new JobTracker();
		do {
			try {
				option = Integer.parseInt(JOptionPane.showInputDialog("Choose one of the following options:" +
						"\n1. Add a job." + 
						"\n2. Display all jobs." +
						"\n3. Find highest paying job." +
						"\n4. Exit."));
				System.out.println(option);
				if (option == 1) {
					if (x >= 50) {
						JOptionPane.showMessageDialog(null, "You have reached the limit of 50 jobs!");
					}
					else {
						jobTracker.addJob(status, x);
						x++;
					}
				}
				else if (option == 2) {
//					displayJobs(status[x]);
					jobTracker.displayJobs(status, x);
				}
				else if (option == 3) {
					jobTracker.findHighest(status, x);
				}
				else if (option == 4) {}
				else {
					invalidRange();
//					JOptionPane.showMessageDialog(null, "Your selection is invalid!");
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Your selection is invalid!");
			}
		}while(option!=4);
	}

	private void addJob(Job[] jobs, int currentIndex) {
//		private static void addJob() {
		Job status = new Job();
		String companyName;
		do {
			companyName = JOptionPane.showInputDialog("Enter company name of job " + status.getNumJobs() + ":");
			if (!status.setCompanyName(companyName)) {
				invalidString();
			}
			else{
				status.setCompanyName(companyName);
			}
		} while (!status.setCompanyName(companyName));

		String recruiterName;
		do {
			recruiterName = JOptionPane.showInputDialog("Enter recruiter name of job " + status.getNumJobs() + ":");
			if (!status.setRecruiterName(recruiterName)) {
				invalidString();
			}
			else{
				status.setRecruiterName(recruiterName);
			}
		} while (!status.setRecruiterName(recruiterName));

		double miles;
		do { 
			try {
				miles = Double.parseDouble(JOptionPane.showInputDialog("Enter number of miles away from home of job " + status.getNumJobs() + ":"));
			} catch (NumberFormatException e) {
				miles = -1;
			}
			if (!status.setMiles(miles)) {
				invalidNumber();
			}
			else{
				status.setMiles(miles);
			}
		}while (!status.setMiles(miles));
		int state=0;
		do { 
			try {
				state = Integer.parseInt(JOptionPane.showInputDialog("Choose one of the following states:" +
						"\n1. Waiting for phone interview." +
						"\n2. Waiting for in-person interview." +
						"\n3. Waiting for offer." +
						"\n4. Offer received."));
				double offerReceived;
				if (state == 1 || state == 2 || state ==3) {
					status.setOfferReceived(0);
				}
				if (state == 4) {
					do {
						try {
							offerReceived = Double.parseDouble(JOptionPane.showInputDialog("Enter offer received:"));
						} catch (NumberFormatException e) {
							offerReceived = -1;
						}
						if (!status.setOfferReceived(offerReceived)) {
							invalidNumber();
						}
						else{
							status.setOfferReceived(offerReceived);
						}
					} while (!status.setOfferReceived(offerReceived));
				}
				if (!status.setState(state)) {
					invalidRange();
				}
				else{
					status.setState(state);
				}
			}
			catch (NumberFormatException e) {
//				e.printStackTrace();
//				JOptionPane.showMessageDialog(null, "Your selection is invalid!");
				invalidRange();
			}
		}while(!status.setState(state));
		jobs[currentIndex] = status;
	}

	//	private static void displayJobs(Job status) {
	//	}
	private void displayJobs(Job[] status, int currentLength) {
//		System.out.println("currentLength: "+currentLength);
		String info = "";
		for(int i=0;i<currentLength; i++){
			info += (i+1)+". Company: "+status[i].getCompanyName()+" - ";
			info+= "Recruiter: "+status[i].getRecruiterName()+" - ";
			info+= "Miles: "+status[i].getMiles()+" - ";
//			info+= "Job State: "+status[i].getState();
			switch (status[i].getState()){
			case 1:
				info+= "Job State: Waiting for phone interview";
				break;
			case 2:
				info+= "Job State: Waiting for in-person interview";
				break;
			case 3:
				info+= "Job State: Waiting for offer";
				break;
			case 4:
				info+= "Job State: Offer received";
				break;
			}
			info+= status[i].getOfferReceived()>0?" - Offer Received: $"+status[i].getOfferReceived()+"\n":"\n";
		}
		JOptionPane.showMessageDialog(null, info);
	}

	private void findHighest(Job[] jobs, int currentLength) {
		Job highest = jobs[0];
		Job[] result = new Job[50];
		int index=0;
		int count=1;
		for (int x = 1; x < currentLength; x++) {
			if (highest.getOfferReceived() < jobs[x].getOfferReceived()) {
				index = x;
			}
		}
		result[0] = jobs[index];
		for (int x = 0; x < currentLength; x++) {
			if (result[0].getOfferReceived() == jobs[x].getOfferReceived() && x!=index) {
				result[count] = jobs[x];
				count++;
			}
		}
		displayJobs(result, count);
	}

	private static void invalidString() {
		JOptionPane.showMessageDialog(null, "This field cannot be empty!");
	}

	private static void invalidNumber() {
		JOptionPane.showMessageDialog(null, "Please enter a number greater than zero!");
	}
	private static void invalidRange() {
		JOptionPane.showMessageDialog(null, "Please enter a number from 1-4!");
	}
}

