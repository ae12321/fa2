import { IPerson } from 'app/shared/model/person.model';

export interface IBook {
  id?: number;
  title?: string;
  person?: IPerson;
}

export const defaultValue: Readonly<IBook> = {};
