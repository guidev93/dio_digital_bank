package edu.digitalBank.account;

import edu.digitalBank.personalInformation.personalInformation;

public class savingsAcount  extends account{

	 public savingsAcount(int numero, personalInformation accountHolder) {
		super(numero, accountHolder);
	}

	    @Override
	    public boolean withdraw(double valor) {
	        if (valor > 0 && balance >= valor) {
	        	balance -= valor;
	            System.out.println("Saque de R$" + valor + " realizado com sucesso na Conta Poupança!");
	            return true;
	        } else {
	            System.out.println("Saque não realizado: saldo insuficiente ou valor inválido.");
	            return false;
	        }
	    }
	
}
