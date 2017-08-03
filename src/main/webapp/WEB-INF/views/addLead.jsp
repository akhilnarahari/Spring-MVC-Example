<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 
<html>
<head>
    <title>Add Student Form</title>
    <style>
    .error
    {
        color: #ff0000;
        font-weight: bold;
    }
    </style>
</head>
 
<body>
    <h2><spring:message code="lbl.page"/></h2>
    <br/>
    <form:form method="post" modelAttribute="lead">
        <!-- Below line displays all error Strings, incase you need to print all erros at one place -->
        <%-- <form:errors path="*" cssClass="error" /> --%>
        <table>
            <tr>
                <td><spring:message code="lbl.firstName" />
                        <%-- spring:message text="Avasarama" / --%>
                </td>
                <td><form:input path="firstName" /></td>
                <td><form:errors path="firstName" cssClass="error" /></td>
            </tr>
            <tr>
                <td><spring:message code="lbl.lastName" text="Last Name" /></td>
                <td><form:input path="lastName" /></td>
                <td><form:errors path="lastName" cssClass="error" /></td>
            </tr>
            <tr>
                <td><spring:message code="lbl.email" text="Email Id" /></td>
                <td><form:input path="email" /></td>
                <td><form:errors path="email" cssClass="error" /></td>
            </tr>
            <tr>
                <td><spring:message code="lbl.phoneno" text="Phone Number" /></td>
                <td><form:input path="phoneno" /></td>
                <td><form:errors path="email" cssClass="error" /></td>
            </tr>
            <tr>
                <td colspan="3"><input type="submit" value="Submit"/></td>
            </tr>
        </table>
    </form:form>
</body>
</html>