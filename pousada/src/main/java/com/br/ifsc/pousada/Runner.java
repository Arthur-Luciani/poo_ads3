package com.br.ifsc.pousada;

import com.br.ifsc.pousada.controller.ApplicationController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {
    @Autowired
    private ApplicationController controller;

    @Override
    public void run(String... args) throws Exception {
        controller.start();
    }
}

