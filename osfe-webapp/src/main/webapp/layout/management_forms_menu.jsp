<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://stripes.sourceforge.net/stripes.tld" %>
<div id="menu">
  <s:link beanclass="com.qagen.osfe.webapp.web.action.auth.HomeActionBean">Home</s:link> |
  <s:link beanclass="com.qagen.osfe.webapp.web.action.auth.ManageFeedDatasourcesActionBean">Manage Data Sources</s:link> |
  <s:link beanclass="com.qagen.osfe.webapp.web.action.auth.ManageFeedGroupActionBean">Manage Groups</s:link> |
  <s:link beanclass="com.qagen.osfe.webapp.web.action.auth.ManageFeedTypeActionBean">Manage Types</s:link> |
  <s:link beanclass="com.qagen.osfe.webapp.web.action.auth.ManageFeedsActionBean">Manage Feeds</s:link>
</div>
<hr/>