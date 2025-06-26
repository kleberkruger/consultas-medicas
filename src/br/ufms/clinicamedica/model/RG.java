package br.ufms.clinicamedica.model;

public class RG extends Documento<Integer> {


    @Override
    protected Integer validarNumero(Integer numero) {
        return 0;
    }

    @Override
    protected String getNumeroFormatado() {
        return "";
    }
}
