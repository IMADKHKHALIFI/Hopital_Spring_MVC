package net.imad.hopital_spring_mvc.web;


import lombok.AllArgsConstructor;
import net.imad.hopital_spring_mvc.Repository.PatientRepository;
import net.imad.hopital_spring_mvc.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;
    @GetMapping("/index")
    public String index(Model model ,
                        @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
                        @RequestParam(name = "size" , defaultValue = "4") int size ,
                        @RequestParam(name = "keyword" , defaultValue = "") String kw
    ){
        Page< Patient> PagePatients = patientRepository.findByNomContains(kw, PageRequest.of(page, size));
        model.addAttribute("ListePatienrs",PagePatients.getContent());
        model.addAttribute("pages",new int[PagePatients.getTotalPages()] );
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword",kw);
    return "patients";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam Long id,
                         @RequestParam(name = "keyword", defaultValue = "") String keyword,
                         @RequestParam(name = "page", defaultValue = "0") Integer page) {

        patientRepository.deleteById(id);
        return "redirect:/index?page=" + page + "&keyword=" + keyword;
    }



    @GetMapping("/")
    public String home( ){


        return  "redirect:/index";
    }
}
