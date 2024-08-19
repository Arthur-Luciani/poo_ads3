package com.br.ifsc.pousada.domain.quarto;

import com.br.ifsc.pousada.controller.Domains;

public enum TipoQuarto {
    BASICO(1),
    SUPERIOR(2),
    PREMIUM(3);

    private final int value;

    TipoQuarto(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static TipoQuarto fromValue(int value) {
        for (TipoQuarto tipoQuarto : TipoQuarto.values()) {
            if (tipoQuarto.getValue() == value) {
                return tipoQuarto;
            }
        }
        throw new IllegalArgumentException("Valor inesperado: " + value);
    }
}
