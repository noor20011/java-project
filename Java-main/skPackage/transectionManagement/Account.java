package skPackage.transectionManagement;

import java.io.*;
import java.lang.*;
import skPackage.transectionManagement.*;

public abstract class Account implements ITransactions{
	private int accountNumber;
	private double balance;
	
	public void setAccountNumber(int accountNumber)
	{
		this.accountNumber=accountNumber;
	}
	public void setBalance(double balance)
	{
		this.balance=balance;
	}
	public int getAccountNumber()
	{
		return this.accountNumber;
	}
	public double getBalance()
	{
		return this.balance;
	}
	abstract public void showInfo();



private File folder;
	private File file;			//to create a File
	private FileWriter writer;		//to write in a file
	private FileReader reader;		//to read from a file
	private BufferedReader buffer;		//to read file content as a String
	

	
	public void writeInFile(String s){
		try
		{
			file = new File("Transection history/Transections.txt");
			file.createNewFile();
			writer = new FileWriter(file, true);
			writer.write(s+"\r\n");
			writer.flush();
			writer.close();
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
	public void readFromFile(){
		try
		{
			reader = new FileReader(file);
			buffer = new BufferedReader(reader);
			String text="", temp;
			
			while((temp=buffer.readLine())!=null)
			{
				
				text=text+temp+"\r"+"\n";
			}
			System.out.print(text);
			reader.close();
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}	
	
	

}	




public void createDirectory()
	{
		try
		{
			folder=new File("F:/java project/Transection history");
			folder.mkdir();
		}
		catch(Exception e)
		{
			e.printStackTrace() ;
		}
	}
	
	public void deposit(double amount)
	{
		writeInFile("\nBefore deposit\nBalance of account number "+accountNumber+" : "+balance);
		this.balance=balance+amount;
		writeInFile(amount+" Deposited successfully\nNew balance of account number "+accountNumber+" : "+balance+"\n");
		readFromFile();
	}
	public void withdraw(double amount)
	{
		if(amount<=balance)
		{
			writeInFile("\nBefore withdraw\nBalance of account number "+accountNumber+" : "+balance);
			this.balance=balance-amount;
			writeInFile(amount+" Withdrawn successfully\nNew balance of account number "+accountNumber+" : "+balance+"\n");
			readFromFile();	
		}
		else
		{
			System.out.println("\n[x] Withdraw failed\nThe account has insufficient money to withdraw");
		}
	}
	public void transfer(Account a, double amount)
	{
		if(amount<=balance)
		{
			writeInFile("\nBefore transfering");
			writeInFile("Balance of account number "+accountNumber+" : "+balance);
			writeInFile("Balance of account number "+a.accountNumber+" : "+a.balance);
			this.balance=balance-amount;
			a.balance=a.balance+amount;
			writeInFile(amount+" Transfered successfully from account number "+accountNumber+" to "+a.accountNumber);
			writeInFile("New balance of account number "+accountNumber+" : "+balance);
			writeInFile("New balance of account number "+a.accountNumber+" : "+a.balance+"\n");
			readFromFile();
		}
		else
		{
			System.out.println("\n[x] Transfer failed\nThe account "+accountNumber+" has insuficient money to transfer");
		}
	}

	


}