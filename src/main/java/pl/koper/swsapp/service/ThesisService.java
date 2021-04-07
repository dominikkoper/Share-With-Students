package pl.koper.swsapp.service;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import pl.koper.swsapp.model.Thesis;
import pl.koper.swsapp.repository.ThesisRepository;


import java.util.List;
import java.util.Optional;


@Service
@RequestMapping("/thesis")
public class ThesisService {

    private final ThesisRepository repository;

    public ThesisService(ThesisRepository repository) {
        this.repository = repository;
    }


    public List<Thesis>getAllThesis(){
        return repository.findAll();
    }

    public void addThesisId(Integer id, String userId) {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriver(new org.mariadb.jdbc.Driver());
        dataSource.setUrl("jdbc:mariadb://localhost:3306/keycloak");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        String updateSql = "update keycloak.user_entity set thesis_id= ? where id = ?";
        JdbcTemplate jtm = new JdbcTemplate(dataSource);
        jtm.update(updateSql, new Object[]{id, userId});
    }
    public String findThesisId(String userId) {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriver(new org.mariadb.jdbc.Driver());
        dataSource.setUrl("jdbc:mariadb://localhost:3306/keycloak");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        String selectSql = "select thesis_id from keycloak.user_entity where id = ?";
        JdbcTemplate jtm = new JdbcTemplate(dataSource);
        String streetName = jtm.queryForObject(
                selectSql, new Object[] { userId }, String.class);

        return streetName;
    }
    public void changeStatus(Integer id){
        Thesis thesis = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Thesis Id:" + id));
        thesis.setReserved(true);
        repository.save(thesis);
    }

    public void statusUpdate(String userId){
        int id = Integer.parseInt(findThesisId(userId));
        Thesis thesis2 = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Thesis Id:" + id));
        thesis2.setReserved(false);
        repository.save(thesis2);
    }
}
