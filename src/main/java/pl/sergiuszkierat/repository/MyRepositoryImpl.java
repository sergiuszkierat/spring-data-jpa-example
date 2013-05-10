package pl.sergiuszkierat.repository;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import pl.sergiuszkierat.model.User;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * @author Sergiusz Kierat <sergiusz.kierat@gmail.com>
 * @since 2013/05/10
 */
public class MyRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements MyRepository<T, ID> {

    private EntityManager entityManager;

    // There are two constructors to choose from, either can be used.
    public MyRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);

        // This is the recommended method for accessing inherited class dependencies.
        this.entityManager = entityManager;
    }

    public User sharedCustomMethod(ID id) {
        System.out.println("sharedCustomMethod");
        return entityManager.find(User.class, id);
    }
}