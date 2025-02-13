import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { VideoItemComponent } from './video-item.component';

import {MatCardModule} from '@angular/material/card';
import {MatIconModule} from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { FormatDatePipe } from './format-date.pipe';
import { RouterModule } from '@angular/router';



@NgModule({
  declarations: [VideoItemComponent, FormatDatePipe],
  imports: [
    CommonModule,
    MatCardModule,
    MatIconModule,
    MatListModule,
    RouterModule
  ],
  exports: [MatListModule, MatCardModule, VideoItemComponent, MatIconModule, FormatDatePipe]
})
export class VideoItemModule { }
