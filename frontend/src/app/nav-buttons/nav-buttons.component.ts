import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-nav-buttons',
  templateUrl: './nav-buttons.component.html',
  styleUrls: ['./nav-buttons.component.css'],
})
export class NavButtonsComponent {

  @Output()
  profileEvent = new EventEmitter<string>();
  goToProfileEvent(value: string) {
    this.profileEvent.emit(value);
    console.log(value)
  }
/*
  @Output()
  loanEvent = new EventEmitter<boolean>();
  goToLoanEvent(value: true) {
    this.loanEvent.emit(value);
  }

  @Output()
  penaltyEvent = new EventEmitter<boolean>();
  goToPenaltyEvent(value: true) {
    this.penaltyEvent.emit(value);
  }
  */
}
