<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security"
    uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>

<html>
	<head>
	   
	   <title>CRM Tool</title>
	   
	   <!-- Reference style sheet -->
	   <link type="text/css" rel="stylesheet" 
	         href="${pageContext.request.contextPath}/resources/css/style.css"/>
	
	</head>
	
	<body>
	   
	   <div id="wrapper">
	       <div id="header">
	           <h2>CRM - Customer Relationship Manager</h2>
	       </div>
	   </div>
	   
	   <div id="container">
	       <div id="content">
	       
	           
	           <security:authorize access="hasAnyRole('MANAGER', 'ADMIN')">
	           
		           <input type="button" value="Add Customer" 
		                  onclick="window.location.href='showFormForAdd'; return false;"
		                  class="add-button"
		           />
		       </security:authorize>
		       
	           <table>
	               <tr>
	                   <th>First Name</th>
	                   <th>Last Name</th>
	                   <th>Email</th> 
	                   <th>Action</th>
	               </tr>
	               
	               <c:forEach var="customer" items="${customers}">
	               
	                   <c:url var="updateLink" value="/customer/showFormForUpdate">
	                      <c:param name="customerId" value="${customer.id}"/>
	                   </c:url>
	                   
	                   <c:url var="deleteLink" value="/customer/delete">
                          <c:param name="customerId" value="${customer.id}"/>
                       </c:url>
						
					   <tr>
						  <td> ${customer.firstName} </td>
						  <td> ${customer.lastName} </td>
						  <td> ${customer.email} </td>
						  
						  <!-- Display Update Link -->
                          <td>
                          
                            <security:authorize access="hasAnyRole('MANAGER', 'ADMIN')">
                                <a href="${updateLink}">Update</a> 
                             </security:authorize>
                             
                             <security:authorize access="hasAnyRole('ADMIN')">
                                |
	                             <a href="${deleteLink}"
	                                onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
                             </security:authorize>
                             
                          </td>
	                   </tr>

	               </c:forEach>
	           </table>
	           
	       </div>
	   </div>
	
	</body>
</html>
