/*
 * Author: Tariq Chowdhury
 * Date: 2/05/2024
 * Purpose: This class is a superclass and represents a gadget. It has attributes model, price, weight and size. The class has a constructor, getPrice method, getWeight method, getSize method and display method.
 */
public class EmptyModelorSizeException extends Exception {
    public EmptyModelorSizeException() {
        super("Please enter a model and size.");
    }

}


