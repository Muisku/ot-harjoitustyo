# Vaatimusmäärittely
## Sovelluksen tarkoitus
Sovelluksesta tulee klassisen todo-sovelluksen variaatio, jossa voidaan pitää listaa tehtävistä ja katsoa kauan tehtävien tekemiseen on kulunut aikaa. Sovelluksessa toivottavasti pystyy kirjautumaan ja luomaan useita käyttäjiä.

## Käyttäjät
Sovelluksessa luultavasti tulee olemaan vain normaali käyttäjä.

## Käyttöliittymä
Sovelluksessa on noin 4 näkymää.

![](https://github.com/Muisku/ot-harjoitustyo/blob/master/todoapp/kuvat/kayttoliittyma_kuvaus.png)

Sovelluksessa ensimmäisenä aukeaa näkymä jossa voidaan suoraan kirjautua tai luoda uusi käyttäjä. Jos päätetään luoda uusi käyttäjä päästään näkymään jossa pyydetään yksinkertaisesti nimeä ja voidaan luoda käyttäjä painamalla create nappia

## Perusversion toiminnot

### Avatessaan sovelluksen ensimmäistä kertaa

* Kun käyttäjä avaa sovelluksen ensimmäistä kertaa hänelle aukeaa yksinkertainen ikkuna jossa voi kirjautua sisään tai luoda uuden käyttäjän.
* Käyttäjä luodaan painamalla create user nappia joka vie uuteen ikkunaan jossa yksinkertaisesti laitetaan toivottu nimi lomakkeeseen ja painetaan create nappia.

### Kirjautumisen jälkeen

* Kirjautumisen jälkeen voidaan lisätä tehtäviä, merkitä ne tehdyksi ja merkitä joku tehtävä työn alla olevaksi.
* Voi katsoa kauan tehtäviin on mennyt aikaa painamalla show statistics nappia joka vie uuteen ikkunaan jossa näkyy kauan kuhunkin tehtävään on mennyt aikaa.
