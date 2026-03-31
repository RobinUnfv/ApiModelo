package com.robin.demo.taller.controller.programacion;

import com.robin.demo.taller.service.exception.ServiceException;
import com.robin.demo.taller.service.programacion.info.IArfafeServi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/arfafe")
public class ArfafeContro {

    @Autowired
    private IArfafeServi  arfafeServi;

    @GetMapping("/pagin-campo")
    public ResponseEntity<Object> pagPorNombre(@RequestParam int limit,
                                               @RequestParam int page,
                                               @RequestParam String orden,
                                               @RequestParam String campo) {
        try {
          Object lst = arfafeServi.listaPagina(limit, page, orden, campo);
          if(lst != null) {
              return ResponseEntity.ok(lst);
          }
            return ResponseEntity.noContent().build();
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
