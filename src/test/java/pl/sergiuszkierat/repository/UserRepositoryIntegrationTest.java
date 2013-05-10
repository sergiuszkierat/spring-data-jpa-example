package pl.sergiuszkierat.repository;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import com.google.common.collect.Lists;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.sergiuszkierat.model.User;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class UserRepositoryIntegrationTest {

    private static final String TEST_FIRST_NAME = "Sergiusz";

    private static final String TEST_LASTNAME = "Kierat";

    @Autowired
    private UserRepository userRepository;

    @Before
    public void before() {
        User user = new User(TEST_FIRST_NAME, TEST_LASTNAME);

        userRepository.save(user);
    }

    @After
    public void afterClass() {
        userRepository.deleteAll();
    }

    @Test
    public void shouldFindPreviouslySavedUser() {
        // given

        // when
        List<User> result = Lists.newArrayList(userRepository.findAll());

        // then
        assertThat(result, hasSize(1));
        User foundUser = result.get(0);
        assertThat(foundUser.getFirstname(), is(TEST_FIRST_NAME));
        assertThat(foundUser.getLastname(), is(TEST_LASTNAME));
    }

    @Test
    public void shouldTestSharedCustomMethod() {
        //given
        Long id = 1L;

        //when
        User result = userRepository.sharedCustomMethod(id);

        //then
        assertThat(result, notNullValue());
    }

    @Test
    public void shouldFindSomeone() {
        //given

        //when
        List<User> result = userRepository.findSomeone();

        //then
        assertThat(result, hasSize(greaterThan(0)));
    }
}
