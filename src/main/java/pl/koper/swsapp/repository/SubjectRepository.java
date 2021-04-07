package pl.koper.swsapp.repository;

import org.springframework.data.repository.query.Param;
import pl.koper.swsapp.model.Subject;

import java.util.List;

public interface SubjectRepository {
    List<Subject> findByTeacherId(@Param("teacher_id") Integer id);
}
