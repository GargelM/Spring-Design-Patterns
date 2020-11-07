import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { DashboardUpdate } from '../model/DashboardUptade.model';

@Injectable({
  providedIn: 'root'
})
export class DashboardService {

  constructor(private http: HttpClient) { }

  public buscarDadosDashboard(): Observable<DashboardUpdate> {
    return this.http.get<DashboardUpdate>('http://localhost/dashboard');
  }

}
