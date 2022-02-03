package domain.usecase;

import java.math.BigDecimal;

public abstract class ImpostoUseCase<ENTITY> {

    abstract ENTITY executeUseCase(BigDecimal receitaBruta);
}
