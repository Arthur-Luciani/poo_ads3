package com.br.ifsc.pousada.controller;

import com.br.ifsc.pousada.domain.pousada.PousadaEntity;
import com.br.ifsc.pousada.domain.pousada.PousadaService;
import com.br.ifsc.pousada.domain.quarto.QuartoEntity;
import com.br.ifsc.pousada.domain.quarto.TipoQuarto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class PousadaController extends AbstractController {

    @Autowired
    private PousadaService pousadaService;

    @Autowired
    private Scanner scanner;

    public void createPousada() {
        System.out.println("========== CRIAÇÃO DE POUSADA ==========");
        var pousada = new PousadaEntity();
        System.out.println("Nome: ");
        pousada.setNome(scanner.nextLine());
        super.executeWithExceptionHandler(() -> pousadaService.create(pousada))
                .ifPresent(System.out::println);
        System.out.println("========================================");
    }

    public void createQuarto() {
        System.out.println("=========== ADIÇÃO DE QUARTO ===========");
        System.out.println("Informe o nome da pousada: ");
        var pousadaNome = scanner.nextLine();
        var quarto = new QuartoEntity();
        System.out.println("Número do quarto");
        quarto.setNumero(readString());
        System.out.println("Tipo do quarto: ");
        List.of(TipoQuarto.values()).forEach(t -> System.out.println(t.getValue() + " - " + t));
        quarto.setTipoQuarto(TipoQuarto.fromValue(readInt()));
        System.out.println("Valor da diária");
        quarto.setValorDiaria(readFloat());
        super.executeWithExceptionHandler(() -> pousadaService.createQuarto(pousadaNome, quarto))
                .ifPresent(System.out::println);
        System.out.println("========================================");
    }

    public void listPousada() {
        System.out.println("=========== LISTAR POUSADAS ============");
        pousadaService.findAll().forEach(System.out::println);
    }
}
