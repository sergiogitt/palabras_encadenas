package com.example.demo.service;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Acertijo;
import com.example.demo.repository.AcertijoRepository;

@Service
public class PalabraService {
	@Autowired
	AcertijoRepository acertijoRepository;
	
	public Boolean crearAcertijo() {
		Acertijo acertijoAux=new Acertijo();
		acertijoAux.setId(1);
		acertijoAux.setPista1("montaña");
		acertijoAux.setPista2("marbella");
		acertijoAux.setResultado("concha");
		acertijoRepository.save(acertijoAux);
		
		acertijoAux.setId(2);
		acertijoAux.setPista1("maria");
		acertijoAux.setPista2("rocio");
		acertijoAux.setResultado("mujer");
		acertijoRepository.save(acertijoAux);
		return true;
	}
	
	public Acertijo comenzarJuego() {
		Integer max= (int) acertijoRepository.count();
		Integer min=1;
		Random random = new Random();
	    Integer randomNumber = random.nextInt(max - min + 1) + min;
	    Optional<Acertijo> acertijoOptional = acertijoRepository.findById( randomNumber);

        if (acertijoOptional.isPresent()) {
            Acertijo acertijoAux = acertijoOptional.get();
            acertijoAux.setResultado(acertijoAux.getResultado().substring(0, 1));
            return acertijoAux;
        } else {
            return null;
        }
	   
	}
	public String comprobarPalabra(String palabra,Integer intento,Integer id) {
		
		Optional<Acertijo> palabraBuscada=acertijoRepository.findById(id);
		if(palabraBuscada.isPresent()) {
			Acertijo palabraEncontradaPresente=palabraBuscada.get();
			if(palabraEncontradaPresente.getResultado().equalsIgnoreCase(palabra)) {
				return "1";
			}else if(intento<3) {
				return palabraEncontradaPresente.getResultado().substring(0, intento+1);
			}else {
				return "-"+palabraEncontradaPresente.getResultado();
			}
		}else {
			return null;
		}
		
		
	}
	
}
