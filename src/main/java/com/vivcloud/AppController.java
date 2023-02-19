package com.vivcloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//import org.thymeleaf.util.StringUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/*
 * This class handle the all request and
 *  will give the response.
 * and also used some annotation like @Autowired, @Controller, @GetMapping
 */
@Controller
public class AppController {

    @Autowired
    private DocumentRepository documentRepository;

    @GetMapping("/")
    public String viewhomePage(){
        return "home";
    }
    @PostMapping("/upload")
    public String  uploadFile(@RequestParam("document")MultipartFile multipartFile, RedirectAttributes ra) throws IOException {

        String fileName=StringUtils.cleanPath(multipartFile.getOriginalFilename());
        Document document = new Document();
        document.setName(fileName);
        document.setContent(multipartFile.getBytes());
        document.setSize(multipartFile.getSize());
        document.setUploadeTime(new Date());

        documentRepository.save(document);

        ra.addFlashAttribute("message","File have been uploaded successfully");

        return "redirect:/";

    }
}
