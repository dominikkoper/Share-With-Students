package pl.koper.swsapp.adapter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.koper.swsapp.repository.SubjectRepository;
import pl.koper.swsapp.model.Subject;

public interface SqlSubjectRepository extends SubjectRepository, JpaRepository<Subject, Integer> {
}
