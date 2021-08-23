package com.exercicioum.exercicioum.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exercicioum")

public class ExercicioUm {
	@GetMapping
	public String exercicioum()
	{
		return "Eu usei as mentalidades de persistencia e a mentalidade de crescimento, nas habilidades foi atenção aos detalhes";
				 
	}
}
