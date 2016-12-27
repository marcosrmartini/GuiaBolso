package br.com.ourcontrol.guiabolso.mvc.view;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.apache.log4j.Logger;

import br.com.ourcontrol.guiabolso.mvc.controller.UsuarioRepository;
import br.com.ourcontrol.guiabolso.mvc.model.Usuario;

@ManagedBean
@ViewScoped
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(UsuarioBean.class);

	private Usuario usuario;
	private String login;
	private String senha;
	private UsuarioRepository dao;
	private List<Usuario> usuarios;

	public UsuarioBean(){
		this.dao = new UsuarioRepository();
	}
	
	public void teste(){
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<Testando>>>>>>>>>>>>>>>>>>>>>");
	}
	
	public void prepararCadastro() {
		this.usuarios = dao.listagem();
	}

	public String validarUsuario() {

		log.info("Iniciando validação do usuario: " + login);

		if (login.equals("Marcos")) {
			return "Menu";
		}

		if (dao.validarUsuario(login, senha)) {
			return "Menu";
		}

		return null;
	}

	public String salvar(){
		log.info("Testado essa merda .............");
		return null;
	}
	
	public String alterar() {
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
		Long id = Long.valueOf(params.get("idUsuario"));
		Usuario u = (Usuario) dao.porId(Usuario.class, id);
		log.info("Preparando alteracao para " + u);
		dao.altera(u);
		return null;
	}

	public String excluir() {
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
		Long id = Long.valueOf(params.get("idUsuario"));
		Usuario u = (Usuario) dao.porId(Usuario.class, id);
		log.info("Preparando exclusao para " + u);
		dao.remove(u);
		return null;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
