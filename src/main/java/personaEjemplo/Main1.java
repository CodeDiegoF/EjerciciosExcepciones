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
          
          List<Persona> personas = new ArrayList<>();
          Scanner sc = new Scanner(new File("ficheros/personas.csv"));
          while (sc.hasNextLine()) {
               String linea = sc.nextLine();
               String[] tokens = linea.split(",");
               String nombre = tokens[0];
               String sEdad = tokens[1];
               if (sEdad.matches("[1-9][0-9]?")) {
                    int edad = Integer.parseInt(sEdad);
                    personas.add(new Persona(nombre, edad));
               }
          }
          sc.close();
          personas.forEach(System.out::println);
     }
}

