package com.robin.demo.taller.controller.programacion;

import com.robin.demo.taller.controller.commons.ResponseRest;
import com.robin.demo.taller.controller.generic.GenericController;
import com.robin.demo.taller.entity.TapusuPvenEntity;
import com.robin.demo.taller.entity.TapusuPvenIdEntity;
import com.robin.demo.taller.service.exception.ServiceException;
import com.robin.demo.taller.service.programacion.info.ITapusuPvenServi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuario")
public class TapusuPvenContro extends GenericController {

    @Autowired
    private ITapusuPvenServi  tapusuPvenServi;


    @GetMapping
    @RequestMapping("/id")
    public ResponseEntity<ResponseRest> getUsuario(@RequestParam String noCia, @RequestParam String usuario) {
        try{
            TapusuPvenIdEntity tapusuPvenIdEntity = new TapusuPvenIdEntity();
            tapusuPvenIdEntity.setUsuario(usuario);
            tapusuPvenIdEntity.setNoCia(noCia);
            TapusuPvenEntity tapusuPvenEntity = tapusuPvenServi.buscarPorCodigo(tapusuPvenIdEntity);
            if ( tapusuPvenEntity == null ) {
                return super.getNotFoundRequest();
            }
            return super.getOKConsultaRequest(tapusuPvenEntity);
        }catch (ServiceException ex) {
            return super.getErrorRequest();
        }
    }

}
