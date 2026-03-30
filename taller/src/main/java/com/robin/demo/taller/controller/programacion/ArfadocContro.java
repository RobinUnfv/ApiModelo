package com.robin.demo.taller.controller.programacion;

import com.robin.demo.taller.controller.commons.ResponseRest;
import com.robin.demo.taller.controller.generic.GenericController;
import com.robin.demo.taller.entity.Arfadoc;
import com.robin.demo.taller.entity.ArfadocId;
import com.robin.demo.taller.service.exception.ServiceException;
import com.robin.demo.taller.service.programacion.info.IArfadocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/arfadoc/v1")
public class ArfadocContro extends GenericController {

    @Autowired
    private IArfadocService  arfadocService;

    @GetMapping
    @RequestMapping("/buscar")
    public ResponseEntity<ResponseRest> buscarDescripDoc(@RequestParam String noCia, @RequestParam String descripcion) {
        List<Arfadoc> documentos = arfadocService.buscarDescripDoc(noCia, descripcion);
        if ( documentos.isEmpty() ) {
            //return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            return super.getNotFoundRequest();
        }
        return super.getOKConsultaRequest(documentos);
    }

    @GetMapping()
    @RequestMapping("/id")
    public ResponseEntity<ResponseRest> getArfadoc(@RequestParam String noCia, @RequestParam String codDoc) {
        try {
            ArfadocId arfadocId = new ArfadocId();
            arfadocId.setNoCia(noCia);
            arfadocId.setCodDoc(codDoc);
            Arfadoc arfadoc = arfadocService.buscarPorCodigo(arfadocId);
            if ( arfadoc == null ) {
                return super.getNotFoundRequest();
            }
            return  super.getOKConsultaRequest(arfadoc);
        } catch (ServiceException e) {
            return super.getErrorRequest();
        }
    }

    @GetMapping
    @RequestMapping("/lista")
    public List<Arfadoc> getAllArfadoc(String noCia) {
        return arfadocService.getAllArfadoc(noCia);
    }

    @PostMapping
    public ResponseEntity<ResponseRest> insertar( @Validated @RequestBody Arfadoc arfadoc, BindingResult result) {

        if (result.hasErrors()) {
            //String msgErr = result.getAllErrors().toString();
            //throw new ResponseStatusException(HttpStatus.BAD_REQUEST, msgErr);
            //throw new ResponseStatusException(HttpStatus.BAD_REQUEST, super.formatMapMessage(result));
            return super.getBadRequest(result);
        }

        Arfadoc doc = arfadocService.crearArfadoc(arfadoc);
        if ( doc != null ) {
            //return ResponseEntity.status(HttpStatus.CREATED).body(doc);
            return super.getCreatedRequest(doc);
        }

        return super.getErrorRequest();

    }

    @PutMapping("/{noCia}/{codDoc}")
    public Arfadoc editar(@PathVariable String noCia, @PathVariable String codDoc, @RequestBody Arfadoc arfadoc) {
        ArfadocId id = new ArfadocId();
        id.setNoCia(noCia);
        id.setCodDoc(codDoc);
        arfadoc.setId(id);
        return arfadocService.crearArfadoc(arfadoc);
    }

}
