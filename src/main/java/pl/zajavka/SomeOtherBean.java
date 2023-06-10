package pl.zajavka;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class SomeOtherBean {
    private static final String SQL = "INSERT INTO PERSON (NAME, AGE) VALUES (:name, :age)";
    private SimpleDriverDataSource simpleDriverDataSource;

    @Transactional(
            propagation = Propagation.REQUIRES_NEW, // nowa tranakcja wewnatrz juz istniejacej
            isolation = Isolation.DEFAULT // default=tryb izolacji taki jak został ustawiony w bazie danych
    )
    public Integer example(){
        int result = 0;
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(simpleDriverDataSource);

        Person person1 = Person.builder().name("Roman").age(55).build();
        Person person2 = Person.builder().name("Tomasz").age(25).build();
        Person person3 = Person.builder().name("Roman2").age(21).build();

        result += jdbcTemplate.update(SQL, new BeanPropertySqlParameterSource(person1));
        result += jdbcTemplate.update(SQL, new BeanPropertySqlParameterSource(person2));
        result += jdbcTemplate.update(SQL, new BeanPropertySqlParameterSource(person3));

        return result;
    }
}
