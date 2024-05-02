import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GadgetShop {
    private static ArrayList<Gadget> gadgets = new ArrayList<Gadget>();
    private static JTextField modelField;
    private static JTextField priceField;
    private static JTextField weightField;
    private static JTextField sizeField;
    private static JTextField creditField;
    private static JTextField memoryField;
    private static JTextField phoneNumberField;
    private static JTextField durationField;
    private static JTextField downloadField;
    private static JTextField displayNumberField;

    public static void main(String[] args) {
        createGUI();
    }

    public static void createGUI() {
        JFrame frame = new JFrame("Gadget Shop");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 150);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 4, 2, 2));

        JLabel modelLabel = new JLabel("Model:");
        modelField = new JTextField();

        JLabel priceLabel = new JLabel("Price:");
        priceField = new JTextField();

        JLabel weightLabel = new JLabel("Weight:");
        weightField = new JTextField();

        JLabel sizeLabel = new JLabel("Size:");
        sizeField = new JTextField();

        JLabel creditLabel = new JLabel("Credit:");
        creditField = new JTextField();

        JLabel memoryLabel = new JLabel("Memory:");
        memoryField = new JTextField();

        JLabel phoneNumberLabel = new JLabel("Phone Number:");
        phoneNumberField = new JTextField();

        JLabel durationLabel = new JLabel("Duration:");
        durationField = new JTextField();

        JLabel downloadLabel = new JLabel("Download:");
        downloadField = new JTextField();

        JLabel displayNumberLabel = new JLabel("Display Number:");
        displayNumberField = new JTextField();

        JButton addMobileButton = new JButton("Add Mobile");
        addMobileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    String model = getModel();
                    double price = getPrice();
                    int weight = getWeight();
                    String size = getSize();
                    int credit = getCredit();
                    if (model.isEmpty() || size.isEmpty()) {
                        throw new EmptyModelorSizeException();
                    }
                    Mobile mobile = new Mobile(model, price, weight, size, credit);
                    gadgets.add(mobile);
                    JOptionPane.showMessageDialog(null, "Mobile Added.");
                } catch (EmptyModelorSizeException emptyModelorSizeException) {
                    System.out.println("Please enter a model and size.");
                    JOptionPane.showMessageDialog(null, "Please enter a model and size.");
                    //emptyModelorSizeException.printStackTrace();
                } catch (NumberFormatException EmptyNumberException) {
                    System.out.println("Please enter a number for the price, weight, and credit.");
                    JOptionPane.showMessageDialog(null, "Please enter a number for the price, weight, and credit.");
                    //EmptyNumberException.printStackTrace();
                } finally {
                    clearAllFields();
                }
                

            }
        });

        JButton addMP3Button = new JButton("Add MP3");
        addMP3Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String model = getModel();
                    double price = getPrice();
                    int weight = getWeight();
                    String size = getSize();
                    int memory = getMemory();
                    if (model.isEmpty() || size.isEmpty()) {
                        throw new EmptyModelorSizeException();
                    }
                    MP3 mp3 = new MP3(model, price, weight, size, memory);
                    gadgets.add(mp3);
                    JOptionPane.showMessageDialog(null, "MP3 Added.");
                } catch (EmptyModelorSizeException emptyModelorSizeException) {
                    System.out.println("Please enter a model and size.");
                    JOptionPane.showMessageDialog(null, "Please enter a model and size.");
                    //emptyModelorSizeException.printStackTrace();
                } catch (NumberFormatException EmptyNumberException) {
                    System.out.println("Please enter a number for the price, weight, and memory.");
                    JOptionPane.showMessageDialog(null, "Please enter a number for the price, weight, and memory.");
                    //EmptyNumberException.printStackTrace();
                } finally {
                   clearAllFields();

                }
            }
        });

        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearAllFields();
            }
        });

        JButton displayAllButton = new JButton("Display All");
        displayAllButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int listPosition = 0;
                String guiOutput = "";
                for (Gadget gadget : gadgets) {
                    guiOutput = guiOutput + "Display Number: " + listPosition + "\n";
                    
                    gadget.display();
                    guiOutput = guiOutput + gadget.display();

                    guiOutput = guiOutput + "\n \n";
                    listPosition++;
                }
                //For GUI
                System.out.println(guiOutput);
                JOptionPane.showMessageDialog(null, guiOutput);
                clearAllFields();
            }
        });

        JButton makeCallButton = new JButton("Make Call");
        makeCallButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int duration = getDuration();
                    int displayNumber = getDisplayNumber();
                    String phoneNumber = getNumber();
                    if (checkDisplayNumber(displayNumber)) {
                        Gadget gadget = gadgets.get(displayNumber);
                        Mobile mobile = (Mobile) gadget;
                        mobile.makeCall(phoneNumber, duration);
                        int remainingCredit = mobile.getCreditRemaining(); 
                        JOptionPane.showMessageDialog(null, "Calling " + phoneNumber + " for " + duration + " minutes. Device has " + remainingCredit + " minutes remaining.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid Display Number");
                    }
                    if (phoneNumber.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Invalid Phone Number");
                        System.out.println("Please enter a phone number.");
                    }
                } catch (NumberFormatException EmptyNumberException) {
                    System.out.println("Please ensure phone number, duration and display number are numbers.");
                    JOptionPane.showMessageDialog(null, "Please enter a number for the duration.");
                    //EmptyNumberException.printStackTrace();
                } 
            }
        });

        JButton downloadButton = new JButton("Download Music");
        downloadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int downloadSize = getDownloadSize();
                    int displayNumber = getDisplayNumber();
                    if (checkDisplayNumber(displayNumber)) {
                        Gadget gadget = gadgets.get(displayNumber);
                        MP3 mp3 = (MP3) gadget;
                        mp3.downloadMP3(downloadSize);
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid Display Number");
                    }
                } catch (NumberFormatException EmptyNumberException) {
                    System.out.println("Please ensure download size and display number are numbers.");
                    JOptionPane.showMessageDialog(null, "Please enter a number for the download size.");
                    EmptyNumberException.printStackTrace();
                }
            }
        });

        panel.add(modelLabel);
        panel.add(priceLabel);
        panel.add(weightLabel);
        panel.add(sizeLabel);
        panel.add(modelField);
        panel.add(priceField);
        panel.add(weightField);
        panel.add(sizeField);
        panel.add(creditLabel);
        panel.add(creditField);
        panel.add(memoryLabel);
        panel.add(memoryField);
        panel.add(phoneNumberLabel);
        panel.add(phoneNumberField);
        panel.add(durationLabel);
        panel.add(durationField);
        panel.add(downloadLabel);
        panel.add(downloadField);
        panel.add(displayNumberLabel);
        panel.add(displayNumberField);
        panel.add(addMobileButton);
        panel.add(addMP3Button);
        panel.add(clearButton);
        panel.add(displayAllButton);
        panel.add(makeCallButton);
        panel.add(downloadButton);

        frame.add(panel);
        frame.setVisible(true);

    }
    

    
    /** Used to get the Model Number of the Gadget in the text field
     * @return String - Model Number of the Gadget
     */
    private static String getModel() {
        return modelField.getText();
    }

    /** Used to get the Price of the Gadget in the text field
     * @return double - Price of the Gadget
     */
    private static double getPrice() {
        return Double.parseDouble(priceField.getText());
    }

    /** Used to get the Weight of the Gadget in grams in the text field
     * @return int - Weight of the Gadget
     */
    private static int getWeight() {
        return Integer.parseInt(weightField.getText());
    }

    /** Used to get the Size of the Gadget in the text field
     * @return String - Size of the Gadget
     */
    private static String getSize() {
        return sizeField.getText();
    }
    
    /** Used to get the Credit of the Gadget
     * @return int - Credit of the Gadget in credit field
     */
    private static int getCredit() {
        return Integer.parseInt(creditField.getText());
    }

    /** Used to get the Memory of the Gadget
     * @return int - Memory of the Gadget in memory field
     */
    private static int getMemory() {
        return Integer.parseInt(memoryField.getText());
    }

    private static String getNumber() {
        return phoneNumberField.getText();
    }

    /** Used to get the Duration of the Gadget
     * @return int - Duration of the Gadget in duration field
     */
    private static int getDuration() {
        return Integer.parseInt(durationField.getText());
    }

    /** Used to get the Download Size of the Gadget
     * @return int - Download Size of the Gadget in download field
     */
    private static int getDownloadSize() {
        return Integer.parseInt(downloadField.getText());
    }

    /** Used to get the Display Number of the Gadget
     * @return int - Display Number of the Gadget in display number field
     */
    private static int getDisplayNumber() {
        return Integer.parseInt(displayNumberField.getText());
    }

    /** Used to check if the Display Number is valid
     * @param displayNumber - Display Number of the Gadget
     * @return boolean - True if the Display Number is valid (in bound of ArrayList and positive), False if the Display Number is invalid
     */
    private static boolean checkDisplayNumber(int displayNumber) {
        if ((displayNumber < gadgets.size()) && (displayNumber >= 0)) {
            return true;
        } else {
            return false;
        }
    }

    /** Used to clear all the fields in the GUI
     */
    private static void clearAllFields() {
        priceField.setText(null);
        modelField.setText(null);
        weightField.setText(null);
        sizeField.setText(null);
        creditField.setText(null);
        phoneNumberField.setText(null);
        durationField.setText(null);
        downloadField.setText(null);
        displayNumberField.setText(null);
        memoryField.setText(null);
    }

    
}