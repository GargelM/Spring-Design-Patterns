package com.gargeis.DesignPatterns.controller;

import com.gargeis.DesignPatterns.model.dto.DadosDashboardDTO;
import com.gargeis.DesignPatterns.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping
    public ResponseEntity<DadosDashboardDTO> buscarDados() {
        return ResponseEntity.ok(dashboardService.buscarRelatorioDashboard());
    }


}
