import java.util.ArrayList;
import java.util.Scanner;

public class AnalisisNotas {
    static ArrayList<Double> notas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    agregarNota(sc,notas);
                    break;
                case 2:
                    mostrarNotas(notas);
                    break;
                case 3:
                    double promedio = calcularPromedio(notas);
                    System.out.printf("Promedio de notas: %.2f\n", promedio);
                    break;
                case 4:
                    int aprobados = contarAprobados(notas);
                    System.out.println("Cantidad de notas apronadas: " + aprobados);
                    break;
                case 5:
                    System.out.println("Ha salido del programa.");
                    break;
                default:
                    System.out.println("Opcion no válida. Intente de nuevo.");
                    break;
            }

        } while (opcion != 5);

        sc.close();

    }

    public static void mostrarMenu() {

        System.out.println("--- Análisis de Notas ---");
        System.out.println("1. Agregar nota");
        System.out.println("2. Mostrar todas las notas");
        System.out.println("3. Calcular promedio de notas");
        System.out.println("4. Contar notas aprobadas (>= 3.5)");
        System.out.println("5. Salir");
        System.out.println("--------------------------");
        System.out.println("Ingrese su opción:");
    }

    public static void agregarNota(Scanner sc, ArrayList<Double> notas) {

        System.out.println("Ingrese una nota (0.0 - 5.0): ");
        double nota = sc.nextDouble();

        if (nota >= 0.0 && nota <= 5.0) {
            notas.add(nota);
        } else {
            System.out.println("La nota ingresada no es valida debe estar entre 0.0 y 5.0 ");
        }
    }

    public static void mostrarNotas(ArrayList<Double> notas) {
        if (notas.isEmpty()) {
            System.out.println("No hay notas registradas.");
            return;
        }

        System.out.println("Notas registradas.");
        for (double nota : notas) {
            System.out.printf("%.1f\n", nota);
        }
    }

    public static double calcularPromedio(ArrayList<Double> notas) {
        if (notas.isEmpty()) {
            return 0.0;
        }

        double suma = 0.0;
        for (double nota : notas) {
            suma += nota;
        }
        return suma / notas.size();
    }

    public static int contarAprobados(ArrayList<Double> notas) {
        if (notas.isEmpty()) {
            return 0;
        }

        int contador = 0;
        for (double nota : notas) {
            if (nota >= 3.5) {
                contador++;
            }
        }

        return contador;
    }

}
