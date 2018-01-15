package ar.com.i2t.rest;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import ar.com.i2t.service.ComprobanteCabeceraService;
import ar.com.mavha.commons.rest.server.Utils;
import ar.com.sancord.commons.dto.ComprobanteCabeceraDTO;


@Stateless
@Path("comprobante")
public class ComprobanteCabeceraREST {

    @Inject
    private ComprobanteCabeceraService comprobanteCabeceraService;

    
    
    @GET
    @Path(value = "buscar")
    @Produces({MediaType.APPLICATION_JSON})
    public List<ComprobanteCabeceraDTO> find(@Context UriInfo uriInfo) {
        Map<String, String> queryParameters = Utils.extractQueryParameters(uriInfo);
        return comprobanteCabeceraService.findByQueryParameters(queryParameters);
    }

    @GET
    @Path(value = "count")
    @Produces({MediaType.APPLICATION_JSON})
    public long count(@Context UriInfo uriInfo) {
        Map<String, String> queryParameters = Utils.extractQueryParameters(uriInfo);
        return comprobanteCabeceraService.countByQueryParameters(queryParameters);
    }

}
