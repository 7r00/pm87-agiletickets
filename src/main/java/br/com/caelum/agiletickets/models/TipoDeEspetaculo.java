package br.com.caelum.agiletickets.models;

public enum TipoDeEspetaculo {
	
	CINEMA(true, 0.05, 0.10, false), SHOW(true, 0.05, 0.10, false), TEATRO(false, 0.0, 0.0, false), BALLET(true, 0.50, 0.20, true), ORQUESTRA(true, 0.50, 0.20, true);
	
	private boolean deveCalcular; 
	private double par1; 
	private double par2; 
	private boolean deveCalcularMaior60;
	
	public boolean isDeveCalcular() {
		return deveCalcular;
	}

	public void setDeveCalcular(boolean deveCalcular) {
		this.deveCalcular = deveCalcular;
	}

	public double getPar1() {
		return par1;
	}

	public void setPar1(double par1) {
		this.par1 = par1;
	}

	public double getPar2() {
		return par2;
	}

	public void setPar2(double par2) {
		this.par2 = par2;
	}

	public boolean isDeveCalcularMaior60() {
		return deveCalcularMaior60;
	}

	public void setDeveCalcularMaior60(boolean deveCalcularMaior60) {
		this.deveCalcularMaior60 = deveCalcularMaior60;
	}

	private TipoDeEspetaculo(boolean deveCalcular, double par1, double par2, boolean deveCalcularMaior60) {
		this.deveCalcular = deveCalcular;
		this.par1 = par1;
		this.par2 = par2;
		this.deveCalcularMaior60 = deveCalcularMaior60;
	}
	
}
