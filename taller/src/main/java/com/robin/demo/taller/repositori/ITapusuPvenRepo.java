package com.robin.demo.taller.repositori;

import com.robin.demo.taller.entity.TapusuPvenEntity;
import com.robin.demo.taller.entity.TapusuPvenIdEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITapusuPvenRepo extends JpaRepository<TapusuPvenEntity, TapusuPvenIdEntity> {
}
