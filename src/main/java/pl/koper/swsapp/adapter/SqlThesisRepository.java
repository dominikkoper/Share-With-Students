package pl.koper.swsapp.adapter;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.koper.swsapp.model.Thesis;
import pl.koper.swsapp.repository.ThesisRepository;

public interface SqlThesisRepository extends ThesisRepository, JpaRepository <Thesis, Integer> {
}
