/*
 * Author: Tariq Chowdhury
 * Date: 2/05/2024
 * Purpose: This class is a subclass of Gadget and represents a mobile phone. It has an additional attribute creditRemaining which represents the credit available on the mobile phone. The class has a constructor, getCreditRemaining method, addCredit method, makeCall method and display method.
 */
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
