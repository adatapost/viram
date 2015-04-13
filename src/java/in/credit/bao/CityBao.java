package in.credit.bao;

import in.credit.HbUtil;
import in.credit.model.City;
import in.credit.model.State;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Viram
 */
public class CityBao {

    public static boolean add(CityViewModel model) {
        Session session = HbUtil.openSession();
        session.beginTransaction();
        try {
            City city = new City();
            city.setCityName(model.getCityName());
            city.setState(new State());
            city.getState().setStateId(model.getStateId());
            session.save(city);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println("CityBao::add " + e);
        } finally {
            session.close();
        }
        return false;
    }

    public static boolean update(CityViewModel model) {
        Session session = HbUtil.openSession();
        session.beginTransaction();
        List<City> list = session.createCriteria(City.class).add(Restrictions.eq("cityId", model.getCityId())).list();

        try {
            if (!list.isEmpty()) {
                City upd = list.get(0);
                upd.setCityName(model.getCityName());
                upd.getState().setStateName(model.getStateName());
                session.update(upd);
                session.getTransaction().commit();
                return true;
            }

        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println("cityBao::update " + e);
        } finally {
            session.close();
        }
        return false;
    }

    public static boolean delete(CityViewModel model) {
        Session session = HbUtil.openSession();
        session.beginTransaction();
        List<City> list = session.createCriteria(City.class)
                .add(Restrictions.eq("cityId", model.getCityId())).list();
        try {
            if (!list.isEmpty()) {
                City del = list.get(0);
                session.delete(del);
                session.getTransaction().commit();
                return true;
            }
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println("CityBao::delete " + e);
        } finally {
            session.close();
        }
        return false;
    }

    public static List<CityViewModel> gets() {
        Session session = HbUtil.openSession();
        session.beginTransaction();
        List<City> list = session.createCriteria(City.class).list();
        List<CityViewModel> cities = new ArrayList<CityViewModel>();
        for (City c : list) {
            cities.add(new CityViewModel(c.getCityId(), c.getCityName(), c.getState().getStateId(), c.getState().getStateName()));
        }
        session.close();
        return cities;
    }

    public static CityViewModel get(CityViewModel model) {
        Session sess = HbUtil.openSession();
        sess.beginTransaction();
        List<City> list = sess.createCriteria(City.class).add(Restrictions.eq("cityId", model.getCityId())).list();

        try {
            if (!list.isEmpty()) {
                City c = list.get(0);
                return new CityViewModel(c.getCityId(), c.getCityName(), c.getState().getStateId(), c.getState().getStateName());
            }

        } catch (Exception e) {
            System.out.println("CityBao::get " + e);
        } finally {
            sess.close();
        }
        return null;
    }

    public static List<CityViewModel> getCitiesOfState(CityViewModel model) {
        Session session = HbUtil.openSession();
        List<CityViewModel> cities = new ArrayList<CityViewModel>();
        session.beginTransaction();
        try {
            List<City> list = session.createCriteria(City.class)
                    .add(Restrictions.eq("state.stateId", model.getStateId())).list();
            for (City c : list) {
                cities.add(new CityViewModel(c.getCityId(), c.getCityName(), c.getState().getStateId(), c.getState().getStateName()));
            }
        } catch (HibernateException e) {
            System.out.println("CityBao::gets(stateId)" + e);
        } finally {
            session.close();
        }
        return cities;
    }

}
