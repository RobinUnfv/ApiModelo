package com.robin.demo.taller.repositori;

import com.robin.demo.taller.entity.Arfafe;
import com.robin.demo.taller.entity.ArfafeId;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IArfafeRepo extends PagingAndSortingRepository<Arfafe, ArfafeId> {
}
