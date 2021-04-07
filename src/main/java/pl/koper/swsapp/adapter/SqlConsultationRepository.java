package pl.koper.swsapp.adapter;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.koper.swsapp.model.Consultation;
import pl.koper.swsapp.repository.ConsultationRepository;


public interface SqlConsultationRepository extends ConsultationRepository, JpaRepository<Consultation, Integer>{


}
