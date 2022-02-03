package domain.entity;

import java.math.BigDecimal;

public enum Aliquota {

    PIS(new BigDecimal("1.65")),
    COFINS(new BigDecimal("7.60"));

    private final BigDecimal valor;

    Aliquota(BigDecimal valor){
        this.valor = valor;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
