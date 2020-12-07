import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PerVideoComponent } from './per-video.component';

describe('PerVideoComponent', () => {
  let component: PerVideoComponent;
  let fixture: ComponentFixture<PerVideoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PerVideoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PerVideoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
