package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class HomeController {
    @Autowired
    TaskRepository taskRepository;
    @RequestMapping("/")
    public String homePage(Model model){
        model.addAttribute("tasks",taskRepository.findAll());
        return "homepage";
    }
    @GetMapping("/process")
    public String bringForm(Model model){
        model.addAttribute("task", new Task());
        return "form";
    }

    @PostMapping("/process")
    public String processForm(@Valid Task task,
                              BindingResult result) {


        if (result.hasErrors()) {
            return "form";
        }


        try {
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");
            String strDate = formatter.format(date);
            task.setFormattedPostedDate(strDate);
            task.setPostedDate(date);
        }
        catch(Exception e){
            e.printStackTrace();
            return "redirect:/form";
        }
        taskRepository.save(task);
        return "redirect:/";
    }
}
