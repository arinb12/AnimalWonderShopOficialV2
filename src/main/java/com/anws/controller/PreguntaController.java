package com.anws.controller;

import com.anws.domain.Pregunta;
import com.anws.service.PreguntaService;
import com.anws.service.impl.FirebaseStorageServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/pregunta")
public class PreguntaController {
    
    @Autowired
    private PreguntaService preguntaService; 

    @GetMapping("/listado") //
    public String inicio(Model model) {
        var preguntas = preguntaService.getPreguntas();
        model.addAttribute("preguntas", preguntas); // 
        model.addAttribute("totalpreguntas", preguntas.size());
        return "/pregunta/listado";
    }
    
    @GetMapping("/nuevo")
    public String preguntaNuevo(Pregunta pregunta) {
        return "/pregunta/modifica";
    }
    
    @PostMapping("/guardar")
    public String preguntaGuardar(Pregunta pregunta) {
        preguntaService.save(pregunta);
        return "redirect:/pregunta/listado";
    }

    @GetMapping("/eliminar/{idPregunta}")
    public String preguntaEliminar(Pregunta pregunta) {
        preguntaService.delete(pregunta);
        return "redirect:/pregunta/listado";
    }

    @GetMapping("/modifica/{idPregunta}")
    public String preguntaModificar(Pregunta pregunta, Model model) {
        pregunta= preguntaService.getPregunta(pregunta);
        model.addAttribute("pregunta", pregunta);
        return "/pregunta/modifica";
    }

}
