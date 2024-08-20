package com.br.ifsc.pousada.domain.reserva;

import com.br.ifsc.pousada.domain.cliente.ClienteEntity;
import com.br.ifsc.pousada.domain.quarto.QuartoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository repository;

    public ReservaEntity reservarQuarto(ClienteEntity cliente, QuartoEntity quarto, LocalDate dtInicio, LocalDate dtFim) {
        if (!repository.isQuartoEmpty(dtInicio, dtFim, quarto)) {
            throw new IllegalArgumentException("Quarto não está disponível para reservas");
        }
        var reserva = new ReservaEntity();
        reserva.setQuarto(quarto);
        reserva.setCliente(cliente);
        reserva.setDataEntrada(dtInicio);
        reserva.setDataSaida(dtFim);
        reserva.setValor(quarto.getValorDiaria() * ChronoUnit.DAYS.between(dtInicio, dtFim));
        return repository.save(reserva);
    }

    public boolean cancelarReserva(Long id) {
        var reserva = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Não foi possível localizar a reserva"));
        if (reserva.getDataEntrada().isAfter(LocalDate.now().minusDays(3))) {
            throw new IllegalArgumentException("Não é possível cancelar a reserva. O cancelamento deve ocorrer com no mínimo três dias de antecedência");
        }
        try {
            repository.delete(reserva);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("Não foi possível cancelar a reserva " + reserva.getId());
        }
        return true;
    }

}
