package com.gargeis.DesignPatterns.service.abstracttemplates;

import com.gargeis.DesignPatterns.enums.TransferenciaStatusEnum;
import com.gargeis.DesignPatterns.model.Conta;
import com.gargeis.DesignPatterns.service.interfaces.ProcessoDeTransferencia;

import java.math.BigDecimal;
import java.util.List;

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

        protected abstract void verificaContas (Conta fonte, Conta destino);

        protected abstract void verificaSaldo (Conta fonte, BigDecimal valor);

        protected abstract TransferenciaStatusEnum realizarTransferenciaDeFato(Conta fonte, Conta destino, BigDecimal valor, List<ProcessoDeTransferencia> processos);

    }
