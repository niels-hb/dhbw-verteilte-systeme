import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'formatDate'
})
export class FormatDatePipe implements PipeTransform {

  transform(dateString: string): string {
    const date = new Date(dateString);
    return `${date.toLocaleDateString('de-DE')} @ ${date.getHours()} Uhr`;
  }

}
