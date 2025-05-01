package br.ufms.clinicamedica;

public class Main {

    public static void main(String[] args) {
        try {
            Secretario secretario = new Secretario("Kleber Kruger", "12345678909", -30000);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
}
