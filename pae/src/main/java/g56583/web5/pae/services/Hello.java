package g56583.web5.pae.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Hello implements CommandLineRunner {
    //@Autowired
    //private StudentDB studentDB;
    //@Autowired
    //private CourseDB courseDB;
    @Autowired
    private PaeService api;

    @Override
    public void run(String... args){
        // Ajout de nouveaux étudiants
        //Student alice = new Student("Alice");
        //Student bob = new Student("Bob");

        // Enregistrement dans la base de données
        //studentDB.save(alice);
        //studentDB.save(bob);

        // Afficher la liste des cours et des étudiants
        //log.info("Liste des cours : " + courseDB.findAll().toString());
        //log.info("Liste des étudiants : " + studentDB.findAll().toString());
        api.getCourse(63000);
    }
    
}
