package com.websystique.springmvc.dao.statistics;

import com.websystique.springmvc.dao.AbstractDao;
import com.websystique.springmvc.model.Companies;
import com.websystique.springmvc.model.statistics.Allmanagerwork;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("allManagerWorkDao")
public class AllManagerWorkDaoImpl extends AbstractDao<Integer, Allmanagerwork>implements AllManagerWorkDao
{
    public List<Allmanagerwork> get() {
        Criteria criteria = createEntityCriteria();
        List<Allmanagerwork> entitylist = (List<Allmanagerwork>) criteria.list();
        return entitylist;
    }
}
