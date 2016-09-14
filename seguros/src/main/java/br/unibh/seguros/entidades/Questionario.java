package br.unibh.seguros.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="tb_questionario")
public class Questionario {
	
	@Id @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="segurado_e_principal_condutor",nullable=false)
	private Boolean seguradoEPrincipal;
	
	@Column(name="nome_condutor_principal", columnDefinition="varchar(100)",nullable=true)
	private String nomeCondutor;
	
	@Column(name="reside_com_pessoa_17_a_25_anos", nullable=false)
	private Boolean resideComPessoa17A25Anos;
	
	@Column(name="possui_garagem_residencia", nullable=false)
	private Boolean possuiGaragemResidencia;
	
	@Column(name="possui_garagem_trabalho", nullable=false)
	private Boolean possuiGaragemTrabalho;
	
	@Column(name="possui_garagem_estudo", nullable=false)
	private Boolean possuiGaragemEstudo;
	
	@Column(name="residencia_propria", nullable=false)
	private Boolean residenciaPropria;
	
	@Column(nullable=false)
	private Long quilometragemAtual;
	
	@Column(name="utiliza_veiculo_atividades_profissionais", nullable=false)
	private Boolean utilizaVeiculoAtividadeProfissionais;
	
	@Column(name="acidente_ou_roubo_ultimos_2_anos", nullable=false)
	private Boolean acidenteOuRouboUltimos2Anos;
	
	@Column(name="possui_dispositivo_anti_furto", nullable=false)
	private Boolean possuiDispositivosAntifurto;
	
	@Version
	private Long version;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Boolean getSeguradoEPrincipal() {
		return seguradoEPrincipal;
	}
	public void setSeguradoEPrincipal(Boolean seguradoEPrincipal) {
		this.seguradoEPrincipal = seguradoEPrincipal;
	}
	public String getNomeCondutor() {
		return nomeCondutor;
	}
	public void setNomeCondutor(String nomeCondutor) {
		this.nomeCondutor = nomeCondutor;
	}
	public Boolean getResideComPessoa17A25Anos() {
		return resideComPessoa17A25Anos;
	}
	public void setResideComPessoa17A25Anos(Boolean resideComPessoa17A25Anos) {
		this.resideComPessoa17A25Anos = resideComPessoa17A25Anos;
	}
	public Boolean getPossuiGaragemResidencia() {
		return possuiGaragemResidencia;
	}
	public void setPossuiGaragemResidencia(Boolean possuiGaragemResidencia) {
		this.possuiGaragemResidencia = possuiGaragemResidencia;
	}
	public Boolean getPossuiGaragemTrabalho() {
		return possuiGaragemTrabalho;
	}
	public void setPossuiGaragemTrabalho(Boolean possuiGaragemTrabalho) {
		this.possuiGaragemTrabalho = possuiGaragemTrabalho;
	}
	public Boolean getPossuiGaragemEstudo() {
		return possuiGaragemEstudo;
	}
	public void setPossuiGaragemEstudo(Boolean possuiGaragemEstudo) {
		this.possuiGaragemEstudo = possuiGaragemEstudo;
	}
	public Boolean getResidenciaPropria() {
		return residenciaPropria;
	}
	public void setResidenciaPropria(Boolean residenciaPropria) {
		this.residenciaPropria = residenciaPropria;
	}
	public Long getQuilometragemAtual() {
		return quilometragemAtual;
	}
	public void setQuilometragemAtual(Long quilometragemAtual) {
		this.quilometragemAtual = quilometragemAtual;
	}
	public Boolean getUtilizaVeiculoAtividadeProfissionais() {
		return utilizaVeiculoAtividadeProfissionais;
	}
	public void setUtilizaVeiculoAtividadeProfissionais(Boolean utilizaVeiculoAtividadeProfissionais) {
		this.utilizaVeiculoAtividadeProfissionais = utilizaVeiculoAtividadeProfissionais;
	}
	public Boolean getAcidenteOuRouboUltimos2Anos() {
		return acidenteOuRouboUltimos2Anos;
	}
	public void setAcidenteOuRouboUltimos2Anos(Boolean acidenteOuRouboUltimos2Anos) {
		this.acidenteOuRouboUltimos2Anos = acidenteOuRouboUltimos2Anos;
	}
	public Boolean getPossuiDispositivosAntifurto() {
		return possuiDispositivosAntifurto;
	}
	public void setPossuiDispositivosAntifurto(Boolean possuiDispositivosAntifurto) {
		this.possuiDispositivosAntifurto = possuiDispositivosAntifurto;
	}
	public Long getVersion() {
		return version;
	}
	public void setVersion(Long version) {
		this.version = version;
	}
	@Override
	public String toString() {
		return "Questionario [id=" + id + ", seguradoEPrincipal=" + seguradoEPrincipal + ", nomeCondutor="
				+ nomeCondutor + ", resideComPessoa17A25Anos=" + resideComPessoa17A25Anos + ", possuiGaragemResidencia="
				+ possuiGaragemResidencia + ", possuiGaragemTrabalho=" + possuiGaragemTrabalho
				+ ", possuiGaragemEstudo=" + possuiGaragemEstudo + ", residenciaPropria=" + residenciaPropria
				+ ", quilometragemAtual=" + quilometragemAtual + ", utilizaVeiculoAtividadeProfissionais="
				+ utilizaVeiculoAtividadeProfissionais + ", acidenteOuRouboUltimos2Anos=" + acidenteOuRouboUltimos2Anos
				+ ", possuiDispositivosAntifurto=" + possuiDispositivosAntifurto + ", version=" + version + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acidenteOuRouboUltimos2Anos == null) ? 0 : acidenteOuRouboUltimos2Anos.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nomeCondutor == null) ? 0 : nomeCondutor.hashCode());
		result = prime * result + ((possuiDispositivosAntifurto == null) ? 0 : possuiDispositivosAntifurto.hashCode());
		result = prime * result + ((possuiGaragemEstudo == null) ? 0 : possuiGaragemEstudo.hashCode());
		result = prime * result + ((possuiGaragemResidencia == null) ? 0 : possuiGaragemResidencia.hashCode());
		result = prime * result + ((possuiGaragemTrabalho == null) ? 0 : possuiGaragemTrabalho.hashCode());
		result = prime * result + ((quilometragemAtual == null) ? 0 : quilometragemAtual.hashCode());
		result = prime * result + ((resideComPessoa17A25Anos == null) ? 0 : resideComPessoa17A25Anos.hashCode());
		result = prime * result + ((residenciaPropria == null) ? 0 : residenciaPropria.hashCode());
		result = prime * result + ((seguradoEPrincipal == null) ? 0 : seguradoEPrincipal.hashCode());
		result = prime * result + ((utilizaVeiculoAtividadeProfissionais == null) ? 0
				: utilizaVeiculoAtividadeProfissionais.hashCode());
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
		Questionario other = (Questionario) obj;
		if (acidenteOuRouboUltimos2Anos == null) {
			if (other.acidenteOuRouboUltimos2Anos != null)
				return false;
		} else if (!acidenteOuRouboUltimos2Anos.equals(other.acidenteOuRouboUltimos2Anos))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nomeCondutor == null) {
			if (other.nomeCondutor != null)
				return false;
		} else if (!nomeCondutor.equals(other.nomeCondutor))
			return false;
		if (possuiDispositivosAntifurto == null) {
			if (other.possuiDispositivosAntifurto != null)
				return false;
		} else if (!possuiDispositivosAntifurto.equals(other.possuiDispositivosAntifurto))
			return false;
		if (possuiGaragemEstudo == null) {
			if (other.possuiGaragemEstudo != null)
				return false;
		} else if (!possuiGaragemEstudo.equals(other.possuiGaragemEstudo))
			return false;
		if (possuiGaragemResidencia == null) {
			if (other.possuiGaragemResidencia != null)
				return false;
		} else if (!possuiGaragemResidencia.equals(other.possuiGaragemResidencia))
			return false;
		if (possuiGaragemTrabalho == null) {
			if (other.possuiGaragemTrabalho != null)
				return false;
		} else if (!possuiGaragemTrabalho.equals(other.possuiGaragemTrabalho))
			return false;
		if (quilometragemAtual == null) {
			if (other.quilometragemAtual != null)
				return false;
		} else if (!quilometragemAtual.equals(other.quilometragemAtual))
			return false;
		if (resideComPessoa17A25Anos == null) {
			if (other.resideComPessoa17A25Anos != null)
				return false;
		} else if (!resideComPessoa17A25Anos.equals(other.resideComPessoa17A25Anos))
			return false;
		if (residenciaPropria == null) {
			if (other.residenciaPropria != null)
				return false;
		} else if (!residenciaPropria.equals(other.residenciaPropria))
			return false;
		if (seguradoEPrincipal == null) {
			if (other.seguradoEPrincipal != null)
				return false;
		} else if (!seguradoEPrincipal.equals(other.seguradoEPrincipal))
			return false;
		if (utilizaVeiculoAtividadeProfissionais == null) {
			if (other.utilizaVeiculoAtividadeProfissionais != null)
				return false;
		} else if (!utilizaVeiculoAtividadeProfissionais.equals(other.utilizaVeiculoAtividadeProfissionais))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}
	public Questionario(Long id, Boolean seguradoEPrincipal, String nomeCondutor, Boolean resideComPessoa17A25Anos,
			Boolean possuiGaragemResidencia, Boolean possuiGaragemTrabalho, Boolean possuiGaragemEstudo,
			Boolean residenciaPropria, Long quilometragemAtual, Boolean utilizaVeiculoAtividadeProfissionais,
			Boolean acidenteOuRouboUltimos2Anos, Boolean possuiDispositivosAntifurto, Long version) {
		super();
		this.id = id;
		this.seguradoEPrincipal = seguradoEPrincipal;
		this.nomeCondutor = nomeCondutor;
		this.resideComPessoa17A25Anos = resideComPessoa17A25Anos;
		this.possuiGaragemResidencia = possuiGaragemResidencia;
		this.possuiGaragemTrabalho = possuiGaragemTrabalho;
		this.possuiGaragemEstudo = possuiGaragemEstudo;
		this.residenciaPropria = residenciaPropria;
		this.quilometragemAtual = quilometragemAtual;
		this.utilizaVeiculoAtividadeProfissionais = utilizaVeiculoAtividadeProfissionais;
		this.acidenteOuRouboUltimos2Anos = acidenteOuRouboUltimos2Anos;
		this.possuiDispositivosAntifurto = possuiDispositivosAntifurto;
		this.version = version;
	}

}
