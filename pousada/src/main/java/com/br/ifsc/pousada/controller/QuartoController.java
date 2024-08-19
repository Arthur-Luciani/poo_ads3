package com.br.ifsc.pousada.controller;

import com.br.ifsc.pousada.domain.quarto.QuartoService;
import com.br.ifsc.pousada.domain.quarto.TipoQuarto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QuartoController extends AbstractController {

    @Autowired
    private QuartoService quartoService;

    public void updateQuarto() {
        System.out.println("======== ATUALIZAÇÃO DE QUARTO =========");
        System.out.println("Número do quarto");
        try {
            var quarto = quartoService.findByNumero(readString());
            System.out.println(quarto.toString());
            System.out.println("Tipo do quarto: ");
            List.of(TipoQuarto.values()).forEach(t -> System.out.println(t.getValue() + " - " + t));
            quarto.setTipoQuarto(TipoQuarto.fromValue(readInt()));
            System.out.println("Valor da diária");
            quarto.setValorDiaria(readFloat());
            var updatedQuarto = super.executeWithExceptionHandler(() -> quartoService.update(quarto));
            System.out.println(updatedQuarto.toString());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("========================================");
        }
    }

    public void deleteQuarto() {
        System.out.println("============ DELETAR QUARTO ============");
        System.out.println("Informe o número: ");
        var numero = readString();
        super.executeWithExceptionHandler(() -> quartoService.delete(numero));
        System.out.println("========================================");
    }
}
