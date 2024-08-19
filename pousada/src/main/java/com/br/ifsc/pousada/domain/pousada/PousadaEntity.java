package com.br.ifsc.pousada.domain.pousada;

import com.br.ifsc.pousada.domain.quarto.QuartoEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Entity (name = "pousada")
@Getter
@Setter
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"nome"}))
public class PousadaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;
    @OneToMany
    private Set<QuartoEntity> quartos;

    @Override
    public String toString() {
        return "\"============ DADOS POUSADA =============\n" + //
                "ID: " + id.toString() + "\n" + //
                "Nome: " + nome + "\n" + //
                "========================================";
    }
}
