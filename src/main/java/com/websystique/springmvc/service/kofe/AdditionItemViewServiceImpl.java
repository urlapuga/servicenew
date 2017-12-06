package com.websystique.springmvc.service.kofe;

import com.websystique.springmvc.dao.kofe.AddItemsViewDao;
import com.websystique.springmvc.model.kofe.KofeAddItemView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("additionsitemsviewService")
@Transactional
public class AdditionItemViewServiceImpl implements AdditionItemViewService {

    @Autowired
    private AddItemsViewDao dao;

    public List<KofeAddItemView> findAll() {
        return dao.findAll();
    }

    @Override
    public List<KofeAddItemView> findByAddition(int id) {
        return dao.getByAddition(id);
    }


}
