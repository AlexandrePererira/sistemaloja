package com.alexandre.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alexandre.model.Cidade;
import com.alexandre.repository.CidadeRepository;

@Service
public class CadastroCidadeService {

	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Transactional
	public void salvar(Cidade cidade) {
			cidadeRepository.save(cidade);
	}
}
