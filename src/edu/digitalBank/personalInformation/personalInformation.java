package edu.digitalBank.personalInformation;

public class personalInformation {

	private String nome;
	private String telefone;
	private String email;
	private String cpf;

	public personalInformation(String nome, String telefone, String email, String cpf) throws Exception {


			this.nome = nome;
			this.telefone = telefone;
			this.email = email;
			if (isValidCPF(cpf)) {
				this.cpf = cpf;
			} else {
				throw new Exception("O CPF informado é invalido");
			}	

	}

	// Métodos getters e setters

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {

		if (this.isValidCPF(cpf)) {
			this.cpf = cpf;
		} else {
			System.out.println("O CPF informado é invalod, favor corrigir!");
		}

	}

	public boolean isValidCPF(String cpf) {

		if (cpf == null) {
			return false;
		}

		// Remove caracteres não numéricos (ponto, hífen, etc).
		cpf = cpf.replaceAll("\\D", "");

		// Verifica se possui 11 dígitos
		if (cpf.length() != 11) {
			return false;
		}

		// Verifica se todos os dígitos são iguais (caso inválido)
		if (cpf.matches("(\\d)\\1{10}")) {
			return false;
		}

		try {
			// Calcula o primeiro dígito verificador
			int soma = 0;
			for (int i = 0; i < 9; i++) {
				int num = Character.getNumericValue(cpf.charAt(i));
				soma += num * (10 - i);
			}
			int resto = 11 - (soma % 11);
			int digito1 = (resto > 9) ? 0 : resto;

			// Verifica se o primeiro dígito está correto
			if (digito1 != Character.getNumericValue(cpf.charAt(9))) {
				return false;
			}

			// Calcula o segundo dígito verificador
			soma = 0;
			for (int i = 0; i < 10; i++) {
				int num = Character.getNumericValue(cpf.charAt(i));
				soma += num * (11 - i);
			}
			resto = 11 - (soma % 11);
			int digito2 = (resto > 9) ? 0 : resto;

			// Verifica se o segundo dígito está correto
			if (digito2 != Character.getNumericValue(cpf.charAt(10))) {
				return false;
			}

		} catch (NumberFormatException e) {
			return false;
		}

		return true;
	}

	// Método para exibir os dados do titular
	@Override
	public String toString() {
		return "Titular {" + "nome='" + nome + '\'' + ", telefone='" + telefone + '\'' + ", email='" + email + '\''
				+ ", cpf='" + cpf + '\'' + '}';
	}
}
