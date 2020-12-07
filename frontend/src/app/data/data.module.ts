import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';

import { DataService } from './data.service';
import { Region } from './region.enum';
import { Trending } from './trending.interface';
import { EnumToArrayPipe } from './enum-to-array.pipe';


@NgModule({
  declarations: [EnumToArrayPipe],
  imports: [
    CommonModule,
    HttpClientModule
  ],
  providers: [DataService],
  exports: [HttpClientModule, EnumToArrayPipe]
})
export class DataModule { }

export { DataService, Trending, Region, EnumToArrayPipe };
