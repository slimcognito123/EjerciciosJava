package model.business;

import model.DAO.JuegosDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by Patata kawaii on 05/02/2017.
 */
@Service(value = "juegoBusiness")
public class juegoBusiness {

    @Autowired
    @Qualifier("juegosDAO")
    JuegosDAO juegosDAO;
}
