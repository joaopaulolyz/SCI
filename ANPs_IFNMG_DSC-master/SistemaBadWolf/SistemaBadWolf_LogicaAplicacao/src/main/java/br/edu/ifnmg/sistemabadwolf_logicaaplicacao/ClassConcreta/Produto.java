package br.edu.ifnmg.sistemabadwolf_logicaaplicacao.ClassConcreta;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

/**
 *
 * @author João Paulo
 */
@Entity
@Table(name="Produtos")
@SecondaryTable(name = "estoques")
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(length = 250, nullable = false, unique = true)
    private String nome;
    
    @Column(precision = 8, scale = 2)
    private BigDecimal preco_unitario; 
    
    @Column(precision = 8, scale = 2)
    private BigDecimal preco_entrada;
    
    @Column(nullable = false, table = "estoques")
    private int estoque;
    
    

    public Produto() {
        this.id = 0L;
        this.nome = "";
        this.preco_entrada = new BigDecimal("0.00");
        this.estoque = 0;
    }

    public Produto(Long id, String nome, String preco_entrada, int estoque) {
        this.id = 0L;
        this.nome = nome;
        this.preco_entrada = new BigDecimal(preco_entrada);
        this.estoque = estoque;
    }
    
    
        

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco_unitario() {
        return preco_entrada;
    }

    public void setPreco_unitario(BigDecimal preco_unitario) {
        this.preco_entrada = preco_unitario;
    }
    
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.nome;
    }

}
