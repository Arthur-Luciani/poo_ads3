package com.br.ifsc.pousada.domain.quarto;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class QuartoService {


    @Autowired
    private QuartoRepository repository;

    @Transactional
    public QuartoEntity create(QuartoEntity quarto) {
        return repository.save(quarto);
    }

    @Transactional
    public QuartoEntity update(QuartoEntity quarto) {
        var updatedQuarto = repository.findById(quarto.getId()).orElseThrow(() -> new IllegalArgumentException("Quarto não encontrado"));
        updatedQuarto = quarto;
        return repository.save(updatedQuarto);
    }

    public QuartoEntity findByNumero(String numero) {
        return repository.findByNumero(numero).orElseThrow(() -> new IllegalArgumentException("Quarto não encontrado"));
    }

    @Transactional
    public boolean delete(String numero) {
        var quarto = repository.findByNumero(numero).orElseThrow(() -> new IllegalArgumentException("Quarto não encontrado"));
        try {
            repository.delete(quarto);
            repository.flush();
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("Não foi possível deletar o quarto " + quarto.getNumero());
        }
        return true;
    }

    @Transactional(readOnly = true)
    public List<QuartoEntity> findAll() {
        return repository.findAll();
    }
}
