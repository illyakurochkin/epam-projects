package com.presents.service;

import com.presents.sweets.SweetPack;

import java.util.Set;

public interface SweetPackService {

    Set<SweetPack> selectAll();

    Set<SweetPack> select(Set<Integer> ids);

    void delete(Set<Integer> ids);

    void insert(Set<SweetPack> sweetPacks);
}
