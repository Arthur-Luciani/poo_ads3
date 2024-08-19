package com.br.ifsc.pousada.controller;

import java.util.function.Supplier;

public abstract class AbstractController {

    public void executeWithExceptionHandler(Runnable runnable ) {
        try {
            runnable.run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + "\n");
        }
    }

    public <T> T executeWithExceptionHandler(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + "\n");
            return null; // Or handle the return value appropriately
        }
    }
}
