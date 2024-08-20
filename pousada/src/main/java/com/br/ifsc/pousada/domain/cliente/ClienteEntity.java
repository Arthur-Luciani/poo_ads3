package com.br.ifsc.pousada.domain.cliente;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity(name = "cliente")
@Getter
@Setter
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"cpf"}))
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;
    private String cpf;

    @Override
    public String toString() {
        return "============ DADOS CLIENTE =============\n" + //
                "ID: " + id.toString() + "\n" + //
                "Nome: " + nome + "\n" + //
                "CPF: " + cpf + "\n" + //
                "========================================";
    }
}
