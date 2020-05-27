package fr.dauphine.miageif.msa.Biblio.Repository;

import fr.dauphine.miageif.msa.Biblio.Pret;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface PretRepository extends JpaRepository<Pret, Long> {

    List<Pret> findAllByLecteur(Long lecteur);

    List<Pret> findAllByIsbn(String isbn);

    Pret findAllByLecteurAndIsbn(Long lecteur, String isbn);

    List<Pret> findAllByDatepret(Date datepret);

    List<Pret> findAll();

    boolean existsByLecteurAndIsbn(String isbn, Long lecteur);
}
