package com.robin.demo.taller.controller.programacion;

import com.robin.demo.taller.controller.commons.ResponseRest;
import com.robin.demo.taller.controller.generic.GenericController;
import com.robin.demo.taller.entity.Arfacc;
import com.robin.demo.taller.entity.ArfaccId;
import com.robin.demo.taller.service.exception.ServiceException;
import com.robin.demo.taller.service.programacion.info.IArfaccServi;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping("/api/arfacc/v1")
public class ArfaccContro extends GenericController {

    @Autowired
    private IArfaccServi arfaccServi;

    @PostMapping()
    @RequestMapping("/id")
    public ResponseEntity<ResponseRest> getArfacc(@RequestBody ArfaccId arfaccId, BindingResult result) {
        if (result.hasErrors()) {
            return super.getBadRequest(result);
        }
        try {
            Arfacc arfacc = arfaccServi.buscarPorCodigo(arfaccId);
            if (arfacc != null) {
                return super.getOKConsultaRequest(arfacc);
            }
            return super.getNotFoundRequest();
        } catch (ServiceException e) {
            return super.getNotFoundRequest();
        }
    }


}
