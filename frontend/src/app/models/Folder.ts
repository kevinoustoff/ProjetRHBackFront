import { File } from "./File";

export interface Folder{
  id:string;
  name:string;
  files:File[];
}
