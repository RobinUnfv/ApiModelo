package com.robin.demo.taller.repositori;

import com.robin.demo.taller.entity.Arfacc;
import com.robin.demo.taller.entity.ArfaccId;
import com.robin.demo.taller.entity.Arfadoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IArfaccRepo extends JpaRepository<Arfacc, ArfaccId> {
}
