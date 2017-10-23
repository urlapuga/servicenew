package com.websystique.springmvc.service;

import com.websystique.springmvc.model.Companies;
import com.websystique.springmvc.model.OpticLines;

import java.util.List;

public interface OpticLinesService {

    List<OpticLines> findAll();
    void add(OpticLines entity);
    void delete(OpticLines entity);
}
