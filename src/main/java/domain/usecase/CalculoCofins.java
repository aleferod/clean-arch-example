package domain.usecase;

import domain.entity.Cofins;
import domain.entity.Empresa;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CalculoCofins extends ImpostoUseCase<Cofins>{

    @Override
    protected Cofins executeUseCase(BigDecimal receitaBruta) {
        return new Cofins(receitaBruta);
    }
}
