/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author muisku
 */
public class KassaPaateTest {
    
   Kassapaate kassa;
   Maksukortti kortti2;
   
   @Before
    public void setUp() {
        kassa = new Kassapaate();
        kortti2 = new Maksukortti(240);
    }

   @Test
    public void rahaMaaraOikea() {
        assertEquals(1000, kassa.kassassaRahaa());
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }
   @Test
    public void rahaKasvaaOikein() {
        kassa.syoEdullisesti(240);
        assertEquals(1240, kassa.kassassaRahaa());
      
    }
   @Test
    public void myydytKasvaa() {
        kassa.syoEdullisesti(240);
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
      
    }
   @Test
    public void josMaksuEiRiittava() {
        kassa.syoEdullisesti(230);
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
        assertEquals(1000, kassa.kassassaRahaa());
      
    }
   @Test
    public void josKortillaOnRahaaEdulliseen() {
        
        int s = kortti2.saldo();
       
        if (s == 240 || s > 240) {
            kortti2.otaRahaa(240);
    }

  
}
   @Test
    public void josKortillaOnRahaaMaukkaaseen() {
        
        int s = kortti2.saldo();
       
        if (s == 400 || s > 400) {
            kortti2.otaRahaa(400);
    }

  
}
}
