import { Component, Input } from '@angular/core';
import { Observable } from 'rxjs';
import { Book } from '../models/book';


@Component({
  selector: 'app-main-board',
  templateUrl: './main-board.component.html',
  styleUrls: ['./main-board.component.css']
})

export class MainBoardComponent {
  @Input() title: Observable<Book[]> | undefined;
items=['PROFILE','LOAN','PENALTY']

buttonSelected = 'PROFILE';

selectComponent(navEvent:string){
 this.buttonSelected=navEvent 
  // console.log(navEvent)
  // console.log('essai')

 
}


}
