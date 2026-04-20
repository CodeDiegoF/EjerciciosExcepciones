package ejercicio2Numeros;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainNumeros {
     public static void main(String[] args) {
          // Lista de valores convertidos a decimal.
          List<Integer> numeros = new ArrayList<>();
          
          // Leer el fichero de números (binario o hexadecimal según configuración).
          try(Scanner sc = new Scanner(new File("ficheros/binario.txt" /* new File(ficheros/hexadecimal)*/))) {
               while (sc.hasNextLine()) {
                    String linea = sc.nextLine();
                    
                    if(linea.isEmpty()){
                         continue; // Saltar líneas vacías.
                    }
                    
                    String[] tokens = linea.split(",");
                    if(tokens.length < 1){
                         System.err.println("Formato inválido en la línea: " + linea);
                         continue;
                    }
                    
                    try{
                         // Convertir el primer token según el sistema numérico.
                         String numero = tokens[0];
                         Numero numeroObj = new Numero(numero, SistemaNumerico.BINARIO);
                         //Numero numeroObj = new Numero(numero, SistemaNumerico.HEXADECIMAL);
                         int numeroDecimal = Numero.sistemaNumericoADecimal(numeroObj.getValor(), numeroObj.getSistemaNumerico());
                         numeros.add(numeroDecimal);
                         
                    }catch(NumberFormatException e){
                         System.err.println("Formato inválido en la línea: " + linea);
                    }catch (Numero.BinaryException e) {
                         System.err.println(e.getMessage());
                    }
               }
          } catch (FileNotFoundException e) {
               System.err.println("Archivo no encontrado: " + e.getMessage());
          }
          
          // Mostrar resultado individual y suma total.
          numeros.forEach(numero -> System.out.println("Número decimal: " + numero));
          int sumaDecimal = Numero.devolverValorSumaDecimal(numeros);
          System.out.println("Suma total en decimal: " + sumaDecimal);
          
     }
}
