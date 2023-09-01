import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ValidationButtonsComponent } from './validation-buttons.component';

describe('ValidationButtonsComponent', () => {
  let component: ValidationButtonsComponent;
  let fixture: ComponentFixture<ValidationButtonsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ValidationButtonsComponent]
    });
    fixture = TestBed.createComponent(ValidationButtonsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
