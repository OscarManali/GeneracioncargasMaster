package ar.com.i2t.service;

import ar.com.sancord.commons.dto.ComprobanteCabeceraDTO;
import ar.com.i2t.dao.ComprobanteCabeceraDao;

import ar.com.mavha.commons.utils.Converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * 
 */
@Stateless
public class ComprobanteCabeceraService {

    @Inject
    private ComprobanteCabeceraDao comprobanteCabeceraDao;

    public long countByQueryParameters(Map<String, String> queryParameters) {
        return comprobanteCabeceraDao.countByQueryParameters(queryParameters);
    }

    public List<ComprobanteCabeceraDTO> findByQueryParameters(Map<String, String> queryParameters) {
        List<ComprobanteCabeceraDTO> result = new ArrayList<>();
        comprobanteCabeceraDao.findByQueryParameters(queryParameters).stream().map((entity) -> Converter.map(ComprobanteCabeceraDTO.class, entity)).forEachOrdered((dto) -> {
            result.add(dto);
        });
        return result;
    }
}
