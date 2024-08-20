package com.br.ifsc.pousada.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApplicationController extends AbstractController {

    @Autowired
    private ClienteController clienteController;

    @Autowired
    private PousadaController pousadaController;

    @Autowired
    private QuartoController quartoController;

    @Autowired
    private ReservaController reservaController;

    public void start() {
        do {
            System.out.println("============ MENU PRINCIPAL ============");
            System.out.println("1 - Gerenciar clientes");
            System.out.println("2 - Gerenciar pousadas");
            System.out.println("3 - Gerenciar quartos");
            System.out.println("4 - Gerenciar reservas");
            System.out.println("5 - Finalizar execução");
            var result = readInt();
            if (result == 5) {
                return;
            }
            menus(Domains.fromValue(result));
        } while (true);
    }

    private void menus(Domains domains) {
        switch (domains) {
            case CLIENTE -> clienteMenu();
            case POUSADA -> pousadaMenu();
            case QUARTO -> quartoMenu();
            case RESERVA -> reservaMenu();
        }

    }

    private void clienteMenu() {
        System.out.println("========== GERENCIAR CLIENTES ==========");
        System.out.println("1 - Criar cliente");
        System.out.println("2 - Atualizar cliente");
        System.out.println("3 - Deletar cliente");
        var result = readInt();
        switch (result) {
            case 1 -> clienteController.createCliente();
            case 2 -> clienteController.updateCliente();
            case 3 -> clienteController.deleteCliente();
        }
    }

    private void pousadaMenu() {
        System.out.println("========== GERENCIAR POUSADAS ==========");
        System.out.println("1 - Criar pousada");
        System.out.println("2 - Adicionar quarto");

        var result = readInt();
        switch (result) {
            case 1 -> pousadaController.createPousada();
            case 2 -> pousadaController.createQuarto();
        }
    }

    private void quartoMenu() {
        System.out.println("========== GERENCIAR QUARTOS ===========");
        System.out.println("1 - Atualizar quarto");
        System.out.println("2 - Deletar quarto");

        var result = readInt();
        switch (result) {
            case 1 -> quartoController.updateQuarto();
            case 2 -> quartoController.deleteQuarto();
        }
    }

    private void reservaMenu() {
        System.out.println("========== GERENCIAR RESERVAS ==========");
        System.out.println("1 - Reservar quarto");
        System.out.println("2 - Cancelar reserva");

        var result = readInt();
        switch (result) {
            case 1 -> reservaController.createReserva();
            case 2 -> reservaController.cancelarReserva();
        }
    }
}
