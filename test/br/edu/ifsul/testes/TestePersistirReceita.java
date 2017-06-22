package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Remedio;
import br.edu.ifsul.modelo.Medico;
import br.edu.ifsul.modelo.Paciente;
import br.edu.ifsul.modelo.Receita;
import java.util.Calendar;
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
public class TestePersistirReceita {
    
  EntityManagerFactory emf;
    EntityManager em;
    

    public TestePersistirReceita() {

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
    public void teste() {
        boolean exception = false;
        try {
            Receita obj = new Receita();
            obj.setDataPrescricao(Calendar.getInstance());
            obj.setDataValidade(Calendar.getInstance());
            obj.setObservacao("Ingerir pela manhã");
            obj.setMedico(em.find(Medico.class, 1));
            obj.setPaciente(em.find(Paciente.class, 1));
            
            Remedio p = em.find(Remedio.class, 1);
            obj.getRemedios().add(p);
            
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            exception = true;
            
        }
        // verificando se o resultado é igual ao esperado
        Assert.assertEquals(false, exception);
    }
    
}
