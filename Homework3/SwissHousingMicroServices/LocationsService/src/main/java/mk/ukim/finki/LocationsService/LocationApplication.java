package mk.ukim.finki.LocationsService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients("mk.ukim.finki.LocationsService")
public class LocationApplication {
    public static void main(String[] args) {
        SpringApplication.run(LocationApplication.class,args);
    }


}