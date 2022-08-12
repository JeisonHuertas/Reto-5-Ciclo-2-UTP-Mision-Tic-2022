package com.model.vo;

public class LiderVo {
	private Integer id_lider;
    private String nombre;
    private String primer_Apellido;
    private String ciudad_residencia;

    

    public String getId_lider() {
		return Integer.toString(this.id_lider);
	}



	public void setId_lider(Integer id_lider) {
		this.id_lider = id_lider;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getPrimer_Apellido() {
		return primer_Apellido;
	}



	public void setPrimer_Apellido(String primer_Apellido) {
		this.primer_Apellido = primer_Apellido;
	}



	public String getCiudad_residencia() {
		return ciudad_residencia;
	}



	public void setCiudad_residencia(String ciudad_residencia) {
		this.ciudad_residencia = ciudad_residencia;
	}



	@Override
	public String toString() {
		return "LiderVo [id_lider=" + id_lider + ", nombre=" + nombre + ", primer_Apellido=" + primer_Apellido
				+ ", ciudad_residencia=" + ciudad_residencia + "]";
	}

}
