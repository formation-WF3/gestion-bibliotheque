import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PenaltyTabComponent } from './penalty-tab.component';

describe('PenaltyTabComponent', () => {
  let component: PenaltyTabComponent;
  let fixture: ComponentFixture<PenaltyTabComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PenaltyTabComponent]
    });
    fixture = TestBed.createComponent(PenaltyTabComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
