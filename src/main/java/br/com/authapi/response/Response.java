package br.com.authapi.response;

import java.util.ArrayList;
import java.util.List;

public class Response <T>{
	
	private T data;
	private List<String>erros;
	
	public Response() {
		this.erros = new ArrayList<>();
	}
	
	public Response(T data){
		super();
		this.data = data;
		
	}
	
	public T getData() {
		return data;
	}
	public void setData(T value) {
		this.data = value;
	}
	public List<String> getErros() {
		return erros;
	}
	public void setErros(List<String> erros) {
		this.erros = erros;
	}
	
	
}
