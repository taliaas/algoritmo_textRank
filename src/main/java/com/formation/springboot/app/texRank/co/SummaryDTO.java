package com.formation.springboot.app.texRank.co;

public class SummaryDTO {
	
	private String text;
	private int cantOraciones;
	
	
	public SummaryDTO(String text, int cantOraciones) {
		this.text = text;
		this.cantOraciones = cantOraciones;
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getCantOraciones() {
		return cantOraciones;
	}
	public void setCantOraciones(int cantOraciones) {
		this.cantOraciones = cantOraciones;
	}
}
