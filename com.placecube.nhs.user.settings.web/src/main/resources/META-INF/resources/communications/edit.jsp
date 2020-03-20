<%@ include file="../init.jsp"%>

<c:choose>
	<c:when test="${themeDisplay.isSignedIn()}">
		<portlet:actionURL var="saveFormURL" name="<%= MVCCommandKeys.COMMUNICATIONS_UPDATE %>" />

		<aui:form action="${saveFormURL}" method="post" name="communicationsForm">

			<c:set var="backToName" value="settings"/>
			<c:set var="showSaveButton" value="true"/>
			<c:set var="windowState" value="${windowStateMaximized}"/>
			<c:set var="mvcRenderCommandName" value="<%=MVCCommandKeys.VIEW_SETTINGS_OPTIONS%>"/>
			<%@ include file="../action-bar.jspf" %>
			
			<nhs-forms-ui:input-checkbox
				fieldLabel="where-do-i-receive-updates" 
				fieldHint="select-your-preferred-channels-to-receive-updates"
				fieldOptions="${notificationOptions}"
				fieldSelectedValues="${notificationSelectedValues}"  
				portletNamespace="${portletNamespace}"
				fieldName="userNotificationPreference" />
			
		</aui:form>
	</c:when>
	<c:otherwise>
		<div class="alert alert-warning">
			<liferay-ui:message key="please-sign-in-to-access-this-application"/>
		</div>
	</c:otherwise>
</c:choose>