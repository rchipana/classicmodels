package pe.egcc.rest.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Mensaje {

  private int code;
  private String texto;

  public Mensaje() {
  }

  public Mensaje(int code, String texto) {
    this.code = code;
    this.texto = texto;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getTexto() {
    return texto;
  }

  public void setTexto(String texto) {
    this.texto = texto;
  }

}
