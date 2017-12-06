package com.websystique.springmvc.service.kofe;

import com.websystique.springmvc.dao.kofe.ItemsIngredientsViewDao;
import com.websystique.springmvc.model.kofe.KofeItemIngredientsView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("itemingredientsService")
@Transactional
public class ItemIngredientsViewServiceImpl implements ItemIngredientsViewService {

    @Autowired
    private ItemsIngredientsViewDao dao;

    public List<KofeItemIngredientsView> findAll() {
        return dao.findAll();
    }

    @Override
    public List<KofeItemIngredientsView> findByItem(int id) {
        return dao.getByItem(id);
    }


}
