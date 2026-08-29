import java.util.Scanner;

public class Cliente_202421250021 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        // Criação do objeto da classe Calculadora
        Calculadora_202421250021 calculadora =
                new Calculadora_202421250021();

        System.out.println("=================================");
        System.out.println("     CALCULADORA MATEMÁTICA");
        System.out.println("=================================");

        // Entrada dos números
        System.out.print("Digite o primeiro número: ");
        double numero1 = entrada.nextDouble();

        System.out.print("Digite o segundo número: ");
        double numero2 = entrada.nextDouble();

        System.out.println();
        System.out.println("===== RESULTADOS =====");

        // Chamadas aos métodos da Calculadora
        System.out.println("Soma: "
                + calculadora.somar(numero1, numero2));

        System.out.println("Subtração: "
                + calculadora.subtrair(numero1, numero2));

        System.out.println("Multiplicação: "
                + calculadora.multiplicar(numero1, numero2));

        System.out.println("Divisão: "
                + calculadora.dividir(numero1, numero2));

        entrada.close();
    }
}


