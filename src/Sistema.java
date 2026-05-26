import java.util.Scanner;
import java.util.ArrayList;

public class Sistema{

    Scanner sc = new Scanner(System.in);

    ArrayList<Empleado>lista=new ArrayList<>();


    public void crear() {
        try{
            System.out.print("Nombre: ");
            String nombre=sc.nextLine();
            if (nombre.trim() .isEmpty()){
                throw new NombreVacioException("El nombre es obligatorio");
            }

            System.out.print("Edad: ");
            int edad=sc.nextInt();
            sc.nextLine();

            if(edad<0){
                throw new EdadNegativaException("La edad debe ser un número positivo");
            }

            System.out.print("Cedula: ");
            if (!sc.hasNextInt()){
                sc.nextLine();
                throw new CedulaVaciaException("La cedula deben ser números");
            }
            int cedula=sc.nextInt();
            sc.nextLine();
            if(Integer.toString(cedula).length() !=10){
                throw new CedulaNumeroException("Debe tener 10 números");
            }

            System.out.print("Carrera: ");
            String carrera=sc.nextLine();
            if (carrera.trim() .isEmpty()){
                throw new CarreraVaciaException("Este campo es obligatorio");
            }

            Estudiante nuevo = new Estudiante(nombre, cedula, edad, carrera);
            lista.add(nuevo);
            System.out.println("¡Usuario creado con éxito!");

        }catch(java.util.InputMismatchException e){
            System.out.println("La edad debe ser númerica");
            sc.nextLine();
        }catch(NombreVacioException e){
            System.out.println("Error de nombre " + e.getMessage());
        }catch(EdadNegativaException e){
            System.out.println("Error de edad " + e.getMessage());
        }catch(CedulaVaciaException e){
            System.out.println("Error de cedula " + e.getMessage());
        }catch(CedulaNumeroException e){
            System.out.println("Error de cedula(10 digitos)"+ e.getMessage());
        } catch (CarreraVaciaException e){
            System.out.println("Error de carrera " + e.getMessage());
        }catch(Exception e){
            System.out.println("Error desconocido " + e.getMessage());
        }
    }


    public void mostrar() {
        if(lista.isEmpty()){
            System.out.println("No hay estudiantes registrados");
            return;
        }

        for (int i=0; i<lista.size();i++){
            Estudiante e =lista.get(i);

            System.out.println("----------------");
            System.out.println("Nombre: " + e.getNombre());
            System.out.println("Edad: " + e.getEdad());
            System.out.println("Cedula: " + e.getCedula());
            System.out.println("Carrera: " + e.getCarrera());
        }
    }


    public void actualizar() {
        try{
            System.out.println("Ingrese la cedula del estudiante: ");
            int cedula=sc.nextInt();
            sc.nextLine();
            boolean encontrado = false;

            for (int i=0;i <lista.size();i++){
                Estudiante e= lista.get(i);
                if (e.getCedula()== cedula){
                    encontrado = true;

                    System.out.println("Nuevo nombre:");
                    e.setNombre(sc.nextLine());

                    System.out.println("Nueva carrera:");
                    e.setCarrera(sc.nextLine());

                    System.out.println("Actualizado");
                }
            }
            if(!encontrado){
                throw new Exception("Estudiante no registrado");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    public void eliminar() {
        try{
            System.out.println("Ingrese la cedula del estudiande a eliminar: ");
            int cedula=sc.nextInt();

            boolean eliminado=lista.removeIf(e->e.getCedula()== cedula);
            if (!eliminado){
                throw new Exception("Estudiande no encontrado");
            }
            System.out.println("Estudiante eliminado");

        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}
