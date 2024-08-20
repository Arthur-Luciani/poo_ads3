package com.br.ifsc.pousada.domain.quarto;

import com.br.ifsc.pousada.domain.pousada.PousadaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
interface QuartoRepository extends JpaRepository<QuartoEntity, UUID> {

    @Query("SELECT q " +
            "FROM quarto q " +
            "LEFT JOIN reserva r ON q = r.quarto " +
            "JOIN q.pousada p " +
            "WHERE p = :pousada " +
            "AND (r IS NULL OR r.dataEntrada >= :dtFim OR r.dataSaida <= :dtIni)")
    List<QuartoEntity> findAllQuartosEmptyByData(@Param("dtIni") LocalDate dataInicio, @Param("dtFim") LocalDate dataFim, @Param("pousada") PousadaEntity pousada);

    Optional<QuartoEntity> findByNumero(String numero);


}
