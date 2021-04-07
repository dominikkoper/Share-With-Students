package pl.koper.swsapp.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.koper.swsapp.model.Teacher;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeacherRepository {

    Page<Teacher> findAll(Pageable page);

    List<Teacher> findAll();

    Optional<Teacher> findById(Integer id);

    Teacher save(Teacher entity);

    void deleteById(Integer id);

    void delete(Teacher entity);

    boolean existsById(Integer id);


   //List<Teacher>findByNameOrSurnameEquals(@Param("name") String name, String surname);

}
