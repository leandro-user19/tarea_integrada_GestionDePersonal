public abstract class Empleado {
    private int cedula;
    private String nombre;
    private int edad;
    private String correo;


    public Empleado(int cedula, String nombre, int edad, String correo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
    }

    public abstract void mostrarInformacion();

    public abstract double calcularPago();


    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
