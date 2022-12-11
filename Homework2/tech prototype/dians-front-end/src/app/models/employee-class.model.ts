import { map } from 'rxjs/operators';


export class EmployeeClass {
    private phone_number:string;
    private stars:Int16Array;
    private web_site:string;
    private location_id:BigInteger;

    constructor(phone_number:string,stars:Int16Array, web_site:string,location_id:BigInteger){
        this.phone_number=phone_number;
        this.stars=stars;
        this.web_site=web_site;
        this.location_id=location_id;
    }
}
