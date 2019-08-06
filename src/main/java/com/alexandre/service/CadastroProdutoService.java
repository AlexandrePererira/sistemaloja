package com.alexandre.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.alexandre.model.Produto;
import com.alexandre.repository.ProdutoRepository;

@Service
public class CadastroProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Transactional
	public void salvar(Produto produto) {
		
		produtoRepository.save(produto);
	}
	
}
