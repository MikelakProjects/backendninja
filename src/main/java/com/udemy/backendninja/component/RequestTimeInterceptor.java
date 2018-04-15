package com.udemy.backendninja.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Este componente definirá métodos para controlar el tiempo de ejecución de los métodos a los que se llamen
 * en nuestra aplicación. Para ello heredamos de la clase abstracta HandlerInterceptorAdapter
 */

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component("requestTimeInterceptor")
public class RequestTimeInterceptor extends HandlerInterceptorAdapter {

	// Como siempre, añadimos la clase de logging de Apache Commons
	private static final Log LOGGER = LogFactory.getLog(RequestTimeInterceptor.class);

	/**
	 * Este método se ejecutará cada vez que haya una request, justo antes de entrar en el método asociado a esa
	 * petición.
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		request.setAttribute("startTime", System.currentTimeMillis());
		return true;
	}

	/**
	 * Este método será llamado justo antes de terminar la ejecución del método asociado a la request (antes de 
	 * que devuelva la vista ¿?)
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		long startTime = (long) request.getAttribute("startTime");
		LOGGER.info("-- Request URL: '" + request.getRequestURL() + "' -- Total time: '" + (System.currentTimeMillis() - startTime) + "' ms");
	}
}
