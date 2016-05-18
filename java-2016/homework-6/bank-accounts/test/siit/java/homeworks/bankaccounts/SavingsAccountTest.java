package siit.java.homeworks.bankaccounts;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;



public class SavingsAccountTest {

	@Test
	public void whenMonthlyFeeIsSet_testingBalanceAfterYear() {
		Date accountCreationTime = TestUtils.getDate(2016, 1, 1);
		SavingsAccount simpleSavingAccount = new SavingsAccount(accountCreationTime, 2, 6000, 0.02f, 0.06f);
		Date balanceInterogationTime = TestUtils.getDate(2017, 12, 1);
		System.out.println(simpleSavingAccount.getBalance(balanceInterogationTime));
		assertEquals(6362.12f, simpleSavingAccount.getBalance(balanceInterogationTime), 0);
	}

	@Test
	public void whenMonthlyFeeIsZero_testingBalanceWithInterestAfterYear() {
		Date accountCreationTime = TestUtils.getDate(2016, 1, 1);
		SavingsAccount simpleSavingAccount = new SavingsAccount(accountCreationTime,0, 6000, 0.02f, 0.06f);
		Date balanceInterogationTime = TestUtils.getDate(2017, 12, 1);
		System.out.println(simpleSavingAccount.getBalance(balanceInterogationTime));
		assertEquals( 6360,simpleSavingAccount.getBalance(balanceInterogationTime), 0);
	}
	
	@Test
	public void whenMonthlyFeeIsNotZero_testingBalanceWithInterestAfterUntilYear() {
		Date accountCreationTime = TestUtils.getDate(2016, 1, 1);
		SavingsAccount simpleSavingAccount = new SavingsAccount(accountCreationTime, 50, 6000, 0.02f, 0.06f);
		Date balanceInterogationTime = TestUtils.getDate(2016, 11, 1);
		System.out.println(simpleSavingAccount.getBalance(balanceInterogationTime));
		assertEquals( 6100,simpleSavingAccount.getBalance(balanceInterogationTime), 0);
	}
	
	

}
