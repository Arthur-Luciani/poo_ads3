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

    public void createCliente() {
        System.out.println("========== CRIAÇÃO DE CLIENTE ==========");
        var cliente = new ClienteEntity();
        System.out.println("Nome: ");
        cliente.setNome(readString());
        System.out.println("CPF: ");
        cliente.setCpf(readString());
        var savedCliente = super.executeWithExceptionHandler(() -> clienteService.create(cliente));
        System.out.println(savedCliente.toString());
        System.out.println("========================================");
    }

    public void updateCliente() {
        System.out.println("======== ATUALIZAÇÃO DE CLIENTE ========");
        System.out.println("Informe o CPF: ");
        try {
            var cliente = clienteService.findByCpf(readString());
            System.out.println(cliente.toString());
            System.out.println("Nome: ");
            cliente.setNome(readString());
            System.out.println("CPF: ");
            cliente.setCpf(readString());
            var updatedCliente = super.executeWithExceptionHandler(() -> clienteService.update(cliente));
            System.out.println(updatedCliente.toString());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        } finally {
            System.out.println("========================================");
        }
    }

    public void deleteCliente() {
        System.out.println("=========== DELETAR CLIENTE ============");
        System.out.println("Informe o CPF: ");
        var cpf = readString();
        super.executeWithExceptionHandler(() -> clienteService.delete(cpf));
        System.out.println("========================================");
    }

}
