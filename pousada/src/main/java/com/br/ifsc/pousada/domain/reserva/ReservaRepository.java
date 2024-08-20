package com.br.ifsc.pousada.domain.reserva;

import com.br.ifsc.pousada.domain.quarto.QuartoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
interface ReservaRepository extends JpaRepository<ReservaEntity, Long> {

    @Query("SELECT CASE WHEN COUNT(r) > 0 THEN FALSE ELSE TRUE END " +
            "FROM reserva r " +
            "WHERE r.quarto = :quarto " +
            "AND (:dtIni BETWEEN r.dataEntrada AND r.dataSaida " +
            "OR :dtFim BETWEEN r.dataEntrada AND r.dataSaida) ")
    Boolean isQuartoEmpty(@Param("dtIni") LocalDate dataInicio, @Param("dtFim") LocalDate dataFim, @Param("quarto") QuartoEntity quarto);

}
