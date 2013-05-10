package pl.sergiuszkierat.repository;

import pl.sergiuszkierat.model.User;

import java.util.List;

/**
 * @author Sergiusz Kierat <sergiusz.kierat@gmail.com>
 * @since 2013/05/10
 */
public interface UserRepositoryCustom {

    List<User> findSomeone();
}
