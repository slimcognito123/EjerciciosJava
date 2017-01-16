package prueba;

import beans.Pelicula;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Pruebas {
        public static void main(String[] args) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("pruebaJPA");
            EntityManager em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            Pelicula pelicula = new Pelicula();
            pelicula.setNombre("Pelicula uno");
            pelicula.setDuration(142);
            tx.begin();
            try {
                em.persist(pelicula);
                tx.commit();
            } catch (Exception e) {
                tx.rollback();
            }
            em.close();
            emf.close();
        }
}
