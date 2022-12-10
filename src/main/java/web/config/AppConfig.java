package web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {

    @Scope("singleton")
    @Bean(name="cars")
    public List<Car> getCars() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("model1", 1));
        carList.add(new Car("model2", 2));
        carList.add(new Car("model3", 3));
        carList.add(new Car("model4", 4));
        carList.add(new Car("model5", 5));
        return carList;
    }

}