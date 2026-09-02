import java.util.Scanner;

public class Cliente_202421250021 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        // Usando o Adapter através da interface Alvo
        Alvo calculadora = new Adapter();

        System.out.println("=================================");
        System.out.println("     CALCULADORA MATEMÁTICA");
        System.out.println("=================================");

        System.out.print("Digite o primeiro número: ");
        double numero1 = entrada.nextDouble();

        System.out.print("Digite o segundo número: ");
        double numero2 = entrada.nextDouble();

        System.out.println();
        System.out.println("===== RESULTADOS =====");

        // O cliente chama o Adapter, que por sua vez chama o .JAR interno
        System.out.println("Soma: " + calculadora.somar(numero1, numero2));
        System.out.println("Subtração: " + calculadora.subtrair(numero1, numero2));
        System.out.println("Multiplicação: " + calculadora.multiplicar(numero1, numero2));
        System.out.println("Divisão: " + calculadora.dividir(numero1, numero2));

        entrada.close();
    }
}