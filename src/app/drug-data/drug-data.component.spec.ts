import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DrugDataComponent } from './drug-data.component';

describe('DrugDataComponent', () => {
  let component: DrugDataComponent;
  let fixture: ComponentFixture<DrugDataComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DrugDataComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DrugDataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
