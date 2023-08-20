import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SmallContainerComponent } from './small-container.component';

describe('SmallContainerComponent', () => {
  let component: SmallContainerComponent;
  let fixture: ComponentFixture<SmallContainerComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SmallContainerComponent]
    });
    fixture = TestBed.createComponent(SmallContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
