package br.unibh.seguros.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

@Entity @Inheritance(strategy=InheritanceType.JOINED)/*@Entity torna a classe persistente*/
@Table(name="tb_pessoa")
public abstract class Pessoa {

	public Pessoa (){}
	
	public Pessoa(Long id, String nome, String sexo, String cpf, String telefoneComercial, String telefoneResidencial,
			String telefoneCelular, String email, Date dataNascimento, Date dataCadastro) {
		super();
		this.id = id;
		this.nome = nome;
		this.sexo = sexo;
		this.cpf = cpf;
		this.telefoneComercial = telefoneComercial;
		this.telefoneResidencial = telefoneResidencial;
		this.telefoneCelular = telefoneCelular;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.dataCadastro = dataCadastro;
	}
	@Id @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(min = 3, max = 100)
	@Pattern(regexp = "[A-Z]*", message = "Deve permitir apenas caracteres de A à Z maiúsculos sem espaços.")
	@Column(columnDefinition="varchar(100)", nullable=false)
	private String nome;
	
	@NotBlank
	@Size(min = 2, max = 10)
	@Pattern(regexp = "(F|M)", message = "Deve conter apenas caracter F ou M.")
	@Column(columnDefinition="char(1)", nullable=false)
	private String sexo;
	
	@CPF
	@Column(columnDefinition="char(11)", nullable=false, unique=true)
	private String cpf;
	
	@Pattern(regexp = "\\(\\d{2}\\)\\d{0,1}\\d{4}-\\d{4}")
	@Column(name="telefone_comercial", columnDefinition="char(14)", nullable=true)
	private String telefoneComercial;
	
	@NotBlank
	@Pattern(regexp = "\\(\\d{2}\\)\\d{0,1}\\d{4}-\\d{4}")
	@Column(name="telefone_residencial", columnDefinition="char(14)", nullable=false)
	private String telefoneResidencial;
	
	@Pattern(regexp = "\\(\\d{2}\\)\\d{0,1}\\d{4}-\\d{4}")
	@Column(name="telefone_celular", columnDefinition="char(14)", nullable=true)
	private String telefoneCelular;
	
	
	@Size(max = 100)
	@Pattern(regexp = ".+@.+\\.[a-z]+")
	@Column(columnDefinition="varchar(100)", nullable=true)
	private String email;
	
	@Past
	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name="data_nascimento", nullable=false)
	private Date dataNascimento;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_cadastro", nullable=false)
	private Date dataCadastro;
	
	@Version
	private Long version;
	
	
	public Pessoa(Long version) {
		super();
		this.version = version;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefoneComercial() {
		return telefoneComercial;
	}

	public void setTelefoneComercial(String telefoneComercial) {
		this.telefoneComercial = telefoneComercial;
	}

	public String getTelefoneResidencial() {
		return telefoneResidencial;
	}

	public void setTelefoneResidencial(String telefoneResidencial) {
		this.telefoneResidencial = telefoneResidencial;
	}

	public String getTelefoneCelular() {
		return telefoneCelular;
	}

	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	@Override
	public String toString() {
		return "Pessoa [version=" + version + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
}
