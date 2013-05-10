package pl.sergiuszkierat.repository;

import pl.sergiuszkierat.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * @author Sergiusz Kierat <sergiusz.kierat@gmail.com>
 * @since 2013/05/10
 */
public class UserRepositoryImpl implements UserRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> findSomeone() {
        System.out.println("findSomeone");
        final Query query = em.createQuery("SELECT u FROM User u");
        return query.getResultList();
    }
}
