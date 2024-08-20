package com.br.ifsc.pousada.domain.pousada;

import com.br.ifsc.pousada.domain.quarto.QuartoEntity;
import com.br.ifsc.pousada.domain.quarto.QuartoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class PousadaService {

    @Autowired
    private PousadaRepository repository;

    @Autowired
    private QuartoService quartoService;

    @Transactional
    public PousadaEntity create(PousadaEntity pousada) {
        PousadaEntity result;
        try {
            result = repository.saveAndFlush(pousada);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("Nome já utilizado");
        }
        return result;
    }

    @Transactional
    public QuartoEntity createQuarto(String nomePousada, QuartoEntity quarto) {
        var pousada = repository.findByNome(nomePousada).orElseThrow(() -> new IllegalArgumentException("Pousada não encontrada"));
        quarto.setPousada(pousada);
        var savedQuarto = quartoService.create(quarto);
        pousada.getQuartos().add(savedQuarto);
        repository.save(pousada);
        return savedQuarto;
    }

    @Transactional
    public PousadaEntity update(PousadaEntity pousada) {
        var updatedPousada = repository.findById(pousada.getId()).orElseThrow(() -> new IllegalArgumentException("Pousada não encontrada"));
        updatedPousada = pousada;
        return repository.save(updatedPousada);
    }

    @Transactional
    public boolean delete(UUID uuid) {
        var pousada = repository.findById(uuid).orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));
        try {
            repository.delete(pousada);
            repository.flush();
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("Não foi possível deletar a pousada " + pousada.getNome());
        }
        return true;
    }

    @Transactional(readOnly = true)
    public List<PousadaEntity> findAll() {
        return repository.findAll();
    }
}
