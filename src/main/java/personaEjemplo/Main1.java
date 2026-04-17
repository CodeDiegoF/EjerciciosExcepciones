package personaEjemplo;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1 {
     public static void main(String[] args) throws FileNotFoundException {
          
          // Leer personas desde CSV con validacion simple de edad.
          // Formato esperado por línea: nombre, edad
          List<Persona> personas = new ArrayList<>();
          Scanner sc = new Scanner(new File("ficheros/personas.csv"));
          while (sc.hasNextLine()) {
               String linea = sc.nextLine();
               // Separar los campos por coma.
               String[] tokens = linea.split(",");
               String nombre = tokens[0];
               String sEdad = tokens[1];
               // Filtrar edades que no sean numericas de 1 o 2 digitos.
               if (sEdad.matches("[1-9][0-9]?")) { // Solo edades 1..99
                    int edad = Integer.parseInt(sEdad);
                    personas.add(new Persona(nombre, edad));
               }
          }
          sc.close();
          // Mostrar por consola las personas válidas.
          personas.forEach(System.out::println); // Mostrar resultados
     }
}
