package adapter;

import adapter.data.HttpAbstractDataSourceMockApi;
import domain.entity.Empresa;
import domain.usecase.DadosImposto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;

@Controller
@RequestMapping("/impostos")
public class DadosImpostoController {

    @Autowired
    private DadosImposto dadosImposto;

    @Autowired
    private HttpAbstractDataSourceMockApi httpEmpresaClientMockApi;

    @GetMapping("/{cnpj}/{receitaBruta}")
    public ResponseEntity<Empresa> obterImpostos(
            @PathVariable("cnpj") String cnpj,
            @PathVariable("receitaBruta") String receitaBruta
    ) {
        BigDecimal valorReceitaBruta = new BigDecimal(receitaBruta).setScale(2);
        Empresa empresa = dadosImposto.obterDadosDeImpostos(cnpj, valorReceitaBruta, httpEmpresaClientMockApi);
        return new ResponseEntity<>(empresa, HttpStatus.OK);
    }
}
