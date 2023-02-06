package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import java.sql.SQLException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class UserDaoTest {

    @BeforeEach
    void setUp() {
        // 테스트 코드를 실행하기에 앞서서 수행해야 될 작업이 있다면
        // 이곳에서 수행하게 된다.
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();

        // 해당 {파일명}.sql 스크립트 파일을  읽어와서 populator에 추가한다.
        populator.addScript(new ClassPathResource("db_schema.sql"));

        // 해당 sql문 실행
        DatabasePopulatorUtils.execute(populator, ConnectionManager.getDataSource());
    }

    @Test
    void createTest() throws SQLException {
        UserDao userDao = new UserDao();

        // 정보 생성
        userDao.create2(new User("wizard", "password", "name", "email"));

        // User 정보 조회
        User user = userDao.findByUserId2("wizard");

        // 생성한 정보와 기존에 있던 정보 비교
        assertThat(user).isEqualTo(new User("wizard", "password", "name", "email"));
    }
}
