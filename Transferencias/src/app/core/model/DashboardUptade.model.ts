import { Conta } from './Conta.model';

export class DashboardUpdate {
    public id: number;
    public quantidadeContas: number;
    public saldo: number;
    public contas: Conta[];
}