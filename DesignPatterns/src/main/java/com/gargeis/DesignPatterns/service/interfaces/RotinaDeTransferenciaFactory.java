package com.gargeis.DesignPatterns.service.interfaces;

import com.gargeis.DesignPatterns.enums.TipoTransferenciaEnum;
import com.gargeis.DesignPatterns.service.abstracttemplates.RotinaDeTransferencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;



@Component
public class RotinaDeTransferenciaFactory {

    private Map<TipoTransferenciaEnum, RotinaDeTransferencia> tiposDeTransferencia;

    //Atraves dessa anotação, o spring vai injetar as rotinas de transferencia no construtor desta classe
    //atraves de um set de rotina de transferencia ( que ele encontrar no projeto )
    @Autowired
    public RotinaDeTransferenciaFactory(Set<RotinaDeTransferencia> tipos){
        tiposDeTransferencia = new HashMap<>();
        tipos.forEach(tipo -> tiposDeTransferencia.put(tipo.getTipoTransferencia(), tipo));
    }


    public RotinaDeTransferencia build(TipoTransferenciaEnum tipo){
        return tiposDeTransferencia.get(tipo);
    }

}
