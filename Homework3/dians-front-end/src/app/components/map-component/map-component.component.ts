import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRouteSnapshot, Resolve, Router, RouterStateSnapshot } from '@angular/router';
import { Loader } from '@googlemaps/js-api-loader';
import { Marker } from '@syncfusion/ej2-maps';
import { ConfigService } from 'src/app/config/config.service';
import { Employee } from 'src/app/employee';
import { ActivatedRoute } from '@angular/router';
import { AlpineHut } from 'src/app/alpinehut';
import { CampSite } from 'src/app/camp-site.model';
import { GuestHouse } from 'src/app/guest-house.model';


@Component({
  selector: 'app-map-component',
  templateUrl: './map-component.component.html',
  styleUrls: ['./map-component.component.css']
})
export class MapComponentComponent implements OnInit,Resolve<any>{

  title="google-maps";
  public hotels:Employee[] | undefined;
  public huts:AlpineHut[] | undefined;
  public camps:CampSite[] | undefined;
  public houses:GuestHouse[]| undefined;
  public map:google.maps.Map | undefined;
  public markers:google.maps.Marker[];
  public locations:any[];
  

  

   constructor(private configService:ConfigService,
    private route: Router,
    private activateRoute: ActivatedRoute,
    ){
    this.hotels=this.activateRoute.snapshot.data['data'];
    this.huts=this.activateRoute.snapshot.data['data2']
    this.camps=this.activateRoute.snapshot.data['data3']
    this.houses=this.activateRoute.snapshot.data['data4']

  }
  
  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    throw new Error('Method not implemented.');
  }


  public getEmployees(): void {
  
    this.configService.getEmployees().subscribe(
      
      (response: Employee[]) => {
        this.hotels = response;
        console.log(this.hotels);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
      
    );
  }
  public getHuts(): any {
  
    this.configService.getHuts().subscribe(
      
      (response: AlpineHut[]) => {
        this.huts = response;
        console.log(this.huts);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
      
    );
  }
  public getCamps(): any {
  
    this.configService.getCamps().subscribe(
      
      (response: CampSite[]) => {
        this.camps= response;
        console.log(this.camps);
      },
      (error: HttpErrorResponse) => {
        alert(error.message); 
      }
      
    );
  }

  bHotels()
  {
    var btn= document.getElementById('hotel')   
    if(this.hotels!=undefined)
    {
      this.hotels=undefined
      btn.style.color='lightgray'
    }
    else
    {
      this.hotels=this.activateRoute.snapshot.data['data'];
      btn.style.color='black'

    }



    this.showMap()
    
  }
  bHuts()
  {
    var btn= document.getElementById('hut')   
    if(this.huts!=undefined)
    {
      this.huts=undefined
      btn.style.color='lightgray'

    }
    else
    {
      this.huts=this.activateRoute.snapshot.data['data2']
      btn.style.color='black'


    }
    
    this.showMap()
    
  }
  bHouses()
  {
    var btn= document.getElementById('house')   
    if(this.houses!=undefined)
    {
      this.houses=undefined
      btn.style.color='lightgray'

    }
    else
    {
      this.houses=this.activateRoute.snapshot.data['data4']
      btn.style.color='black'

    }
    this.showMap()
  }
  bSites()
  {
    var btn= document.getElementById('camp')   
    if(this.camps!=undefined)
    {
      this.camps=undefined;
      btn.style.color='lightgray'
    }
    else
    {
      this.camps=this.activateRoute.snapshot.data['data3']
      btn.style.color='black'

    }
    this.showMap()
    
  }
   ngOnInit():void {
    this.showMap();

  }

  loadAllMarkers(){
    this.markers.forEach(markerInfo => {
      console.log
    })
  }

  showMap(){

    let loader = new Loader({
      apiKey:'AIzaSyCBQHpSfY2NfXhJy7rHqn-bmQN_GGSFOGI',
    });

    loader.load().then(()=>{
      console.log("Loaded map")

      const location = {
        lat:46.8182,
        lng:8.2275,
      }
      
      this.map=new google.maps.Map(document.getElementById('map')!,{
        center:location,
        zoom:8,
      })


      const svgMarker = {
        path: "M10.453 14.016l6.563-6.609-1.406-1.406-5.156 5.203-2.063-2.109-1.406 1.406zM12 2.016q2.906 0 4.945 2.039t2.039 4.945q0 1.453-0.727 3.328t-1.758 3.516-2.039 3.070-1.711 2.273l-0.75 0.797q-0.281-0.328-0.75-0.867t-1.688-2.156-2.133-3.141-1.664-3.445-0.75-3.375q0-2.906 2.039-4.945t4.945-2.039z",
        fillColor: "blue",
        fillOpacity: 0.8,
        strokeWeight: 0,
        rotation: 0,
        scale: 2,
        anchor: new google.maps.Point(15, 30),
      };
      const icons: Record<string, any> = {
        hotel: {
          name: "hotels",
          icon:"http://maps.google.com/mapfiles/ms/icons/blue-dot.png",
        },
        hut: {
          name: "huts",
          icon: "http://maps.google.com/mapfiles/ms/icons/green-dot.png",
        },
        camp: {
          name: "camps",
          icon: "http://maps.google.com/mapfiles/ms/icons/green-dot.png",
        },
        house: {
          name: "houses",
          icon: "http://maps.google.com/mapfiles/ms/icons/yellow-dot.png",
        },
        
      };

      const blue = {
        url: "http://maps.google.com/mapfiles/ms/icons/blue-dot.png",
        // This marker is 20 pixels wide by 32 pixels high.
        size: new google.maps.Size(32, 32),
        // The origin for this image is (0, 0).
        origin: new google.maps.Point(0, 0),
        // The anchor for this image is the base of the flagpole at (0, 32).
        anchor: new google.maps.Point(0, 32),
      };
      
      const green = {
        url: "http://maps.google.com/mapfiles/ms/icons/green-dot.png",
        // This marker is 20 pixels wide by 32 pixels high.
        size: new google.maps.Size(32, 32),
        // The origin for this image is (0, 0).
        origin: new google.maps.Point(0, 0),
        // The anchor for this image is the base of the flagpole at (0, 32).
        anchor: new google.maps.Point(0, 32),
      };
      
      const red = {
        url: "http://maps.google.com/mapfiles/ms/icons/red-dot.png",
        // This marker is 20 pixels wide by 32 pixels high.
        size: new google.maps.Size(32, 32),
        // The origin for this image is (0, 0).
        origin: new google.maps.Point(0, 0),
        // The anchor for this image is the base of the flagpole at (0, 32).
        anchor: new google.maps.Point(0, 32),
      };
      
      const yellow = {
        url: "http://maps.google.com/mapfiles/ms/icons/yellow-dot.png",
        // This marker is 20 pixels wide by 32 pixels high.
        size: new google.maps.Size(32, 32),
        // The origin for this image is (0, 0).
        origin: new google.maps.Point(0, 0),
        // The anchor for this image is the base of the flagpole at (0, 32).
        anchor: new google.maps.Point(0, 32),
      };

      const shape = {
        coords: [1, 1, 1, 20, 18, 20, 18, 1],
        type: "poly",
      };
      if(this.hotels!=undefined){
      for(let hotel of Object.values(this.hotels)){
        const location1={
          lat:hotel.y,
          lng:hotel.x
        }
          const marker = new google.maps.Marker({
            position:location1,
            map:this.map,
            title:hotel.city,
            icon:blue,
            shape:shape,
            optimized:false,
            clickable:true,
            
          })
          
      }
    }
      if(this.huts!=undefined){
      for(let hut of Object.values(this.huts)){
        const location2={
          lat:hut.y,
          lng:hut.x
        }
        console.log(hut)

          const marker2 = new google.maps.Marker({
            position:location2,
            map:this.map,
            title:hut.city,
            icon:green,
            shape:shape,
            optimized:false,
            clickable:true,
          })

          
      }
    }
      if(this.camps!=undefined){
      for(let camp of Object.values(this.camps)){
        const location3={
          lat:camp.y,
          lng:camp.x
        }
        console.log(camp)

          const marker3 = new google.maps.Marker({
            position:location3,
            map:this.map,
            title:camp.city,
            icon:red,
            shape:shape,
            optimized:false,
            clickable:true,
          })

          
      }
    }
    if(this.houses!=undefined){
      for(let house of Object.values(this.houses)){
        const location3={
          lat:house.y,
          lng:house.x
        }
        console.log(house)

          const marker3 = new google.maps.Marker({
            position:location3,
            map:this.map,
            title:house.city,
            icon:yellow,
            shape:shape,
            optimized:false,
            clickable:true,
          })

          
      }
    }
      
      
    })


  }


}


