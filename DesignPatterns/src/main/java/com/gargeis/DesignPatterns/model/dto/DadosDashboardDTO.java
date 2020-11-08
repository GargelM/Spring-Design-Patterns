package com.gargeis.DesignPatterns.model.dto;

import com.gargeis.DesignPatterns.model.Conta;
import com.gargeis.DesignPatterns.model.DadosDashboard;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DadosDashboardDTO {

    private Integer id;
    private Integer quantidadeContas;
    private BigDecimal saldo;
    private List<Conta> contas;

    public DadosDashboardDTO(DadosDashboard dados, List<Conta> contas){
        this.id = dados.getId();
        this.quantidadeContas = dados.getQuantidadeContas();
        this.saldo = dados.getSaldo();
        this.contas = contas;
    }


}
