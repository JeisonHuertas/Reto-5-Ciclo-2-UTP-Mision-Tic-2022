package com.model.vo;

public class CompraVo {
    private Integer id_Compra;
    private String constructora;
    private String banco_Vinculado;
    
	public Integer getId_Compra() {
		return id_Compra;
	}
	public void setId_Compra(Integer id_Compra) {
		this.id_Compra = id_Compra;
	}
	public String getConstructora() {
		return constructora;
	}
	public void setConstructora(String constructora) {
		this.constructora = constructora;
	}
	public String getBanco_Vinculado() {
		return banco_Vinculado;
	}
	public void setBanco_Vinculado(String banco_Vinculado) {
		this.banco_Vinculado = banco_Vinculado;
	}
	@Override
	public String toString() {
		return "CompraVo [id_Compra=" + id_Compra + ", constructora=" + constructora + ", banco_Vinculado="
				+ banco_Vinculado + "]";
	}
    
    

    
}
