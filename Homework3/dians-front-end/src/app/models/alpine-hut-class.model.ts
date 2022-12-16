export class AlpineHutClass {
    private name:string;
    private elevation:Int16Array;
    private street:string;
    private location_id:BigInteger;

    constructor(name:string,elevation:Int16Array, street:string,location_id:BigInteger){
        this.name=name;
        this.elevation=elevation;
        this.street=street;
        this.location_id=location_id;
    }
}
