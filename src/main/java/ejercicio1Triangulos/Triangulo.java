package ejercicio1Triangulos;

public class Triangulo {
     // Lados del triángulo.
     private double lado1;
     private double lado2;
     private double lado3;
     
     private Triangulo(double lado1, double lado2, double lado3) {
          this.lado1 = lado1;
          this.lado2 = lado2;
          this.lado3 = lado3;
     }
     
     public double getLado1() {
          return lado1;
     }
     
     public void setLado1(double lado1) {
          this.lado1 = lado1;
     }
     
     public double getLado2() {
          return lado2;
     }
     
     public void setLado2(double lado2) {
          this.lado2 = lado2;
     }
     
     public double getLado3() {
          return lado3;
     }
     
     public void setLado3(double lado3) {
          this.lado3 = lado3;
     }
     
     public boolean comprobarDesigualdadTriangular(){
          // Validar lados positivos y desigualdad triangular.
          if (lado1 <= 0 || lado2 <= 0 || lado3 <= 0) {
               throw new TrianguloException(this);
          } else if (lado1 + lado2 <= lado3 || lado1 + lado3 <= lado2 || lado2 + lado3 <= lado1) {
               throw new TrianguloException(this);
          }else
               System.out.println("Triangulo válido con lados: " + lado1 + ", " + lado2 + ", " + lado3);
               return true;
     }
     
     public static Triangulo factoriaTriangulo(double lado1, double lado2, double lado3){
          // Crear y validar el triángulo antes de devolverlo.
          Triangulo triangulo = new Triangulo(lado1, lado2, lado3);
          
          if(!triangulo.comprobarDesigualdadTriangular()){
               throw new TrianguloException(triangulo);
          };
          return triangulo;
     }
     
     static class TrianguloException extends RuntimeException {
          public TrianguloException(Triangulo triangulo) {
               // Mensaje con los lados inválidos.
               super("Triangulo no valido con los lados: " + triangulo.getLado1() + ", " + triangulo.getLado2() + ", " + triangulo.getLado3());
          }
     }
}
