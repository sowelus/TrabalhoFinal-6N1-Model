package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Medico;
import br.edu.ifsul.modelo.Clinica;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Suelen A. Camargo
 * @email s-a-camargo@hotmail.com
 */
public class TestePersistirMedico {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirMedico() {
    }
    
    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("TrabalhoFinal-6N1-ModelPU");
        em = emf.createEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
        emf.close();
    }
    
    @Test
    public void teste(){
        boolean exception = false;
        try {
            
            Medico c = new Medico();
            c.setCremers("303020");
            c.setNome("Kim Seokjin");
            c.setEmail("ks@centralclinicas.med");
            c.setClinica(em.find(Clinica.class, 1));
            
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
            
        } catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        // verifica se o atributo exception ainda é falso para passar no teste
        Assert.assertEquals(false, exception);
    }
    
    
    
    
}
