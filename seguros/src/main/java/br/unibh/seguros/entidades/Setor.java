package br.unibh.seguros.entidades;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "tb_setor")
@NamedQueries({ @NamedQuery(name = "Setor.findByName", query = "select o from Setor o where o.nome like :nome"),
		@NamedQuery(name = "Setor.findByNameComFuncionarios", query = "select o from Setor o join fetch o.funcionarios where o.nome like :nome"),
		@NamedQuery(name = "Setor.findByIDComSetorSuperior", query = "select o from Setor o left join fetch o.setorSuperior where o.id = :id") })
public class Setor implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(min = 3, max = 150)
	@Pattern(regexp = "[A-zÀ-ú .']*", message = "Deve permitir apenas caracteres de A à Z maiúsculos ou minúsculos, com ou sem acentuação, além dos caracteres de espaço, ponto e aspas simples.")
	@Column(columnDefinition = "varchar(150)", nullable = false)
	private String nome;

	@NotBlank
	@Size(min = 2, max = 10)
	@Pattern(regexp = "[A-Z]*", message = "Deve permitir apenas caracteres de A à Z maiúsculos sem espaços.")
	@Column(columnDefinition = "varchar(10)", nullable = false, unique = true)
	private String sigla;

	@OneToOne
	@JoinColumn(name = "setor_superior")
	private Setor setorSuperior;

	@OneToMany(mappedBy = "setor")
	private Set<Funcionario> funcionarios;

	@Version
	private Long version;

	public Setor(Long version) {
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

	public Setor() {

	}

	public Setor(Long id, String nome, String sigla, Setor setorSuperior, Set<Funcionario> funcionarios) {
		super();
		this.id = id;
		this.nome = nome;
		this.sigla = sigla;
		this.setorSuperior = setorSuperior;
		this.funcionarios = funcionarios;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public Setor getSetorSuperior() {
		return setorSuperior;
	}

	public void setSetorSuperior(Setor setorSuperior) {
		this.setorSuperior = setorSuperior;
	}

	public Set<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(Set<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
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
		Setor other = (Setor) obj;
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

	@Override
	public String toString() {
		return "Setor [version=" + version + "]";
	}

	 

}
