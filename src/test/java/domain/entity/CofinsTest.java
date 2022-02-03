package domain.entity;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class CofinsTest {

    @Test
    public void obterValorDoImposto() {
        BigDecimal receitaBruta = new BigDecimal(50000);
        BigDecimal aliquota = Aliquota.COFINS.getValor();
        BigDecimal esperado = new BigDecimal("3800").setScale(2);
        Cofins resultado = new Cofins(receitaBruta);
        assertEquals(esperado, resultado.getValor());
    }

}