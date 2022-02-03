package domain.usecase;

import domain.entity.Empresa;
import domain.entity.Pis;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CalculoPis extends ImpostoUseCase<Pis>{

    @Override
    protected Pis executeUseCase(BigDecimal receitaBruta) {
        return new Pis(receitaBruta);
    }
}
