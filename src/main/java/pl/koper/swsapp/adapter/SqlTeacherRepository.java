package pl.koper.swsapp.adapter;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.koper.swsapp.model.Teacher;
import pl.koper.swsapp.repository.TeacherRepository;

public interface SqlTeacherRepository extends TeacherRepository, JpaRepository<Teacher, Integer> {
}
