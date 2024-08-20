package com.br.ifsc.pousada.controller;

import com.br.ifsc.pousada.domain.cliente.ClienteService;
import com.br.ifsc.pousada.domain.quarto.QuartoService;
import com.br.ifsc.pousada.domain.reserva.ReservaService;
import com.br.ifsc.pousada.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ReservaController extends AbstractController {

    @Autowired
    private ReservaService reservaService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private QuartoService quartoService;


    public void createReserva() {
        System.out.println("=========== RESERVAR QUARTO ============");
        System.out.println("CPF do cliente: ");
        var cliente = clienteService.findByCpf(readString());
        System.out.println("Número do quarto");
        var quarto = quartoService.findByNumero(readString());
        System.out.println("Data de entrada: (dd/MM/yyyy)");
        var dataEntrada = DateUtil.getDateFromString(readString());
        System.out.println("Data de saída: (dd/MM/yyyy)");
        var dataSaida = DateUtil.getDateFromString(readString());
        super.executeWithExceptionHandler(() -> reservaService.reservarQuarto(cliente, quarto, dataEntrada, dataSaida)).ifPresent(System.out::println);
        System.out.println("========================================");
    }

    public void cancelarReserva() {
        System.out.println("=========== CANCELAR RESERVA ===========");
        System.out.println("ID da reserva: ");
        var id = (long) readInt();
        super.executeWithExceptionHandler(() -> reservaService.cancelarReserva(id)).ifPresent(o -> System.out.println("Reserva cancelada!"));
        System.out.println("========================================");
    }
}