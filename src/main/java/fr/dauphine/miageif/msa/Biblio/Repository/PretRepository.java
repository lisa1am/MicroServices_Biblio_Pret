package fr.dauphine.miageif.msa.Biblio.Repository;

import fr.dauphine.miageif.msa.Biblio.Pret;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface PretRepository extends JpaRepository<Pret, Long> {

    List<Pret> findAllByIdLecteur(Long IdLecteur);

    List<Pret> findAllByIsbn(String isbn);

    Pret findAllByIdLecteurAndIsbn(Long IdLecteur, String isbn);

    List<Pret> findAllByDate(Date date_emprunt);

    List<Pret> findAll();

    boolean existsByIsbn(String isbn);

    boolean existsByIdLecteur(Long id);
}
