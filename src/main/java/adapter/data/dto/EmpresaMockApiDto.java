package adapter.data.dto;

public class EmpresaMockApiDto {

    private String id;

    private String razaoSocial;

    public EmpresaMockApiDto() {
    }

    public EmpresaMockApiDto(String id, String razaoSocial) {
        this.id = id;
        this.razaoSocial = razaoSocial;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
}
