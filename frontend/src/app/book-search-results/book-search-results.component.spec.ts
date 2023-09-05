import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BookSearchResultsComponent } from './book-search-results.component';

describe('BookSearchResultsComponent', () => {
  let component: BookSearchResultsComponent;
  let fixture: ComponentFixture<BookSearchResultsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BookSearchResultsComponent]
    });
    fixture = TestBed.createComponent(BookSearchResultsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
