<%@ taglib prefix="ww" uri="/struts-tags"%>  
<ww:if test="#session.logined != 'true'">
<jsp:forward page="/userLogin.jsp" />
</ww:if>