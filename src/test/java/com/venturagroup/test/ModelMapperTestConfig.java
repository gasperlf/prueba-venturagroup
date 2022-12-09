package com.venturagroup.test;

import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class ModelMapperTestConfig {

  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }
}
