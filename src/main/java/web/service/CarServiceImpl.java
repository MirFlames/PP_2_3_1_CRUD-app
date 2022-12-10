package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import web.config.AppConfig;
import web.models.Car;

import java.util.List;

public class CarServiceImpl implements CarService {

    private final ApplicationContext applicationContext =
            new AnnotationConfigApplicationContext(AppConfig.class);
    private final List<Car> cars =
            (List<Car>) applicationContext.getBean("cars");

    public List<Car> getCars() {
        return getCars(cars.size());
    }

    public List<Car> getCars(int count) {
        return cars.stream().limit(count).toList();
    }
}
