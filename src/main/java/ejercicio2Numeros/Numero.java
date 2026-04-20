package ejercicio2Numeros;

import java.util.List;

public class Numero {
     private static String valor;
     private static SistemaNumerico sistemaNumerico;
     
     public Numero(String valor, SistemaNumerico sistemaNumerico) {
          // Validar que el valor es correcto según el sistema numérico.
          if(valor.matches("[01]*") && sistemaNumerico == SistemaNumerico.BINARIO  /*valor.matches("[0-9a-fA-F]{6}") && sistemaNumerico == SistemaNumerico.HEXADECIMAL*/){
               this.valor = valor;
               this.sistemaNumerico = sistemaNumerico;
          }else {
               throw new BinaryException(valor);
          }
          
     }
     
     public SistemaNumerico getSistemaNumerico() {
          return sistemaNumerico;
     }
     
     public String getValor() {
          return valor;
     }
     
     public static int sistemaNumericoADecimal(String valor, SistemaNumerico sistemaNumerico) {
          int numeroDecimal = 0;
          switch (sistemaNumerico) {
               case BINARIO:
                    numeroDecimal = Integer.parseInt(valor, 2);
                    break;
               case HEXADECIMAL:
                    numeroDecimal = Integer.parseInt(valor, 16);
                    break;
               case OCTAL:
                    numeroDecimal = Integer.parseInt(valor, 8);
                    break;
               case DECIMAL:
                    numeroDecimal = Integer.parseInt(valor);
                    break;
          }
          return numeroDecimal;
     }
     
     public static int devolverValorSumaDecimal(List<Integer> numeros){
          int suma = 0;
          for (int numero : numeros) {
               suma += numero;
          }
          return suma = Integer.parseInt(String.valueOf(suma));
     }
     
     class BinaryException extends RuntimeException{
          public BinaryException(String valor) {
               super("Formato incorrecto: " + valor + " no es un número hexadecimal válido.");
          }
     }
}
