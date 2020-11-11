package com.gargeis.DesignPatterns.service.interfaces.impl;

import com.gargeis.DesignPatterns.model.Conta;
import com.gargeis.DesignPatterns.service.interfaces.ProcessoDeTransferencia;

import java.math.BigDecimal;

public class DelayTransferencia implements ProcessoDeTransferencia {

    private final Integer segundos;

    public DelayTransferencia(Integer segundos){
        this.segundos = segundos;
    }

    @Override
    public void executar(Conta fonte, Conta destino, BigDecimal valor) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
