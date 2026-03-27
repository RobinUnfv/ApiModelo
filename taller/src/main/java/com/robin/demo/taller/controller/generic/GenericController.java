package com.robin.demo.taller.controller.generic;

import com.robin.demo.taller.controller.commons.ResponseEstado;
import com.robin.demo.taller.controller.commons.ResponseRest;
import com.robin.demo.taller.controller.constants.ResponseContants;
import com.robin.demo.taller.controller.enums.ResponseEnums;
import com.robin.demo.taller.entity.Arfadoc;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class GenericController {

    @Value("${api.version}")
    private String apiVersion;

    protected String formatMapMessage(BindingResult result) {
        List<Map<String, String>> errors =
                result.getFieldErrors().stream().map(err ->
                        {
                            Map<String, String> error = new HashMap<>();
                            error.put(err.getField(), err.getDefaultMessage());
                            return error;
                        }

                ).collect(Collectors.toList());
        return errors.toString();
    }

    protected List<Map<String, String>> formatMapMessageList(BindingResult result) {
        List<Map<String, String>> errors =
                result.getFieldErrors().stream().map(err ->
                        {
                            Map<String, String> error = new HashMap<>();
                            error.put(err.getField(), err.getDefaultMessage());
                            return error;
                        }

                ).collect(Collectors.toList());
        return errors;
    }

    protected ResponseEntity<ResponseRest> getBadRequest(BindingResult result){
        ResponseRest res= 	ResponseRest.builder()
                .apiVersion(apiVersion)
                .estado(
                        ResponseEstado.builder()
                                .codigo(ResponseEnums.ALERTA)
                                .mensaje(ResponseContants.MSG_REG_ALERTA)
                                .estado(HttpStatus.BAD_REQUEST.value())
                                .error(HttpStatus.BAD_REQUEST.name())
                                .detalle(this.formatMapMessageList(result))
                                .build())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
    }

    protected ResponseEntity<ResponseRest> getBadRequest(String detalle){
        ResponseRest res= 	ResponseRest.builder()
                .apiVersion(apiVersion)
                .estado(
                        ResponseEstado.builder()
                                .codigo(ResponseEnums.ALERTA)
                                .mensaje(ResponseContants.MSG_AlER_GENE)
                                .estado(HttpStatus.BAD_REQUEST.value())
                                .error(HttpStatus.BAD_REQUEST.name())
                                .detalle(detalle)
                                .build())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
    }

    protected ResponseEntity<ResponseRest> getBadIdRequest(){
        return this.getBadRequest(ResponseContants.ID_ALERTA);
    }

    protected ResponseEntity<ResponseRest> getNotFoundRequest(){
        ResponseRest res= 	ResponseRest.builder()
                .apiVersion(apiVersion)
                .estado(
                        ResponseEstado.builder()
                                .codigo(ResponseEnums.ALERTA)
                                .mensaje(ResponseContants.MSG_CONS_SIN_CONT)
                                .estado(HttpStatus.NOT_FOUND.value())
                                .error(HttpStatus.NOT_FOUND.name())
                                .build())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
    }

    protected ResponseEntity<ResponseRest> getCreatedRequest(Object obj){
        ResponseRest res= 	ResponseRest.builder()
                .apiVersion(apiVersion)
                .estado(
                        ResponseEstado.builder()
                                .codigo(ResponseEnums.EXITO)
                                .mensaje(ResponseContants.MSG_REG_EXITO)
                                .estado(HttpStatus.OK.value())
                                .error(HttpStatus.OK.name())
                                .build())
                .resultado(obj)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }

    protected ResponseEntity<ResponseRest> getOKRegistroRequest(Object obj){
        ResponseRest res= 	ResponseRest.builder()
                .apiVersion(apiVersion)
                .estado(
                        ResponseEstado.builder()
                                .codigo(ResponseEnums.EXITO)
                                .mensaje(ResponseContants.MSG_REG_EXITO)
                                .estado(HttpStatus.OK.value())
                                .error(HttpStatus.OK.name())
                                .build())
                .resultado(obj)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    protected ResponseEntity<ResponseRest> getOKConsultaRequest(Object obj){
        ResponseRest res= 	ResponseRest.builder()
                .apiVersion(apiVersion)
                .estado(
                        ResponseEstado.builder()
                                .codigo(ResponseEnums.EXITO)
                                .mensaje(ResponseContants.MSG_CONS_EXITO)
                                .estado(HttpStatus.OK.value())
                                .error(HttpStatus.OK.name())
                                .build())
                .resultado(obj)
                .build();
        return ResponseEntity.ok(res);
    }

    public ResponseEntity<ResponseRest> getErrorRequest() {
        ResponseRest res= 	ResponseRest.builder()
                .apiVersion(apiVersion)
                .estado(
                        ResponseEstado.builder()
                                .codigo(ResponseEnums.ERROR)
                                .mensaje(ResponseContants.MSG_ERR_GENE)
                                .estado(HttpStatus.INTERNAL_SERVER_ERROR.value())
                                .error(HttpStatus.INTERNAL_SERVER_ERROR.name())
                                .build())
                .build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);
    }

}
