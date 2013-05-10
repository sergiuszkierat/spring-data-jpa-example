package pl.sergiuszkierat.repository;

import pl.sergiuszkierat.model.User;

/**
 * @author Sergiusz Kierat <sergiusz.kierat@gmail.com>
 * @since 2013/05/10
 */
public interface UserRepository extends MyRepository<User, Long>, UserRepositoryCustom {
}
