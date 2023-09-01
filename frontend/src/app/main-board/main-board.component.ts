import { Component } from '@angular/core';


@Component({
  selector: 'app-main-board',
  templateUrl: './main-board.component.html',
  styleUrls: ['./main-board.component.css']
})

export class MainBoardComponent {
  items=['PROFILE','LOAN','PENALTY']
    buttonSelected = 'PROFILE';

  selectComponent(navEvent:string){
    this.buttonSelected=navEvent
    // console.log(navEvent)
    // console.log('essai')
  }
}
