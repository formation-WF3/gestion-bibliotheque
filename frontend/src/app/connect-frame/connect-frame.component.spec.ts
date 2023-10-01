import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConnectFrameComponent } from './connect-frame.component';

describe('ConnectFrameComponent', () => {
  let component: ConnectFrameComponent;
  let fixture: ComponentFixture<ConnectFrameComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ConnectFrameComponent]
    });
    fixture = TestBed.createComponent(ConnectFrameComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
