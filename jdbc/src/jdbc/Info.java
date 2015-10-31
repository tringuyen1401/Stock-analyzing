public class Info {
    private String name;
    private int corporate;
    private double donation;
    private double desiredDonation;
    private double receivedDonation;

    public Info(){
        this.desiredDonation=1000;
        this.receivedDonation=0;
        this.corporate = 0;
    }
    public String getName() {
        return this.name;
    }
    public boolean setName(String name) {
        if (name != null) {
            this.name = name;
            return true;
        }
        else {
            return false;
        }
    }
    public double getDesiredDonation() {
        return desiredDonation;
    }
    public boolean setDesiredDonation(double desiredDonation) {
        if (desiredDonation > 0) {
            this.desiredDonation = desiredDonation;
            return true;
        }
        else {
            return false;
        }
    }
    public String getCorporate(){
    	if (corporate == 0)
    		return "NO";
    	return "YES";
    }
    public void setCorporate(int corporate) {
        this.corporate = corporate;
    }
    public double getDonation() {
        return receivedDonation;
    }
    public boolean setDonation(double donation) {
        if (donation > 0) {
            this.donation = donation;
            return true;
        }
        else {
            return false;
        }
    }
    public void calculateReceivedDonation(double donation) {
        if (corporate == 0 ) {
            Info.this.receivedDonation +=donation;
        }
        else {
            Info.this.receivedDonation +=(donation*2);
        }
    }
    public boolean exceedAmount(double donation){
    	if ((receivedDonation + donation) > desiredDonation)
    		return true;
    	return false;
    }
}