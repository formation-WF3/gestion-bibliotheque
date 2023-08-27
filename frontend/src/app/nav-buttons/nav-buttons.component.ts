import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-nav-buttons',
  templateUrl: './nav-buttons.component.html',
  styleUrls: ['./nav-buttons.component.css'],
})
export class NavButtonsComponent {

  @Output()
  navEvent = new EventEmitter<string>();
  goToNavEvent(value: string) {
    this.navEvent.emit(value);
    console.log(value)
  }

}
