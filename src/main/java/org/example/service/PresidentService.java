package org.example.service;

import org.example.entity.Country;
import org.example.entity.President;

import java.util.List;

public interface PresidentService {
    String save (President president);
    String delete(Long id);
   void   getPresidents(List<President>presidents);
}
