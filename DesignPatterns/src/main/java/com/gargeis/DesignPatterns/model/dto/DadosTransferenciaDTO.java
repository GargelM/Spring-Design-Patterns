package com.gargeis.DesignPatterns.model.dto;

import com.gargeis.DesignPatterns.enums.TipoTransferenciaEnum;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class DadosTransferenciaDTO {

    private Integer idFonte;
    private Integer idDestino;
    private BigDecimal valor;
    private TipoTransferenciaEnum tipo;

}
