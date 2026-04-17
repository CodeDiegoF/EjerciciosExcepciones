package personaEjemplo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
     public static void main(String[] args) {
          // Scanner inicial para asegurar cierre en finally.
          Scanner sc = new Scanner(System.in);
          try{
               // Leer personas desde CSV y validar edades.
               // Se informa de líneas con formato o edad inválidos.
               List<Persona> personas = new ArrayList<>();
               sc = new Scanner(new File("ficheros/personas.csv"));
               while (sc.hasNextLine()) {
                    String linea = sc.nextLine();
                    String[] tokens = linea.split(",");
                    if (tokens.length < 2) {
                         System.err.println("Formato inválido en la línea: " + linea);
                         continue;
                    }
                    String nombre = tokens[0];
                    String sEdad = tokens[1];
                    try {
                         int edad = Integer.parseInt(sEdad);
                         // Validar un rango razonable de edad.
                         if (edad < 0 || edad > 150) { // Rango razonable
                              throw new NumberFormatException("La edad debe estar entre 0 y 150: " + sEdad);
                         }
                         personas.add(new Persona(nombre, edad));
                    } catch (NumberFormatException e) {
                         System.err.println("Edad inválida en la línea: " + linea);
                    }
               }
               // Mostrar las personas que pasaron la validación.
               personas.forEach(System.out::println);
          } catch (FileNotFoundException e) {
               System.err.println("Archivo no encontrado: " + e.getMessage());
          } finally {
               // Cerrar siempre el scanner.
               System.out.println("Cerrando el scanner");
               sc.close();
          }
     }
}
