package ArrayList1;

/**
 * Created by curso mañana on 29/11/2016.
 */
public class Empleado {
    private String NIF;
    private double sueldo;
    private float pagoHoraExtra;
    private int horasExtraMes;
    private float IRPF;
    private int hijos;

    public Empleado() {
        //no hay na
    }

    public Empleado(String NIF, double sueldo, float pagoHoraExtra, int horasExtraMes, float IRPF, int hijos) {
        this.NIF = NIF;
        this.sueldo = sueldo;
        this.pagoHoraExtra = pagoHoraExtra;
        this.horasExtraMes = horasExtraMes;
        this.IRPF = IRPF;
        this.hijos = hijos;
    }

    public float calcularComplementoDelMes() {
        return pagoHoraExtra * horasExtraMes;
    }

    public double calcularSueldoAnualBruto(int numeroSueldos) {
        return sueldo * numeroSueldos;
    }

    public double calcularRetencionIRPF(int numeroSueldos) {
        switch (hijos) {
            case 0:
                return calcularSueldoAnualBruto(numeroSueldos);
            case 1:
            case 2:
                return calcularSueldoAnualBruto(numeroSueldos) * (IRPF - 1 / 100);
            default:
                return calcularSueldoAnualBruto(numeroSueldos) * (IRPF - 2 / 100);
        }
    }

    @Override
    public String toString() {
        return "Empleado:" +
                "NIF='" + NIF + '\'' +
                ", sueldo=" + sueldo +
                ", pagoHoraExtra=" + pagoHoraExtra +
                ", horasExtraMes=" + horasExtraMes +
                ", IRPF=" + IRPF +
                ", hijos=" + hijos;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public float getPagoHoraExtra() {
        return pagoHoraExtra;
    }

    public void setPagoHoraExtra(float pagoHoraExtra) {
        this.pagoHoraExtra = pagoHoraExtra;
    }

    public int getHorasExtraMes() {
        return horasExtraMes;
    }

    public void setHorasExtraMes(int horasExtraMes) {
        this.horasExtraMes = horasExtraMes;
    }

    public float getIRPF() {
        return IRPF;
    }

    public void setIRPF(float IRPF) {
        this.IRPF = IRPF;
    }

    public int getHijos() {
        return hijos;
    }

    public void setHijos(int hijos) {
        this.hijos = hijos;
    }
}
