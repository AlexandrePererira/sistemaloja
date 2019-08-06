package com.alexandre.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alexandre.enums.Sexo;
import com.alexandre.model.Cliente;
import com.alexandre.repository.CidadeRepository;



@Controller
public class ClientesController {
	
//	@Autowired
//	private Estilos estilos;
	
//	@Autowired
//	private CadastroCervejaService cadastroCervejaService;
	
	@Autowired
	private CidadeRepository cidades;

	@RequestMapping("/clientes/novo")
	public ModelAndView novo(Cliente clientes) {
		ModelAndView mv = new ModelAndView("cliente/CadastroCliente");
     	mv.addObject("sexos", Sexo.values());
    	mv.addObject("cidades", cidades.findAll());
//		mv.addObject("origens", Origem.values());
		return mv;
	}
	
	@RequestMapping(value = "/clientes/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Cliente cliente, BindingResult result, Model model, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(cliente);
		}
		
		//cadastroCervejaService.salvar(cerveja);
		attributes.addFlashAttribute("mensagem", "Cliente salva com sucesso!");
		return new ModelAndView("redirect:/clientes/novo");
	}
	
}
