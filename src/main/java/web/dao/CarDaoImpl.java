package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Car> getAllCars() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Car").list();
        }
    }

    @Override
    public List<Car> getAllCars(Integer count) {
        List<Car> list = null;
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Car").setMaxResults(count).list();
        }
    }
}
