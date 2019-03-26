package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }
    
    @Test
    public void saldoAlussaOikein() {
        assertEquals("saldo: 0.10", kortti.toString());      
    }
    @Test
    public void saldoKasvattaminenToimii() {
       kortti.lataaRahaa(10);
       assertEquals("saldo: 0.20", kortti.toString());
    }
    @Test
    public void saldoVäheneeOikein() {
       kortti.lataaRahaa(990);
       kortti.otaRahaa(100);
       assertEquals("saldo: 9.0", kortti.toString());
    }
    @Test
    public void saldoEiMuutuJosRahaaEiTarpeeksi() {
       kortti.lataaRahaa(990);
       kortti.otaRahaa(1100);
       assertEquals("saldo: 10.0", kortti.toString());
    }
    @Test
    public void palauttaaTrueMuutenFalse() {
       kortti.lataaRahaa(990);
      kortti.otaRahaa(1100);
       
    }
    
    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
}
