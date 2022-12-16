export class GuestHouseClass {
    private name:string;
    private street:string;
    private location_id:BigInteger;

    constructor(name:string, street:string,location_id:BigInteger){
        this.name=name;
        this.street=street;
        this.location_id=location_id;
    }
}
