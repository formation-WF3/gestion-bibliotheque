import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListLoanComponent } from './list-loan.component';

describe('ListLoanComponent', () => {
  let component: ListLoanComponent;
  let fixture: ComponentFixture<ListLoanComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ListLoanComponent]
    });
    fixture = TestBed.createComponent(ListLoanComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
