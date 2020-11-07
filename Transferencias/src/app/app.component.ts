import { Component, OnInit } from '@angular/core';
import { DashboardUpdate } from './core/model/DashboardUptade.model';
import { DashboardService } from './core/service/dashboard.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  public dashboardDados: DashboardUpdate;

  ngOnInit() {
    setInterval(() => {
      this.buscarDados();
    }, 1000);
  }

  constructor(private dashboardService: DashboardService){

  }

  buscarDados(){
    this.dashboardService.buscarDadosDashboard().subscribe(response => {
      this.dashboardDados = response;
    });
  }


}
