package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.OpticLines;

import java.util.List;

public interface OpticLinesDao {
    List<OpticLines> findAll();
    void add(OpticLines opticLines);
    void delete(OpticLines opticLines);
}
