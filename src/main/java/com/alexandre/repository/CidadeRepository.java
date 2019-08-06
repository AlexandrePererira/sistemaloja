package com.alexandre.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alexandre.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

}
