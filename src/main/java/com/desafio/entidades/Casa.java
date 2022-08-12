package com.desafio.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Casa{
	
	@Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length = 50 , nullable = false)
    private String descricao;
    @Column(length = 50, nullable = false)
    private String dimensao;
    @Column(length = 50, nullable = false)
    private String comodo;
    
	public Casa() {
	}

	public Casa( String descricao, String dimensao, String comodo) {
		this.descricao = descricao;
		this.dimensao = dimensao;
		this.comodo = comodo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDimensao() {
		return dimensao;
	}

	public void setDimensao(String dimensao) {
		this.dimensao = dimensao;
	}

	public String getComodo() {
		return comodo;
	}

	public void setComodo(String comodo) {
		this.comodo = comodo;
	}
	
	
	
    
    

}
