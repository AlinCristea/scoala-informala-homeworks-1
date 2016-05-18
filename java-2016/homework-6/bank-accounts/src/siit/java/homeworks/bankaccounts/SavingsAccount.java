package siit.java.homeworks.bankaccounts;

import java.util.Calendar;
import java.util.Date;

public class SavingsAccount extends BankAccount {

	private float withdrawalCommision;
	private float interes;
	private float debit;

	public SavingsAccount(Date accountCreationDate, float monthlyFee, float debit, float withdrawalCommision, float interes) {
		super(accountCreationDate, monthlyFee);
		this.debit = debit;
		balance = debit;
		this.withdrawalCommision = withdrawalCommision;
		this.interes = interes;
	}

	@Override
	public void withdrawFunds(float amount) throws InsufficientFundsException {
		super.withdrawFunds(amount + amount * withdrawalCommision);
	}

	@Override
	public float getBalance(Date accountCreationDate) {
		float balance = super.getBalance(accountCreationDate);
		return applyInterest(balance, accountCreationDate);
	}

	private float applyInterest(float balance, Date accountCreationDate) {
		Calendar accountCreationTime = Calendar.getInstance();
		accountCreationTime.setTime(getAccountCreationDate());
		int accountCreationYear = accountCreationTime.get(Calendar.YEAR);
		int accountCreationMonth = accountCreationTime.get(Calendar.MONTH);
		Calendar balanceTime = Calendar.getInstance();
		balanceTime.setTime(accountCreationDate);
		int currentYear = balanceTime.get(Calendar.YEAR);
		int currentMonth = balanceTime.get(Calendar.MONTH);
		if (currentMonth < accountCreationMonth) {
			return balance + interes * balance * (currentYear - accountCreationYear - 1);
		} else {
			return balance + interes * balance * (currentYear - accountCreationYear);
		}

	}
	
	public static void main(String[] args) {
		Date accountCreationTime = TestUtils.getDate(2016, 1, 1);
		SavingsAccount simpleSavingAccount = new SavingsAccount(accountCreationTime, 7, 6000, 0.02f, 0.06f);
		Date balanceInterogationTime = TestUtils.getDate(2017, 7, 1);
		System.out.println(simpleSavingAccount.getBalance(balanceInterogationTime));
		
		Date accountCreationTime1 = TestUtils.getDate(2016, 1, 1);
		SavingsAccount simpleSavingAccount1 = new SavingsAccount(accountCreationTime1, 50, 6000, 0.02f, 0.06f);
		Date balanceInterogationTime1 = TestUtils.getDate(2016, 11, 1);
		System.out.println(simpleSavingAccount1.getBalance(balanceInterogationTime1));
	}

}
