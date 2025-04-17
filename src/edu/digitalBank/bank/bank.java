package edu.digitalBank.bank;

import java.util.ArrayList;
import java.util.List;

import edu.digitalBank.account.account;

public class bank {
	
	
	  private List<account> accounts;

	    public bank() {
	        this.accounts = new ArrayList<>();
	    }

	    public List<account> getAccount() {
	        return accounts;
	    }

	    public void addAccount(account newAccount) {
	        this.accounts.add(newAccount);
	    }

	    public account searchAccount(int numero) {
	        for (account conta : accounts) {
	            if (conta.getAccountNumber() == numero) {
	                return conta;
	            }
	        }
	        return null;
	    }
	    
	    
	    public Boolean CPFAccountHolderExist(String  cpf) {
	    	
	    	cpf = cpf.replaceAll("\\D", "");
	        for (account conta : accounts) {
	            if (conta.getAccountHolder().getCpf() == cpf) {
	                return true;
	            }
	        }
	        return false;
	    }

	    public void removeAccount(int numero) {
	    	account conta = searchAccount(numero);
	        if (conta != null) {
	        	accounts.remove(conta);
	        } else {
	            System.out.println("Conta não encontrada.");
	        }
	    }
	    
	    
	    public void listAccount() {
	        for (account conta : accounts) {
	        	System.out.println("Conta:" +conta.getAccountNumber()+ " Saldo:" + conta.getBalance() + " Titula:" + conta.getAccountHolder().toString() );
	        }
	    }

}
