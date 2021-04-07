package pl.koper.swsapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.koper.swsapp.service.UploadFileService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
public class FileController {

    @Autowired
    private final UploadFileService service;

    public FileController(UploadFileService service) {
        this.service = service;
    }

    @GetMapping("/uploadfile")
    String uploadFile2(Model model){
        model.addAttribute("files");
        return "uploadfile";
    }

    @PostMapping("/uploadfile")
    String uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("group")String group, @RequestParam("lesson") String lesson, Model model) throws IOException {
        service.addFile(file, group, lesson);
        model.addAttribute("files");
        return "uploadfile";
    }

    @GetMapping("/groups")
    String getGroups(Model model){
        model.addAttribute("groups",service.getAllGroups());
        return "groups";
    }
    @GetMapping("/groups/{name}")
    String getGroups(@PathVariable(value = "name") String name, Model model){
        model.addAttribute("lessons",service.getLessons(name));
        return "lessons";
    }
    @GetMapping("/groups/{id}/{lesson}")
    String getGroups(@PathVariable(value = "id") Integer id, @PathVariable(value = "lesson") String lesson, Model model){
        model.addAttribute("files",service.getFiles(id, lesson));
        return "files";
    }



    @GetMapping("/groups/{group}/{lesson}/{file}")
    String uploadFile3(@PathVariable("group")String group, @PathVariable("lesson") String lesson, @PathVariable("file") String file, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String filePath = "C:\\Projekty\\sws-app\\src\\main\\resources\\uploads\\" + group + "\\" + lesson + "\\" + file;
        File f = new File(filePath);
        if(f.exists()){
            String mimeType = "text/plain";
            response.setContentType(mimeType);
            response.setHeader("Content-Disposition",String.format("attachment; filename=\"" + f.getName() + "\""));
        }
        response.setContentLength((int)f.length());
        InputStream inputStream = new BufferedInputStream(new FileInputStream(f));
        FileCopyUtils.copy(inputStream, response.getOutputStream());
        return "files";
    }
}



