package com.gargeis.DesignPatterns.service.interfaces;

import com.gargeis.DesignPatterns.model.Conta;

import java.math.BigDecimal;

/**
 * OBSERVER
 */
public interface ProcessoDeTransferencia {

    void executar(Conta fonte, Conta destino, BigDecimal valor);

}
