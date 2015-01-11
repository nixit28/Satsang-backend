package com.satsang.webapps.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by nixit on 12/17/14.
 */
@Entity
@Table(name = "Quote", schema = "", catalog = "satsang")
public class Quote {
    private int idQuotes;

    @NotEmpty
    private String quote;
    private Granth granth;
    private Orator orator;
    private List<Category> category = new ArrayList<Category>();
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date datePublish;
    private String type;


    @Id
    @Column(name = "id_quote")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getIdQuotes() {
        return idQuotes;
    }

    public void setIdQuotes(Integer idQuotes) {
        this.idQuotes = idQuotes;
    }

    @Basic
    @Column(name = "quote")
    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    @Basic
    @Column(name = "date_publish")
    public Date getDatePublish() {
        return datePublish;
    }

    public void setDatePublish(Date datePublish) {
        this.datePublish = datePublish;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @ManyToOne(optional=false)
    @JoinColumn(name="id_granth",referencedColumnName="id_granth")
    public Granth getGranth() {
        return granth;
    }

    public void setGranth(Granth granth) {
        this.granth = granth;
    }

    @ManyToOne(optional=false)
    @JoinColumn(name="id_orator",referencedColumnName="id_orator")
    public Orator getOrator() {
        return orator;
    }

    public void setOrator(Orator orator) {
        this.orator = orator;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Quote_Category", joinColumns = { @JoinColumn(name = "id_quote") }, inverseJoinColumns = { @JoinColumn(name = "id_category") })
    public List<Category> getCategory() {
        return category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Quote that = (Quote) o;

        if (idQuotes != that.idQuotes) return false;
        if (quote != null ? !quote.equals(that.quote) : that.quote != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idQuotes;
        result = 31 * result + (quote != null ? quote.hashCode() : 0);
        return result;
    }
}
