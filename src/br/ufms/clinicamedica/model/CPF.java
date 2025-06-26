package br.ufms.clinicamedica.model;

public class CPF extends Documento<String> {

    @Override
    protected String validarNumero(String numero) {
        return numero;
    }

    @Override
    protected String getNumeroFormatado() {
        return numero;
    }
}
