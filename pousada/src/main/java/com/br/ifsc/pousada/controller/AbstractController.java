package com.br.ifsc.pousada.controller;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;
import java.util.function.Supplier;

public abstract class AbstractController {

    @Autowired
    private Scanner scanner;

    public void executeWithExceptionHandler(Runnable runnable ) {
        try {
            runnable.run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public <T> T executeWithExceptionHandler(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public int readInt() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Valor informado não esperado");
            return readInt();
        }
    }

    public float readFloat() {
        try{
            return Float.parseFloat(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Valor informado não esperado");
            return readFloat();
        }
    }

    public String readString() {
        try {
            return scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Valor informado não esperado");
            return readString();
        }
    }
}
