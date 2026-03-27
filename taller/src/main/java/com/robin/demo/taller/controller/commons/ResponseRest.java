package com.robin.demo.taller.controller.commons;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseRest {
    private String apiVersion;
    private ResponseEstado estado;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object resultado;
    /*
    @Builder.Default
    private Date fechaHora =  new Date();

    private HttpStatus estado;
    private String error;
    private Object mensaje;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object detalle;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object registro;
    */
}
