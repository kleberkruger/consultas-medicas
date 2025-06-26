package br.ufms.clinicamedica.view;

import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

public class Menu {

    private static final Scanner scanner = new Scanner(System.in);
    private static final int LARGURA_MINIMA = 40;

    public static int exibir(String titulo, Map<Integer, String> opcoes) {
        while (true) {
            imprimirMenu(titulo, opcoes);
            System.out.print("Escolha uma opção: ");
            String entrada = scanner.nextLine();

            if (entrada.matches("\\d+")) {
                int opc = Integer.parseInt(entrada);
                if (opcoes.containsKey(opc)) {
                    return opc;
                }
            }
            System.out.println("\u001B[31mOpção inválida. Tente novamente.\u001B[0m\n");
        }
    }

    public static void imprimirCabecalho(String titulo, int largura) {
        String borda = repetir("═", largura);
        System.out.println("╔" + borda + "╗");
        System.out.println("║" + centralizar(titulo, largura) + "║");
        System.out.println("╚" + borda + "╝");
    }

    public static String lerCampo(String nomeCampo, Function<String, Boolean> validador) {
        while (true) {
            System.out.print("║ " + nomeCampo + ": ");
            String entrada = scanner.nextLine();

            if (validador.apply(entrada)) {
                return entrada;
            } else {
                System.out.println("║\u001B[31m Valor inválido. Tente novamente.\u001B[0m");
            }
        }
    }

    private static void imprimirMenu(String titulo, Map<Integer, String> opcoes) {
        int largura = Math.max(calcularLargura(titulo, opcoes), LARGURA_MINIMA);

        String borda = repetir("═", largura);
        System.out.println("╔" + borda + "╗");
        System.out.println("║" + centralizar(titulo, largura) + "║");
        System.out.println("╠" + borda + "╣");

        opcoes.entrySet().stream()
                .sorted(Comparator.comparingInt(e -> e.getKey() == 0 ? Integer.MAX_VALUE : e.getKey()))
                .forEach(entrada -> {
                    String linha = String.format("%d. %s", entrada.getKey(), entrada.getValue());
                    System.out.println("║" + ajustarEspaco(linha, largura) + "║");
                });

        System.out.println("╚" + borda + "╝");
    }

    private static int calcularLargura(String titulo, Map<Integer, String> opcoes) {
        int largura = titulo.length();
        for (var entrada : opcoes.entrySet()) {
            int tam = String.format("%d. %s", entrada.getKey(), entrada.getValue()).length();
            if (tam > largura) largura = tam;
        }
        return largura + 2; // espaço extra para margens internas
    }

    private static String ajustarEspaco(String texto, int largura) {
        int espacos = largura - texto.length();
        return " " + texto + repetir(" ", espacos - 1); // -1, pois já adicionamos um espaço no início
    }

    private static String centralizar(String texto, int largura) {
        int total = largura - texto.length();
        int left = total / 2;
        int right = total - left;
        return repetir(" ", left) + texto + repetir(" ", right);
    }

    private static String repetir(String s, int n) {
        return s.repeat(Math.max(0, n));
    }
}
