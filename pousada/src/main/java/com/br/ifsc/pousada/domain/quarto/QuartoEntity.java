package com.br.ifsc.pousada.domain.quarto;

import com.br.ifsc.pousada.domain.pousada.PousadaEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity (name = "quarto")
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
}
