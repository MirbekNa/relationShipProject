package org.example.service.impl;

import org.example.entity.President;
import org.example.repository.impl.PresidentRepositoryImpl;
import org.example.service.PresidentService;

import java.util.List;

public class PresidentServiceImpl implements PresidentService {
    PresidentRepositoryImpl presidentRepository = new PresidentRepositoryImpl();
    @Override
    public String save(President president) {
        return  presidentRepository.save(president);
    }

    @Override
    public String delete(Long id) {
        return presidentRepository.delete(id);
    }

    @Override
    public void   getPresidents(List<President>presidents) {
         presidentRepository.getPresidents(presidents);
    }
}
