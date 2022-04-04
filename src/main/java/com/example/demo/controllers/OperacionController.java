package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OperacionController {
	
	@Autowired
	private RestTemplate clienteRest;

	@GetMapping("/hello")
	public String saludo() {
		return "Hola mundo";
	}

	@GetMapping("/sumar")
	public String sumar(@RequestParam float a, @RequestParam float b) {
		String resultado = Float.toString(a + b);
		return clienteRest.getForObject("https://resultados-eeuu-uda.herokuapp.com/resultado/" + resultado , String.class);
	}

	@GetMapping("/restar")
	public String restar(@RequestParam float a, @RequestParam float b) {
		String resultado = Float.toString(a - b);
		return clienteRest.getForObject("https://resultados-eeuu-uda.herokuapp.com/resultado/" + resultado , String.class);
	}

	@GetMapping("/sumareuropa")
	public String sumarEuropa(@RequestParam float a, @RequestParam float b) {
		String resultado = Float.toString(a + b);
		return clienteRest.getForObject("https://resultados-europa-uda.herokuapp.com/resultado/" + resultado , String.class);
	}
	@GetMapping("/restareuropa")
	public String restarEuropa(@RequestParam float a, @RequestParam float b) {
		String resultado = Float.toString(a - b);
		return clienteRest.getForObject("https://resultados-europa-uda.herokuapp.com/resultado/" + resultado , String.class);
	}
	
}
