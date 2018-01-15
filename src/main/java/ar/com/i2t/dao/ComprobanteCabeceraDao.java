package ar.com.i2t.dao;

import ar.com.mavha.commons.Expression;
import ar.com.sancord.commons.entities.ComprobanteCabecera;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import org.apache.commons.lang3.StringUtils;


@Stateless
public class ComprobanteCabeceraDao extends SQLServerDataOriginDao<ComprobanteCabecera> {

	// agrego un comentario vuelvo
	
    public ComprobanteCabeceraDao() {
        super(ComprobanteCabecera.class);
    }

    /**
     * Contar en base los filtros aplicados 
     * @param queryParameters
     * @return long
     */
    public long countByQueryParameters(Map<String, String> queryParameters) {
        return count(buildExpressions(queryParameters));
    }

    /**
     * Encontrar en base los filtros aplicados 
     * @param queryParameters
     * @return List<Transaccion>
     */
    public List<ComprobanteCabecera> findByQueryParameters(Map<String, String> queryParameters) {
//        if (queryParameters.containsKey("startPosition") && queryParameters.containsKey("maxResults")) {
//            return find(
//                    buildExpressions(queryParameters),
//                    Integer.valueOf(queryParameters.get("startPosition")),
//                    Integer.valueOf(queryParameters.get("maxResults"))
//            );
//        } else {
//           return new ArrayList<>();
//
//        }
    	
    	// return this.find(buildExpressions(queryParameters));
    	String jpql = "Select a from ComprobanteCabecera a where nCarga = :nCarga";
    	Map p = new HashMap();
    	p.put("nCarga", 2L);
    	return this.find(jpql, p);
    }
    
    /**
     * Método privado para reutilizar la lógica de la consulta, excepto el
     * paginado
     *
     * @param queryParameters
     * @return
     */
    private List<Expression> buildExpressions(Map<String, String> queryParameters) {
        List<Expression> expressions = Expression.createEmptyList();
       if (queryParameters.containsKey("nCarga")) {
            expressions.add(Expression.equal("nCarga", queryParameters.get("nCarga")));
       } 
        return expressions;
    }

}
