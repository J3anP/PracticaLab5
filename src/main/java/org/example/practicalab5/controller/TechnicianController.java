package org.example.practicalab5.controller;

import org.example.practicalab5.entity.Technician;
import org.example.practicalab5.repository.TechnicianRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tecnico")
public class TechnicianController {
    final TechnicianRepository technicianRepository;

    public TechnicianController(TechnicianRepository technicianRepository) {
        this.technicianRepository = technicianRepository;
    }

    @GetMapping(value = {"", "/"})
    public String listaTecnicos(Model model) {
        model.addAttribute("listaTecnicos", technicianRepository.findAll());
        return "tecnicos/lista";
    }

    @GetMapping("/new")
    public String nuevoTecnicoFrm(Model model, @ModelAttribute("tecnico") Technician tecnico) {

        model.addAttribute("listaJefes", getListaJefes());
        return "tecnicos/editFrm";
    }


}
