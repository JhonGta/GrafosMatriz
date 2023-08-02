package grafos;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GrafoMatriz grafo = new GrafoMatriz();

        // Ingreso dinámico de vértices
        System.out.print("Ingrese la cantidad de vértices que desea agregar: ");
        int numVertices = scanner.nextInt();
        scanner.nextLine(); // Consumimos el salto de línea pendiente

        for (int i = 0; i < numVertices; i++) {
            System.out.print("Ingrese el nombre del vértice " + (i + 1) + ": ");
            String nombreVertice = scanner.nextLine();
            grafo.nuevoVertice(nombreVertice);
        }

        // Ingreso dinámico de arcos
        System.out.print("Ingrese la cantidad de arcos que desea agregar: ");
        int numArcos = scanner.nextInt();
        scanner.nextLine(); // Consumimos el salto de línea pendiente

        for (int i = 0; i < numArcos; i++) {
            System.out.print("Ingrese el nombre del vértice origen del arco " + (i + 1) + ": ");
            String origen = scanner.nextLine();

            System.out.print("Ingrese el nombre del vértice destino del arco " + (i + 1) + ": ");
            String destino = scanner.nextLine();

            try {
                grafo.nuevoArco(origen, destino);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Calcular el camino mínimo desde un vértice origen
        System.out.print("Ingrese el nombre del vértice origen para calcular el camino mínimo: ");
        String nombreOrigen = scanner.nextLine();
        int origen = grafo.numVertice(nombreOrigen);

        if (origen >= 0) {
            CaminoMinimo caminoMinimo = new CaminoMinimo(grafo, origen);
            caminoMinimo.caminoMinimos();

            for (int i = 0; i < grafo.numVerts; i++) {
                if (i != origen) {
                    System.out.print("Camino mínimo desde " + nombreOrigen + " hasta V" + i + ": ");
                    caminoMinimo.recuperaCamino(i);
                    System.out.println(" con peso total " + caminoMinimo.D[i]);
                }
            }
        } else {
            System.out.println("El vértice origen no existe en el grafo.");
        }
    }
}
