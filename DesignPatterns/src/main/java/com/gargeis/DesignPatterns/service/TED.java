package com.gargeis.DesignPatterns.service;

import com.gargeis.DesignPatterns.enums.TransferenciaStatusEnum;
import com.gargeis.DesignPatterns.model.Conta;
import com.gargeis.DesignPatterns.repository.ContaRepository;
import com.gargeis.DesignPatterns.repository.TransferenciaRepository;
import com.gargeis.DesignPatterns.service.abstracttemplates.RotinaDeTransferencia;
import com.gargeis.DesignPatterns.service.interfaces.ProcessoDeTransferencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TED extends RotinaDeTransferencia {

    @Autowired
    private TransferenciaRepository transferenciaRepository;

    @Autowired
    private ContaRepository contaRepository;

    @Override
    protected void verificaContas(Conta fonte, Conta destino) {
        contaRepository.findById(fonte.getId()).orElseThrow(() -> new RuntimeException("Conta Fonte inexistente!"));
        contaRepository.findById(destino.getId()).orElseThrow(() -> new RuntimeException("Conta Destino inexistente"));
    }

    @Override
    protected void verificaSaldo(Conta fonte, BigDecimal valor) {
        if(fonte.getSaldo().compareTo(valor) <= 0){
            throw new RuntimeException("Saldo inválido!");
        }
    }

    @Override
    protected TransferenciaStatusEnum realizarTransferenciaDeFato(Conta fonte, Conta destino, BigDecimal valor, List<ProcessoDeTransferencia> processos) {
        fonte.setSaldo(fonte.getSaldo().subtract(valor));
        destino.setSaldo(destino.getSaldo().add(valor));

        processos.forEach(processo -> processo.executar(fonte, destino, valor));

        return TransferenciaStatusEnum.OK;
    }
}
