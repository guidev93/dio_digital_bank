package edu.digitalBank.account;

import edu.digitalBank.personalInformation.personalInformation;

public class currentAccount  extends account{
	
	 public currentAccount(int numero, personalInformation accountHolder) {
		super(numero, accountHolder);
	}

	    @Override
	    public boolean withdraw(double valor) {
	        if (valor > 0 && balance >= valor) {
	        	balance -= valor;
	            System.out.println("Saque de R$" + valor + " realizado com sucesso na Conta Corrente!");
	            return true;
	        } else {
	            System.out.println("Saque não realizado: saldo insuficiente ou valor inválido.");
	            return false;
	        }
	    }

}
