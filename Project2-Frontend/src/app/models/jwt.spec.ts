import { Jwt } from './jwt';
import { TestBed } from '@angular/core/testing';

describe('Jwt', () => {

  let model: Jwt;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    model = TestBed.inject(Jwt);
  });

  it('should create an instance', () => {
    expect(model).toBeTruthy();
  });
});