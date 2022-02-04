package domain.usecase;

import adapter.data.HttpClientMockApi;
import domain.entity.Cofins;
import domain.entity.Empresa;
import domain.entity.Pis;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DadosImposto {

    private CalculoPis calculoPis;
    private CalculoCofins calculoCofins;
    private HttpClientMockApi httpClientMockApi;

    public DadosImposto(
            CalculoPis calculoPis,
            CalculoCofins calculoCofins,
            HttpClientMockApi httpClientMockApi
            ) {
        this.calculoPis = calculoPis;
        this.calculoCofins = calculoCofins;
        this.httpClientMockApi = httpClientMockApi;
    }

    public Empresa obterDadosDeImpostos(String cnpj, BigDecimal receitaBruta) {
        String razaoSocial = httpClientMockApi.obterRazaoSocialPeloCnpj(cnpj);
        Pis pis = calculoPis.executeUseCase(receitaBruta);
        Cofins cofins = calculoCofins.executeUseCase(receitaBruta);
        return new Empresa(razaoSocial, cnpj, receitaBruta, pis, cofins);
    }

}
