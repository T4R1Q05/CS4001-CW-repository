public class Mobile extends Gadget {
    private int creditRemaining;


    public Mobile(String model, double price, int weight, String size, int creditRemaining) {
        super(model, price, weight, size);
        this.creditRemaining = creditRemaining;
    }


    public int getCreditRemaining() {
        return this.creditRemaining;
    }

    public void addCredit(int amount) {
        if (amount > 0) {
            this.creditRemaining += amount;
        } else {
            System.out.println("Please enter a positive number of minutes.");
        }
    }

    public void makeCall(String phoneNumber, int duration) {
        if (this.creditRemaining >= duration) {
            System.out.println("Calling " + phoneNumber + " for " + duration + " minutes.");
            this.creditRemaining -= duration;
        } else {
            System.out.println("There is insufficient credit remaining to make the call.");
        }
    }

    public String display() {
        String output = super.display();
        String outputFinal = output + "Credit Remaining: " + this.creditRemaining;
        return outputFinal;
    }

}