package com.alexandre.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.alexandre.enums.Estados;

@Entity
@Table(name = "CIDADE")
public class Cidade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long codigo;
	
	
	@Column(name = "NOME")
	@NotBlank(message  = "Nome é obrigatório")
	private String nome;
	
    @Column(name = "Estado")
    @NotBlank(message  = "Estado 1 é obrigatório")
	@Enumerated(EnumType.STRING)
	private Estados estado;
	
	@OneToMany(mappedBy = "cidade")
	private List<Cliente> clientes;

	public Cidade() {
	
	}

	
	
	public Long getCodigo() {
		return codigo;
	}



	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

       



	public Estados getEstado() {
		return estado;
	}



	public void setEstado(Estados estado) {
		this.estado = estado;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Cidade other = (Cidade) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	

}
