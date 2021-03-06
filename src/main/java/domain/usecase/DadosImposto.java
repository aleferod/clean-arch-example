package domain.usecase;

import adapter.data.AbstractDataSource;
import domain.entity.Cofins;
import domain.entity.Empresa;
import domain.entity.Pis;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DadosImposto {

    private CalculoPis calculoPis;
    private CalculoCofins calculoCofins;

    public DadosImposto(
            CalculoPis calculoPis,
            CalculoCofins calculoCofins
            ) {
        this.calculoPis = calculoPis;
        this.calculoCofins = calculoCofins;
    }

    public Empresa obterDadosDeImpostos(String cnpj, BigDecimal receitaBruta, AbstractDataSource abstractDataSource) {
        String razaoSocial = abstractDataSource.obterRazaoSocialPeloCnpj(cnpj);
        Pis pis = calculoPis.executeUseCase(receitaBruta);
        Cofins cofins = calculoCofins.executeUseCase(receitaBruta);
        return new Empresa(razaoSocial, cnpj, receitaBruta, pis, cofins);
    }

}
