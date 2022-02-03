package domain.entity;

import java.math.BigDecimal;

public class Pis implements Imposto{

    private final BigDecimal valor;

    public BigDecimal getValor() {
        return valor;
    }

    public Pis(BigDecimal receitaBruta) {
        this.valor = this.obterValorDoImposto(receitaBruta);
    }

    @Override
    public BigDecimal obterValorDoImposto(BigDecimal receita) {
        return receita.multiply(Aliquota.PIS.getValor()).divide(new BigDecimal("100")).setScale(2);
    }
}
