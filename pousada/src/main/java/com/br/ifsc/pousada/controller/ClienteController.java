package com.br.ifsc.pousada.controller;

import com.br.ifsc.pousada.domain.cliente.ClienteEntity;
import com.br.ifsc.pousada.domain.cliente.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ClienteController extends AbstractController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private Scanner scanner;

    public void createCliente() {
        System.out.println("========== CRIAÇÃO DE CLIENTE ==========");
        var cliente = new ClienteEntity();
        System.out.println("Nome: ");
        cliente.setNome(scanner.nextLine());
        System.out.println("CPF: ");
        cliente.setCpf(scanner.nextLine());
        super.executeWithExceptionHandler(() -> System.out.println(clienteService.create(cliente).toString()));
        System.out.println("========================================");
    }

    public void updateCliente() {
        System.out.println("========== ATUALIZAÇÃO DE CLIENTE ==========");
        System.out.println("Informe o CPF");
        var cliente = super.executeWithExceptionHandler(() -> clienteService.findByCpf(scanner.nextLine()));
        System.out.println(cliente.toString());
        System.out.println("Nome: ");
        cliente.setNome(scanner.nextLine());
        System.out.println("CPF: ");
        cliente.setCpf(scanner.nextLine());
        super.executeWithExceptionHandler(() -> clienteService.update(cliente));
        System.out.println("========================================");
    }

    public void deleteCliente() {
        System.out.println("Deletar Cliente");

        super.executeWithExceptionHandler(() -> clienteService.delete("001"));
    }


}
