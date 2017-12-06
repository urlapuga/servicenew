package com.websystique.springmvc.service.kofe;

import com.websystique.springmvc.dao.kofe.IngredientsDao;
import com.websystique.springmvc.model.kofe.KofeIngredients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("ingredientsService")
@Transactional
public class IngredientsServiceImpl implements IngredientsService {

    @Autowired
    private IngredientsDao dao;

    public List<KofeIngredients> findAll() {
        return dao.findAll();
    }

    public void add(KofeIngredients entity) {

        dao.add(entity);
    }

    public void update(KofeIngredients entity) {
        dao.update(entity);
    }

    public void delete(KofeIngredients entity) {
        dao.delete(entity);
    }

    public void deleteById(int id) {
        dao.deleteById(id);
    }

    public KofeIngredients getById(int id) {
        return dao.getById(id);
    }

}
