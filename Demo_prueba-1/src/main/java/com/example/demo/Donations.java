package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="donacion")
public class Donations {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long iddonacion;
	
	@Column(nullable = false, length = 45)
	private String donacion;
	
	@Column(nullable = false, length = 100)
	private String fecha;
	
	@Column(nullable = false, length = 45)
	private int usuario_idusuario;
	
	@Column(nullable = false, length = 45)
	private int institucion_idinstitucion;

	public long getIddonacion() {
		return iddonacion;
	}

	public void setIddonacion(long iddonacion) {
		this.iddonacion = iddonacion;
	}

	public String getDonacion() {
		return donacion;
	}

	public void setDonacion(String donacion) {
		this.donacion = donacion;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getUsuario_idusuario() {
		return usuario_idusuario;
	}

	public void setUsuario_idusuario(int usuario_idusuario) {
		this.usuario_idusuario = usuario_idusuario;
	}

	public int getInstitucion_idinstitucion() {
		return institucion_idinstitucion;
	}

	public void setInstitucion_idinstitucion(int institucion_idinstitucion) {
		this.institucion_idinstitucion = institucion_idinstitucion;
	}
}
