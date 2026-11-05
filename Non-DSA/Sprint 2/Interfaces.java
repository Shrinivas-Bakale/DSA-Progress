
interface PaymentGateway {
    void processPayment(double amount);
}

class CreaditCardPayment implements PaymentGateway {
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of " + amount);
    }
}

class UPIPayment implements PaymentGateway {
    public void processPayment(double amount) {
        System.out.println("Processing UPI payment of " + amount);
    }
}

public class Interfaces {
    public static void main(String[] args) {

    }
}

/*
 * You are required to design an interface PaymentGateway that defines a common
 * method for processing payments. Implement two classes, CreditCardPayment and
 * UPIPayment, which provide specific implementations of the processPayment()
 * method. Use polymorphism to demonstrate how different payment methods can be
 * processed through the same interface.
 * 
 * Interface PaymentGateway :
 * 
 * Abstract Method processPayment( double amount ) : This method processes a
 * payment of the specifies amount.
 * Implementing classes :
 * 
 * CreditCardPayment :
 * 
 * Method :
 * 
 * processPayment( double amount ) : Implements to print
 * "Processing credit card payment of amount".
 * UPIPayment
 * 
 * Method :
 * 
 * processPayment( double amount ) : Implements to print
 * "Processing UPI payment of amount".
 * Refer the sample input example to understand about the output format.
 * 
 * Refer the commented code on IDE for output statements.
 * 
 * Example 1:
 * Input : paymetMethod = [ "credit", "upi" ]
 * 
 * paymentValue = [ 284.5 , 27476.2 ]
 * 
 * Output :
 * 
 * Processing credit card payment of 284.50
 * 
 * Processing UPI payment of 27476.20
 */