package com.gargeis.DesignPatterns.service.interfaces.impl;

import com.gargeis.DesignPatterns.model.Conta;
import com.gargeis.DesignPatterns.model.Transferencia;
import com.gargeis.DesignPatterns.repository.TransferenciaRepository;
import com.gargeis.DesignPatterns.service.interfaces.ProcessoDeTransferencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
public class RegistroTransferencia implements ProcessoDeTransferencia {

    @Autowired
    private TransferenciaRepository transferenciaRepository;

    @Override
    public void executar(Conta fonte, Conta destino, BigDecimal valor) {
        this.transferenciaRepository.save(Transferencia.builder().fonte(fonte).destino(destino).valor(valor).datahora(LocalDateTime.now()).build());
    }
}
