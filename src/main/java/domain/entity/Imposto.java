package domain.entity;

import java.math.BigDecimal;

public interface Imposto {

    BigDecimal obterValorDoImposto(BigDecimal receita);
}
