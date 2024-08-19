package com.br.ifsc.pousada.domain.reserva;

import com.br.ifsc.pousada.domain.cliente.ClienteEntity;
import com.br.ifsc.pousada.domain.quarto.QuartoEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity (name = "reserva")
@Getter
@Setter
public class ReservaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "quarto_id")
    private QuartoEntity quarto;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteEntity cliente;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    private Float valor;
}
