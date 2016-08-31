package br.unibh.seguros.entidades;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hahah")
public class Setor {
	
	@Id
	private Long id;
	
	private String nome;
	private String sigla;
	private Setor setorSuperior;
	private Set<Funcionario> funcionarios;
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
