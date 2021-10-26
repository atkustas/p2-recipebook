import { Favorite } from './favorite';
import { TestBed } from '@angular/core/testing';

describe('Favorite', () => {

  let model: Favorite;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    model = TestBed.inject(Favorite);
  });

  it('should create an instance', () => {
    expect(model).toBeTruthy();
  });
});
