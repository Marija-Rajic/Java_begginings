import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {
    public static void main(String[] args) {
     /*   principal: 100000
                Annual rate: 3.92
                period years: 30
                mortgage $472.81
*/
        Scanner scan = new Scanner(System.in);
        double principal = 0;
        double annualRate = 0;
        double monthlyRate = 0; //(annualRate / 100) / 12;
        double paymentNumber = 0;
        double years = 0;

        while (true) {
            System.out.print("Principal: ");
            principal = scan.nextDouble();
            if (1000 <= principal && principal <= 1000000) {
                break;
            }
            System.out.println("Enter a number between 1,000 and 1,000,000.");
        }
        System.out.println(principal);

        while (true) {
            System.out.print("Annual rate: ");
            annualRate = scan.nextDouble();
            if (0 < annualRate && annualRate <= 5) {
                monthlyRate = (annualRate / 100) / 12;
                break;
            }
            System.out.println("Enter a value greater than 0 and less than 5.");
        }
        System.out.println(monthlyRate);

        while (true) {
            System.out.print("Period years: ");
            years = scan.nextDouble();
            if (1 <= years && years <= 30) {
                paymentNumber = years * 12;
                break;
            }
            System.out.println("Enter a value between 1 and 30.");
        }
        System.out.println(paymentNumber);

        double mortgage = Math.floor(principal * ((monthlyRate * Math.pow((1 + monthlyRate), paymentNumber)) / (Math.pow((1 + monthlyRate), paymentNumber) - 1)));
        NumberFormat currency = NumberFormat.getCurrencyInstance();

        String result = currency.format(mortgage);

        System.out.println("Mortgage is " + result);

    }
}
