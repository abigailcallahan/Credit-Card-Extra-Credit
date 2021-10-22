import java.io.File;
import java.io.IOException;
import java.util.Scanner;

//For extra credit, generate exactly 100 potentially valid credit card numbers.
public class CreditCardExtraCredit
	{
		static long creditCardTest;
		static long creditCardTest1;
		static long [] ccArray = new long[16];
		static long digit;
		static long doubleDigit1;
		static long doubleDigit2;
		static long ccSum;
		static int counter = 0;
		
		public static void main(String[] args) throws IOException
			{
				Scanner myFile = new Scanner(new File("realcredit.txt"));
				for(long i = 0; i <= 100; i++) 
					{
						long generateNums = (long) (Math.random() * 1000000000000000L) + 1;
						creditCardTest = generateNums;
						intoArray();
						takeAltNums();
						addDoubleDigits();
						sumAllDigits();
						
					}

				while(myFile.hasNext()) 
					{
						

						
					}
				System.out.println("\n\nThe number of potential valid credit cards: " + counter);
			}
	
		public static void intoArray()
			{

				for(int i = 0; i < ccArray.length; i++)
					{
						digit = creditCardTest1 % 10;
						ccArray[15 - i] = digit;
						creditCardTest1 = creditCardTest1 / 10;
					}
			}

		public static void takeAltNums()
		{
			for(int i = 0; i < ccArray.length; i+=2)
				{
					ccArray[i] = ccArray[i] * 2;
				}
		}

		public static void addDoubleDigits()
		{
			for(int i = 0; i < ccArray.length; i++)
				{
					if(ccArray[i] > 9)
						{
							doubleDigit1 = ccArray[i] % 10;
							doubleDigit2 = ccArray[i] / 10;
							ccArray[i] = doubleDigit1 + doubleDigit2;
						}
				}
		}

		public static void sumAllDigits()
		{
			ccSum = 0;
			for(int i = 0; i < ccArray.length; i++)
				{
					ccSum = ccSum + ccArray[i]; 
				}
			
			if(ccSum % 10 == 0)
				{
					System.out.println("The credit card number " + creditCardTest + " is potentially valid.");
					counter++;
				}
			else
				{
					System.out.println("The credit card number " + creditCardTest + " is invalid.");
				}
				
			
		}

	}
