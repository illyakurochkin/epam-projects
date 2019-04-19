package com.presents.service;

import com.presents.repository.SweetRepository;
import com.presents.sweets.Sweet;

import java.util.Set;

public class SweetServiceImpl implements SweetService {

    private SweetRepository sweetRepository;

    public SweetServiceImpl(SweetRepository sweetRepository) {
        this.sweetRepository = sweetRepository;
    }

    @Override
    public Set<Sweet> selectAll() {
        return sweetRepository.selectAll();
    }

    @Override
    public Set<Sweet> select(Set<Integer> ids) {
        return sweetRepository.select(ids);
    }

    @Override
    public void delete(Set<Integer> ids) {
        sweetRepository.delete(ids);
    }

    @Override
    public void insert(Set<Sweet> sweets) {
        sweetRepository.insert(sweets);
    }

    @Override
    public Set<Sweet> selectByName(String name) {
        return sweetRepository.selectByName(name);
    }

    @Override
    public Set<Sweet> selectByBrand(String brand) {
        return sweetRepository.selectByBrand(brand);
    }

    @Override
    public Sweet select(int id) {
        return sweetRepository.select(id);
    }

    @Override
    public void delete(int id) {
        sweetRepository.delete(id);
    }

    @Override
    public void insert(Sweet sweet) {
        sweetRepository.insert(sweet);
    }
}
