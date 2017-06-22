
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Suelen A. Camargo
 * @email s-a-camargo@hotmail.com
 */
@Entity
@Table(name = "medico")
public class Medico implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_medico", sequenceName = "seq_medico_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_medico", strategy = GenerationType.SEQUENCE)    
    private Integer id;
   
    
    @NotNull(message = "O nome não pode ser nulo")
    @Length(max = 40, message = "O nome não pode ter mais de {max} caracteres")
    @NotBlank(message = "O nome não pode ser em branco")
    @Column(name = "nome", length = 40, nullable = false)
    private String nome;    
    
    @NotNull(message = "O cremers não pode ser nulo")
    @Length(max = 40, message = "O cremers não pode ter mais de {max} caracteres")
    @NotBlank(message = "O cremers não pode ser em branco")
    @Column(name = "cremers", length = 40, nullable = false)
    private String cremers;    
    
    @NotNull(message = "O email não pode ser nulo")
    @NotBlank(message = "O email não pode ser em branco")
    @Length(max = 50, message = "O email não pode ter mais que {max} caracteres")
    @Column(name = "email", length = 50, nullable = false)    
    private String email;   
     
    @NotNull(message = "A clinica não pode ser nula")
    @ManyToOne
    @JoinColumn(name = "clinica", referencedColumnName = "id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_medico_clinica"))        
    private Clinica clinica;

    public Medico() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getCremers() {
        return cremers;
    }

    public void setCremers(String cremers) {
        this.cremers = cremers;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Clinica getClinica() {
        return clinica;
    }

    public void setClinica(Clinica clinica) {
        this.clinica = clinica;
    }
   
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Medico other = (Medico) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }


}
