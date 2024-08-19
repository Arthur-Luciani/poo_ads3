package com.br.ifsc.pousada.application;

import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public Scanner scanner(){
        return new Scanner(System.in);
    }
}
