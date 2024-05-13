package gaga.elmahdi.tp3.mvc.web;

import gaga.elmahdi.tp3.mvc.entities.Patient;
import gaga.elmahdi.tp3.mvc.repositories.PatientRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Controller
public class PatientRestService {
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/")
    public String home() {
        return "redirect:/user/index";
    }

    @GetMapping("/user/index")
    public String index(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
                        @RequestParam(name = "size", defaultValue = "5") int size,
                        @RequestParam(name = "keyword", defaultValue = "") String keyword) {
        Page<Patient> patientsPages = patientRepository.findByNameContains(keyword, PageRequest.of(page, size));
        List<Patient> patientsList = patientsPages.getContent();
        model.addAttribute("patientsList", patientsList);
        model.addAttribute("pages", new int[patientsPages.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);
        return "Home";
    }


    @GetMapping("/admin/delete")
    public String delete(@RequestParam(name = "id") Long id, @RequestParam(name = "keyword", defaultValue = "") String keyword, @RequestParam(name = "page", defaultValue = "0") int page, @RequestParam(name = "size", defaultValue = "5") int size) {
        patientRepository.deleteById(id);
        return "redirect:/index?page=" + page + "&size=" + size + "&keyword=" + keyword;
    }

    @GetMapping("/admin/formPatient")
    public String formPatient(Model model) {
        model.addAttribute("patient", new Patient());
        return "AddPatientForm";
    }

    @PostMapping("/admin/savePatient")
    public String savePatient(@Valid Patient patient, BindingResult bindingResult, @RequestParam(name = "keyword", defaultValue = "") String keyword, @RequestParam(name = "page", defaultValue = "0") int page, @RequestParam(name = "size", defaultValue = "5") int size)  {
        if (bindingResult.hasErrors()) return "AddPatientForm";
        patientRepository.save(patient);
        return "redirect:/user/index?page=" + page + "&size=" + size + "&keyword=" + keyword;
    }

    @GetMapping("/admin/editPatient")
    public String editPatient(Model model, @RequestParam(name = "id") Long id, @RequestParam(name = "keyword", defaultValue = "") String keyword, @RequestParam(name = "page", defaultValue = "0") int page, @RequestParam(name = "size", defaultValue = "5") int size) {
        Optional<Patient> patient = patientRepository.findById(id);
        if (patient.isEmpty()) {
            return "redirect:/user/index?page=" + page + "&size=" + size + "&keyword=" + keyword;
        }

        model.addAttribute("patient", patient.get());
        model.addAttribute("keyword", keyword);
        model.addAttribute("page", page);
        model.addAttribute("size", size);


        return "EditPatientForm";
    }
}
