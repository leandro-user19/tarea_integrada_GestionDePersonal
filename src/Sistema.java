import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {

    Scanner sc = new Scanner(System.in);

    ArrayList<Empleado> lista = new ArrayList<>();

    public void registrarMedico() {

        try {

            System.out.println("\n=== REGISTRO MEDICO ===");

            System.out.print("Cedula: ");
            String cedula = sc.nextLine();

            for (Empleado e : lista) {

                if (e.getCedula().equals(cedula)) {

                    throw new Exception("Cedula ya registrada");
                }
            }

            if (cedula.trim().isEmpty()) {
                throw new Exception("Cedula vacia");
            }

            if (cedula.length() != 10) {
                throw new Exception("La cedula debe tener 10 digitos");
            }

            System.out.print("Nombre: ");
            String nombre = sc.nextLine();

            if (nombre.trim().isEmpty()) {
                throw new Exception("Nombre obligatorio");
            }

            System.out.print("Edad: ");

            int edad = Integer.parseInt(sc.nextLine());

            if (edad <= 0 || edad > 120) {

                throw new Exception("Edad invalida");
            }

            System.out.print("Correo: ");
            String correo = sc.nextLine();

            if (!correo.contains("@") || !correo.contains(".")) {
                throw new Exception("Correo invalido");
            }

            System.out.print("Telefono: ");
            String telefono = sc.nextLine();

            if (!telefono.matches("[0-9]+")) {
                throw new Exception("Telefono invalido");
            }

            System.out.print("Especialidad: ");
            String especialidad = sc.nextLine();

            if (especialidad.trim().isEmpty()) {
                throw new Exception("Especialidad obligatoria");
            }

            System.out.print("Pacientes atendidos: ");

            int pacientes = Integer.parseInt(sc.nextLine());

            if (pacientes <= 0) {
                throw new Exception("Pacientes invalidos");
            }

            System.out.print("Valor consulta: ");

            double valorConsulta = Double.parseDouble(sc.nextLine());

            if (valorConsulta <= 0) {

                throw new Exception("Valor invalido");
            }

            Medico m = new Medico(
                    cedula,
                    nombre,
                    edad,
                    correo,
                    telefono,
                    especialidad,
                    pacientes,
                    valorConsulta
            );

            lista.add(m);

            System.out.println("Medico registrado");

        }catch (NumberFormatException e) {

            System.out.println("Error: dato numerico invalido");

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
        }
    }


    public void registrarAdministrativo() {
        try {
            System.out.println("\n=== REGISTRO ADMINISTRATIVO ===");

            System.out.print("Cedula: ");
            String cedula = sc.nextLine();

            for (Empleado e : lista) {

                if (e.getCedula().equals(cedula)) {
                    throw new Exception("Cedula ya registrada");
                }
            }

            if (cedula.length() != 10) {

                throw new Exception("Cedula invalida");
            }

            System.out.print("Nombre: ");
            String nombre = sc.nextLine();

            if (nombre.trim().isEmpty()) {
                throw new Exception("Nombre obligatorio");
            }

            System.out.print("Edad: ");

            int edad = Integer.parseInt(sc.nextLine());

            if (edad <= 0 || edad > 120) {

                throw new Exception("Edad invalida");
            }

            System.out.print("Correo: ");
            String correo = sc.nextLine();

            if (!correo.contains("@") || !correo.contains(".")) {

                throw new Exception("Correo invalido");
            }

            System.out.print("Telefono: ");
            String telefono = sc.nextLine();

            if (!telefono.matches("[0-9]+")) {

                throw new Exception("Telefono invalido");
            }

            System.out.print("Departamento: ");
            String departamento = sc.nextLine();

            if (departamento.trim().isEmpty()) {

                throw new Exception("Departamento obligatorio");
            }

            System.out.print("Horas trabajadas: ");

            int horas = Integer.parseInt(sc.nextLine());

            if (horas <= 0) {

                throw new Exception("Horas invalidas");
            }

            System.out.print("Valor por hora: ");

            double valorHora = Double.parseDouble(sc.nextLine());

            if (valorHora <= 0) {
                throw new Exception("Valor invalido");
            }

            Administrativo a =
                    new Administrativo(
                            cedula,
                            nombre,
                            edad,
                            correo,
                            telefono,
                            departamento,
                            horas,
                            valorHora
                    );

            lista.add(a);

            System.out.println("Administrativo registrado");

        } catch (NumberFormatException e) {

            System.out.println("Error: dato numerico invalido");

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
        }
    }

    public void mostrar() {

        if (lista.isEmpty()) {
            System.out.println("No hay empleados registrados");
            return;
        }

        for (Empleado e : lista) {

            System.out.println("\n====================");

            System.out.println("Cedula: " + e.getCedula());

            System.out.println("Nombre: " + e.getNombre());

            System.out.println("Edad: " + e.getEdad());

            System.out.println("Correo: " + e.getCorreo());

            System.out.println("Telefono: " + e.getTelefono());

            if (e instanceof Medico) {

                Medico m = (Medico) e;

                System.out.println("Tipo: Medico");

                System.out.println("Especialidad: " + m.getEspecialidad());

            } else if (
                    e instanceof Administrativo
            ) {

                Administrativo a =
                        (Administrativo) e;

                System.out.println("Tipo: Administrativo");

                System.out.println("Departamento: " + a.getDepartamento());
            }
        }
    }


    public void buscar() {

        try {

            System.out.print("Ingrese cedula: ");

            String cedula = sc.nextLine();

            boolean encontrado = false;

            for (Empleado e : lista) {

                if (e.getCedula()==cedula) {

                    encontrado = true;

                    System.out.println("Nombre: " + e.getNombre());

                    System.out.println("Edad: " + e.getEdad());

                    System.out.println("Correo: " + e.getCorreo());
                }
            }

            if (!encontrado) {

                throw new Exception("Registro no encontrado");
            }

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }



    public void actualizar() {

        try {
            System.out.print("Ingrese cedula: ");
            String cedula = sc.nextLine();

            boolean encontrado = false;

            for (Empleado e : lista) {

                if (e.getCedula()==cedula) {

                    encontrado = true;

                    System.out.print("Nuevo nombre: ");

                    String nuevo = sc.nextLine();

                    if (nuevo.trim().isEmpty()) {
                        throw new Exception("Nombre vacio");
                    }
                    e.setNombre(nuevo);
                    System.out.println("Actualizado");
                }
            }

            if (!encontrado) {

                throw new Exception("Empleado no encontrado");
            }
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }

    public void eliminar() {

        try {

            System.out.print("Ingrese cedula: ");

            String cedula = sc.nextLine();

            boolean eliminado = lista.removeIf(e -> e.getCedula()==cedula);

            if (!eliminado) {
                throw new Exception("Empleado no encontrado");
            }
            System.out.println("Empleado eliminado");

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }

    public void calcularPagos() {

        for (Empleado e : lista) {

            if (e instanceof Medico) {
                Medico m = (Medico) e;
                double pago = m.getNumeroPacientesAtendidos() * m.getValorConsulta();
                System.out.println(m.getNombre() + " paga: " + pago);

            } else if (
                    e instanceof Administrativo
            ) {

                Administrativo a =
                        (Administrativo) e;

                double pago = a.getHorasTrabajadas() * a.getValorHora();

                System.out.println(a.getNombre() + " paga: " + pago);
            }
        }
    }

    public void estadisticas() {

        int medicos = 0;
        int administrativos = 0;

        for (Empleado e : lista) {

            if (e instanceof Medico) {
                medicos++;
            } else if (
                    e instanceof Administrativo
            ) {
                administrativos++;
            }
        }

        System.out.println("Total empleados: " + lista.size()
        );

        System.out.println("Total medicos: " + medicos
        );

        System.out.println("Total administrativos: " + administrativos
        );
    }
}


