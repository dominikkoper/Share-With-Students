package pl.koper.swsapp.repository;

import org.springframework.data.repository.query.Param;
import pl.koper.swsapp.model.Consultation;

import java.util.List;

public interface ConsultationRepository {
    List<Consultation> findByTeacherId(@Param("teacher_id") Integer id);
}
