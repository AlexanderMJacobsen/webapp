package com.danmarkmodmadspild.webapp.repository;


import com.danmarkmodmadspild.webapp.model.AboutText;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public class HomeRepository {

    public AboutText getAboutText() {

        return new AboutText(
                "Red maden – mød mennesker",
                "Dine fødevarer rejser langt fra jord til tallerken og ender desværre tit i skraldespanden",
                "Danmark mod madspild forbinder dig med virksomheders overskudsmad og sociale events i dit nærområde",
                "Her kan lokalsamfundet i fællesskab ygge nye vaner op omkring at forebygge madspild.",
                "Det er starten på jeres rejse mod en fremtid med meget mindre madspild",
                "En fælles løsning på et fælles problem",
                LocalDate.of(2025,10,30));



    }

}
