package pl.zajavka;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class SimpleJdbcInsertExample {

    private final SimpleDriverDataSource simpleDriverDataSource;

    public void SimpleJdbcInsertExample() {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(simpleDriverDataSource);
        simpleJdbcInsert.setTableName("PERSON");

//        Map<String, Object> params = new HashMap<>();
//        params.put("ID",13);
//        params.put("NAME","Damian");
//        params.put("AGE",42);
//
//        int result = simpleJdbcInsert.execute(params);

        Person person = Person.builder()
                .id(90L)
                .name("Maksymilian")
                .age(8)
                .build();

        BeanPropertySqlParameterSource beanPropertySqlParameterSource = new BeanPropertySqlParameterSource(person);
        int result = simpleJdbcInsert.execute(beanPropertySqlParameterSource);
        System.out.println(result);
    }
}
