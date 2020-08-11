package primes;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;

/**
 * PrimesProgram contains methods for PrimesGUI.
 * @author Monjin
 * @version 1.1, 17.7.2014
 * @version 1.2 16.10.2014
 */
public class PrimesProgram implements Runnable {
	private JTextArea result;
	private ProgramMode runMode;
	
	private long findPrimesStartRange = 0;
	private long findPrimesEndRange = 0;
	
	public PrimesProgram(ProgramMode pMode) {
		this.runMode = pMode;
	}
	
	public enum ProgramMode {
		SINGLE_PRIME,
		FIND_PRIMES
	}
	
	/**
	 * Sets the range for findingPrimes
	 * @param numberOne Starging number
	 * @param numberTwo Ending number
	 */
	public void setFindPrimesRange(String numberOne, String numberTwo) {
		boolean isNumberStart = tryParseLong(numberOne);
    	boolean isNumberEnd = tryParseLong(numberTwo);
        String message; //Used to print how many primes were found.
        message = "\nBetween " + numberOne + " - " + numberTwo + ":";
        printOnScreen(message);
    	
    	printOnScreen("\n-------------------------------------");
    	
    	if (isNumberStart == false || isNumberEnd == false){
    		printOnScreen("\nStarting and ending numbers must be integers!");
    		return;
    	}
    	
    	long a = Long.valueOf(numberOne), b = Long.valueOf(numberTwo);
    	
    	if (a <= 0 || b <= 0) {
    		printOnScreen("\nNo negative numbers!");
    		return;
    	}
    	
        //
        //Works as an error check if the starting number is higher than
        //the ending number.
        //
        while (a >= b){
            printOnScreen("\nStarting number must be greater than the ending number!");
            return;
        }
        
        this.findPrimesStartRange = a;
        this.findPrimesEndRange = b;
	}
	
	/**
	 * Sets the result area for the program
	 * @param textField resultArea of the GUI.
	 */
	public void setResultArea(JTextArea textField) {
		result = textField;
	}
	
	/**
	 * Called upon checking a single prime's primality.
	 * @param s Contains the number that is being checked.
	 * @param textField Is the result field.
	 */
    @SuppressWarnings("unused")
	private void singlePrime(String inputNumber){
    	boolean isNumber = tryParseLong(inputNumber);
    	
    	printOnScreen("\n-------------------------------------");
    	
    	if (isNumber == false){
    		printOnScreen("\n" + "Input must be an integer!");
    		return;
    	}
    	
    	long testedNumber = Long.valueOf(inputNumber);
    	
    	if (testedNumber <= 0){
    		printOnScreen("\n" + "No negative numbers!");
    		return;
    	}
    	
        boolean primeNumber = checkPrime(testedNumber);
        
        if (primeNumber == true) printOnScreen("\n" + testedNumber + " is a prime!");
        else printOnScreen("\n" + testedNumber + " is not a prime.");
    }
    
    /**
     * Prints found primes and all messages.
     * @param result Is the result text area.
     * @param s Contains found primes.
     */
    protected void printOnScreen(String s){
    	result.append(s);
    }
    
    /**
     * Finds all the primes found in the given range.
     * @param start
     * @param end
     * @return RecordHelper that records both a list of the found primes and how many were found
     */
    protected static RecordHelper findPrimesFromRange(long start, long end) {
    	List<Long> foundPrimes = new ArrayList<Long>();
    	int numberFound = 0;
    	long current = start;
    	while (current <= end){
            if (checkPrime(current)){
                foundPrimes.add(current);
                numberFound++;
            }            
            current++;
        }
    	return new RecordHelper(foundPrimes, numberFound);
    }

    /**
     * Does the actual checking of the number whether it's a prime or not.
     * @param n The number that is being checked.
     * @return True if is a prime, false if not a prime.
     */
    protected static boolean checkPrime(long n){
        if (n == 1) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        long i = 5;
        long w = 2;
        while (i * i <= n){
            if (n % i == 0) return false;
            i += w;
            w = 6 - w;
        }
        return true;
    }
    
    /**
     * Checks if the input is an integer.
     * @param value Contains the input.
     * @return True if input is an integer, false if not an integer.
     */
    protected static boolean tryParseLong(String value) {  
         try  {  
             Long.parseLong(value);  
             return true;  
          } catch(NumberFormatException nfe)  {  
              return false;  
          }  
    }
    
    public static class RecordHelper {
    	public List<Long> primes;
    	public int found;
    	
    	public RecordHelper(List<Long> foundPrimes, int numberFound) {
    		this.primes = foundPrimes;
    		this.found = numberFound;
    	}
    	
    	@Override
    	public String toString() {
    		StringBuilder message = new StringBuilder("\nPrimes found: " + found + "\nFound primes are:\n");
    		int counter = 1;
    		for(long prime : primes) {
    			if (counter == 10) {
    				message.append("\n" + String.valueOf(prime) + ", ");
    				counter = 1;
    			}
    			else {
    				message.append(String.valueOf(prime) + ", ");
    				counter++;
    			}
    		}
    		message.setLength(message.length() - 2);
    		message.append("\n");
    		return message.toString();
    	}
    }
    
    /**
     * TODO: To be used later
     */
    public static void sumRecordLists() {
    	
    }

    /**
     * Run method for Runnable Interface
     */
	@Override
	public void run() {
		try {
			if (this.runMode == ProgramMode.FIND_PRIMES) {
				RecordHelper rh = findPrimesFromRange(this.findPrimesStartRange, this.findPrimesEndRange);
				printOnScreen(rh.toString());
				result.setCaretPosition(result.getDocument().getLength());
			}
			else {
				printOnScreen("Nothing");
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
