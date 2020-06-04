package model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class User extends Entity<User>{
	
	@NotEmpty(message = "Login não pode estar vazio")
	
	private String login;
	
	@Email(message = "E-mail não válido")
	@NotEmpty(message = "E-mail não pode estar vazio")
	private String email;
	
	@NotEmpty(message = "Senha não pode estar vazio")
	private String senha;
	
	@NotEmpty(message = "Nome não pode estar vazio")
	private String nome;
	
	private boolean godMod;

	
	public boolean isGodMod() {
		return godMod;
	}

	public void setGodMod(boolean godMod) {
		this.godMod = godMod;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	
	
	
	
	
	
	
	

}
