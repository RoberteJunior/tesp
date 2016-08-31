package br.unibh.seguros.entidades;

public class Veiculo {
	private Long id;
	private String marca;
	private String descricao;
	private int anoFabricacao;
	private int anoModelo;
	private String placa;
	private String chassi;
	private TipoCombustivel tipoCombustivel;
	private Boolean zeroKm;
	private Boolean veiculoAlienado;
	private Long version;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getAnoFabricacao() {
		return anoFabricacao;
	}
	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}
	public int getAnoModelo() {
		return anoModelo;
	}
	public void setAnoModelo(int anoModelo) {
		this.anoModelo = anoModelo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getChassi() {
		return chassi;
	}
	public void setChassi(String chassi) {
		this.chassi = chassi;
	}
	public TipoCombustivel getTipoCombustivel() {
		return tipoCombustivel;
	}
	public void setTipoCombustivel(TipoCombustivel tipoCombustivel) {
		this.tipoCombustivel = tipoCombustivel;
	}
	public Boolean getZeroKm() {
		return zeroKm;
	}
	public void setZeroKm(Boolean zeroKm) {
		this.zeroKm = zeroKm;
	}
	public Boolean getVeiculoAlienado() {
		return veiculoAlienado;
	}
	public void setVeiculoAlienado(Boolean veiculoAlienado) {
		this.veiculoAlienado = veiculoAlienado;
	}
	public Long getVersion() {
		return version;
	}
	public void setVersion(Long version) {
		this.version = version;
	}
	@Override
	public String toString() {
		return "Veiculo [id=" + id + ", marca=" + marca + ", descricao=" + descricao + ", anoFabricacao="
				+ anoFabricacao + ", anoModelo=" + anoModelo + ", placa=" + placa + ", chassi=" + chassi
				+ ", tipoCombustivel=" + tipoCombustivel + ", zeroKm=" + zeroKm + ", veiculoAlienado=" + veiculoAlienado
				+ ", version=" + version + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + anoFabricacao;
		result = prime * result + anoModelo;
		result = prime * result + ((chassi == null) ? 0 : chassi.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((marca == null) ? 0 : marca.hashCode());
		result = prime * result + ((placa == null) ? 0 : placa.hashCode());
		result = prime * result + ((tipoCombustivel == null) ? 0 : tipoCombustivel.hashCode());
		result = prime * result + ((veiculoAlienado == null) ? 0 : veiculoAlienado.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		result = prime * result + ((zeroKm == null) ? 0 : zeroKm.hashCode());
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
		Veiculo other = (Veiculo) obj;
		if (anoFabricacao != other.anoFabricacao)
			return false;
		if (anoModelo != other.anoModelo)
			return false;
		if (chassi == null) {
			if (other.chassi != null)
				return false;
		} else if (!chassi.equals(other.chassi))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca))
			return false;
		if (placa == null) {
			if (other.placa != null)
				return false;
		} else if (!placa.equals(other.placa))
			return false;
		if (tipoCombustivel != other.tipoCombustivel)
			return false;
		if (veiculoAlienado == null) {
			if (other.veiculoAlienado != null)
				return false;
		} else if (!veiculoAlienado.equals(other.veiculoAlienado))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		if (zeroKm == null) {
			if (other.zeroKm != null)
				return false;
		} else if (!zeroKm.equals(other.zeroKm))
			return false;
		return true;
	}
	public Veiculo(Long id, String marca, String descricao, int anoFabricacao, int anoModelo, String placa,
			String chassi, TipoCombustivel tipoCombustivel, Boolean zeroKm, Boolean veiculoAlienado, Long version) {
		super();
		this.id = id;
		this.marca = marca;
		this.descricao = descricao;
		this.anoFabricacao = anoFabricacao;
		this.anoModelo = anoModelo;
		this.placa = placa;
		this.chassi = chassi;
		this.tipoCombustivel = tipoCombustivel;
		this.zeroKm = zeroKm;
		this.veiculoAlienado = veiculoAlienado;
		this.version = version;
	}

}
