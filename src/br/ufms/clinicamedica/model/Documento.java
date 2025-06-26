package br.ufms.clinicamedica.model;

public abstract class Documento<E> {

    protected E numero;

    public E getNumero() {
        return numero;
    }

    public void setNumero(E numero) {
        this.numero = validarNumero(numero);
    }

    protected abstract E validarNumero(E numero);

    protected abstract String getNumeroFormatado();
}
