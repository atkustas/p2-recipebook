import { User } from './user';
import { TestBed } from '@angular/core/testing';

describe('User', () => {

  let model: User;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    model = TestBed.inject(User);
  });

  it('should create an instance', () => {
    expect(model).toBeTruthy();
  });
});