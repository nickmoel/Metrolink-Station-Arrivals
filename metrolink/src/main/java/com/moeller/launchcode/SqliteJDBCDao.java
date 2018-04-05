package com.moeller.launchcode;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

 //Data Access Object is basically an object or an interface that provides access to an underlying database
@Repository
public class SqliteJDBCDao implements MetrolinkDao {


    @Autowired
    private SessionFactory sessionFactoryBean;


    public SqliteJDBCDao() {

    }

    public List<Station> getStopsAllStops() {

        sessionFactoryBean.getCurrentSession().beginTransaction();//DataBase TransAction
        String sql = "SELECT stops.stop_id, stops.stop_name FROM stops WHERE stop_name LIKE '%METROLINK STATION%' ORDER BY stop_name ASC";
        Query query = sessionFactoryBean.getCurrentSession().createSQLQuery(sql).addEntity(Station.class);
        List<Station> arrivals = query.list();

        sessionFactoryBean.getCurrentSession().getTransaction().commit();

        return arrivals;

    }

    public List<String> getArrivals(Station station) {
        sessionFactoryBean.getCurrentSession().beginTransaction();
        String sql = "SELECT arrival_time FROM stop_times WHERE stop_id LIKE :station AND arrival_time > time('now', 'localtime') ORDER BY arrival_time asc LIMIT 1;";
        Query query = sessionFactoryBean.getCurrentSession().createSQLQuery(sql); //arrival_times are strings in the database and hibernate knows how to directly handle that so no need for a DTO class
        query.setParameter("station", station.getId());
        List<String> arrivals = query.list();

        sessionFactoryBean.getCurrentSession().getTransaction().commit();

        return arrivals;

    }
}






