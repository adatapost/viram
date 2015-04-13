package in.credit.bao;

import in.credit.HbUtil;
import in.credit.model.State;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Team
 */
public class StateBao {
    public static boolean add(CityViewModel model) {
        Session session = HbUtil.openSession();
        session.beginTransaction();
        try {
            State state=new State(model.getStateName());
            session.save(state);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println("StateBao::add " + e);
        }finally {
            session.close();
        }
        
        return false;
    }

    public static boolean update(CityViewModel model) {
        Session session = HbUtil.openSession();
        session.beginTransaction();
        List<State> list = session.createCriteria(State.class).add(Restrictions.eq("stateId", model.getStateId())).list();
        try {
            if (!list.isEmpty()) {
                State upd = list.get(0);
                upd.setStateName(model.getStateName());
                session.update(upd);
                session.getTransaction().commit();
                return true;
            }
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println("StateBao::update " + e);
        }finally {
            session.close();
        }
        return false;
    }

    public static boolean delete(CityViewModel model) {
        Session session = HbUtil.openSession();
        session.beginTransaction();
        List<State> list = session.createCriteria(State.class).add(Restrictions.eq("stateId", model.getStateId())).list();
        try {
            if (!list.isEmpty()) {
                State del = list.get(0);
                session.delete(del);
                session.getTransaction().commit();
            }
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println("StateBao::delete " + e);
        }finally {
            session.close();
        }
        return false;
    }

    public static List<CityViewModel> gets() {
        Session session = HbUtil.openSession();
        List<CityViewModel> states = new ArrayList<>();
        session.beginTransaction();
        try{
        List<State> list=session.createCriteria(State.class).list();
        for(State s:list) {
            states.add(new CityViewModel(0, "", s.getStateId(), s.getStateName()));
        }
        }finally {
            session.close();
        }
        return states;
    }

    public static CityViewModel get(CityViewModel model) {
        Session session = HbUtil.openSession();
        session.beginTransaction();
        List<State> list = session.createCriteria(State.class).add(Restrictions.eq("stateId", model.getStateId())).list();
        try {
            if (!list.isEmpty()) {
                State search = list.get(0);
                return new CityViewModel(0,"",search.getStateId(),search.getStateName());
            }

        } catch (Exception e) { 
            System.out.println("StateBao::get " + e);
        }finally {
            session.close();
        }
        return null;
    }
}
