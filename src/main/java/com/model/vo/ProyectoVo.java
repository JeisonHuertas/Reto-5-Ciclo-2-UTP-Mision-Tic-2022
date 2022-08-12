package com.model.vo;

public class ProyectoVo {
    private Integer Id_proyecto;
    private String Constructora;
    private Integer num_habitaciones;
    private String ciudad;
	public Integer getId_proyecto() {
		return Id_proyecto;
	}
	public void setId_proyecto(Integer id_proyecto) {
		Id_proyecto = id_proyecto;
	}
	public String getConstructora() {
		return Constructora;
	}
	public void setConstructora(String constructora) {
		Constructora = constructora;
	}
	public Integer getNum_habitaciones() {
		return num_habitaciones;
	}
	public void setNum_habitaciones(Integer num_habitaciones) {
		this.num_habitaciones = num_habitaciones;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	@Override
	public String toString() {
		return "ProyectoVo [Id_proyecto=" + Id_proyecto + ", Constructora=" + Constructora
				+ ", num_habitaciones=" + num_habitaciones + ", ciudad=" + ciudad + "]";
	}
    
    
    
}
