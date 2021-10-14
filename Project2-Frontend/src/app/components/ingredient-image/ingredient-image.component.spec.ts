import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IngredientImageComponent } from './ingredient-image.component';

describe('IngredientImageComponent', () => {
  let component: IngredientImageComponent;
  let fixture: ComponentFixture<IngredientImageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ IngredientImageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(IngredientImageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
