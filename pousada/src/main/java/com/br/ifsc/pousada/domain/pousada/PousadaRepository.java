package com.br.ifsc.pousada.domain.pousada;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
interface PousadaRepository extends JpaRepository<PousadaEntity, UUID> {

    Optional<PousadaEntity> findByNome(String nome);
}
