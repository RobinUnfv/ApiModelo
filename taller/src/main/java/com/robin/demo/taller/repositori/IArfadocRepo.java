package com.robin.demo.taller.repositori;

import com.robin.demo.taller.entity.Arfadoc;
import com.robin.demo.taller.entity.ArfadocId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IArfadocRepo extends JpaRepository<Arfadoc, ArfadocId> {

    @Query("Select a from Arfadoc a where a.id.noCia = :noCia")
    List<Arfadoc> listaDocumentosNoCia(@Param("noCia") String noCia);

    @Query("Select a from Arfadoc a where a.id.noCia = :noCia and a.descripcion like :descripcion ")
    List<Arfadoc> buscarDescripDoc(@Param("noCia") String noCia, @Param("descripcion") String descripcion);
}
