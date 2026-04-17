package ejercicio1Triangulos;
import java.io.FileNotFoundException;


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainTriangulo {
     public static void main(String[] args) throws FileNotFoundException {
          List<Triangulo> triangulos = new ArrayList<>();
          try (Scanner sc = new Scanner(new File("ficheros/triangulos.csv"))) {
               boolean primeraLinea = true;

               while (sc.hasNextLine()) {
                    String linea = sc.nextLine().trim();
                    
                    if (linea.isEmpty()) {
                         continue;
                    }
                    
                    if (primeraLinea) {
                         primeraLinea = false;
                         if (linea.toLowerCase().startsWith("lado1")) {
                              continue;
                         }
                    }

                    String[] tokens = linea.split(",");
                    if (tokens.length < 3) {
                         System.err.println("Formato inválido en la línea: " + linea);
                         continue;
                    }

                    try {
                         double lado1 = Double.parseDouble(tokens[0]);
                         double lado2 = Double.parseDouble(tokens[1]);
                         double lado3 = Double.parseDouble(tokens[2]);

                         Triangulo triangulo = Triangulo.factoriaTriangulo(lado1, lado2, lado3);
                         triangulos.add(triangulo);
                    } catch (NumberFormatException e) {
                         System.err.println("Número inválido en la línea: " + linea);
                    } catch (Triangulo.TrianguloException e) {
                         System.err.println(e.getMessage());
                    }
               }
          }catch (FileNotFoundException e) {
               System.err.println("Archivo no encontrado: " + e.getMessage());
          }

          triangulos.forEach(t -> System.out.println("Triangulo válido con lados: " + t.getLado1() + ", " + t.getLado2() + ", " + t.getLado3()));
     }
}

