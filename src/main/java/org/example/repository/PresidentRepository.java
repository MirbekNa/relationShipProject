package org.example.repository;

import org.example.entity.Country;
import org.example.entity.President;

import java.util.List;

public interface PresidentRepository {
    String save (President president);
    String delete(Long id);
    void   getPresidents(List<President>presidents);
}
