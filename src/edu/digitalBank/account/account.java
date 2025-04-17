package edu.digitalBank.account;

import edu.digitalBank.personalInformation.personalInformation;

public abstract class account {

	protected int accountNumber;
	protected personalInformation accountHolder;
	protected double balance;

	public account(int number, personalInformation accountHolder) {
		this.accountNumber = number;
		this.accountHolder = accountHolder;
		this.balance = 0.0;
	}

	// Método para depositar um valor na conta
	public void deposit(double value) {
		if (value > 0) {
			balance += value;
			System.out.println("Depósito de R$" + value + " realizado com sucesso!");
		} else {
			System.out.println("Valor de depósito inválido.");
		}
	}

	// Método para sacar um valor da conta
	public abstract boolean withdraw(double value);

	// Método para transferir um valor para outra conta
	public boolean transfer(account destination, double value) {
		if (this.withdraw(value)) {
			destination.deposit(value);
			System.out.println(
					"Transferência de R$" + value + " para " + destination.getAccountHolder() + " realizada com sucesso!");
			return true;
		} else {
			System.out.println("Transferência não realizada: saldo insuficiente.");
			return false;
		}
	}

	public personalInformation getAccountHolder() {
		return accountHolder;
	}

	public double getBalance() {
		return balance;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}

	@Override
	public String toString() {
		return "Conta [numero=" + accountNumber + ", titular=" + accountHolder.toString() + ", saldo=R$" + balance
				+ "]";
	}
}
