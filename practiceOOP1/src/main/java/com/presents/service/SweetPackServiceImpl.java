package com.presents.service;

import com.presents.repository.SweetPackRepository;
import com.presents.sweets.SweetPack;

import java.util.Set;

public class SweetPackServiceImpl implements SweetPackService {

    private final SweetPackRepository repository;

    public SweetPackServiceImpl(SweetPackRepository repository) {
        this.repository = repository;
    }

    @Override
    public Set<SweetPack> selectAll() {
        return repository.selectAll();
    }

    @Override
    public Set<SweetPack> select(Set<Integer> ids) {
        return repository.select(ids);
    }

    @Override
    public void delete(Set<Integer> ids) {
        repository.delete(ids);
    }

    @Override
    public void insert(Set<SweetPack> sweetPacks) {
        repository.insert(sweetPacks);
    }
}
