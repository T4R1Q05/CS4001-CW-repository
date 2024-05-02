/*
 * Aurthor: Tariq Chowdhury
 * Date: 2/05/2024
 * Purpose: This class is a subclass of Gadget and represents an MP3 player. It has an additional attribute remainingMemory which represents the memory available on the MP3 player. The class has a constructor, getAvailableMemory method, downloadMP3 method, deleteMP3 method and display method.
 */
import javax.swing.JOptionPane;

public class MP3 extends Gadget {
    private int remainingMemory;

    public MP3(String model, double price, int weight, String size, int remainingMemory) {
        super(model, price, weight, size)
        this.remainingMemory = remainingMemory; // Missing semicolon
    }

    public int getAvailableMemory(){
        return remainingMemory // Missing semicolon
    }

    public void downloadMP3(int memoryRequired){
        if (memoryRequired < 0){
            System.out.println("Please enter a positive number of MB");
            JOptionPane.showMessageDialog(null, "Please enter a positive number of MB");
        } else
        if ((this.remainingMemory >= memoryRequired)){
            this.remainingMemory -= memoryRequired;
            System.out.println("MP3 file downloaded. You have " + remainingMemory + " MB remaining");
            JOptionPane.showMessageDialog(null, "MP3 file downloaded. You have " + remainingMemory + " MB remaining");
        } else {
            System.out.println("Not enough memory available. " + "You have " + remainingMemory + "MB remaining");
            JOptionPane.showMessageDialog(null, "Not enough memory available. " + "You have " + remainingMemory + "MB remaining");
        }
    }

    public void deleteMP3(int memoryUsed){
        System.out.println("Deleting file");
        remainingMemory += memoryUsed
        System.out.println("Deleted " + memoryUsed + " MB"); // Missing semicolon
        System.out.println("Available Memory: " + remainingMemory + " MB");
    }

    public String display() {
        String output = super.display();
        String outputFinal = output + "Remaining Memory: " + remainingMemory + " MB";
        return outputFinal;
    }
}
