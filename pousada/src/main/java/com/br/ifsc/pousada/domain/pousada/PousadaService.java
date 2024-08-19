package com.br.ifsc.pousada.domain.pousada;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PousadaService {


    @Autowired
    private PousadaRepository repository;

    public PousadaEntity create(PousadaEntity pousada) {
        return repository.save(pousada);
    }

    public PousadaEntity update(PousadaEntity pousada) {
        var updatedPousada = repository.findById(pousada.getId()).orElseThrow(() -> new IllegalArgumentException("Pousada não encontrada"));
        updatedPousada = pousada;
        return repository.save(updatedPousada);
    }

    public void delete(UUID uuid) {
        var pousada = repository.findById(uuid).orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));
        try {
            repository.delete(pousada);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("Não foi possível deletar a pousada " + pousada.getNome());
        }
    }
}
