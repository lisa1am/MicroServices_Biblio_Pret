package fr.dauphine.miageif.msa.Biblio.Controller;

import fr.dauphine.miageif.msa.Biblio.Pret;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import fr.dauphine.miageif.msa.Biblio.Repository.PretRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.sql.Date;
import java.util.ArrayList;

@RestController
@Transactional
public class PretController {

    @Autowired
    private Environment environment;

    @Autowired
    private PretRepository repository;

    @GetMapping("prets/lecteur/{lecteur}")
    public List<Pret> findByIdLecteur(@PathVariable Long lecteur){
        List<Pret> prets = repository.findAllByLecteur(lecteur);
        return prets;
    }

    @GetMapping("prets/isbn/{isbn}")
    public List<Pret> findByIsbn(@PathVariable String isbn){
        List<Pret> prets = repository.findAllByIsbn(isbn);
        return prets;
    }

    @GetMapping("prets/lecteur/{lecteur}/isbn/{isbn}")
    public Pret findByIdLecteurAndByIsbn(@PathVariable Long lecteur, @PathVariable String isbn){
        Pret pret = repository.findAllByLecteurAndIsbn(lecteur, isbn);
        return pret;
    }

    @GetMapping("prets/date/{datepret}")
    public List<Pret> findAllByDate(@PathVariable Date datepret){
        List<Pret> prets = repository.findAllByDatepret(datepret);
        return prets;
    }

    @GetMapping("prets/encours/")
    public List<Pret> findAllEnCours(){
        List<Pret> prets = repository.findAll();
        List<Pret> encours = new ArrayList<Pret>();

        for (Pret p:
             prets) {
            if(p.getDate_retour().equals("")){
                encours.add(p);
            }
        }
        return encours;
    }


    //HEADER : 'Content-type: application/json'
    @PutMapping("prets/lecteur/{lecteur}/isbn/{isbn}")
    public String updatePret(@RequestBody Pret pret, @PathVariable String isbn, @PathVariable Long lecteur) {
        if (!repository.existsByLecteurAndIsbn(lecteur, isbn)){
            return "Le pret n'existe pas dans la base de données !";
        }else{
            Pret pretEnBase = repository.findAllByLecteurAndIsbn(lecteur, isbn);
            if(pret.getIsbn() == null){
                pret.setIsbn(pretEnBase.getIsbn());
            }
            if(pret.getLecteur() == null){
                pret.setLecteur(pretEnBase.getLecteur());
            }
            if(pret.getDate_pret() == null){
                pret.setDate_pret(pretEnBase.getDate_pret());
            }
            if(pret.getDate_retour() == null){
                pret.setDate_retour(pretEnBase.getDate_retour());
            }
            repository.save(pret);
            return "Le prêt ayant l'ISBN "+isbn+" et le lecteur "+lecteur+" a été mis à jour avec succès";
        }
    }

    @PostMapping("prets/")
    public String addPret(@RequestBody Pret pret){
        if (repository.existsByLecteurAndIsbn(pret.getLecteur(), pret.getIsbn()))
            return "Le pret existe déjà dans la base de données !";

        repository.save(pret);
        return "Le pret a été enregistré avec succès";
    }


}
