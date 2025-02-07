package entidades;
import java.time.LocalDate;

public class Casa {
    private Integer idCasa;
    private String calle;
    private Integer numero;
    private String codigoPostal;
    private String ciudad;
    private String pais;
    private LocalDate fechaDesde;
    private LocalDate fechaHasta;
    private Integer tiempoMinimo;
    private Integer tiempoMaximo;
    private Integer precioHabitacion;
    private String tipoVivienda;

    public Casa() {
    }

    public Casa(Integer idCasa, String calle, Integer numero, String codigoPostal, String ciudad, String pais,
            LocalDate fechaDesde, LocalDate fechaHasta, Integer tiempoMinimo, Integer tiempoMaximo,
            Integer precioHabitacion, String tipoVivienda) {
        this.idCasa = idCasa;
        this.calle = calle;
        this.numero = numero;
        this.codigoPostal = codigoPostal;
        this.ciudad = ciudad;
        this.pais = pais;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.tiempoMinimo = tiempoMinimo;
        this.tiempoMaximo = tiempoMaximo;
        this.precioHabitacion = precioHabitacion;
        this.tipoVivienda = tipoVivienda;
    }

    public Integer getIdCasa() {
        return idCasa;
    }

    public void setIdCasa(Integer idCasa) {
        this.idCasa = idCasa;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public LocalDate getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(LocalDate fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public LocalDate getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(LocalDate fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public Integer getTiempoMinimo() {
        return tiempoMinimo;
    }

    public void setTiempoMinimo(Integer tiempoMinimo) {
        this.tiempoMinimo = tiempoMinimo;
    }

    public Integer getTiempoMaximo() {
        return tiempoMaximo;
    }

    public void setTiempoMaximo(Integer tiempoMaximo) {
        this.tiempoMaximo = tiempoMaximo;
    }

    public Integer getPrecioHabitacion() {
        return precioHabitacion;
    }

    public void setPrecioHabitacion(Integer precioHabitacion) {
        this.precioHabitacion = precioHabitacion;
    }

    public String getTipoVivienda() {
        return tipoVivienda;
    }

    public void setTipoVivienda(String tipoVivienda) {
        this.tipoVivienda = tipoVivienda;
    }

    @Override
    public String toString() {
        return "Casas [idCasa=" + idCasa + ", calle=" + calle + ", numero=" + numero + ", codigoPostal=" + codigoPostal
                + ", ciudad=" + ciudad + ", pais=" + pais + ", fechaDesde=" + fechaDesde + ", fechaHasta=" + fechaHasta
                + ", tiempoMinimo=" + tiempoMinimo + ", tiempoMaximo=" + tiempoMaximo + ", precioHabitacion="
                + precioHabitacion + ", tipoVivienda=" + tipoVivienda + "]";
    }

}
