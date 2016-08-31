package br.unibh.seguros.entidades;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

public class Proposta {
	private Long id;
	private Date data;
	private String classe;
	private String codigoSusep;
	private BigDecimal valorSegurado;
	private BigDecimal valorFranquia;
	private Date dataInicioVigencia;
	private Date dataTerminoVigencia;
	private int carenciaEmMeses;
	private BigDecimal valorPremio;
	private int diaPagamento;
	private String bancoPagamento;
	private String agencia;
	private String conta;
	private Segurado segurado;
	private Veiculo veiculo;
	private Questionario questionario;
	private Set<Tramitacao> tramitacoes;
	private Long version;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	public String getCodigoSusep() {
		return codigoSusep;
	}
	public void setCodigoSusep(String codigoSusep) {
		this.codigoSusep = codigoSusep;
	}
	public BigDecimal getValorSegurado() {
		return valorSegurado;
	}
	public void setValorSegurado(BigDecimal valorSegurado) {
		this.valorSegurado = valorSegurado;
	}
	public BigDecimal getValorFranquia() {
		return valorFranquia;
	}
	public void setValorFranquia(BigDecimal valorFranquia) {
		this.valorFranquia = valorFranquia;
	}
	public Date getDataInicioVigencia() {
		return dataInicioVigencia;
	}
	public void setDataInicioVigencia(Date dataInicioVigencia) {
		this.dataInicioVigencia = dataInicioVigencia;
	}
	public Date getDataTerminoVigencia() {
		return dataTerminoVigencia;
	}
	public void setDataTerminoVigencia(Date dataTerminoVigencia) {
		this.dataTerminoVigencia = dataTerminoVigencia;
	}
	public int getCarenciaEmMeses() {
		return carenciaEmMeses;
	}
	public void setCarenciaEmMeses(int carenciaEmMeses) {
		this.carenciaEmMeses = carenciaEmMeses;
	}
	public BigDecimal getValorPremio() {
		return valorPremio;
	}
	public void setValorPremio(BigDecimal valorPremio) {
		this.valorPremio = valorPremio;
	}
	public int getDiaPagamento() {
		return diaPagamento;
	}
	public void setDiaPagamento(int diaPagamento) {
		this.diaPagamento = diaPagamento;
	}
	public String getBancoPagamento() {
		return bancoPagamento;
	}
	public void setBancoPagamento(String bancoPagamento) {
		this.bancoPagamento = bancoPagamento;
	}
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	public String getConta() {
		return conta;
	}
	public void setConta(String conta) {
		this.conta = conta;
	}
	public Segurado getSegurado() {
		return segurado;
	}
	public void setSegurado(Segurado segurado) {
		this.segurado = segurado;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	public Questionario getQuestionario() {
		return questionario;
	}
	public void setQuestionario(Questionario questionario) {
		this.questionario = questionario;
	}
	public Set<Tramitacao> getTramitacoes() {
		return tramitacoes;
	}
	public void setTramitacoes(Set<Tramitacao> tramitacoes) {
		this.tramitacoes = tramitacoes;
	}
	public Long getVersion() {
		return version;
	}
	public void setVersion(Long version) {
		this.version = version;
	}
	@Override
	public String toString() {
		return "Proposta [id=" + id + ", data=" + data + ", classe=" + classe + ", codigoSusep=" + codigoSusep
				+ ", valorSegurado=" + valorSegurado + ", valorFranquia=" + valorFranquia + ", dataInicioVigencia="
				+ dataInicioVigencia + ", dataTerminoVigencia=" + dataTerminoVigencia + ", carenciaEmMeses="
				+ carenciaEmMeses + ", valorPremio=" + valorPremio + ", diaPagamento=" + diaPagamento
				+ ", bancoPagamento=" + bancoPagamento + ", agencia=" + agencia + ", conta=" + conta + ", segurado="
				+ segurado + ", veiculo=" + veiculo + ", questionario=" + questionario + ", tramitacoes=" + tramitacoes
				+ ", version=" + version + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agencia == null) ? 0 : agencia.hashCode());
		result = prime * result + ((bancoPagamento == null) ? 0 : bancoPagamento.hashCode());
		result = prime * result + carenciaEmMeses;
		result = prime * result + ((classe == null) ? 0 : classe.hashCode());
		result = prime * result + ((codigoSusep == null) ? 0 : codigoSusep.hashCode());
		result = prime * result + ((conta == null) ? 0 : conta.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((dataInicioVigencia == null) ? 0 : dataInicioVigencia.hashCode());
		result = prime * result + ((dataTerminoVigencia == null) ? 0 : dataTerminoVigencia.hashCode());
		result = prime * result + diaPagamento;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((valorFranquia == null) ? 0 : valorFranquia.hashCode());
		result = prime * result + ((valorPremio == null) ? 0 : valorPremio.hashCode());
		result = prime * result + ((valorSegurado == null) ? 0 : valorSegurado.hashCode());
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
		Proposta other = (Proposta) obj;
		if (agencia == null) {
			if (other.agencia != null)
				return false;
		} else if (!agencia.equals(other.agencia))
			return false;
		if (bancoPagamento == null) {
			if (other.bancoPagamento != null)
				return false;
		} else if (!bancoPagamento.equals(other.bancoPagamento))
			return false;
		if (carenciaEmMeses != other.carenciaEmMeses)
			return false;
		if (classe == null) {
			if (other.classe != null)
				return false;
		} else if (!classe.equals(other.classe))
			return false;
		if (codigoSusep == null) {
			if (other.codigoSusep != null)
				return false;
		} else if (!codigoSusep.equals(other.codigoSusep))
			return false;
		if (conta == null) {
			if (other.conta != null)
				return false;
		} else if (!conta.equals(other.conta))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (dataInicioVigencia == null) {
			if (other.dataInicioVigencia != null)
				return false;
		} else if (!dataInicioVigencia.equals(other.dataInicioVigencia))
			return false;
		if (dataTerminoVigencia == null) {
			if (other.dataTerminoVigencia != null)
				return false;
		} else if (!dataTerminoVigencia.equals(other.dataTerminoVigencia))
			return false;
		if (diaPagamento != other.diaPagamento)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (valorFranquia == null) {
			if (other.valorFranquia != null)
				return false;
		} else if (!valorFranquia.equals(other.valorFranquia))
			return false;
		if (valorPremio == null) {
			if (other.valorPremio != null)
				return false;
		} else if (!valorPremio.equals(other.valorPremio))
			return false;
		if (valorSegurado == null) {
			if (other.valorSegurado != null)
				return false;
		} else if (!valorSegurado.equals(other.valorSegurado))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}
	public Proposta(Long id, Date data, String classe, String codigoSusep, BigDecimal valorSegurado,
			BigDecimal valorFranquia, Date dataInicioVigencia, Date dataTerminoVigencia, int carenciaEmMeses,
			BigDecimal valorPremio, int diaPagamento, String bancoPagamento, String agencia, String conta,
			Long version) {
		super();
		this.id = id;
		this.data = data;
		this.classe = classe;
		this.codigoSusep = codigoSusep;
		this.valorSegurado = valorSegurado;
		this.valorFranquia = valorFranquia;
		this.dataInicioVigencia = dataInicioVigencia;
		this.dataTerminoVigencia = dataTerminoVigencia;
		this.carenciaEmMeses = carenciaEmMeses;
		this.valorPremio = valorPremio;
		this.diaPagamento = diaPagamento;
		this.bancoPagamento = bancoPagamento;
		this.agencia = agencia;
		this.conta = conta;
		this.version = version;
	}

}
