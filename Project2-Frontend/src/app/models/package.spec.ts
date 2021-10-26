import { Package } from './package';
import { TestBed } from '@angular/core/testing';

describe('Package', () => {

  let model: Package;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    model = TestBed.inject(Package);
  });

  it('should create an instance', () => {
    expect(model).toBeTruthy();
  });
});