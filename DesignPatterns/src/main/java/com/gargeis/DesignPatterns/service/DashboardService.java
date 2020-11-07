package com.gargeis.DesignPatterns.service;

import com.gargeis.DesignPatterns.model.Conta;
import com.gargeis.DesignPatterns.model.DadosDashboard;
import com.gargeis.DesignPatterns.repository.ContaRepository;
import com.gargeis.DesignPatterns.repository.DashboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class DashboardService {

    @Autowired
    public DashboardRepository dashboardRepository;

    @Autowired
    public ContaRepository contaRepository;

    public DadosDashboard buscarDados() {
        DadosDashboard dados = null;
        try {
                dados = dashboardRepository.findById(1).get();
        } catch (Exception e){
            return dashboardRepository.save(DadosDashboard.builder()
                    .quantidadeContas(0)
                    .saldo(BigDecimal.ZERO)
                    .build());
        }
        return dados;
    }

    public Conta cadastrarConta(Conta conta) {
        Conta contaSalva = contaRepository.save(conta);

        atualizarDadosDaDashboard(contaSalva);

        return contaSalva;
    }

    private void atualizarDadosDaDashboard(Conta conta) {
        DadosDashboard dados = this.buscarDados();

        dados.setQuantidadeContas(dados.getQuantidadeContas() + 1);

        dados.setSaldo(dados.getSaldo().add(conta.getSaldo()));

        dashboardRepository.save(dados);
    }
}
