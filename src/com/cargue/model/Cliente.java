package com.cargue.model;

public class Cliente {

	private int Id;
	private String Nombres;
	private String apellidos;
	private String telefono;
	private String direccion;
	
	
	public Cliente() {
		
		
	}
	
	
	public Cliente(int Id, String nombres, String apellidos, String telefono, String direccion) {
		super();
		this.Id = Id;
		this.Nombres = nombres;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.direccion = direccion;
	}

	public int getId() {
		return Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}

	public String getNombres() {
		return Nombres;
	}

	public void setNombres(String nombres) {
		Nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Cliente [Id=" + Id + ", Nombres=" + Nombres + ", apellidos=" + apellidos + ", telefono=" + telefono
				+ ", direccion=" + direccion + "]";
	}

	
}
