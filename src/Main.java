import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Sistema s = new Sistema();

        int opcion = 0;

        do {
            try {
                System.out.println("\n===== CLINICA SALUD TOTAL =====");

                System.out.println("1. Registrar medico");

                System.out.println("2. Registrar administrativo");

                System.out.println("3. Mostrar empleados");

                System.out.println("4. Buscar por cedula");

                System.out.println("5. Reemplazar informacion");

                System.out.println("6. Eliminar registro");

                System.out.println("7. Calcular pagos");

                System.out.println("8. Mostrar estadisticas");

                System.out.println("9. Salir");

                System.out.print("Seleccione una opcion: ");

                opcion = Integer.parseInt(sc.nextLine());

                if (opcion < 1 || opcion > 9) {
                    throw new Exception("Opcion invalida");
                }

                switch (opcion) {

                    case 1:
                        s.registrarMedico();
                        break;

                    case 2:
                        s.registrarAdministrativo();
                        break;

                    case 3:
                        s.mostrar();
                        break;

                    case 4:
                        s.buscar();
                        break;

                    case 5:
                        s.actualizar();
                        break;

                    case 6:
                        s.eliminar();
                        break;

                    case 7:
                        s.calcularPagos();
                        break;

                    case 8:
                        s.estadisticas();
                        break;

                    case 9:
                        System.out.println("Saliendo del sistema...");

                        break;
                }

            } catch (NumberFormatException e) {
                System.out.println("Error: ingrese solo numeros");

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (opcion != 9);
    }
}