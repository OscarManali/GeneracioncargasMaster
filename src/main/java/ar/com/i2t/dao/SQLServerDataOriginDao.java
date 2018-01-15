package ar.com.i2t.dao;


import ar.com.mavha.commons.AbstractDao;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class SQLServerDataOriginDao<T> extends AbstractDao<T> {

    // Definición del origen de datos, ejemplo sql server data source 
    @PersistenceContext(unitName = "db2DataSource")
    private EntityManager em;

    public SQLServerDataOriginDao(Class<T> entityClass) {
        super(entityClass);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
