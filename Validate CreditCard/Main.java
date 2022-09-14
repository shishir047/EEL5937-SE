package io.github.shishir;
import java.util.Scanner;
//  Importing scanner class in the main to scan the credit card number entered by the user.
class Main {
    public static void main(String[] args) {
        ValidateCreditCard vcc = new ValidateCreditCard(); // Creating an instance of ValidateCreditCard Class.
        Scanner sc = new Scanner(System.in);
        long ccNo;
        System.out.print("Enter credit card number: ");
        ccNo = sc.nextLong(); // Scanning credit card number from the user.
        sc.close();
        vcc.validate(ccNo); // calling method using an instance of ValidateCreditCard Class.
        // Validating credit card number using a method validateCC mentioned in ValidateCreditCard Class.
    }

}