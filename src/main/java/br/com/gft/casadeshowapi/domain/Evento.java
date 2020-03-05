package br.com.gft.casadeshowapi.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@Entity
public class Evento {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@NotNull
	private Genero genero;
	
	@NotNull
	@Size(min=3, max=30)
	private String nomeEvento;
	
	@NotNull
	@Positive
	private Integer capacidade;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE) //Apenas data, sem hora e minuto
	@NotNull
	@Future
	private Date data;
	
	@NumberFormat(pattern="#,##0.00")
	@NotNull
	private BigDecimal valor;
	
	@ManyToOne
	@NotNull
	private Casa casa;
	
	@OneToMany(mappedBy="evento", cascade=javax.persistence.CascadeType.ALL) 
	private List<Venda> compra;
	@JsonIgnore
	public List<Venda> getCompra() {
		return compra;
	}
	public void setCarrinho(List<Venda> compra) {
		this.compra = compra;
	}
	public Casa getCasa() {
		return casa;
	}
	public void setCasa(Casa casa) {
		this.casa = casa;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(Integer capacidade) {
		this.capacidade = capacidade;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public BigDecimal getValor() {
		return valor;
	} 
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Evento other = (Evento) obj;
		if (id != other.id)
			return false;
		return true;
	}
	public String getNomeEvento() {
		return nomeEvento;
	}
	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}
	
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}

}


