package com.gargeis.DesignPatterns.service;

import com.gargeis.DesignPatterns.enums.TransferenciaStatusEnum;
import com.gargeis.DesignPatterns.model.Conta;
import com.gargeis.DesignPatterns.model.DadosDashboard;
import com.gargeis.DesignPatterns.model.dto.DadosDashboardDTO;
import com.gargeis.DesignPatterns.model.dto.DadosTransferenciaDTO;
import com.gargeis.DesignPatterns.repository.ContaRepository;
import com.gargeis.DesignPatterns.repository.DashboardRepository;
import com.gargeis.DesignPatterns.repository.TransferenciaRepository;
import com.gargeis.DesignPatterns.service.abstracttemplates.RotinaDeTransferencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class DashboardService {

    @Autowired
    private DashboardRepository dashboardRepository;

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private TransferenciaRepository transferenciaRepository;

    public DadosDashboard buscarDados() {
        DadosDashboard dados = null;
        try {
            dados = dashboardRepository.findById(1).get();
        } catch (Exception e) {
            return dashboardRepository.save(DadosDashboard.builder()
                    .quantidadeContas(0)
                    .saldo(BigDecimal.ZERO)
                    .build());
        }
        return dados;
    }

    public DadosDashboardDTO buscarRelatorioDashboard(){
        DadosDashboard dadosDashboard = buscarDados();
        List<Conta> contas = buscarContas();
        return new DadosDashboardDTO(dadosDashboard, contas);
    }

    public Conta cadastrarConta(Conta conta) {
        Conta contaSalva = contaRepository.save(conta);

        atualizarDadosDaDashboard(contaSalva);

        return contaSalva;
    }

    public List<Conta> buscarContas() {
        return contaRepository.findAll();
    }

    private void atualizarDadosDaDashboard(Conta conta) {
        DadosDashboard dados = this.buscarDados();

        dados.setQuantidadeContas(dados.getQuantidadeContas() + 1);

        dados.setSaldo(dados.getSaldo().add(conta.getSaldo()));

        dashboardRepository.save(dados);
    }


    public TransferenciaStatusEnum transferir(DadosTransferenciaDTO dados) {

        RotinaDeTransferencia ted = new TED();

        return ted.realizarTransferencia(contaRepository.findById(dados.getIdFonte()).get(), contaRepository.findById(dados.getIdDestino()).get(), dados.getValor(), new ArrayList<>());
    }
}
