package model.DAO;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Patata kawaii on 05/02/2017.
 */

@Repository(value = "juegosDAO")
public class JuegosDAO {

    @PersistenceContext
    private EntityManager entityManager;

}
