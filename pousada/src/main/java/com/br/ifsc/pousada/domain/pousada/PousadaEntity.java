package com.br.ifsc.pousada.domain.pousada;

import com.br.ifsc.pousada.domain.quarto.QuartoEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity (name = "pousada")
@Getter
@Setter
public class PousadaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;
    @OneToMany
    private List<QuartoEntity> quartos;
}
