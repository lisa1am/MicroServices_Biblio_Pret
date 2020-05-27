package fr.dauphine.miageif.msa.Biblio.Repository;

import fr.dauphine.miageif.msa.Biblio.Pret;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PretRepository extends JpaRepository<Pret, Long> {
    /*Pret findByIsbn(String isbn);

    List<Pret> findAllByAuteur(String Auteur);

    void deleteByIsbn(String isbn);

    boolean existsByIsbn(String isbn);*/



}
