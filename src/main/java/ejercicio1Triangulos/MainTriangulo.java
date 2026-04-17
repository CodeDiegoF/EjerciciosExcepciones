package ejercicio1Triangulos;
import java.io.FileNotFoundException;


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainTriangulo {
     public static void main(String[] args) throws FileNotFoundException {
          // Lista donde se guardan los triangulos válidos.
          List<Triangulo> triangulos = new ArrayList<>();
          // Abrir el CSV y cerrarlo automáticamente al terminar.
          try (Scanner sc = new Scanner(new File("ficheros/triangulos.csv"))) {
               boolean primeraLinea = true;

               while (sc.hasNextLine()) {
                    String linea = sc.nextLine().trim();
                    
                    if (linea.isEmpty()) { // Saltar líneas vacías
                         continue;
                    }
                    
                    if (primeraLinea) { // Saltar cabecera
                         primeraLinea = false;
                         if (linea.toLowerCase().startsWith("lado1")) {
                              continue;
                         }
                    }

                    // Separar la línea en los tres lados del triángulo.
                    String[] tokens = linea.split(",");
                    if (tokens.length < 3) {
                         System.err.println("Formato inválido en la línea: " + linea);
                         continue;
                    }

                    try {
                         double lado1 = Double.parseDouble(tokens[0]);
                         double lado2 = Double.parseDouble(tokens[1]);
                         double lado3 = Double.parseDouble(tokens[2]);

                         // La factoria válida y crea el triángulo.
                         Triangulo triangulo = Triangulo.factoriaTriangulo(lado1, lado2, lado3);
                         triangulos.add(triangulo);
                    } catch (NumberFormatException e) {
                         System.err.println("Número inválido en la línea: " + linea);
                    } catch (Triangulo.TrianguloException e) {
                         System.err.println(e.getMessage());
                    }
               }
          }

          // Imprimir todos los triángulos válidos encontrados.
          triangulos.forEach(t -> System.out.println("Triangulo válido con lados: " + t.getLado1() + ", " + t.getLado2() + ", " + t.getLado3()));
     }
}
