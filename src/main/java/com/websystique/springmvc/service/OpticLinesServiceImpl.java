package com.websystique.springmvc.service;

import com.websystique.springmvc.dao.OpticLinesDao;
import com.websystique.springmvc.model.OpticLines;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("opticLinesService")
@Transactional
public class OpticLinesServiceImpl implements OpticLinesService {

    @Autowired
    OpticLinesDao dao;

    @Override
    public List<OpticLines> findAll() {
        return dao.findAll();
    }

    @Override
    public void add(OpticLines entity) {
        dao.add(entity);
    }

    @Override
    public void delete(OpticLines entity) {
        dao.delete(entity);
    }
}
