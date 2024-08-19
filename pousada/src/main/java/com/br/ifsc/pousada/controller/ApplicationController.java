package com.br.ifsc.pousada.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ApplicationController {

    @Autowired
    private Scanner scanner;

    @Autowired
    private ClienteController clienteController;

    public void start() {
        do {
            System.out.println("1 - Gerenciar clientes");
            System.out.println("2 - Fazer outra coisa");
            System.out.println("5 - Finalizar execução");
            var result = Integer.parseInt(scanner.nextLine());
            if (result == 5) {
                return;
            }
            menus(Domains.fromValue(result));
        } while (true);
    }

    private void menus(Domains domains) {
        switch (domains) {
            case CLIENTE -> clienteMenu();
        }

    }

    private void clienteMenu() {
        System.out.println("1 - Criar cliente");
        System.out.println("2 - Atualizar cliente");
        System.out.println("3 - Deletar cliente");
        var result = Integer.parseInt(scanner.nextLine());
        if (result == 1) {
            clienteController.createCliente();
        } else if (result == 2) {
            clienteController.updateCliente();
        } else if (result == 3) {
            clienteController.deleteCliente();
        }
    }
}
