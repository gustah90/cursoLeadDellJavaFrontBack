import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SegundoComponentComponent } from './segundo-component.component';

describe('SegundoComponentComponent', () => {
  let component: SegundoComponentComponent;
  let fixture: ComponentFixture<SegundoComponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SegundoComponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SegundoComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
