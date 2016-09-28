package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class adminarea_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_c_005fset_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<link href=\"");
      if (_jspx_meth_c_005furl_005f0(_jspx_page_context))
        return;
      out.write("\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js\"></script>\r\n");
      out.write("    <script src=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<link href=\"//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css\" rel=\"stylesheet\" media=\"screen\">  \r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("    <div class=\"row user-menu-container square\">\r\n");
      out.write("        <div class=\"col-md-12 user-details\">\r\n");
      out.write("            <div class=\"row coralbg white\">\r\n");
      out.write("                <div class=\"col-md-6 no-pad\">\r\n");
      out.write("                    <div class=\"user-pad\">\r\n");
      out.write("                        <h4><a title=\"Log Out\" href=\"logout\">Log Out</a></h4>\r\n");
      out.write("                        <h3>Welcome , ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.userName}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</h3>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-md-6 no-pad\">\r\n");
      out.write("                    <div class=\"col-md-1 no-pad\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("                <div class=\"col-md-8 no-pad\">\r\n");
      out.write("                    <div class=\"user-image\">\r\n");
      out.write("                    <div class=\"col-sm-4\"></div>\r\n");
      out.write("                        <img class=\"col-sm-4\" src=\"http://loopssolutions.com/Images/admin.png\" class=\"img-responsive thumbnail\">\r\n");
      out.write("                    </div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("                    <div class=\"col-md-1 no-pad\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"row overview greyback\">\r\n");
      out.write("            \r\n");
      out.write("                <div class=\"col-md-6 user-pad text-center\">\r\n");
      out.write("                    <h3>Age</h3>\r\n");
      out.write("                    <h4>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userage}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</h4>\r\n");
      out.write("                   \r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-md-6 user-pad text-center\">\r\n");
      out.write("                    <h3>Role</h3>\r\n");
      out.write("                    <h4>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.role}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</h4>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("    <div class=\"row user-menu-container square\">\r\n");
      out.write("    <div class=\"card hovercard\">\r\n");
      out.write("        <div class=\"card-background\">\r\n");
      out.write("            \r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"btn-pref btn-group btn-group-justified btn-group-lg\" role=\"group\" aria-label=\"...\">\r\n");
      out.write("        <div class=\"btn-group\" role=\"group\">\r\n");
      out.write("            <button type=\"button\" id=\"stars\" class=\"btn btn-default\" href=\"#tab1\" data-toggle=\"tab\" onclick=\"finduser()\"><span class=\"glyphicon glyphicon-star\" aria-hidden=\"true\"></span>\r\n");
      out.write("                <div class=\"hidden-xs\" onclick=\"add(this)\">Users</div>\r\n");
      out.write("            </button>\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("        <div class=\"btn-group\" role=\"group\">\r\n");
      out.write("            <button type=\"button\" id=\"following\" class=\"btn btn-default\" href=\"#tab2\" data-toggle=\"tab\" onclick=\"showplaylists()\"><span class=\"glyphicon glyphicon-user\" aria-hidden=\"true\"></span>\r\n");
      out.write("                <div class=\"hidden-xs\">User - PlayList</div>\r\n");
      out.write("            </button>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"well\">\r\n");
      out.write("      <div class=\"tab-content\">\r\n");
      out.write("        <div class=\"tab-pane fade in\" id=\"tab1\">\r\n");
      out.write("          <div id=\"results\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"tab-pane fade in\" id=\"tab2\">\r\n");
      out.write("          <div id=\"AllPlaylist\">          \r\n");
      out.write("               ");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write("    <button type=\"button\" class=\"btn btn-default\" onclick=\"generatepdf()\">Generate Pdf</button>\r\n");
      out.write("    <button type=\"button\" class=\"btn btn-default\" onclick=\"location.href='contact.htm';\">Send Mail</button>\r\n");
      out.write("    \r\n");
      out.write("    \t<div class=\"row\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<article class=\"col-sm-9\">\r\n");
      out.write("\t\t\t\t\t<h1>Contact us</h1>\r\n");
      out.write("\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t<form>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-sm-4\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input class=\"form-control\" type=\"text\" id=\"namecontact\"  placeholder=\"Name\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-sm-4\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input class=\"form-control\" type=\"text\" id=\"emailcontact\" placeholder=\"Email\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-sm-4\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input class=\"form-control\" type=\"text\" id=\"phonecontact\" placeholder=\"Phone\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-sm-12\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<textarea placeholder=\"Type your message here...\" class=\"form-control\" rows=\"9\"></textarea>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-sm-12 text-right\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input class=\"btn btn-action\" type=\"submit\" value=\"Send message\" onclick=\"sendmail()\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("<div id=\"AA\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userlists}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</div>\r\n");
      out.write("\t\t\t</article>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("var finduser = function finduser() {\r\n");
      out.write("    $.ajax({\r\n");
      out.write("    \ttype: \"POST\",\r\n");
      out.write("    \tdataType : \"json\",\r\n");
      out.write("    \turl : \"getusers.htm\",\r\n");
      out.write("        success: function (data) {\r\n");
      out.write("        \t$(\"#results\").empty();\r\n");
      out.write("            var tostr=JSON.stringify(data);\r\n");
      out.write("            var end=tostr.indexOf(\"}}\");\r\n");
      out.write("            var jsonStr=tostr.substring(0,end+2);\r\n");
      out.write("            var outerObj=$.parseJSON(jsonStr);\r\n");
      out.write("            $.each(outerObj, function(i, val) {\r\n");
      out.write("                var innerStr=JSON.stringify(val);\r\n");
      out.write("                var innerObj=$.parseJSON(innerStr);\r\n");
      out.write("                var str=\"<tr>\";\r\n");
      out.write("                $.each(innerObj, function(j, value) {\r\n");
      out.write("                \tstr+=\"User : \";\r\n");
      out.write("                    str+=\"<td>\"+value+\"</td>\";\r\n");
      out.write("                });\r\n");
      out.write("                str+=\"</tr>\";\r\n");
      out.write("                $(\"#results\").append(str);\r\n");
      out.write("            });\r\n");
      out.write("        }\r\n");
      out.write("    });\r\n");
      out.write("};\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("function requestdetails(i, personId, ok) {\r\n");
      out.write("    $.ajax({\r\n");
      out.write("    \ttype: \"POST\",\r\n");
      out.write("    \tdataType : \"json\",\r\n");
      out.write("    \turl : \"getusers/approverequest.htm\",\r\n");
      out.write("    \tdata : {query: i , personId : personId},\r\n");
      out.write("        success: function (data) {\r\n");
      out.write("        \tif(data == 1)\r\n");
      out.write("        \t\tfinduser();\r\n");
      out.write("        \telse\r\n");
      out.write("        \t\talert(\"Error while deleting\");\r\n");
      out.write("        }\r\n");
      out.write("    });\r\n");
      out.write("};\r\n");
      out.write("\r\n");
      out.write("// 3rd Ajax call\r\n");
      out.write("\r\n");
      out.write("var showplaylists = function () {\r\n");
      out.write("    $.ajax({\r\n");
      out.write("    \ttype: \"POST\",\r\n");
      out.write("    \turl : \"getusers/getuseralbums.htm\",\r\n");
      out.write("        success: function (data) {\r\n");
      out.write("        \t\r\n");
      out.write("        }\r\n");
      out.write("    });\r\n");
      out.write("};\r\n");
      out.write("\r\n");
      out.write("//call for pdf\r\n");
      out.write("\r\n");
      out.write("var generatepdf = function () {\r\n");
      out.write("\tvar win = window.open('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.servletContext.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/resources/images/report.pdf', '_blank');\r\n");
      out.write("\tif(win){\r\n");
      out.write("\t    win.focus();\r\n");
      out.write("\t}else{\r\n");
      out.write("\t    alert('Please allow popups for this site');\r\n");
      out.write("\t}\r\n");
      out.write("};\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("$( document ).ready(function() {\r\n");
      out.write("    \r\n");
      out.write("\t    $.ajax({\r\n");
      out.write("\t    \ttype: \"POST\",\r\n");
      out.write("\t    \turl : \"getusers/getpdf.htm\",\r\n");
      out.write("\t        success: function (data) {\r\n");
      out.write("\t        \t\r\n");
      out.write("\t        }\r\n");
      out.write("\t    });\r\n");
      out.write("\t\r\n");
      out.write("  });\r\n");
      out.write("\r\n");
      out.write("var showplaylists = function () {\r\n");
      out.write("    $.ajax({\r\n");
      out.write("    \ttype: \"POST\",\r\n");
      out.write("    \turl : \"getusers/getuseralbums.htm\",\r\n");
      out.write("        success: function (data) {\r\n");
      out.write("        \t\r\n");
      out.write("        }\r\n");
      out.write("    });\r\n");
      out.write("};\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</html>    ");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fset_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f0.setParent(null);
    // /WEB-INF/views/adminarea.jsp(3,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setVar("contextPath");
    // /WEB-INF/views/adminarea.jsp(3,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setValue(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/adminarea.jsp(3,0) '${pageContext.request.contextPath}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${pageContext.request.contextPath}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
    if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f0 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f0.setParent(null);
    // /WEB-INF/views/adminarea.jsp(8,12) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f0.setValue("/css/lol.css");
    int _jspx_eval_c_005furl_005f0 = _jspx_th_c_005furl_005f0.doStartTag();
    if (_jspx_th_c_005furl_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /WEB-INF/views/adminarea.jsp(84,15) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/adminarea.jsp(84,15) '${sessionScope.allusershere}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${sessionScope.allusershere}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /WEB-INF/views/adminarea.jsp(84,15) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("element");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("  \t\t\t\t\t\t<ul style=\"list-style-type:disc\">\r\n");
          out.write("    \t\t\t\t\t<li> ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${element.userName}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</li><br/>\r\n");
          out.write("    \t\t\t\t\t\t");
          if (_jspx_meth_c_005fforEach_005f1(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
          out.write("\r\n");
          out.write("    \t\t\t\t\t</ul>\r\n");
          out.write("\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
    // /WEB-INF/views/adminarea.jsp(87,10) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f1.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/adminarea.jsp(87,10) '${element.playlists}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${element.playlists}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /WEB-INF/views/adminarea.jsp(87,10) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f1.setVar("playlistsss");
    int[] _jspx_push_body_count_c_005fforEach_005f1 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f1 = _jspx_th_c_005fforEach_005f1.doStartTag();
      if (_jspx_eval_c_005fforEach_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("    \t\t\t\t\t\t<ul><li>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${playlistsss.playlistName}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</li></ul>\r\n");
          out.write("    \t\t\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f1.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f1);
    }
    return false;
  }
}
