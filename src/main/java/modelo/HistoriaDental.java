    package modelo;

/**
 *
 * @author Christian Aguilar Alvarado
 */
public class HistoriaDental {
    
  private int idHistoriaDental;
  private String ultimaVisitaDentista;
  private int numeroCepilladosDia;
  private boolean usoHilo;
  private boolean usoEnjuague;
  private String tipoPastaDental;
  private int numeroComidasDia;
  private boolean dietaMuyCariogenica;
  private boolean dietaPocoCariogenica;
  private boolean dietaNadaCariogenica;
  private boolean masAgua;
  private boolean igualAgua;
  private boolean menosAgua;
  private String cedulaPaciente;

    public HistoriaDental(String ultimaVisitaDentista, int numeroCepilladosDia, boolean usoHilo, boolean usoEnjuague, String tipoPastaDental, int numeroComidasDia, boolean dietaMuyCariogenica, boolean dietaPocoCariogenica, boolean dietaNadaCariogenica, boolean masAgua, boolean igualAgua, boolean menosAgua, String cedulaPaciente) {
        this.ultimaVisitaDentista = ultimaVisitaDentista;
        this.numeroCepilladosDia = numeroCepilladosDia;
        this.usoHilo = usoHilo;
        this.usoEnjuague = usoEnjuague;
        this.tipoPastaDental = tipoPastaDental;
        this.numeroComidasDia = numeroComidasDia;
        this.dietaMuyCariogenica = dietaMuyCariogenica;
        this.dietaPocoCariogenica = dietaPocoCariogenica;
        this.dietaNadaCariogenica = dietaNadaCariogenica;
        this.masAgua = masAgua;
        this.igualAgua = igualAgua;
        this.menosAgua = menosAgua;
        this.cedulaPaciente = cedulaPaciente;
    }

    public int getIdHistoriaDental() {
        return idHistoriaDental;
    }

    public void setIdHistoriaDental(int idHistoriaDental) {
        this.idHistoriaDental = idHistoriaDental;
    }

    public String getUltimaVisitaDentista() {
        return ultimaVisitaDentista;
    }

    public void setUltimaVisitaDentista(String ultimaVisitaDentista) {
        this.ultimaVisitaDentista = ultimaVisitaDentista;
    }

    public int getNumeroCepilladosDia() {
        return numeroCepilladosDia;
    }

    public void setNumeroCepilladosDia(int numeroCepilladosDia) {
        this.numeroCepilladosDia = numeroCepilladosDia;
    }

    public boolean isUsoHilo() {
        return usoHilo;
    }

    public void setUsoHilo(boolean usoHilo) {
        this.usoHilo = usoHilo;
    }

    public boolean isUsoEnjuague() {
        return usoEnjuague;
    }

    public void setUsoEnjuague(boolean usoEnjuague) {
        this.usoEnjuague = usoEnjuague;
    }

    public String getTipoPastaDental() {
        return tipoPastaDental;
    }

    public void setTipoPastaDental(String tipoPastaDental) {
        this.tipoPastaDental = tipoPastaDental;
    }

    public int getNumeroComidasDia() {
        return numeroComidasDia;
    }

    public void setNumeroComidasDia(int numeroComidasDia) {
        this.numeroComidasDia = numeroComidasDia;
    }

    public boolean isDietaMuyCariogenica() {
        return dietaMuyCariogenica;
    }

    public void setDietaMuyCariogenica(boolean dietaMuyCariogenica) {
        this.dietaMuyCariogenica = dietaMuyCariogenica;
    }

    public boolean isDietaPocoCariogenica() {
        return dietaPocoCariogenica;
    }

    public void setDietaPocoCariogenica(boolean dietaPocoCariogenica) {
        this.dietaPocoCariogenica = dietaPocoCariogenica;
    }

    public boolean isDietaNadaCariogenica() {
        return dietaNadaCariogenica;
    }

    public void setDietaNadaCariogenica(boolean dietaNadaCariogenica) {
        this.dietaNadaCariogenica = dietaNadaCariogenica;
    }

    public boolean isMasAgua() {
        return masAgua;
    }

    public void setMasAgua(boolean masAgua) {
        this.masAgua = masAgua;
    }

    public boolean isIgualAgua() {
        return igualAgua;
    }

    public void setIgualAgua(boolean igualAgua) {
        this.igualAgua = igualAgua;
    }

    public boolean isMenosAgua() {
        return menosAgua;
    }

    public void setMenosAgua(boolean menosAgua) {
        this.menosAgua = menosAgua;
    }

    public String getCedulaPaciente() {
        return cedulaPaciente;
    }

    public void setCedulaPaciente(String cedulaPaciente) {
        this.cedulaPaciente = cedulaPaciente;
    }
  
  
}
