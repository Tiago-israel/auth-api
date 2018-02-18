package br.com.authapi.dto;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class UsuarioDto {
	
	private int id;
	@NotEmpty(message = "O campo nome é obrigatório")
	private String nome;
	@NotEmpty(message = "O campo email é obrigatório")
	@Email(message = "Email inválido")
	private String email;
	@NotEmpty(message = "O campo senha é obrigatório")
	@Length(min = 5, max = 20, message = "O campo senha deve conter entre 5 e 20 caracteres")
	private String senha;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
	
	
	
}
