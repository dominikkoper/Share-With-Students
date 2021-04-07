package pl.koper.swsapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.koper.swsapp.model.Lesson;

import java.util.List;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Integer> {

    Lesson findByName(String name);
    List<Lesson> findLessonByGroupeName(String name);
}
