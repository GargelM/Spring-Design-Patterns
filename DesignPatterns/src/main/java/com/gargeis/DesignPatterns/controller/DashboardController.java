package com.gargeis.DesignPatterns.controller;

import com.gargeis.DesignPatterns.model.Conta;
import com.gargeis.DesignPatterns.model.DadosDashboard;
import com.gargeis.DesignPatterns.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping
    public ResponseEntity<DadosDashboard> buscarDados(){
        return ResponseEntity.ok(dashboardService.buscarDados());
    }

    @PostMapping("/conta")
    public ResponseEntity<Conta> cadastrarConta(@RequestBody Conta conta){
        return ResponseEntity.ok(dashboardService.cadastrarConta(conta));
    }




}
