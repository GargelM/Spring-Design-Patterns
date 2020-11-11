package com.gargeis.DesignPatterns.service.interfaces.impl;

import com.gargeis.DesignPatterns.model.Conta;
import com.gargeis.DesignPatterns.service.interfaces.ProcessoDeTransferencia;

import java.math.BigDecimal;

public class MostrarLogDeTransferencia implements ProcessoDeTransferencia {

    @Override
    public void executar(Conta fonte, Conta destino, BigDecimal valor) {
        System.out.print("Transferência realizada de " + fonte.getTitular() + " para " + destino.getTitular() + " no valor de " + valor);
    }
}
