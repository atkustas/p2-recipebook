import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CocktailImageComponent } from './cocktail-image.component';

describe('CocktailImageComponent', () => {
  let component: CocktailImageComponent;
  let fixture: ComponentFixture<CocktailImageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CocktailImageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CocktailImageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
