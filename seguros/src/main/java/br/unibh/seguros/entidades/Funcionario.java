package br.unibh.seguros.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="tb_funcionario")
public class Funcionario extends Pessoa {
	
	@ManyToOne
	private Setor setor;
	
	@NotBlank
	@NotNull
	@Pattern(regexp = "[A-zÀ-ú0-9]*", message = "Deve permitir apenas caracteres de A à Z maiúsculos sem espaços e números.")
	@Column(columnDefinition="varchar(30)", nullable=false)
	private String perfil;
	
	@Size(min = 8, max = 15)
	@NotBlank
	@NotNull
	@Pattern(regexp = "[A-z0-9]*", message = "Deve permitir apenas caracteres de A à Z maiúsculos sem espaços e números.")
	@Column(columnDefinition="varchar(15)", nullable=false)
	private String login;
	
	@NotBlank
	@NotNull
	@Size(max = 100)
	@Pattern(regexp = "[A-z0-9]*", message = "Não pode ser nulo, vazio ou apenas espaço, o tamanho não deverá exceder 100 caracteres")
	@Column(columnDefinition="varchar(100)", nullable=false)
	private String senha;
	
	public Setor getSetor() {
		return setor;
	}
	public void setSetor(Setor setor) {
		this.setor = setor;
	}
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	@Override
	public String toString() {
		return "Funcionario [setor=" + setor + ", perfil=" + perfil + ", login=" + login + ", senha=" + senha
				+ ", toString()=" + super.toString() + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((perfil == null) ? 0 : perfil.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + ((setor == null) ? 0 : setor.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (perfil == null) {
			if (other.perfil != null)
				return false;
		} else if (!perfil.equals(other.perfil))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (setor == null) {
			if (other.setor != null)
				return false;
		} else if (!setor.equals(other.setor))
			return false;
		return true;
	}
	public Funcionario(){
		
	}
	public Funcionario(Long id, String nome, String sexo, String cpf, String telefoneComercial,
			String telefoneResidencial, String telefoneCelular, String email, Date dataNascimento, Date dataCadastro,
			Setor setor, String perfil, String login, String senha) {
		super(id, nome, sexo, cpf, telefoneComercial, telefoneResidencial, telefoneCelular, email, dataNascimento,
				dataCadastro);
		this.setor = setor;
		this.perfil = perfil;
		this.login = login;
		this.senha = senha;
	}
	

}
