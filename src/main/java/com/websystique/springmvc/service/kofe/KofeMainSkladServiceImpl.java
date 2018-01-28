package com.websystique.springmvc.service.kofe;

import com.websystique.springmvc.dao.kofe.MainSkladDao;
import com.websystique.springmvc.model.kofe.KofeMainSklad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("kofemainskladService")
@Transactional
public class KofeMainSkladServiceImpl implements KofeMainSkladService {

    @Autowired
    private MainSkladDao dao;

    public List<KofeMainSklad> findAll() {
        return dao.findAll();
    }

    @Override
    public void addIngredient(KofeMainSklad kofeMainSklad) {
        dao.addIngredient(kofeMainSklad);
    }


}
