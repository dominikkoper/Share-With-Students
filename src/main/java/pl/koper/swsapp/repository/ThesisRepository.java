package pl.koper.swsapp.repository;


import org.springframework.data.repository.query.Param;
import pl.koper.swsapp.model.Thesis;

import java.util.List;
import java.util.Optional;

public interface ThesisRepository {

    List<Thesis> findAll();
    //List<Thesis> findByTeacherId();

    Thesis save (Thesis entity);

    List<Thesis> findByTeacherId(@Param("teacher_id") Integer id);
    Optional<Thesis> findById(Integer id);
}
