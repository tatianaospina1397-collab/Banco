public class ObjBanco {
private int Id;
private String Nombre;
private String TipoTramite;
private int Edad;
private int Especial;
private int Turno;
private int Estado;

public ObjBanco(int id, String nombre, String tipoTramite, int edad, int especial, int turno, int estado) {
    Id = id;
    Nombre = nombre;
    TipoTramite = tipoTramite;
    Edad = edad;
    Especial = especial;
    Turno = turno;
    Estado = estado;
}

public ObjBanco() {
}

public int getId() {
    return Id;
}

public void setId(int id) {
    Id = id;
}

public String getNombre() {
    return Nombre;
}

public void setNombre(String nombre) {
    Nombre = nombre;
}

public String getTipoTramite() {
    return TipoTramite;
}

public void setTipoTramite(String tipoTramite) {
    TipoTramite = tipoTramite;
}

public int getEdad() {
    return Edad;
}

public void setEdad(int edad) {
    Edad = edad;
}

public int getEspecial() {
    return Especial;
}

public void setEspecial(int especial) {
    Especial = especial;
}

public int getTurno() {
    return Turno;
}

public void setTurno(int turno) {
    Turno = turno;
}

public int getEstado() {
    return Estado;
}

public void setEstado(int estado) {
    Estado = estado;
}



}
