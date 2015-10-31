/**
Name: Tam Ngo
Date: 02/15/2015
Course/Section: IT 206.DL1
Assignment: Programming Assignment 2

Description:

This program supports Cheery Charities, a local organization that helps charities raise money to fund projects.
The organization uses this program to track donations made towards a specific project. First, the program asks
the user to enter project's name, to set project's target total amount, and to indicate if the project has a
corporate sponsor. Next, the program asks the user to enter donation amount. The program repeats that task until
the user indicates that all donation amounts are entered. When all entered information have been processed, the
project's name, the project's target total amount, the sum of donation amounts, and if the project has a corporate
sponsor are displayed.

The user will be required to input the project's name, the project's target total amount, if the project has a 
corporate sponsor, and the donation amounts.

After all information is input and processed, the project's name, the project's target total amount, the sum of
donation amounts, and if the project has a corporate sponsor are displayed.
*/
import javax.swing.JOptionPane;
public class Project {
    public static void main (String[] args) {
        Info oneProject = new Info();
	
/*      
Prompt for the project's name. Will only progress if the project's name is not empty.
*/
        String name;
        do {
            name = JOptionPane.showInputDialog("Enter the project's name.");
        } while(!oneProject.setName(name));

/*     
Prompt the user whether or not they want to use the default target total amount of 1,000. 
If the user chooses "YES", set the default target total amount to 1,000.
If the user chooses "NO", prompt for the project's target total amount. Will only progress if the target total amount
        is a numeric value and greater than 0.   
*/
        double desiredDonation = (JOptionPane.showConfirmDialog(null, "Use the default target total amount of $1,000?", null,
                JOptionPane.YES_NO_OPTION));            
        if (desiredDonation == JOptionPane.YES_OPTION) {
            oneProject.setDesiredDonation(1000);    
	} else if (desiredDonation == JOptionPane.NO_OPTION) {
            while (true) {
                try {
                    desiredDonation = Double.parseDouble(JOptionPane.showInputDialog("Enter the project's target total amount:"));
                        if (desiredDonation <= 0) {
                            JOptionPane.showMessageDialog(null,"The project's target total amount must be greater than 0!");
                            continue;
                        }
                    oneProject.setDesiredDonation(desiredDonation);
                    break;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null,"The project's target total amount must be a numeric value!");
                }
            }
        }

/*	
Prompt the user whether or not the project has a corporate sponsor
*/
        int corporate = JOptionPane.showConfirmDialog(null, "The project has corporate sponsor?", null, JOptionPane.YES_NO_OPTION);
        if (corporate == JOptionPane.YES_OPTION) {
            oneProject.setCorporate(1);
        }
        else{
            oneProject.setCorporate(0);
        }

/*	
Countinue prompting the user for donation amount until they indicate they are done. Will only progress if the donation amount is a 
        numeric value and greater than 0, and total donation amount has not exceeded the project's target total amount.
*/
        double donation;
        while (true) {
			int choice;
			try {
				donation = Double.parseDouble(JOptionPane
						.showInputDialog("Enter donation amount:"));
				if (donation <= 0 || oneProject.exceedAmount(donation)) {
					JOptionPane
							.showMessageDialog(null,
									"Your donation is negative or has exceeded the desired amount");
					continue;
				}
				oneProject.calculateReceivedDonation(donation);
                                if (oneProject.getDonation() == oneProject.getDesiredDonation()) {
                                    JOptionPane.showMessageDialog(null, "Project name: "
						+ oneProject.getName() + "\n Desired donation: "
						+ oneProject.getDesiredDonation()
						+ "\n Donation received: " + oneProject.getDonation()
						+ "\n Corporate: " + oneProject.getCorporate());
                                    break;
                                }
                                

			} catch (NumberFormatException e) {

				JOptionPane.showMessageDialog(null,
						"Please enter a numeric value greater than 0!");

				continue;
			}

			choice = (JOptionPane.showConfirmDialog(null, "Continue?", null,
					JOptionPane.YES_NO_OPTION));
			if (choice == JOptionPane.YES_OPTION)
				continue;
			else {
				JOptionPane.showMessageDialog(null, "Project name: "
						+ oneProject.getName() + "\n Desired donation: "
						+ oneProject.getDesiredDonation()
						+ "\n Donation received: " + oneProject.getDonation()
						+ "\n Corporate: " + oneProject.getCorporate());
			}
			break;
        }
    }
}