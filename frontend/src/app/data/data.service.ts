import { environment } from '../../environments/environment';

import { Injectable } from '@angular/core';
import { Region } from './region.enum';
import { Trending } from './trending.interface';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor(private http: HttpClient) { }

  getRanking(date: Date, region: Region): Observable<Trending[]> {
    const formattedDate = `${date.getFullYear()}-${
      String(date.getMonth() + 1).padStart(2, '0')
    }-${
      String(date.getDate()).padStart(2, '0')
    }T${
      String(date.getHours()).padStart(2, '0')
    }:00:00`;
    const url = `${environment.apiBaseUrl}/api/ranking?region=${region}&fetchedOn=${formattedDate}&size=200`;
    return this.http.get(url).pipe(map((res: any) => res.content), e => e);
  }

  getVideo(videoId: string, region: Region): Observable<Trending[]> {
    const url = `${environment.apiBaseUrl}/api/video?region=${region}&videoId=${videoId}&size=200`;
    return this.http.get(url).pipe(map((res: any) => res.content), e => e);
  }

}
