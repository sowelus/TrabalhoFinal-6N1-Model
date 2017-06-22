package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Suelen A. Camargo
 * @email s-a-camargo@hotmail.com
 */
@Entity
@Table(name = "clinica")
public class Clinica implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_clinica", sequenceName = "seq_clinica_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_clinica", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotNull(message = "A razão social  não pode ser nulo")
    @NotBlank(message = "A razão social não pode ser em branco")
    @Length(max = 50, message = "O nomeA razão social não pode ter mais que {max} caracteres")
    @Column(name = "razaosocial", length = 50, nullable = false)
    private String razaoSocial;
    
    @NotNull(message = "O endereço não pode ser nulo")
    @NotBlank(message = "O endereço não pode ser em branco")
    @Length(max = 50, message = "O endereço não pode ter mais que {max} caracteres")
    @Column(name = "endereco", length = 50, nullable = false)    
    private String endereco;
    
       
    @NotNull(message = "O telefone não pode ser nulo")
    @NotBlank(message = "O telefone não pode ser em branco")
    @Length(max = 50, message = "O endereco não pode ter mais que {max} caracteres")
    @Column(name = "telefone", length = 50, nullable = false)    
    private String telefone;
    
    
    @OneToMany(mappedBy = "clinica", cascade = CascadeType.ALL, 
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Medico> medicos = new ArrayList<>();

    public Clinica() {
    }

    public void adicionarMedico(Medico obj){
        obj.setClinica(this);
        this.medicos.add(obj);
    }
    
    public void removerMedico(int idx){
        this.medicos.remove(idx);
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public List<Medico> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<Medico> medicos) {
        this.medicos = medicos;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final Clinica other = (Clinica) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
