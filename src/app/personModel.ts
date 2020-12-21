import { DrugModel } from './drugModel';

export interface PersonModel{
    firstName:string,
    lastName:string,
    emailId:string,
    location:string,
    personId: number,
    drugsList:DrugModel
}
