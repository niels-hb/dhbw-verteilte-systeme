import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';
import { PerVideoComponent } from './per-video/per-video.component';
import { RankingComponent } from './ranking/ranking.component';

const routes: Routes = [
  { path: '', redirectTo: 'ranking', pathMatch: 'full' },
  { path: 'ranking', component: RankingComponent },
  { path: 'video/:videoId/:region', component: PerVideoComponent },
  { path: '**', redirectTo: '' },
];

@NgModule({
  declarations: [],
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules, useHash: true }),
  ],
  exports: [RouterModule]
})
export class RoutingModule { }
