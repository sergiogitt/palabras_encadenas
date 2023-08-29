package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Acertijo;
import com.example.demo.service.PalabraService;

@RestController
public class PalabraController {
	@Autowired
	PalabraService palabraService;
	@GetMapping("/crearAcertijo")
	
	Boolean crearAcertijo() {
		return palabraService.crearAcertijo();
	}
	@GetMapping("/comenzarJuego")
	Acertijo comenzarJuego() {
		return palabraService.comenzarJuego();
	}
	@PostMapping("/comprobarPalabra/{palabra}")
	String comprobarPalabra(@PathVariable String palabra,@RequestParam Integer intento,@RequestParam Integer id){
		return palabraService.comprobarPalabra(palabra,intento,id);
	}
}
