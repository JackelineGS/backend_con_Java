package jpa.entidades;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="gama_producto")
public class GamaProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_gama")
    private int idGama;

    @Column(name = "descripcion_html")
    private String descripcionHTML;

    @Column(name = "descripcion_texto")
    private String descripcionTexto;
    
    @Column(name = "gama")
    private String gama;

    @Column(name = "imagen")
    private String imagen;

    @OneToMany(mappedBy = "gamaProducto")
    private List<Producto> productos;
    
    public GamaProducto() {

    }

    public GamaProducto(String descripcionHTML, String descripcionTexto, String gama, String imagen) {
        this.descripcionHTML = descripcionHTML;
        this.descripcionTexto = descripcionTexto;
        this.gama = gama;
        this.imagen = imagen;
    }

    public int getIdGama() {
        return idGama;
    }

    public void setIdGama(int idGama) {
        this.idGama = idGama;
    }

    public String getDescripcionHTML() {
        return descripcionHTML;
    }

    public void setDescripcionHTML(String descripcionHTML) {
        this.descripcionHTML = descripcionHTML;
    }

    public String getDescripcionTexto() {
        return descripcionTexto;
    }

    public void setDescripcionTexto(String descripcionTexto) {
        this.descripcionTexto = descripcionTexto;
    }

    public String getGama() {
        return gama;
    }

    public void setGama(String gama) {
        this.gama = gama;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    
}

