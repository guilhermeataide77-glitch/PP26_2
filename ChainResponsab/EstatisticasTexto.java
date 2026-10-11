import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// 1. Interface do Handler (Elo da Corrente)
interface CaractereHandler {
    void setProximo(CaractereHandler proximo);
    void processar(char c);
    void exibirEstatisticas();
}

// 2. Handler Concreto para Espaços
class EspacoHandler implements CaractereHandler {
    private CaractereHandler proximo;
    private int contador = 0;

    @Override
    public void setProximo(CaractereHandler proximo) {
        this.proximo = proximo;
    }

    @Override
    public void processar(char c) {
        if (c == ' ') {
            contador++;
        } else if (proximo != null) {
            proximo.processar(c);
        }
    }

    @Override
    public void exibirEstatisticas() {
        System.out.println("a) Número de espaços: " + contador);
        if (proximo != null) {
            proximo.exibirEstatisticas();
        }
    }
}

// 3. Handler Concreto para a letra 'a' (considerando minúscula e maiúscula)
class LetraAHandler implements CaractereHandler {
    private CaractereHandler proximo;
    private int contador = 0;

    @Override
    public void setProximo(CaractereHandler proximo) {
        this.proximo = proximo;
    }

    @Override
    public void processar(char c) {
        if (c == 'a' || c == 'A') {
            contador++;
        } else if (proximo != null) {
            proximo.processar(c);
        }
    }

    @Override
    public void exibirEstatisticas() {
        System.out.println("b) Número de letras 'a' (e 'A'): " + contador);
        if (proximo != null) {
            proximo.exibirEstatisticas();
        }
    }
}

// 4. Handler Concreto para Pontos
class PontoHandler implements CaractereHandler {
    private CaractereHandler proximo;
    private int contador = 0;

    @Override
    public void setProximo(CaractereHandler proximo) {
        this.proximo = proximo;
    }

    @Override
    public void processar(char c) {
        if (c == '.') {
            contador++;
        } else if (proximo != null) {
            proximo.processar(c);
        }
    }

    @Override
    public void exibirEstatisticas() {
        System.out.println("c) Número de pontos: " + contador);
        if (proximo != null) {
            proximo.exibirEstatisticas();
        }
    }
}

// 5. Classe Principal (Main) que gerencia a entrada via linha de comando
public class EstatisticasTexto {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Uso:");
            System.out.println("  Para texto direto: java EstatisticasTexto \"Seu texto aqui com a e .\"");
            System.out.println("  Para arquivo:      java EstatisticasTexto -f caminho_do_arquivo.txt");
            return;
        }

        String texto = "";

        // Verifica se a entrada é um arquivo ou texto direto
        if (args[0].equals("-f") && args.length > 1) {
            texto = lerArquivo(args[1]);
            if (texto == null) return;
        } else {
            // Junta todos os argumentos caso o texto tenha espaços e não esteja entre aspas completas
            StringBuilder sb = new StringBuilder();
            for (String arg : args) {
                sb.append(arg).append(" ");
            }
            texto = sb.toString().trim();
        }

        // Montando a cadeia de responsabilidade: Espaco -> LetraA -> Ponto
        CaractereHandler espacoHandler = new EspacoHandler();
        CaractereHandler letraAHandler = new LetraAHandler();
        CaractereHandler pontoHandler = new PontoHandler();

        espacoHandler.setProximo(letraAHandler);
        letraAHandler.setProximo(pontoHandler);

        // Processa cada caractere do texto passando pela corrente
        for (int i = 0; i < texto.length(); i++) {
            espacoHandler.processar(texto.charAt(i));
        }

        // Exibe os resultados coletados pela corrente
        System.out.println("\n--- Estatísticas do Texto ---");
        espacoHandler.exibirEstatisticas();
    }

    private static String lerArquivo(String caminho) {
        StringBuilder conteudo = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                conteudo.append(linha).append("\n");
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            return null;
        }
        return conteudo.toString();
    }
}