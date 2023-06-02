package pl.zajavka;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class JdbcTemplateExample {

    private final SimpleDriverDataSource simpleDriverDataSource;
    public void insert() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(simpleDriverDataSource);
        String sql="INSERT INTO PERSON (NAME, AGE) VALUES (?, ?)";
        jdbcTemplate.update(sql,"Roman",25);
    }
}
