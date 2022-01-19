<%@page import="estm.dsic.jee.dal.Contact"%>
<%@page import="estm.dsic.jee.business.ContactServices"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
ContactServices contactServices = new ContactServices();

int id = Integer.parseInt(request.getParameter("id_conM"));
Contact contact = contactServices.getContactByID(id);

if (contact == null) {
	response.sendRedirect("welcome.jsp");
}
%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="/html/header.html"%>
</head>
<body>
	<!-- Edit Modal HTML -->
	<div id="editContactModal" class="">
		<div class="modal-dialog">
			<div class="modal-content">
				<form action="editContact" method="post">
					<div class="modal-header">
						<h4 class="modal-title">Edit Contact</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label>ID</label> <input type="text" name="idConM"
								value="<%=contact.getIdC()%>" class="form-control" required>
						</div>
						<div class="form-group">
							<label>Name</label> <input type="text"
								value="<%=contact.getNom()%>" name="name" class="form-control" required>
						</div>
						<div class="form-group">
							<label>Email</label> <input type="email"
								value="<%=contact.getEmail()%>" name="email" class="form-control" required>
						</div>
						<div class="form-group">
							<label>Address</label>
							<textarea name="adresse" class="form-control" required><%=contact.getAdresse()%></textarea>
						</div>
						<div class="form-group">
							<label>Phone</label> <input type="text" name="tel"
								value="<%=contact.getTel()%>" class="form-control" required>
						</div>
					</div>
					<div class="modal-footer">
						<!-- Cancel -->
						<input type="button" class="btn btn-default" data-dismiss="modal"
							value="Cancel">

						<!-- Save -->
						<input type="submit" class="btn btn-info" value="Save">
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>