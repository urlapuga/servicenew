package com.websystique.springmvc.service;

import com.websystique.springmvc.dao.statistics.AllManagerWorkDao;
import com.websystique.springmvc.model.statistics.Allmanagerwork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service("statisticsService")
@Transactional
public class StatisticsServiceImpl  implements StatisticsService{

    @Autowired
    AllManagerWorkDao allManagerWorkDao;

    @Override
    public List<Allmanagerwork> allManworkList() {
        return allManagerWorkDao.get();
    }
}
