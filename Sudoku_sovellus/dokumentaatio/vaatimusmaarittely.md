# Vaatimusmäärittely

## Sovelluksen tarkoitus

Sovelluksen avulla käyttäjän on mahdollista viettää aikaa pelaamalla Sudokua kolmella eri vaikeusasteella.

## Käyttäjät

Alkuvaiheessa sovelluksella on yksi käyttäjä, niin kutsuttu *normaali käyttäjä*. Myöhemmin sovellukseen saatetaan lisätä mahdollisuus kirjautua käyttäjänä ja saada tietoa edellisistä pelatuista peleistä.

## Käyttöliittymäluonnos

Alkuvaiheessa sovellus koostuu kolmesta eri näkymästä. Myöhemmässä vaiheessa mahdollisesti mahdollisuus kirjautua sovellukseen, jonka myötä näkymiä lisätään.

![Nakyma](https://raw.githubusercontent.com/OlliSavisalo/ot-harjoitustyo/master/Sudoku_sovellus/dokumentaatio/kuvat/sudoku_luonnos.jpg)

Sovellus aukeaa etusivulle, josta voidaan valita uusi peli, exit ja mahdollisesti tuleva kirjautuminen. Uusi peli - valikosta sovellus siirtyy näkymään, jossa valitaan vaikeusaste kolmesta vaihtoehdosta (helppo, normaali ja vaikea). Pelinäkymä aukeaa valitun vaikeusasteen mukaiseksi.

## Suunnitellut toiminnallisuudet

### Pelin etusivu

* Uusi peli -painike siirtyy vaikeusasteen valintaan
* Exit -painike keskeyttää pelin suorittamisen ja poistuu pelistä

### Vaikeusasteen valinta

* Kolme vaihtoehtoa vaikeusasteen valintaan:
  * Helppo
  * Normaali
  * Vaikea
* Valinnan jälkeen siirrytään valitseman vaikeusasteen mukaiseen pelinäkymään.

### Peli

* Sudoku -peli käyttäjän valitseman vaikeusasteen mukaisena.
* Edellisen liikkeen peruminen
* Tietyn ruudukon tyhjentäminen
* Uusi peli (Restart)
* Poistu pelistä (Exit)

## Jatkokehitysideoita

* Käyttäjän tunnistaminen edellisten pelien seurantaa varten
* Pelin pisteytys esim. käytetyn ajan mukaan
* High-score lista eri käyttäjien kesken

 
