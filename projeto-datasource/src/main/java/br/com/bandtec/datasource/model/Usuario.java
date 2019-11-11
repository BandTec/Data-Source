package br.com.bandtec.datasource.model;

/**
 *
 * @author fernando.oliveira
 */
public class Usuario {

    private int idUsuario;
    private String nomeUsuario;
    private String emailUsuario;
    private String senhaUsuario;
    private String emailIndicao;
    private boolean tipoUsuario;

    public Usuario() {
    }

    public Usuario(int idUsuario, String nomeUsuario, String emailUsuario, String senhaUsuario, String emailIndicao, boolean tipoUsuario) {
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.emailUsuario = emailUsuario;
        this.senhaUsuario = senhaUsuario;
        this.emailIndicao = emailIndicao;
        this.tipoUsuario = tipoUsuario;
    }

    public void coletaDadosUsuario() {

    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    public String getEmailIndicao() {
        return emailIndicao;
    }

    public void setEmailIndicao(String emailIndicao) {
        this.emailIndicao = emailIndicao;
    }

    public boolean isTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(boolean tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

}
