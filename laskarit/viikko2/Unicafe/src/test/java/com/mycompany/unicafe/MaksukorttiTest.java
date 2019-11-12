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
    public void luotuKorttiOlemassa() {
        assertTrue(kortti != null);
    }

    @Test
    public void maksukortinSaldoOikeinAlussa() {
        assertEquals("saldo: 0.10", kortti.toString());
    }

    @Test
    public void rahanLataaminenKasvattaaSaldoaOikein() {
        kortti.lataaRahaa(100);
        assertEquals("saldo: 1.10", kortti.toString());
    }

    @Test
    public void rahanOttaminenSaldoaOnRiittavasti() {
        kortti.otaRahaa(10);
        assertEquals("saldo: 0.0", kortti.toString());
    }

    @Test
    public void rahanOttaminenSaldoaEiRiittavasti() {
        kortti.otaRahaa(15);
        assertEquals("saldo: 0.10", kortti.toString());
    }

    @Test
    public void rahanOttaminenPalauttaaTrue() {
        assertTrue(kortti.otaRahaa(10));
    }

    @Test
    public void rahanOttaminenPalauttaaFalse() {
        assertFalse(kortti.otaRahaa(15));
    }
    
    @Test
    public void lisaaRahaaJaPalautaSaldo() {
        kortti.lataaRahaa(10);
        assertEquals(20, kortti.saldo());
    }
}
