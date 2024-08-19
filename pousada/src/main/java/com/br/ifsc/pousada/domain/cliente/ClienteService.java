package com.br.ifsc.pousada.domain.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public ClienteEntity create(ClienteEntity cliente) {
        return repository.save(cliente);
    }

    public ClienteEntity update(ClienteEntity cliente) {
        var updatedCliente = repository.findById(cliente.getId()).orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));
        updatedCliente = cliente;
        return repository.save(updatedCliente);
    }

    public void delete(String cpf) {
        var cliente = repository.findByCpf(cpf).orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));
        try {
            repository.delete(cliente);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("Não foi possível deletar o cliente " + cliente.getNome());
        }
    }

    public ClienteEntity findByCpf(String cpf) {
        return repository.findByCpf(cpf).orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));
    }
}
