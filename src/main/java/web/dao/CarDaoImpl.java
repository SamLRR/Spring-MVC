package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.Collections;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Car> getAllCars() {
        try (Session session = sessionFactory.openSession()) {
            return Collections.unmodifiableList(session.createQuery("FROM Car").list());
        }
    }

    @Override
    public List<Car> getAllCars(Integer count) {
        try (Session session = sessionFactory.openSession()) {
            return Collections.unmodifiableList(session.createQuery("FROM Car").setMaxResults(count).list());
        }
    }
}
