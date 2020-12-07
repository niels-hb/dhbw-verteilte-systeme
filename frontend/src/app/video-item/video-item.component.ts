import { Component, Input, OnInit } from '@angular/core';
import { Trending } from '../data/data.module';

@Component({
  selector: 'app-video-item',
  templateUrl: './video-item.component.html',
  styleUrls: ['./video-item.component.scss']
})
export class VideoItemComponent implements OnInit {

  @Input()
  video!: Trending;

  @Input()
  showFetchedOn: boolean;

  constructor() { }

  ngOnInit(): void {
  }

}
