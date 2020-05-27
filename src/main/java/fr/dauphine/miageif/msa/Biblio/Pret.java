package fr.dauphine.miageif.msa.Biblio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

@Entity
public class Pret {

    @Id
    private String id;

    @Column(name="isbn")
    private String isbn;

    @Column(name="lecteur")
    private String lecteur;

    @Column(name="date_pret")
    private Date date_pret;

    @Column(name="date_retour")
    private Date date_retour;




}
