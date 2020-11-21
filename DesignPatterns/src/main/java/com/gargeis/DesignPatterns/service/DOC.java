package com.gargeis.DesignPatterns.service;

import com.gargeis.DesignPatterns.enums.TipoTransferenciaEnum;
import com.gargeis.DesignPatterns.enums.TransferenciaStatusEnum;
import com.gargeis.DesignPatterns.model.Conta;
import com.gargeis.DesignPatterns.repository.ContaRepository;
import com.gargeis.DesignPatterns.service.abstracttemplates.RotinaDeTransferencia;
import com.gargeis.DesignPatterns.service.interfaces.ProcessoDeTransferencia;
import com.gargeis.DesignPatterns.service.interfaces.impl.DelayTransferencia;
import com.gargeis.DesignPatterns.service.interfaces.impl.MostrarLogDeTransferencia;
import com.gargeis.DesignPatterns.service.interfaces.impl.RegistroTransferencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Component
public class DOC extends RotinaDeTransferencia {
    //bd
    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private RegistroTransferencia registroTransferencia;


    @Override
    protected void verificaContas(Conta fonte, Conta destino) {
        contaRepository.findById(fonte.getId()).orElseThrow(() -> new RuntimeException("Conta Fonte inexistente!"));
        contaRepository.findById(destino.getId()).orElseThrow(() -> new RuntimeException("Conta Destino inexistente"));
    }

    @Override
    protected void verificaSaldo(Conta fonte, BigDecimal valor) {
        if (fonte.getSaldo().compareTo(valor) <= 0) {
            throw new RuntimeException("Saldo inválido!");
        }
    }

    @Override
    protected TransferenciaStatusEnum realizarTransferenciaDeFato(Conta fonte, Conta destino, BigDecimal valor, List<ProcessoDeTransferencia> processos) {
        fonte.setSaldo(fonte.getSaldo().subtract(valor));
        destino.setSaldo(destino.getSaldo().add(valor));


        contaRepository.save(fonte);
        contaRepository.save(destino);


        processos.forEach(processo -> processo.executar(fonte, destino, valor));

        return TransferenciaStatusEnum.OK;
    }

    @Override
    public TipoTransferenciaEnum getTipoTransferencia() {
        return TipoTransferenciaEnum.DOC;
    }

    @Override
    public List<ProcessoDeTransferencia> getProcessos() {
        return Arrays.asList(registroTransferencia, new MostrarLogDeTransferencia(), new DelayTransferencia(15));
    }

}
