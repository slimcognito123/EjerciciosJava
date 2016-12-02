package empresa;

public class Empleado {

	private String nif;
	private double sueldoBase;
	private int horasExtraMes;
	private double pagoHoraExtra;
	private double irpf;
	private int numHijos;
	
	public Empleado(){
		
	}
	
	public Empleado(String nif, double sueldoBase, int horasExtraMes, double pagoHoraExtra, double irpf, int numHijos) {
		super();
		this.nif = nif;
		this.sueldoBase = sueldoBase;
		this.horasExtraMes = horasExtraMes;
		this.pagoHoraExtra = pagoHoraExtra;
		this.irpf = irpf;
		this.numHijos = numHijos;
	}
	
	public String getNif() {
		return nif;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}
	public double getSueldoBase() {
		return sueldoBase;
	}
	public void setSueldoBase(double sueldoBase) {
		this.sueldoBase = sueldoBase;
	}
	public int getHorasExtraMes() {
		return horasExtraMes;
	}
	public void setHorasExtraMes(int horasExtraMes) {
		this.horasExtraMes = horasExtraMes;
	}
	public double getPagoHoraExtra() {
		return pagoHoraExtra;
	}
	public void setPagoHoraExtra(double pagoHoraExtra) {
		this.pagoHoraExtra = pagoHoraExtra;
	}
	public double getIrpf() {
		return irpf;
	}
	public void setIrpf(double irpf) {
		this.irpf = irpf;
	}
	public int getNumHijos() {
		return numHijos;
	}
	public void setNumHijos(int numHijos) {
		this.numHijos = numHijos;
	}
	
	public double calculoComplementoHorasExtra(){
		return pagoHoraExtra*horasExtraMes;
	}
	
	public double sueldoBruto(){
		return sueldoBase + calculoComplementoHorasExtra();
	}
	
	public double retencion(){
		switch (numHijos) {
		case 0:
			return sueldoBruto()* (irpf/100);
		case 1:
		case 2:
			return sueldoBruto()* ((irpf-1)/100);
		default:
			return sueldoBruto()* ((irpf-2)/100);
		}
	}

	@Override
	public String toString() {
		return "\n Empleado [nif=" + nif + ", sueldoBase=" + sueldoBase + ", horasExtraMes=" + horasExtraMes
				+ ", pagoHoraExtra=" + pagoHoraExtra + ", irpf=" + irpf + ", numHijos=" + numHijos + "]";
	}
	
	
	
}
