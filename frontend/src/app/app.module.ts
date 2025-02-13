import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { DataModule } from './data/data.module';
import {MatToolbarModule} from '@angular/material/toolbar';
import { RoutingModule } from './routing.module';
import { RankingModule } from './ranking/ranking.module';
import { PerVideoModule } from './per-video/per-video.module';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    DataModule,
    RoutingModule,
    RankingModule,
    PerVideoModule,
    MatToolbarModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
