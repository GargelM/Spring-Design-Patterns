package com.gargeis.DesignPatterns.service.interfaces;

import com.gargeis.DesignPatterns.enums.TipoTransferenciaEnum;
import com.gargeis.DesignPatterns.service.abstracttemplates.RotinaDeTransferencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


// FACTORY

/**
 *
 * TED ted = new TED();
 * ted.setTransferenciaRepository = new TransferenciaRepository();
 * ted.setlalalalalaRepository = new LALALALALARepository();
 *
 * this.build("TED");
 *
 */
@Component
public class RotinaDeTransferenciaFactory {

    private Map<TipoTransferenciaEnum, RotinaDeTransferencia> tiposDeTransferencia;

    @Autowired
    public RotinaDeTransferenciaFactory(Set<RotinaDeTransferencia> tipos){
        tiposDeTransferencia = new HashMap<>();
        tipos.forEach(tipo -> tiposDeTransferencia.put(tipo.getTipoTransferencia(), tipo));
    }

    public RotinaDeTransferencia build(TipoTransferenciaEnum tipo){
        return tiposDeTransferencia.get(tipo);
    }

}
