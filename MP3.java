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