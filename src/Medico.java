public class Medico extends Empleado{
    private String especialidad;
    private int numeroPacientesAtendidos;
    private double valorConsulta;


    public Medico(int cedula, String nombre, int edad, String correo, String especialidad, int numeroPacientesAtendidos, double valorConsulta) {
        super(cedula, nombre, edad, correo);
        this.especialidad = especialidad;
        this.numeroPacientesAtendidos = numeroPacientesAtendidos;
        this.valorConsulta = valorConsulta;
    }


    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getNumeroPacientesAtendidos() {
        return numeroPacientesAtendidos;
    }

    public void setNumeroPacientesAtendidos(int numeroPacientesAtendidos) {
        this.numeroPacientesAtendidos = numeroPacientesAtendidos;
    }

    public double getValorConsulta() {
        return valorConsulta;
    }

    public void setValorConsulta(double valorConsulta) {
        this.valorConsulta = valorConsulta;
    }

    @Override
    public void mostrarInformacion() {

    }

    @Override
    public double calcularPago() {

        return numeroPacientesAtendidos*valorConsulta;
    }
}
