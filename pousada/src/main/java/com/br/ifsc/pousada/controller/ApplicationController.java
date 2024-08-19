package com.br.ifsc.pousada.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApplicationController extends AbstractController {

    @Autowired
    private ClienteController clienteController;

    @Autowired
    private PousadaController pousadaController;

    public void start() {
        do {
            System.out.println("1 - Gerenciar clientes");
            System.out.println("2 - Gerenciar pousadas");
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
        }

    }
    private void clienteMenu() {
        System.out.println("========== GERENCIAR CLIENTES ==========");
        System.out.println("1 - Criar cliente");
        System.out.println("2 - Atualizar cliente");
        System.out.println("3 - Deletar cliente");
        var result = readInt();
        if (result == 1) {
            clienteController.createCliente();
        } else if (result == 2) {
            clienteController.updateCliente();
        } else if (result == 3) {
            clienteController.deleteCliente();
        }
    }

    private void pousadaMenu(){
        System.out.println("========== GERENCIAR POUSADA ==========");
        System.out.println("1 - Criar pousada");
        System.out.println("2 - Criar quarto");

        var result = readInt();
        switch (result) {
            case 1 -> pousadaController.createPousada();
            case 2 -> pousadaController.createQuarto();
        }

    }
}
