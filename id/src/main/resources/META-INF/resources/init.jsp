<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="idea.constants.sWebKeys" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
String bootstrapRequire = (String)renderRequest.getAttribute(sWebKeys.BOOTSTRAP_REQUIRE);
String stylesheetURL = (String)renderRequest.getAttribute("stylesheetURL");
%>