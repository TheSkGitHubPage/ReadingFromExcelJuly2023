package challenges;

import junit.framework.Assert;

public class RemoveSpecialChars {
	
	public static void main(String[] args) {
		
		String bankBalanceStr = "$1000.23";
		String depositStr = "$345.22";
		String totalBalanceAfterDepositStr = "$1344.28";
		
		bankBalanceStr = bankBalanceStr.replace('$', ' ').strip();
		bankBalanceStr = bankBalanceStr.replace("$", "").strip();
		System.out.println(bankBalanceStr);
		
		
		
		
		double bankBalance = removeDollarSign(bankBalanceStr);
		double deposit = removeDollarSign(depositStr);
		double totalBalance = removeDollarSign(totalBalanceAfterDepositStr);
		
		//Assert.assertEquals(false, false);
		
		String age = "45";
		int ageInt = Integer.parseInt(age);
		System.out.println(ageInt + 15);
		
		
		
	}
	
	public static double removeDollarSign(String s) {
		s = s.replace("$", "");
		return Double.parseDouble(s);
	}

}
