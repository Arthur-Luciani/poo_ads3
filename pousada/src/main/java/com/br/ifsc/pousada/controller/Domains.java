package com.br.ifsc.pousada.controller;

public enum Domains {
    CLIENTE(1),
    POUSADA(2),
    QUARTO(3),
    RESERVA(4);

    private final int value;

    Domains(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Domains fromValue(int value) {
        for (Domains domain : Domains.values()) {
            if (domain.getValue() == value) {
                return domain;
            }
        }
        throw new IllegalArgumentException("Valor inesperado: " + value);
    }

}
