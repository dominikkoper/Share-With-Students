package pl.koper.swsapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.koper.swsapp.model.FileModel;

import java.util.List;

@Repository
public interface FileRepository extends JpaRepository<FileModel, Integer> {

    List<FileModel> getAllByGroupname(String group);
    List<FileModel> getAllByGroupeIdAndLessonName(Integer id, String lessonName);
}
