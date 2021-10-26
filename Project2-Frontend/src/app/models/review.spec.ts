import { Review } from './review';
import { TestBed } from '@angular/core/testing';

describe('Review', () => {

  let model: Review;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    model = TestBed.inject(Review);
  });

  it('should create an instance', () => {
    expect(model).toBeTruthy();
  });
});