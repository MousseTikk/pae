package g56583.web5.pae.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import g56583.web5.pae.services.PaeService;


@Controller
public class CourseController {

    @Autowired
    private PaeService api;

    @GetMapping("/courses")
    public String courses(Model model){
        model.addAttribute("courses", api.getAllCourses());
        return "courses.html";
    }
}
