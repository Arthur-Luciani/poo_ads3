package com.br.ifsc.pousada.domain.reserva;

import com.br.ifsc.pousada.domain.pousada.PousadaEntity;
import com.br.ifsc.pousada.domain.quarto.QuartoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
interface ReservaRepository extends JpaRepository<ReservaEntity, UUID> {

    @Query("SELECT r.quarto " +
            "FROM reserva r " +
            "WHERE r.quarto = quarto ")
    boolean isQuartoEmpty(@Param("dtIni") LocalDate dataInicio, @Param("dtFim") LocalDate dataFim, @Param("quarto") QuartoEntity quarto);
}
