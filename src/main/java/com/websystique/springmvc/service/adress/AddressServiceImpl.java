package com.websystique.springmvc.service.adress;

import com.websystique.springmvc.dao.adress.AddressDao;
import com.websystique.springmvc.model.address.AddrAdress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("addressService")
@Transactional
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressDao dao;

    public List<AddrAdress> findAll() {
        return dao.findAll();
    }

    public void add(AddrAdress entity) {
        dao.add(entity);
    }

}
