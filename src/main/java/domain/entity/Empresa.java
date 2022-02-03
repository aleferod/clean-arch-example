package domain.entity;

import java.math.BigDecimal;

public class Empresa {

    private String razaoSocial;

    private String cnpj;

    private final BigDecimal receitaBruta;

    private Pis pis;

    private Cofins cofins;

    public Empresa(BigDecimal receitaBruta) {
        this.receitaBruta = receitaBruta;
    }

    public Empresa(String razaoSocial, String cnpj, BigDecimal receitaBruta, Pis pis, Cofins cofins) {
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.receitaBruta = receitaBruta;
        this.pis = pis;
        this.cofins = cofins;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public BigDecimal getReceitaBruta() {
        return receitaBruta;
    }

    public Pis getPis() {
        return pis;
    }

    public Cofins getCofins() {
        return cofins;
    }
}
