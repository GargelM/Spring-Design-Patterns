package com.gargeis.DesignPatterns.service.factory;

import com.gargeis.DesignPatterns.model.DadosDashboard;

import java.math.BigDecimal;


public class DadosDashboardFactory {
    public static DadosDashboard buildEmptyObject() {
        return  DadosDashboard.builder()
                .quantidadeContas(0)
                .saldo(BigDecimal.ZERO)
                .build();
    }
}
