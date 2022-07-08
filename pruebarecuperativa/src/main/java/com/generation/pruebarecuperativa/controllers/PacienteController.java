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

import com.generation.pruebarecuperativa.models.Paciente;
import com.generation.pruebarecuperativa.services.PacienteService;

@Controller
@RequestMapping("/registro") //asignamos url inicio
public class PacienteController {
    //inyeccion de dependencia

    @Autowired
    PacienteService pacienteService;


    // Ruta para desplegar jsp
    @RequestMapping("")
    public String registro(@ModelAttribute("paciente") Paciente paciente){
        // Pasamos el objeto paciente vacio
        return "registroPaciente.jsp"; //pagina a desplegar
    }

    @PostMapping("/paciente")
	public String guardarPaciente(@Valid @ModelAttribute("paciente") Paciente paciente, BindingResult resultado,
			Model model) { // siempre Model model para enviar datos desde el controlador al jsp

		if (resultado.hasErrors()) {// capturando si existe un error en el ingreso de datos desde el jsp
			model.addAttribute("msgError", "Debe realizar ingreso correcto de datos");// Enviar atributo al jsp para que
																						// muestre que hay un error
			return "registroPaciente.jsp";
		}

		// enviar el objeto al service
		pacienteService.savePaciente(paciente);

		// obtener una lista de usuario
		List<Paciente> listaPacientes = pacienteService.findAll();
		// Pasamos la lista de usuario al jsp
		model.addAttribute("pacientesCapturados", listaPacientes);
		
		return "listaCitasPacientes.jsp"; // pagina a desplegar

	}


}   
