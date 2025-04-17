package edu.digitalBank;

import java.util.Scanner;

import edu.digitalBank.account.account;
import edu.digitalBank.account.currentAccount;
import edu.digitalBank.account.savingsAcount;
import edu.digitalBank.bank.bank;
import edu.digitalBank.personalInformation.personalInformation;

public class Main {

	public static void main(String[] args) {

		boolean isTurnOn = true;
		int aplicationSelect = 0;
		bank dioBank = new bank();
		Scanner function = new Scanner(System.in);
		Scanner informations = new Scanner(System.in);
		Scanner newAccount = new Scanner(System.in);
		
		
		int accountNumber = 1;

		while (isTurnOn) {

			System.out.println("Selecione uma opção: ");
			System.out.println("1) Criar conta concorrente");
			System.out.println("2) Criar conta poupança");
			System.out.println("3) Listar contas do banco");
			System.out.println("4) Depositar");
			System.out.println("5) Sacar");
			System.out.println("6) Tranferir");
			System.out.println("7) Buscar conta");
			System.out.println("8) Sair");

			if (function.hasNextInt()) {
				// Lê o valor digitado pelo usuário
				aplicationSelect = function.nextInt();

				if (aplicationSelect >= 9) {
					System.out.println("A aplicação não está disponível.");
				} else {
					switch (aplicationSelect) {
					case 1: {

						if (newAccount(informations, dioBank, accountNumber, "CC")) {
							System.out.println("Conta criada com sucesso.");
							accountNumber++;
						}
						break;
					}
					case 2: {

						if (newAccount(informations, dioBank, accountNumber, "CP")) {
							System.out.println("Conta criada com sucesso.");
							accountNumber++;
						}
						break;
					}
					case 3: {
						dioBank.listAccount();
						break;
					}
					case 4: {

						System.out.println("Informar  número conta");
						informations = new Scanner(System.in);

						if (informations.hasNextInt()) {

							int number = informations.nextInt();

							account accountValue = dioBank.searchAccount(number);

							if (accountValue != null) {
								System.out.println("Informar o valor a ser depositado");
								if (informations.hasNextDouble()) {
									double money = informations.nextDouble();
									if (money > 0) {
										accountValue.deposit(money);
									}

								} else {
									System.out.println("O valor informado não é um número");
								}

							} else {
								System.out.println("A conta informada não foi encontrada");
							}

						} else {
							System.out.println("O valor informado não é um número");
						}

						break;
					}
					case 5: {

						System.out.println("Informar  número conta");
						informations = new Scanner(System.in);

						if (informations.hasNextInt()) {

							int number = informations.nextInt();

							account accountValue = dioBank.searchAccount(number);

							if (accountValue != null) {
								System.out.println("Informar o valor a ser depositado");
								informations = new Scanner(System.in);
								if (informations.hasNextDouble()) {
									double money = informations.nextDouble();
									if (money > 0) {
										accountValue.withdraw(money);
									}

								} else {
									System.out.println("O valor informado não é um número");
								}

							} else {
								System.out.println("A conta informada não foi encontrada");
							}

						} else {
							System.out.println("O valor informado não é um número");
						}

						break;
					}
					case 6: {

						System.out.println("Informar  número conta origem");
						informations = new Scanner(System.in);

						if (informations.hasNextInt()) {

							int number = informations.nextInt();

							account accountOrigin = dioBank.searchAccount(number);

							if (accountOrigin != null) {

								System.out.println("Informar  número conta destino");
								informations = new Scanner(System.in);
								if (informations.hasNextInt()) {
									
									number = informations.nextInt();
									account accountDestination = dioBank.searchAccount(number);

									if (accountDestination != null) {

										System.out.println("Informar o valor a ser depositado");
										informations = new Scanner(System.in);
										if (informations.hasNextDouble()) {
											double money = informations.nextDouble();
											if (money > 0) {
												accountOrigin.transfer(accountDestination, money);
											}
										} else {
											System.out.println("O valor informado não é um número");
										}

									} else {
										System.out.println("A conta informada não foi encontrada");
									}

								} else {
									System.out.println("O valor informado não é um número");
								}

							} else {
								System.out.println("A conta informada não foi encontrada");
							}

						} else {
							System.out.println("O valor informado não é um número");
						}

						break;
					}
					case 7: {
						System.out.println("Informar  número conta");
						informations = new Scanner(System.in);

						if (informations.hasNextInt()) {

							int number = informations.nextInt();

							account accountValue = dioBank.searchAccount(number);

							if (accountValue != null) {
								System.out.println(accountValue.toString());

							} else {
								System.out.println("A conta informada não foi encontrada");
							}
						}
						break;
					}
					case 8: {
						System.out.println("Saindo da aplicação");
						isTurnOn = false;
					}
					}

				}

			}

		}
		function.close();
		informations.close();
	}

	public static boolean newAccount(Scanner informations, bank dioBank, int accountNumber, String typeAccount) {

		System.out.println("Informe o nome:");
		String name = informations.nextLine();
		
	
		System.out.println("Informe o telefone:");
		String phone = informations.nextLine();

		System.out.println("Informe o email:");
		String email = informations.nextLine();

		System.out.println("Informe o cpf:");
		String cpf = informations.nextLine();

		try {

			if (!dioBank.CPFAccountHolderExist(cpf)) {
				personalInformation person = new personalInformation(name, phone, email, cpf);

				if (typeAccount == "CC") {
					currentAccount account = new currentAccount(accountNumber, person);
					dioBank.addAccount(account);
				} else {
					savingsAcount account = new savingsAcount(accountNumber, person);
					dioBank.addAccount(account);
				}

			} else {
				System.out.println("Ja existe uma conta com  o cpf:" + cpf);
				return false;
			}

			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

	}
}
