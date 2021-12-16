package modelo;

public class DatosMedicos {

    //Attributes
    private int idDatosMedicos;
    private String antecedentesPatologicosPersonales;
    private String antecedentesPatologicosFamiliares;
    private String antecedentesQuirurgicos;
    private boolean alergia;
    private String alergiaDetalle;
    private String medicamentosConsumidos;
    private String cedulaPaciente;

    //Constructors
    public DatosMedicos() {
    }

    public DatosMedicos(int idDatosMedicos, String antecedentesPatologicosPersonales, String antecedentesPatologicosFamiliares, String antecedentesQuirurgicos, boolean alergia, String alergiaDetalle, String medicamentosConsumidos, String cedulaPaciente) {
        this.idDatosMedicos = idDatosMedicos;
        this.antecedentesPatologicosPersonales = antecedentesPatologicosPersonales;
        this.antecedentesPatologicosFamiliares = antecedentesPatologicosFamiliares;
        this.antecedentesQuirurgicos = antecedentesQuirurgicos;
        this.alergia = alergia;
        this.alergiaDetalle = alergiaDetalle;
        this.medicamentosConsumidos = medicamentosConsumidos;
        this.cedulaPaciente = cedulaPaciente;
    }

    public DatosMedicos(String antecedentesPatologicosPersonales, String antecedentesPatologicosFamiliares, String antecedentesQuirurgicos, boolean alergia, String alergiaDetalle, String medicamentosConsumidos, String cedulaPaciente) {
        this.antecedentesPatologicosPersonales = antecedentesPatologicosPersonales;
        this.antecedentesPatologicosFamiliares = antecedentesPatologicosFamiliares;
        this.antecedentesQuirurgicos = antecedentesQuirurgicos;
        this.alergia = alergia;
        this.alergiaDetalle = alergiaDetalle;
        this.medicamentosConsumidos = medicamentosConsumidos;
        this.cedulaPaciente = cedulaPaciente;
    }

    //Getter and Setters
    public int getIdDatosMedicos() {
        return this.idDatosMedicos;
    }

    public void setIdDatosMedicos(int idDatosMedicos) {
        this.idDatosMedicos = idDatosMedicos;
    }

    public String getAntecedentesPatologicosPersonales() {
        return this.antecedentesPatologicosPersonales;
    }

    public void setAntecedentesPatologicosPersonales(String antecedentesPatologicosPersonales) {
        this.antecedentesPatologicosPersonales = antecedentesPatologicosPersonales;
    }

    public String getAntecedentesPatologicosFamiliares() {
        return this.antecedentesPatologicosFamiliares;
    }

    public void setAntecedentesPatologicosFamiliares(String antecedentesPatologicosFamiliares) {
        this.antecedentesPatologicosFamiliares = antecedentesPatologicosFamiliares;
    }

    public String getAntecedentesQuirurgicos() {
        return this.antecedentesQuirurgicos;
    }

    public void setAntecedentesQuirurgicos(String antecedentesQuirurgicos) {
        this.antecedentesQuirurgicos = antecedentesQuirurgicos;
    }

    public boolean isAlergia() {
        return this.alergia;
    }

    public boolean getAlergia() {
        return this.alergia;
    }

    public void setAlergia(boolean alergia) {
        this.alergia = alergia;
    }

    public String getAlergiaDetalle() {
        return this.alergiaDetalle;
    }

    public void setAlergiaDetalle(String alergiaDetalle) {
        this.alergiaDetalle = alergiaDetalle;
    }

    public String getMedicamentosConsumidos() {
        return this.medicamentosConsumidos;
    }

    public void setMedicamentosConsumidos(String medicamentosConsumidos) {
        this.medicamentosConsumidos = medicamentosConsumidos;
    }

    public String getCedulaPaciente() {
        return this.cedulaPaciente;
    }

    public void setCedulaPaciente(String cedulaPaciente) {
        this.cedulaPaciente = cedulaPaciente;
    }

}
