import { Component, OnInit } from '@angular/core';
import { StorageService } from '../_services/storage.service';


@Component({
  selector: 'app-main-board',
  templateUrl: './main-board.component.html',
  styleUrls: ['./main-board.component.css']
})

export class MainBoardComponent implements OnInit {
isLoggedIn = false;
items=['PROFILE','LOAN','PENALTY']

buttonSelected = 'PROFILE';
constructor(private storageService: StorageService) { }

selectComponent(navEvent:string){
 this.buttonSelected=navEvent 
  // console.log(navEvent)
  // console.log('essai')

  }
  ngOnInit(): void {
    this.isLoggedIn = this.storageService.isLoggedIn();

   
    }
}
