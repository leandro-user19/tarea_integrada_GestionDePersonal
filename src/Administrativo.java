public class Administrativo extends Empleado{
    private String departamento;
    private int horasTrabajadas;
    private double valorHora;

    public Administrativo(String cedula, String nombre, int edad, String correo, String departamento, String s, int horasTrabajadas, double valorHora) {
        super(cedula, nombre, edad, correo);
        this.departamento = departamento;
        this.horasTrabajadas = horasTrabajadas;
        this.valorHora = valorHora;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    @Override
    public void mostrarInformacion() {

    }

    @Override
    public double calcularPago() {
        return horasTrabajadas*valorHora;

    }
}
