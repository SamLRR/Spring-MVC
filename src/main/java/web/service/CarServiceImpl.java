package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import web.dao.CarDao;
import web.model.Car;

import java.util.List;

@Service
public class CarServiceImpl implements CarService{

    @Qualifier("carDaoImpl")
    @Autowired
    CarDao carDao;

    @Override
    public List<Car> getAllCars() {
        return carDao.getAllCars();
    }
}
