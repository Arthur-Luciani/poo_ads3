package com.br.ifsc.pousada.domain.reserva;

import com.br.ifsc.pousada.domain.cliente.ClienteEntity;
import com.br.ifsc.pousada.domain.quarto.QuartoEntity;
import com.br.ifsc.pousada.util.DateUtil;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity(name = "reserva")
@Getter
@Setter
public class ReservaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "quarto_id")
    private QuartoEntity quarto;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteEntity cliente;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    private Float valor;

    @Override
    public String toString() {
        return "\"============ DADOS RESERVA =============\n" + //
                "ID: " + id.toString() + "\n" + //
                "Cliente: " + cliente.getCpf() + "\n" + //
                "Quarto: " + quarto.getNumero() + "\n" + //
                "Valor: R$" + valor + "\n" + //
                "Data entrada: " + DateUtil.getStringFromDate(dataEntrada) + "\n" + //
                "Data saída: " + DateUtil.getStringFromDate(dataSaida) + "\n" + //
                "========================================";
    }
}
