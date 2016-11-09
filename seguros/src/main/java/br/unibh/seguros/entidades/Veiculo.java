package br.unibh.seguros.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="tb_veiculo")
public class Veiculo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Pattern(regexp="[A-zÀ-ú ]*",message="Deverá ter apenas Letras e Espaço")
	@Size(max=50)
	@Column(columnDefinition="varchar(50)", nullable=false)
	private String marca;
	
	@NotBlank
	@Pattern(regexp="[A-zÀ-ú ]*",message="Deverá ter apenas Letras e Espaço")
	@Size(max=150)
	@Column(columnDefinition="varchar(150)", nullable=false)
	private String descricao;
	
	@NotNull
	@Min(value=1950, message ="Só é permitido acima de 1950")
	@Column(name="ano_fabricacao", nullable=false)	
	private int anoFabricacao;
	
	@NotNull
	@Min(value=1950, message ="Só é permitido acima de 1950")
	@Column(name="ano_modelo", nullable=false)
	private int anoModelo;
	
	@NotBlank
	@Pattern(regexp="[A-Z]{3}-\\d{4}",message="Exemplo modelo de placa AAA-9999")
	@Column(columnDefinition="char(8)", nullable=false)
	private String placa;
	
	@NotBlank
	@Pattern(regexp="[A-z ]*",message="Deverá ter apenas Letras e Espaço")
	@Size(max=50)
	@Column(columnDefinition="varchar(50)", nullable=false)
	private String chassi;
	
	@NotNull
	@Column(name="tipo_combustivel", nullable=false)
	private TipoCombustivel tipoCombustivel;
	
	@NotNull
	@Column(name="zero_km", nullable=false)
	private Boolean zeroKm;
	
	@NotNull
	@Column(name="veiculo_alienado", nullable=false)
	private Boolean veiculoAlienado;
	
	
	@Version 
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
	public Veiculo(){
		
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
