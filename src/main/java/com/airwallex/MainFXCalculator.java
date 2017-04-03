package com.airwallex;
import java.util.Scanner;

import com.airwallex.common.CurrencyConverter;
import com.airwallex.exception.CurrencyException;

public class MainFXCalculator {
	
	public static void main(String args[]){
		CurrencyConverter currencyConverter = new CurrencyConverter();
		Double convertedValue=null;
		Scanner scanner = null;
		try {
			scanner = new Scanner(System.in);
			System.out.println("Ex : AUD 100.00 in USD ");
			System.out.print("Please enter value--> ");
			String input= scanner.nextLine();
			
			String[] inputArr = input.split("\\s");
			currencyConverter.validateSetValues(inputArr[0], inputArr[3], inputArr[1]);
			convertedValue=currencyConverter.process();
			System.out.println(currencyConverter.getSource() + " " + currencyConverter.getQuantity() + "=" + currencyConverter.getTarget() + " " +  convertedValue);

		} catch (CurrencyException e) {
			e.printStackTrace();
		}finally{
			scanner.close();
		}
	}
}
