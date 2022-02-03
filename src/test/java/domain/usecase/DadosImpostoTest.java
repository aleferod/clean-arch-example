package domain.usecase;

import adapter.data.HttpAbstractDataSourceMockApi;
import domain.entity.Cofins;
import domain.entity.Empresa;
import domain.entity.Pis;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class DadosImpostoTest {

    @Test
    public void obterDadosDeImpostos() {
        String cnpj = "62011317000180";
        String razaoSocial = "Padaria da Natalina";
        BigDecimal receitaBruta = new BigDecimal("50000").setScale(2);
        Pis pis = new Pis(receitaBruta);
        Cofins cofins = new Cofins(receitaBruta);
        Empresa esperado = new Empresa(razaoSocial, cnpj, receitaBruta, pis, cofins);

        CalculoPis calculoPisMock = Mockito.spy(CalculoPis.class);
        CalculoCofins calculoCofinsMock = Mockito.spy(CalculoCofins.class);
        HttpAbstractDataSourceMockApi httpClientMockApiMock = Mockito.spy(HttpAbstractDataSourceMockApi.class);

        Mockito.when(calculoPisMock.executeUseCase(receitaBruta)).thenReturn(pis);
        Mockito.when(calculoCofinsMock.executeUseCase(receitaBruta)).thenReturn(cofins);
        Mockito.when(httpClientMockApiMock.obterRazaoSocialPeloCnpj(cnpj)).thenReturn(razaoSocial);

        Empresa resultado = new DadosImposto(calculoPisMock, calculoCofinsMock).obterDadosDeImpostos(cnpj, receitaBruta, httpClientMockApiMock);
        assertEquals(esperado.getCnpj(), resultado.getCnpj());
        assertEquals(esperado.getRazaoSocial(), resultado.getRazaoSocial());
        assertEquals(esperado.getReceitaBruta(), resultado.getReceitaBruta());
        assertEquals(esperado.getPis().getValor(), resultado.getPis().getValor());
        assertEquals(esperado.getCofins().getValor(), resultado.getCofins().getValor());
    }

}