package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.CarDao;
import web.model.Car;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarDao carDao;

    @Transactional(readOnly = true)
    @Override
    public List<Car> getAllCars() {
        return carDao.getAllCars();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Car> getAllCars(int count) {
        return carDao.getAllCars(count);
    }
}
