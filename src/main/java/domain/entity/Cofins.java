package domain.entity;

import java.math.BigDecimal;

public class Cofins implements Imposto{

    private final BigDecimal valor;

    public BigDecimal getValor() {
        return valor;
    }

    public Cofins(BigDecimal receitaBruta) {
        this.valor = this.obterValorDoImposto(receitaBruta);
    }

    @Override
    public BigDecimal obterValorDoImposto(BigDecimal receita) {
        return receita.multiply(Aliquota.COFINS.getValor()).divide(new BigDecimal("100")).setScale(2);
    }
}
