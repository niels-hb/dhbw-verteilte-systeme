import { Component, OnInit } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { DataService, Region, Trending } from '../data/data.module';

interface Search {
  date: Date;
  hour: number;
  region: Region;
}

@Component({
  selector: 'app-ranking',
  templateUrl: './ranking.component.html',
  styleUrls: ['./ranking.component.scss']
})
export class RankingComponent implements OnInit {

  Region = Region;

  searchBuffer: Search;
  search: BehaviorSubject<Search>;
  videos: Trending[] = [];

  hours = [...Array(23).keys()];

  constructor(private dataService: DataService) { }

  ngOnInit(): void {
    this.searchBuffer = {
      date: new Date(),
      hour: (new Date()).getHours(),
      region: Region.DE
    };

    this.applySearch();

    this.search.subscribe(search => {
      this.getRanking(search);
    });
  }

  applySearch(): void {

    if (!(this.searchBuffer.date && this.searchBuffer.hour && this.searchBuffer.region)) { return; }

    if (this.search) {
      this.search.next({
        date: this.searchBuffer.date,
        hour: this.searchBuffer.hour,
        region: this.searchBuffer.region
      });
    } else {
      this.search = new BehaviorSubject({
        date: this.searchBuffer.date,
        hour: this.searchBuffer.hour,
        region: this.searchBuffer.region
      });
    }

  }

  private getRanking(search: Search): void {
    const date = search.date;
    date.setHours(search.hour);
    this.dataService.getRanking(date, search.region).subscribe((res) => {
      this.videos = res;
    });
  }
}
