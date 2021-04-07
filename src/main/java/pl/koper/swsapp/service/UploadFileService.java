package pl.koper.swsapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.koper.swsapp.model.FileModel;
import pl.koper.swsapp.model.Group;
import pl.koper.swsapp.model.Lesson;
import pl.koper.swsapp.repository.FileRepository;
import pl.koper.swsapp.repository.GroupRepository;
import pl.koper.swsapp.repository.LessonRepository;
import java.io.File;
import java.io.IOException;

import java.util.List;

@Service
public class UploadFileService {

    @Autowired
    private final FileRepository repo;

    @Autowired
    private final GroupRepository groupRepo;

    @Autowired
    private final LessonRepository lessonRepo;

    public UploadFileService(FileRepository repo, GroupRepository groupRepo, LessonRepository lessonRepo) {
        this.repo = repo;
        this.groupRepo = groupRepo;
        this.lessonRepo = lessonRepo;
    }

    public void addFile(MultipartFile multipartFile, String group, String lesson) throws IOException {
        String filePath = "C:\\Projekty\\sws-app\\src\\main\\resources\\uploads\\" + group + "\\" + lesson + "\\" + multipartFile.getOriginalFilename();
        File f = new File(filePath);
        f.getParentFile().getParentFile().mkdir();
        f.getParentFile().mkdir();
        multipartFile.transferTo(f);
        FileModel obj = new FileModel();
        obj.setName(multipartFile.getOriginalFilename());
        obj.setPath(filePath);
        obj.setGroupname(group);
        obj.setLessonname(lesson);
        Group check = groupRepo.findByName(group);
        Lesson checkLesson = lessonRepo.findByName(lesson);
        //grupa nie istnieje
        if (check == null) {
            Group newGroup = new Group(group);
            groupRepo.save(newGroup);
            obj.setGroupe(newGroup);
            //sprawdza czy leckja istnieje
            Lesson newLesson = new Lesson(lesson);
            newLesson.setGroupe(newGroup);
            lessonRepo.save(newLesson);
            obj.setLesson(newLesson);
            repo.save(obj);
        }
        //grupa istnieje
        else {
            obj.setGroupe(check);
            if (checkLesson == null) {
                Lesson newLesson = new Lesson(lesson);
                newLesson.setGroupe(check);
                lessonRepo.save(newLesson);
                obj.setLesson(newLesson);
                repo.save(obj);
            } else {
                obj.setLesson(checkLesson);
                repo.save(obj);
            }
        }
    }
        public List<FileModel> getAll (String group){
            return repo.getAllByGroupname(group);
        }


        public List<Group> getAllGroups () {
            return groupRepo.findAll();
        }

        public List<Lesson> getLessons (String name){
            return lessonRepo.findLessonByGroupeName(name);
        }

        public List<FileModel> getFiles(Integer id, String lessonName){
            return repo.getAllByGroupeIdAndLessonName(id, lessonName);
        }
    }


