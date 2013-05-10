package pl.sergiuszkierat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import pl.sergiuszkierat.model.User;

import java.io.Serializable;

/**
 * @author Sergiusz Kierat <sergiusz.kierat@gmail.com>
 * @since 2013/05/10
 */
@NoRepositoryBean
public interface MyRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {

    User sharedCustomMethod(ID id);
}