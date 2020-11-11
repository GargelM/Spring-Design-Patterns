package com.gargeis.DesignPatterns.service.abstracttemplates;

import com.gargeis.DesignPatterns.enums.TipoTransferenciaEnum;
import com.gargeis.DesignPatterns.enums.TransferenciaStatusEnum;
import com.gargeis.DesignPatterns.model.Conta;
import com.gargeis.DesignPatterns.service.interfaces.ProcessoDeTransferencia;

import java.math.BigDecimal;
import java.util.List;

/*
    TEMPLATE METHOD PATTERN

    Consiste em deixar uma fórmula de implementação e assim dar a responsabilidade de implementação para as classes filhas.

    Animal animal = new Cachorro();


    Agua
    coloca na jarra
    empreme o limão
    adiciona açucar
    mistura


    Agua
    colocar na jarra
    espremer limao rosa
    adicionar acucar cristal
    mistura

    TED APROX 30 MIN - TARIFA
    DOC MAIS DEMORADA - TARIFA
    PIX INSTANTANEA - GRATIS

  */
public abstract class RotinaDeTransferencia {

    public TransferenciaStatusEnum realizarTransferencia(Conta fonte, Conta destino, BigDecimal valor, List<ProcessoDeTransferencia> processos) {
        try {
            verificaContas(fonte, destino);
            verificaSaldo(fonte, valor);
            return realizarTransferenciaDeFato(fonte, destino, valor, processos);
        } catch (RuntimeException e) {
            return TransferenciaStatusEnum.ERRO_GENERICO;
        }
    }

    protected abstract void verificaContas(Conta fonte, Conta destino);

    protected abstract void verificaSaldo(Conta fonte, BigDecimal valor);

    protected abstract TransferenciaStatusEnum realizarTransferenciaDeFato(Conta fonte, Conta destino, BigDecimal valor, List<ProcessoDeTransferencia> processos);

    public abstract TipoTransferenciaEnum getTipoTransferencia();

    public abstract List<ProcessoDeTransferencia> getProcessos();

}
