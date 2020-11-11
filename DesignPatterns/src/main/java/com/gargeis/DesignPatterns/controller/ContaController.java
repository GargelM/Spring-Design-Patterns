package com.gargeis.DesignPatterns.controller;

import com.gargeis.DesignPatterns.enums.TransferenciaStatusEnum;
import com.gargeis.DesignPatterns.model.Conta;
import com.gargeis.DesignPatterns.model.Transferencia;
import com.gargeis.DesignPatterns.model.dto.DadosTransferenciaDTO;
import com.gargeis.DesignPatterns.service.DashboardService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/conta")
public class ContaController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping
    public ResponseEntity<List<Conta>> buscarConta(){
        return ResponseEntity.ok(dashboardService.buscarContas());
    }

    @PostMapping
    public ResponseEntity<Conta> cadastrarConta(@RequestBody Conta conta){
        return ResponseEntity.ok(dashboardService.cadastrarConta(conta));
    }

    @PostMapping("/transferencia")
    public ResponseEntity<TransferenciaStatusEnum> transferir(@RequestBody DadosTransferenciaDTO corpo) {
        return ResponseEntity.ok(dashboardService.transferir(corpo));
    }

    @GetMapping("/transferencia")
    public ResponseEntity<List<Transferencia>> buscarTransferenciar(){
        return ResponseEntity.ok(dashboardService.buscarTransferencias());
    }


}
