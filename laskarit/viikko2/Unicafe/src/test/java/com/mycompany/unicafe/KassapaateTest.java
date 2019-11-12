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
 * @author ollisavi
 */
public class KassapaateTest {

    Kassapaate paate;

    @Before
    public void setUp() {
        paate = new Kassapaate();
    }

    @Test
    public void kassassaRahaaLuonninJalkeen() {
        assertEquals(100000, paate.kassassaRahaa());
    }

    @Test
    public void edullisiaLounaitaMyytyNolla() {
        assertEquals(0, paate.edullisiaLounaitaMyyty());
    }

    @Test
    public void maukkaitaLounaitaMyytyNolla() {
        assertEquals(0, paate.maukkaitaLounaitaMyyty());
    }

    @Test
    public void kateisostoToimiiEdullinenLounasMaksuRiittava() {
        paate.syoEdullisesti(300);
        assertEquals(100240, paate.kassassaRahaa());
        assertEquals(1, paate.edullisiaLounaitaMyyty());
    }

    @Test
    public void kateisostoToimiiEdullinenLounasRahaaTakaisin() {
        assertEquals(60, paate.syoEdullisesti(300));
    }

    @Test
    public void kateisostoToimiiMaukasLounasMaksuRiittava() {
        paate.syoMaukkaasti(400);
        assertEquals(100400, paate.kassassaRahaa());
        assertEquals(1, paate.maukkaitaLounaitaMyyty());
    }

    @Test
    public void kateisostoToimiiMaukasLounasRahaaTakaisin() {
        assertEquals(50, paate.syoMaukkaasti(450));
    }

    @Test
    public void kateisostoEdullinenLounasMaksuEiRiittava() {
        paate.syoEdullisesti(150);
        assertEquals(100000, paate.kassassaRahaa());
        assertEquals(0, paate.edullisiaLounaitaMyyty());
    }

    @Test
    public void kateisostoEdullinenLounasMaksuEiRiittavaRahaaTakaisin() {
        assertEquals(100, paate.syoEdullisesti(100));
    }

    @Test
    public void kateisostoMaukasLounasMaksuEiRiittava() {
        paate.syoMaukkaasti(250);
        assertEquals(100000, paate.kassassaRahaa());
        assertEquals(0, paate.maukkaitaLounaitaMyyty());
    }

    @Test
    public void kateisostoMaukasLounasMaksuEiRiittavaRahaaTakaisin() {
        assertEquals(250, paate.syoMaukkaasti(250));
    }

    @Test
    public void korttiostoEdullinenLounasMaksuRiittava() {
        Maksukortti kortti = new Maksukortti(500);
        assertTrue(paate.syoEdullisesti(kortti));
        assertEquals(1, paate.edullisiaLounaitaMyyty());
        assertEquals(260, kortti.saldo());
    }

    @Test
    public void korttiostoMaukasLounasMaksuRiittava() {
        Maksukortti kortti = new Maksukortti(500);
        assertTrue(paate.syoMaukkaasti(kortti));
        assertEquals(1, paate.maukkaitaLounaitaMyyty());
        assertEquals(100, kortti.saldo());
    }
    
    @Test
    public void korttiostoEdullinenLounasMaksuEiRiittava() {
        Maksukortti kortti = new Maksukortti(200);
        assertFalse(paate.syoEdullisesti(kortti));
        assertEquals(0, paate.edullisiaLounaitaMyyty());
        assertEquals(200, kortti.saldo());
    }
    
    @Test
    public void korttiostoMaukasLounasMaksuEiRiittava() {
        Maksukortti kortti = new Maksukortti(200);
        assertFalse(paate.syoMaukkaasti(kortti));
        assertEquals(0, paate.maukkaitaLounaitaMyyty());
        assertEquals(200, kortti.saldo());
    }
    
    @Test
    public void kassanRahamaaraEiMuutuKortillaOstettaessa() {
        Maksukortti kortti = new Maksukortti(500);
        paate.syoMaukkaasti(kortti);
        assertEquals(100000, paate.kassassaRahaa());
    }
    
    @Test
    public void lataaRahaaKortilleSaldoMuuttuuKortillaJaKassassa() {
        Maksukortti kortti = new Maksukortti(100);
        paate.lataaRahaaKortille(kortti, 300);
        assertEquals(100300, paate.kassassaRahaa());
        assertEquals(400, kortti.saldo());
    }
    
    @Test
    public void lataaNegatiivistaRahaaKortille() {
        Maksukortti kortti = new Maksukortti(100);
        paate.lataaRahaaKortille(kortti, -300);
        assertEquals(100000, paate.kassassaRahaa());
        assertEquals(100, kortti.saldo());
    }

}
