package com.websystique.springmvc.dao.kofe;

import com.websystique.springmvc.model.kofe.KofeItemTypes;
import com.websystique.springmvc.model.kofe.KofeItems;

import java.util.List;

public interface ItemsDao {
    List<KofeItems> findByType(int type);
    List<KofeItems> findAll();
    void add(KofeItems entity);
    void update(KofeItems entity);
    void delete(KofeItems entity);
    void deleteById(int id);
    KofeItems getById(int id);
}
