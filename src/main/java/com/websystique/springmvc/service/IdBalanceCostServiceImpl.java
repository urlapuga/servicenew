package com.websystique.springmvc.service;

import com.websystique.springmvc.dao.IdBalanceCostDao;
import com.websystique.springmvc.model.Idbalancecost;
import jdk.nashorn.internal.ir.annotations.Immutable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("companiesService")
@Transactional
@Immutable
public class IdBalanceCostServiceImpl implements IdBalanceCostService {

    @Autowired
    private IdBalanceCostDao dao;

    public List<Idbalancecost> findAll() {
        return dao.findAll();
    }

}
