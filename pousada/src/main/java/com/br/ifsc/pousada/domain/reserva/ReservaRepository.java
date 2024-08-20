package com.br.ifsc.pousada.domain.reserva;

import com.br.ifsc.pousada.domain.quarto.QuartoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
interface ReservaRepository extends JpaRepository<ReservaEntity, Long> {

    /*@Query("SELECT r.quarto " +
            "FROM reserva r " +
            "WHERE r.quarto = quarto ")
    boolean isQuartoEmpty(@Param("dtIni") LocalDate dataInicio, @Param("dtFim") LocalDate dataFim, @Param("quarto") QuartoEntity quarto);*/

    @Query("SELECT CASE WHEN COUNT(r) > 0 THEN FALSE ELSE TRUE END " +
            "FROM reserva r " +
            "WHERE r.quarto = :quarto " +
            "AND r.dataEntrada <= :dtFim AND r.dataSaida >= :dtIni")
    Boolean isQuartoEmpty(@Param("dtIni") LocalDate dataInicio, @Param("dtFim") LocalDate dataFim, @Param("quarto") QuartoEntity quarto);

}
