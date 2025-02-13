import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'enumToArray'
})
export class EnumToArrayPipe implements PipeTransform {

  transform(value: { [key: string]: string } ): { [key: string]: string }[] {
    return Object.keys(value).map(i => ({index: i, value: value[i]}));
  }

}
