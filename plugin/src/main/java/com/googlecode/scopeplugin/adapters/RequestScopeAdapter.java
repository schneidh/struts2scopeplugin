package com.googlecode.scopeplugin.adapters;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.googlecode.scopeplugin.ScopeType;
import com.opensymphony.xwork2.ActionContext;

public class RequestScopeAdapter extends AbstractScopeAdapter {
	private HttpServletRequest request;
	
	public RequestScopeAdapter(ActionContext context, String name) {
		super(context, ScopeType.REQUEST, name);
		this.request = ServletActionContext.getRequest();
	}

	public Object findObject() {
		return request.getAttribute(getName());
	}

	public void putObject(Object obj) {
		request.setAttribute(getName(), obj);
	}

	public Object removeObject() {
		Object obj = findObject();
		request.removeAttribute(getName());
		return obj;
	}
}
