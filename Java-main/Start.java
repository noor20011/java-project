import java.util.Scanner;
import skPackage.accountManagement.*;
import skPackage.employeeCustomerManagement.*;
import skPackage.transectionManagement.*;


public class Start
{
	public static void main(String args[])
	{
		mainMenu();
	}
//Code for clear screen

	public static void cls()
{
	try
	{	
		new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
	}catch(Exception E)
		{
			System.out.println(E);
		}
}
//----------------------
	public static void mainMenu()
	{

//Code for clear screen
		    for(int i=1; i<=100; i=i+10)
		{
			System.out.println("Loading... \n\nProgress : "+i+"%");
			cls();
		}  
//----------------------
            System.out.println();	
            System.out.println("");
			System.out.println("                                                                         ");
			System.out.println("                            *** Bank Management System ***               ");
			System.out.println("                            ______________________________               ");
			System.out.println();

		try
		{
			Bank bank=new Bank();
			Employee existingEmployee=new Employee();
			Customer existingCustomer=new Customer();
			Scanner input=new Scanner(System.in);
			int option;
			do
			{
				System.out.println("                                    ~~ Main Menu ~~                          ");
				System.out.println();
				System.out.println("1. Employee Management\n2. Customer Management\n3. Customer Account Management\n4. Account Transactions\n5. Exit");
				System.out.print("\nChoose an Option : ");
				option=input.nextInt();
				input.nextLine();
				if(option==1)
				{
					String name;
					String empId;
					double salary;
					Employee newEmployee=new Employee();
					System.out.println("                             ~~ Employee Management ~~                         ");
					System.out.println();
					System.out.println("\t1. Insert New Employee\n\t2. Remove Existing Employee\n\t3. Show All Employees\n\t4. Back");
					System.out.print("\nChoose an Option : ");
					option=input.nextInt();
					input.nextLine();
					if(option==1)
					{
						
						System.out.print("Enter the Name of the Employee  : ");
						name=input.nextLine();
						newEmployee.setName(name);
						System.out.print("Enter the Employee's ID         : ");
						empId=input.nextLine();
						newEmployee.setEmpId(empId);
						System.out.print("Enter the Employee's Salary     : ");
						salary=input.nextDouble();
						newEmployee.setSalary(salary);
						bank.insertEmployee(newEmployee);
					}
					else if(option==2)
					{
						
						System.out.print("Enter the Employee's ID        : ");
						empId=input.nextLine();
						bank.removeEmployee(bank.getEmployee(empId));
					}
					else if(option==3)
					{
						bank.showAllEmployees();
					}
					else if(option==4){
						mainMenu();
					}
					else
					{
						System.out.println("\n[x] No such option\nPlease select another option");
					}
				}
				else if(option==2)
				{
					String name;
					int nid;
					Customer newCustomer=new Customer();
					System.out.println("                                  ~~ Customer Management ~~                         ");
					System.out.println();
					System.out.println("\n\t1. Insert New Customer\n\t2. Remove Existing Customer\n\t3. Show All Customer\n\t4. Back");
					System.out.print("\nChoose an Option : ");
					option=input.nextInt();
					input.nextLine();
					if(option==1)
					{   
						
						System.out.print("Enter the Name of the Customer : ");
						name=input.nextLine();
						newCustomer.setName(name);
						System.out.print("Enter the Customer's NID       : ");
						nid=input.nextInt();
						input.nextLine();
						newCustomer.setNid(nid);
						bank.insertCustomer(newCustomer);
					}
					else if(option==2)
					{
						
						System.out.print("Enter the Customer's NID      : ");
						nid=input.nextInt();
						input.nextLine();
						bank.removeCustomer(bank.getCustomer(nid));
					}
					else if(option==3)
					{
						
						bank.showAllCustomers();
					}
					else if(option==4){
						mainMenu();
					}
					else
					{
						System.out.println("\n[x] No such option\nPlease select another option");
					}
				}
				else if(option==3)
				{
					int accountNumber;
					double balance;
					double interestRate;
					int tenureYear;
					System.out.println("                             ~~ Customer Account Management ~~                         ");
					System.out.println();
					System.out.println("\n\t1. Insert New Account\n\t2. Remove Existing Account\n\t3. Show All Accounts\n\t4. Back");
					System.out.print("\nChoose an Option : ");
					option=input.nextInt();
					input.nextLine();
					if(option==1)
					{   
						System.out.println("\nWhat type of account you want to create?");
				        System.out.println();
						System.out.println("1. Fixed Account\n2. Savings Account\n3. Back to Main Menu");
						System.out.print("\nChoose an Option : ");
						option=input.nextInt();
						input.nextLine();
						if(option==1)
							{
							FixedAccount f=new FixedAccount();
							System.out.print("Enter Account Number        : ");
							accountNumber=input.nextInt();
							input.nextLine();
							f.setAccountNumber(accountNumber);
							System.out.print("Enter Account's Balance   : ");
							balance=input.nextDouble();
							input.nextLine();
							f.setBalance(balance);
							System.out.print("Enter Account's Tenure Year : ");
							tenureYear=input.nextInt();
							input.nextLine();
							f.setTenureYear(tenureYear);
							existingCustomer.insertAccount(f);
						}
						
						else if(option==2)
							{
							SavingsAccount s=new SavingsAccount();
							System.out.print("Enter Account Number          : ");
							accountNumber=input.nextInt();
							input.nextLine();
							s.setAccountNumber(accountNumber);
							System.out.print("Enter Account's Balance       : ");
							balance=input.nextDouble();
							input.nextLine();
							s.setBalance(balance);
							System.out.print("Enter Account's Interest Rate : ");
							interestRate=input.nextDouble();
							input.nextLine();
							s.setInterestRate(interestRate);
							existingCustomer.insertAccount(s);
						}
						
					}
					else if(option==2)
					{
						
						System.out.print("Enter Account Number  : ");
						accountNumber=input.nextInt();
						input.nextLine();
						existingCustomer.removeAccount(existingCustomer.getAccount(accountNumber));
					}
					else if(option==3)
					{

						existingCustomer.showAllAccounts();
					}
					else if(option==4){
						mainMenu();
					}
					else
					{
						System.out.println("\n[x] No such option\nPlease select another option");
					}
				}
				else if(option==4)
				{
					int accountNumber;
					double amount;
					System.out.println("                           ~~ Transactions Management ~~                         ");
					System.out.println();
					System.out.println("\t1. Deposit Money\n\t2. Withdraw Money\n\t3. Transfer Money\n\t4. Back");
					System.out.print("\nChoose an Option : ");
					option=input.nextInt();
					input.nextLine();
					if(option==1)
					{
						
						System.out.print("Enter an Account Number in Which you Want to Deposit Money : ");
						accountNumber=input.nextInt();
						input.nextLine();
						System.out.print("Enter Amount of Money to Deposit                        : ");
						amount=input.nextDouble();
						input.nextLine();
						(existingCustomer.getAccount(accountNumber)).createDirectory();
						(existingCustomer.getAccount(accountNumber)).deposit(amount);
					}
					else if(option==2)
					{
						
						System.out.print("Enter an Account Number in Which you Want to Withdrow Money : ");
						accountNumber=input.nextInt();
						input.nextLine();
						System.out.print("Enter Amount of Money to Withdraw                       : ");
						amount=input.nextDouble();
						input.nextLine();
						(existingCustomer.getAccount(accountNumber)).createDirectory();
						(existingCustomer.getAccount(accountNumber)).withdraw(amount);
					}
					else if(option==3)
					{
						int transferFrom,transferTo;
						System.out.print("Enter an Account Number from Which you Want to Transfer Money : ");
						transferFrom=input.nextInt();
						input.nextLine();
						System.out.print("Enter an Account Number to Which you Want to Transfer Money   : ");
						transferTo=input.nextInt();
						input.nextLine();
						System.out.print("Enter Amount of Money to Transfer                         : ");
						amount=input.nextDouble();
						input.nextLine();
						(existingCustomer.getAccount(transferFrom)).createDirectory();
						(existingCustomer.getAccount(transferFrom)).transfer(existingCustomer.getAccount(transferTo), amount);
					}
					else if(option==4){
						mainMenu();
					}
					else
					{
						System.out.println("\n[x] No such option\nPlease select another option");
					}
				}
				else
				{
					if(option!=5)
					{
						System.out.println("\n[x] No such option\nPlease select another option");
					}
					else if(option==5){
						System.out.println("\n[x] Program is Exited");
						System.out.println("\n\n\t\t\t** Thanks for trusting us ** ");
						System.out.println();
						System.exit(0);
					}
					else
					{
						
						mainMenu();
					}
				}

			}while(option!=5);
		}
		catch(Exception ex)
		{

			System.out.println("\n[x] Wrong input\n\n[x] Program Exited\n\n\t\t\t** Thanks for trusting us **");

		}
	}
}