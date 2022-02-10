package Labs;
import java.util.Scanner;
import java.util.Date;
public class Loan
{
    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;
    private Date loanDate;
    // Constructor no input
    public Loan()
    {

    }
    // Constructor with all input
    public Loan(double annualInterestRate, int numberOfYears, double loanAmount)
    {
        Date date = new Date();
        this.annualInterestRate=annualInterestRate;
        this.numberOfYears=numberOfYears;
        this.loanAmount=loanAmount;
        this.loanDate=date;
    }

    public double getAnnualInterestRate() 
    {
        return this.annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) 
    {
        this.annualInterestRate = annualInterestRate;
    }

    public int getNumberOfYears() 
    {
        return this.numberOfYears;
    }

    public void setNumberOfYears(int numberOfYears) 
    {
        this.numberOfYears = numberOfYears;
    }

    public double getLoanAmount() 
    {
        return this.loanAmount;
    }

    public void setLoanAmount(double loanAmount) 
    {
        this.loanAmount = loanAmount;
    }

    public Date getLoanDate() 
    {
        return this.loanDate;
    }

    public double getMonthlyPayment()
    {
        double monthlyInterestRate = this.annualInterestRate/(12*100);
        double monthlyPayment = (this.loanAmount*monthlyInterestRate)/(1 - 1/Math.pow((1+monthlyInterestRate), this.numberOfYears*12));
        return monthlyPayment;
    }

    public double getTotalPayment()
    {
        double totalPayment = getMonthlyPayment()*this.numberOfYears*12;
        return totalPayment;
    }
    
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter annual interest rate, for example, 8.25: ");
        double annualInterestRate = input.nextDouble();
        System.out.print("Enter number of years an integer: ");
        int numberOfYears = input.nextInt();
        System.out.print("Enter loan amount, for example, 120000.95: ");
        double loanAmount = input.nextDouble();
        Loan l1 = new Loan(annualInterestRate,numberOfYears,loanAmount);
        System.out.println("The loan was created on "+l1.getLoanDate());
        System.out.println("The monthly payment is "+String.format("%.2f", l1.getMonthlyPayment()));
        System.out.println("The total payment is "+String.format("%.2f", l1.getTotalPayment()));
        input.close();
    }
}
