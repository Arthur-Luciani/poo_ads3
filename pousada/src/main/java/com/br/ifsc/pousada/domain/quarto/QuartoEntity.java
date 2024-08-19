package com.br.ifsc.pousada.domain.quarto;

import com.br.ifsc.pousada.domain.pousada.PousadaEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity(name = "quarto")
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"numero"}))
@Getter
@Setter
public class QuartoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String numero;
    @Enumerated(EnumType.STRING)
    private TipoQuarto tipoQuarto;
    @ManyToOne
    @JoinColumn(name = "pousada_id")
    private PousadaEntity pousada;
    private Float valorDiaria;

    @Override
    public String toString() {
        return "\"============ DADOS QUARTO ============\n" + //
                "ID: " + id.toString() + "\n" + //
                "Nome: " + numero + "\n" + //
                "CPF: " + tipoQuarto.toString() + "\n" + //
                "Valor diária: R$" + valorDiaria + "\n" + //
                "========================================";
    }
}
