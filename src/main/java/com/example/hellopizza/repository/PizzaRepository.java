package com.example.hellopizza.repository;


import com.example.hellopizza.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

// interfaccia che eredita da JpaRepository tutti i metodi che permettono di fare le CRUD
// i generics chiedono: che tipo di dato è l'entità (Book) e che tipo di dato è la chiave primaria (Integer)
public interface PizzaRepository extends JpaRepository<Pizza, Integer> {


    Optional<Pizza> findByNome(String nome);

    List<Pizza> findByNomeContaining(String search);
}
