export class CampSiteClass {
    private name:string;
    private street:string;
    private location_id:BigInteger;
    private phone:string;

    constructor(name:string, street:string,location_id:BigInteger,phone:string){
        this.name=name;
        this.street=street;
        this.location_id=location_id;
        this.phone=phone;
    }
}
