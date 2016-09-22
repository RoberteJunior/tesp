package br.unibh.seguros.entidades;

import java.io.File;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
@Table(name="tb_tramitacao")
public class Tramitacao {
	
	@Id @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Proposta proposta;
	
	@Column(name="etapa_processo", nullable=false)
	private EtapaProcesso EtapaProcesso;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_hora", nullable=false)
	private Date dataHora;
	
	@Column(name="tipo_decisao", nullable=false)
	private TipoDecisao tipoDecisao;
	
	@OneToOne
	@JoinColumn(name="funcionario_id")
	private Funcionario usuarioDecisao;
	
	@Column(columnDefinition="varchar(4000)",nullable=true)
	private String comentario;
	
	@Column(columnDefinition="blob", nullable=false)
	private File documento;
	
	@Version
	private Long version;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Proposta getProposta() {
		return proposta;
	}

	public void setProposta(Proposta proposta) {
		this.proposta = proposta;
	}

	public EtapaProcesso getEtapaProcesso() {
		return EtapaProcesso;
	}

	public void setEtapaProcesso(EtapaProcesso etapaProcesso) {
		EtapaProcesso = etapaProcesso;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public TipoDecisao getTipoDecisao() {
		return tipoDecisao;
	}

	public void setTipoDecisao(TipoDecisao tipoDecisao) {
		this.tipoDecisao = tipoDecisao;
	}

	public Funcionario getUsuarioDecisao() {
		return usuarioDecisao;
	}

	public void setUsuarioDecisao(Funcionario usuarioDecisao) {
		this.usuarioDecisao = usuarioDecisao;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public File getDocumento() {
		return documento;
	}

	public void setDocumento(File documento) {
		this.documento = documento;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Tramitacao [id=" + id + ", proposta=" + proposta + ", EtapaProcesso=" + EtapaProcesso + ", dataHora="
				+ dataHora + ", tipoDecisao=" + tipoDecisao + ", usuarioDecisao=" + usuarioDecisao + ", comentario="
				+ comentario + ", documento=" + documento + ", version=" + version + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((EtapaProcesso == null) ? 0 : EtapaProcesso.hashCode());
		result = prime * result + ((comentario == null) ? 0 : comentario.hashCode());
		result = prime * result + ((dataHora == null) ? 0 : dataHora.hashCode());
		result = prime * result + ((documento == null) ? 0 : documento.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((proposta == null) ? 0 : proposta.hashCode());
		result = prime * result + ((tipoDecisao == null) ? 0 : tipoDecisao.hashCode());
		result = prime * result + ((usuarioDecisao == null) ? 0 : usuarioDecisao.hashCode());
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
		Tramitacao other = (Tramitacao) obj;
		if (EtapaProcesso != other.EtapaProcesso)
			return false;
		if (comentario == null) {
			if (other.comentario != null)
				return false;
		} else if (!comentario.equals(other.comentario))
			return false;
		if (dataHora == null) {
			if (other.dataHora != null)
				return false;
		} else if (!dataHora.equals(other.dataHora))
			return false;
		if (documento == null) {
			if (other.documento != null)
				return false;
		} else if (!documento.equals(other.documento))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (proposta == null) {
			if (other.proposta != null)
				return false;
		} else if (!proposta.equals(other.proposta))
			return false;
		if (tipoDecisao != other.tipoDecisao)
			return false;
		if (usuarioDecisao == null) {
			if (other.usuarioDecisao != null)
				return false;
		} else if (!usuarioDecisao.equals(other.usuarioDecisao))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}
	
	public Tramitacao(){
		
	}

	public Tramitacao(Long id, Proposta proposta, br.unibh.seguros.entidades.EtapaProcesso etapaProcesso, Date dataHora,
			TipoDecisao tipoDecisao, Funcionario usuarioDecisao, String comentario, File documento, Long version) {
		super();
		this.id = id;
		this.proposta = proposta;
		EtapaProcesso = etapaProcesso;
		this.dataHora = dataHora;
		this.tipoDecisao = tipoDecisao;
		this.usuarioDecisao = usuarioDecisao;
		this.comentario = comentario;
		this.documento = documento;
		this.version = version;
	}

}
