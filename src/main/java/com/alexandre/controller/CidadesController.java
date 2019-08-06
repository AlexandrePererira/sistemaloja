package com.alexandre.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alexandre.enums.Estados;
import com.alexandre.model.Cidade;
import com.alexandre.service.CadastroCidadeService;
import com.alexandre.service.exception.NomeCidadeJaCadastradoException;



@Controller
public class CidadesController {
	
	@Autowired
	private CadastroCidadeService cadastroCidadeService;

	
	@RequestMapping(value = "/cidades", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody ResponseEntity<?> salvar(@RequestBody @Valid Cidade cidade, BindingResult result) {
		
		
		
		
		
		if (result.hasErrors()) {

			
			return ResponseEntity.badRequest().body(result.getFieldError("nome").getDefaultMessage() );
		}
		
//		try {
//			System.out.println("Teste 1");
//			cadastroCidadeService.salvar(cidade);
//		} catch (NomeCidadeJaCadastradoException e) {
//			return ResponseEntity.badRequest().body(e.getMessage());
//		}
//		
	
		return ResponseEntity.ok(cidade);
	}
}
