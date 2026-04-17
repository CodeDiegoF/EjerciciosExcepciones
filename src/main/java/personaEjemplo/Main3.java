package personaEjemplo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main3 {
     public static void main(String[] args) {
          try (Scanner sc = new Scanner(new File("ficheros/personas.csv"))) {
               List<Persona> personas = new ArrayList<>();
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
                         if (edad < 0 || edad > 150) {
                              throw new PersonaException(new Persona(nombre, edad));
                         }
                         personas.add(new Persona(nombre, edad));
                    } catch (NumberFormatException e) {
                         System.err.println("Edad inválida en la línea: " + linea);
                    }
               }
               personas.forEach(System.out::println);
          } catch (FileNotFoundException e) {
               System.err.println("Archivo no encontrado: " + e.getMessage());
          }
     }
     
     static class PersonaException extends RuntimeException {
          public PersonaException(Persona persona) {
               super("edad no valida: " + persona.getEdad() + " de " +  persona.getNombre());
          }
     }
}

