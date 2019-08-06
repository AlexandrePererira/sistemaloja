package com.alexandre.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.alexandre.service.CadastroProdutoService;



@Configuration
@ComponentScan(basePackageClasses = CadastroProdutoService.class)
public class ServiceConfig {

}
