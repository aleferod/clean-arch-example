package domain.entity;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class PisTest {

    @Test
    public void obterValorDoImposto() {
        BigDecimal receitaBruta = new BigDecimal(50000);
        BigDecimal aliquota = Aliquota.PIS.getValor();
        BigDecimal esperado = new BigDecimal("825").setScale(2);
        Pis resultado = new Pis(receitaBruta);
        assertEquals(esperado, resultado.getValor());
    }

}