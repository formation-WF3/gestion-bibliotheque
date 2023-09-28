import { Component, OnInit } from '@angular/core';
import { Loan } from '../models/Loan';
import { LoanService } from '../_services/loan.service';

@Component({
  selector: 'app-list-loan',
  templateUrl: './list-loan.component.html',
  styleUrls: ['./list-loan.component.css']
})
export class ListLoanComponent implements OnInit {

listLoans: Loan[] = [];

constructor(  
  private loanService: LoanService,
)
 {}

  ngOnInit(): void {
  
    this.loanService.getAll().subscribe(listLoans => this.listLoans = listLoans );
    console.log(this.listLoans);
  }
  

}
