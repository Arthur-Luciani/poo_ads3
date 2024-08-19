package com.br.ifsc.pousada.domain.quarto;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

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
    public void delete(String numero) {
        var quarto = repository.findByNumero(numero).orElseThrow(() -> new IllegalArgumentException("Quarto não encontrado"));
        try {
            repository.delete(quarto);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("Não foi possível deletar o quarto " + quarto.getNumero());
        }
    }
}
