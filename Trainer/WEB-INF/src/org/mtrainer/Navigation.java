/*
 * Created on Nov 1, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package org.mtrainer;

import org.apache.struts.action.*;
import org.apache.struts.tiles.actions.*;
import org.apache.struts.tiles.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;


public final class Navigation extends TilesAction {
	/**
	 * Process http request (controller)
	 * @param context The current Tile context, containing Tile attributes
	 * @param mapping The ActionMapping used to select this instance
	 * @param form The optional ActionForm bean for this request (if any)
	 * @param request The HTTP request we are processing
	 * @param response The HTTP response we are creating
	 *
	 * @exception IOException if an input/output error occurs
	 * @exception ServletException if a servlet exception occurs
	 */
	public ActionForward perform( ComponentContext context,
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
	throws IOException, ServletException
	{
		String title = (String)context.getAttribute( "body" );
		System.out.println( "Original title" + title );
		context.putAttribute( "body", request.getParameter("navig") );
		return null;
	}
}