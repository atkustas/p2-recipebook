import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CocktailComponentsComponent } from './cocktail-components.component';

describe('CocktailComponentsComponent', () => {
  let component: CocktailComponentsComponent;
  let fixture: ComponentFixture<CocktailComponentsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CocktailComponentsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CocktailComponentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
