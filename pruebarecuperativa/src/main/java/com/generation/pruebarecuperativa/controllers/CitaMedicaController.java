package com.generation.pruebarecuperativa.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.generation.pruebarecuperativa.models.CitaMedica;
import com.generation.pruebarecuperativa.services.CitaMedicaService;

@Controller
@RequestMapping("/registrocita")
public class CitaMedicaController {
    @Autowired
    CitaMedicaService citaMedicaService;

    @RequestMapping("")
    public String registro(@ModelAttribute("paciente") CitaMedica citaMedica){
        // Pasamos el objeto paciente vacio
        return "citaMedica.jsp"; //pagina a desplegar
    }

    @PostMapping("/citamedica")
	public String guardarUsuario(@Valid @ModelAttribute("usuario") CitaMedica citaMedica, BindingResult resultado,
			Model model) { // siempre Model model para enviar datos desde el controlador al jsp

		if (resultado.hasErrors()) {// capturando si existe un error en el ingreso de datos desde el jsp
			model.addAttribute("msgError", "Debe realizar ingreso correcto de datos");// Enviar atributo al jsp para que
																						// muestre que hay un error
			return "citaMedica.jsp";
		}

		// enviar el objeto al service
		citaMedicaService.saveCitaMedica(citaMedica);

		// obtener una lista de citas medicas
		List<CitaMedica> listaCitasMedicas = citaMedicaService.findAll();
		// Pasamos la lista de usuario al jsp
		model.addAttribute("citasMedicasCapturadas", listaCitasMedicas);
		
		return "listaCitasPacientes.jsp"; // pagina a desplegar

	}
}
