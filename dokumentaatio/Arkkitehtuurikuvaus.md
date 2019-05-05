## Arkkitehtuurikuvaus


Ohjelman rakenne muodostuu kolmesta ryhmästä:

<img src="https://github.com/Muisku/ot-harjoitustyo/blob/master/kuvat/arkkitehtuuri.png" width="160">

Ui sisältää käyttöliittymän, sovelluslogiikasta pitää huolen domain ja database hoitaa tietojen viemisen ja tuomisen tietokannasta.

## Käyttöliittymä

Sovelluksessa on kolme erillasita näkymää, kirjautumis, käyttäjän luominen ja tehtävien luominen.

Näkymät ovat yksi kerrallaan näkyvillä. Sovelluksessa näkymät vaihtuu sen mukaan mitä käyttäjä tekee, esimerkiksi kun ohjelman käynnistää, pystyy käyttäjä kirjautumaan tai luomaan uuden käyttäjän. Näkymistä huolehtii Scene-olio johon on upotettu tarvittavia komponentteja kuten nappeja yms.

Käyttöliittymän tarkoitus on pitää huoli miltä ohjelma visuaalisesti näyttää ja luoda kaikki tarvittava, kuten tietokantaan yhteys. Muuten ohjelman tarvitsema toiminnallisuus toteutetaan timeservice olion toimesta jolta käyttöliittymä pyytää palveluksia tarvittaviin tehtäviin, kuten tehtävien tuomiseen tietokannasta yms. Metodi refreshTask pitää huolen, että kun kirjaudutaan sisään niin listataan kyseisen käyttäjän tehtävät automaattisesti, samoin kun käyttäjä lisää tehtävän niin lista päivitetään metodin avulla.

## Sovelluslogiikka

Käytössä on kaksi luokkaa jotka muodostavat ohjelman ytimen, User ja Task.

<img src="https://github.com/Muisku/ot-harjoitustyo/blob/master/kuvat/luokat.png" width="160">

TimeService vastaa käyttöliittymän tarvitsemista metodeista kuten login, createTask, getTask, createUser, getLoggedUser ja logout. Timeservice toimii rajapinnat TaskInterfaceDao, UserInterfaceDao toteuttavien luokkien TaskDao ja UserDao kautta.

## Tietokanta

Kuten monissa ohjelmissa halutaan tiedot tallentaa jonnekin pysyvästi. Tästä huolehtii UserDao, TaskDao ja Database. Database luokka luo yhteyden tietokantaan ja luo tietokantantaulut luovat lauseet. Tämä toteutus noudatta Data Access Object mallia.

## Toiminnallisuus

* Käyttäjän luominen
Kun käyttäjä avaa ohjelman hän saa mahdollisuuden kirjautua tai painaa nappia joka vie näkymään jossa voi antaa nimen ja käyttäjänimen ja luoda käyttäjä. Käyttäjän antamalla tarvittavat tiedot ja painamalla createuser nappia tapahtuu seuraavan toiminta:

<img src="https://github.com/Muisku/ot-harjoitustyo/blob/master/kuvat/luok%C3%A4ytt%C3%A4j%C3%A4.png" width="160">

* Kirjautuminen

Kun käyttäjä kirjautuu tapahtuu seuraava toiminta:

<img src="https://github.com/Muisku/ot-harjoitustyo/blob/master/kuvat/kirjautuminen.png" width="160">

* Tehtävän luominen

Käyttäjän painaessa createtask nappia tapahtuu seuraava:

<img src="https://github.com/Muisku/ot-harjoitustyo/blob/master/kuvat/teht%C3%A4v%C3%A4nluominen.png" width="160">
