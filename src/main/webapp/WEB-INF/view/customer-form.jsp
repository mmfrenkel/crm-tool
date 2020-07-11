<!-- Add support for Spring MVC tags -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
    <head>
       
        <title>Save New Customer</title>
       
       <!-- Reference style sheet -->
        <link type="text/css" rel="stylesheet" 
             href="${pageContext.request.contextPath}/resources/css/style.css"/>
             
        <link type="text/css" rel="stylesheet" 
             href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"/>
    
    </head>
    
    <body>
       
        <div id="wrapper">
            <div id="header">
                <h2>SalesTracker</h2>
            </div>
        </div>
        
        <div id="container">
            <h3>Add New Customer</h3>
            
            <form:form action="saveCustomer" modelAttribute="customer" method="POST">
            
                <!-- Need to associate data with a given customer by adding hidden form field -->
                <!-- Without this line, you'd loose the id of the customer for update operations -->
                <form:hidden path="id"/>
                
                <table>
                    <tbody>
                    
                        <tr>
                            <td><label>First name:</label></td>
                            <td><form:input path="firstName"/></td>
                        </tr>
                        
                        <tr>
                            <td><label>Last name:</label></td>
                            <td><form:input path="lastName"/></td>
                        </tr>
                        
                        <tr>
                            <td><label>Email:</label></td>
                            <td><form:input path="email"/></td>
                        </tr>
                        
                        <tr>
                            <td><label></label></td>
                            <td><input type="submit" value="Save" class="save"/></td>
                        </tr>
                        
                    </tbody>
                </table>

            </form:form>
            
            <div style="clear; both;"></div>
            
            <p>
                <a href="${pageContext.request.contextPath}/customer/list">Back To List</a>
            </p>
          
       </div>
    
    </body>
</html>
