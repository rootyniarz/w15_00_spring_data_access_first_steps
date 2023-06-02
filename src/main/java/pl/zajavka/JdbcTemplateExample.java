package pl.zajavka;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class JdbcTemplateExample {

    private final SimpleDriverDataSource simpleDriverDataSource;
    public void insert() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(simpleDriverDataSource);
        String sql="INSERT INTO PERSON (NAME, AGE) VALUES (?, ?)";
        jdbcTemplate.update(sql,"Roman",25);
    }

    public void update() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(simpleDriverDataSource);
        String sql="UPDATE PERSON SET AGE = ? WHERE NAME = ?";
        jdbcTemplate.update(sql,40,"Roman");
    }

    public void select() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(simpleDriverDataSource);
        String sql="SELECT * FROM PERSON";
        RowMapper<Person> personRowMapper = (resultSet, rowNumber) -> Person.builder()
                .id(resultSet.getLong("ID"))
                .name(resultSet.getString("NAME"))
                .age(resultSet.getInt("AGE"))
                .build();
        List<Person> result1 = jdbcTemplate.query(sql,personRowMapper);
        System.out.println(result1);

        // zamiast od linii z RowMapper możemy wykorzystć mechanizm Spring do mapowania pol bazy na pol klsy o ile się
        // tak samo nazywają

        BeanPropertyRowMapper<Person> personBeanPropertyRowMapper = BeanPropertyRowMapper.newInstance(Person.class);
        List<Person> result2 = jdbcTemplate.query(sql, personBeanPropertyRowMapper);
        System.out.println(result2);

    }
}
