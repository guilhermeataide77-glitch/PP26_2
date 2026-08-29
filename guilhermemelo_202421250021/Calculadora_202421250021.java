public class Calculadora_202421250021 {

    // Método para realizar a soma
    public double somar(double a, double b) {
        return a + b;
    }

    // Método para realizar a subtração
    public double subtrair(double a, double b) {
        return a - b;
    }

    // Método para realizar a multiplicação
    public double multiplicar(double a, double b) {
        return a * b;
    }

    // Método para realizar a divisão
    public double dividir(double a, double b) {
        if (b == 0) {
            System.out.println("Erro: não é possível dividir por zero.");
            return 0;
        }

        return a / b;
    }
}

