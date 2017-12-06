package com.websystique.springmvc.service.kofe;

import com.websystique.springmvc.model.kofe.KofeAddItemView;
import com.websystique.springmvc.model.kofe.KofeAdditionsItems;

import java.util.List;

public interface AdditionItemViewService {
     List<KofeAddItemView> findAll();
     List<KofeAddItemView> findByAddition(int id);

}
