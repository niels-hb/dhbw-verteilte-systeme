import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { PerVideoComponent } from './per-video.component';
import { VideoItemModule } from '../video-item/video-item.module';
import { DataModule } from '../data/data.module';
import {MatExpansionModule} from '@angular/material/expansion';
import { MatInputModule } from '@angular/material/input';



@NgModule({
  declarations: [PerVideoComponent],
  imports: [
    CommonModule,
    DataModule,
    FormsModule,
    MatExpansionModule,
    MatInputModule,
    VideoItemModule
  ],
  exports: [DataModule, MatExpansionModule, VideoItemModule]
})
export class PerVideoModule { }
