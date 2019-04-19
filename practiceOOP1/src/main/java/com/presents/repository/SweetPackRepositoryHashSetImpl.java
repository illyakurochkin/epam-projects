package com.presents.repository;

import com.presents.sweets.SweetPack;

import java.util.HashSet;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class SweetPackRepositoryHashSetImpl implements SweetPackRepository {

    private final Set<SweetPack> set;

    public SweetPackRepositoryHashSetImpl(Set<SweetPack> set) {
        this.set = new HashSet<>(set);
    }

    public SweetPackRepositoryHashSetImpl(){
        this(new HashSet<>());
    }

    @Override
    public Set<SweetPack> selectAll() {
        return new HashSet<>(set);
    }

    @Override
    public Set<SweetPack> select(Set<Integer> ids) {
        return set.stream()
                .filter(sweetPack -> ids.contains(sweetPack.getId()))
                .collect(toSet());
    }

    @Override
    public void delete(Set<Integer> ids) {
        set.removeIf(sweetPack -> ids.contains(sweetPack.getId()));
    }

    @Override
    public void insert(Set<SweetPack> sweetPacks) {
        set.addAll(sweetPacks);
    }
}
