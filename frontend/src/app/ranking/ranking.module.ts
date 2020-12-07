import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RankingComponent } from './ranking.component';

import { FormsModule } from '@angular/forms';



import {MatButtonModule} from '@angular/material/button';
import { MatDatepickerModule } from '@angular/material/datepicker';
import {MatExpansionModule} from '@angular/material/expansion';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatNativeDateModule } from '@angular/material/core';
import { VideoItemModule } from '../video-item/video-item.module';
import { DataModule } from '../data/data.module';


@NgModule({
  declarations: [RankingComponent],
  imports: [
    CommonModule,
    FormsModule,
    DataModule,
    MatButtonModule,
    MatDatepickerModule,
    MatExpansionModule,
    MatFormFieldModule,
    MatInputModule,
    MatNativeDateModule,
    VideoItemModule
  ],
  exports: [
    DataModule,
    MatButtonModule,
    MatDatepickerModule,
    MatExpansionModule,
    MatFormFieldModule,
    MatInputModule,
    MatNativeDateModule,
    VideoItemModule]
})
export class RankingModule { }
