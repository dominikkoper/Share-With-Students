package pl.koper.swsapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.koper.swsapp.model.Consultation;
import pl.koper.swsapp.model.Thesis;
import pl.koper.swsapp.model.Subject;
import pl.koper.swsapp.model.projection.TeacherWriteModel;
import pl.koper.swsapp.model.Teacher;
import pl.koper.swsapp.repository.ConsultationRepository;
import pl.koper.swsapp.repository.ThesisRepository;
import pl.koper.swsapp.repository.SubjectRepository;
import pl.koper.swsapp.repository.TeacherRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository repository;

    @Autowired
    private ThesisRepository repositoryDiss;

    @Autowired
    private SubjectRepository repositorySub;

    @Autowired
    private ConsultationRepository repositoryCon;

    public Teacher save(final TeacherWriteModel toSave) {
        return repository.save(toSave.toTeacher());
    }

    public List<Teacher>getAllTeachers(){
        return repository.findAll();
    }

    public Teacher getTeacherById(Integer id){
        Optional<Teacher> optional = repository.findById(id);
        Teacher teacher = null;
        if(optional.isPresent()){
            teacher = optional.get();
        } else{
            throw new RuntimeException("Teacher not found");
        }
        return teacher;
    }

    public void deleteTeacherById(Integer id){
        this.repository.deleteById(id);
    }


    public Page<Teacher> findPaginated(int pageNo, int pageSize){
        Pageable pageable = PageRequest.of(pageNo -1, pageSize);
        return this.repository.findAll(pageable);
    }

    public List<Thesis> getThesisByTeacherId(int id){
        return repositoryDiss.findByTeacherId(id);
    }
    public List<Subject> getSubjectById(int id) {return repositorySub.findByTeacherId(id);}
    public List<Consultation> getConsultationById(int id) {return repositoryCon.findByTeacherId(id);}

}
