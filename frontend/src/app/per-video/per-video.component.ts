import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BehaviorSubject } from 'rxjs';
import { DataService, Region, Trending } from '../data/data.module';

interface Search {
  videoId: string;
  region: Region;
}

@Component({
  selector: 'app-per-video',
  templateUrl: './per-video.component.html',
  styleUrls: ['./per-video.component.scss']
})
export class PerVideoComponent implements OnInit {

  Region = Region;

  videoId: string;
  videoSets: Trending[];
  region: Region;
  search: BehaviorSubject<Search>;
  searchBuffer: Search;

  constructor(private route: ActivatedRoute, private dataService: DataService, private router: Router) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.searchBuffer = {
        videoId: params.videoId,
        region: params.region
      };
      if (this.search ) {
        this.search.next({
          videoId: params.videoId,
          region: params.region
        });
      } else {
        this.search = new BehaviorSubject({
            videoId: params.videoId,
            region: params.region
          });
      }
    });

    this.search.subscribe(search => {
      this.getVideo(search.videoId, search.region);
    });
  }

  applySearch(): void {
    this.router.navigateByUrl(`/video/${this.searchBuffer.videoId}/${this.searchBuffer.region}`);
  }

  private getVideo(videoId: string, region: Region): void {
    this.dataService.getVideo(videoId, region).subscribe((res: any) => {
      this.videoSets = res;
    });
  }

}
