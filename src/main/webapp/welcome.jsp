<%@page import="estm.dsic.jee.dal.Contact"%>
<%@page import="java.util.ArrayList"%>
<%@page import="estm.dsic.jee.dal.User"%>
<%@page import="estm.dsic.jee.business.ContactServices"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
ContactServices contactServices = new ContactServices();
String userName = (String) session.getAttribute("userName");

if (userName == null) {
	System.out.println("Error !!!!!!");
	response.sendRedirect("index.jsp");
} else {
	ArrayList<Contact> arrayList = null;
	String val = request.getParameter("value");

	System.out.println(val);
	
	if (val != null) {
		arrayList = contactServices.ContactSearch(val);
	} else {
		arrayList = contactServices.getAll();
	}
%>

<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="/html/header.html"%>
</head>
<body>
	<div class="container">
		<div class="table-responsive">
			<div class="table-wrapper">
				<h3 style="font-size: 20px; margin-top: -10px; margin-bottom: 24px;"
					class="text-right">
					Bonjour
					<%=userName%>
					<b><a href="logout">Logout</a></b>

				</h3>

				<div class="table-title">
					<div class="row">
						<div class="col-xs-6">
							<h2>
								Manage <b>Contacts</b>
							</h2>
						</div>
						<div class="col-xs-6">
							<a href="addContact.jsp" class="btn btn-success"><i
								class="material-icons">&#xE147;</i> <span>Add New Contact</span></a>

							<!-- add search button -->
							<form action="search" method="post"
								class="form-inline my-2 my-lg-0">
								<input name="ValS" class="form-control mr-sm-2" value=""
									placeholder="" aria-label="search"> <input
									type="submit" class="btn btn-primary" value="Search">
							</form>
						</div>
					</div>
				</div>
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th><span class="custom-checkbox"> <input
									type="checkbox" id="selectAll"> <label for="selectAll"></label>
							</span></th>
							<th>Name</th>
							<th>Email</th>
							<th>Address</th>
							<th>Phone</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>

						<%
						for (Contact contact : arrayList) {
						%>

						<tr>
							<td><span class="custom-checkbox"> <input
									type="checkbox" id="checkbox1" name="options[]" value="1">
									<label for="checkbox1"></label>
							</span></td>
							<td><%=contact.getNom()%></td>
							<td><%=contact.getEmail()%></td>
							<td><%=contact.getAdresse()%></td>
							<td><%=contact.getTel()%></td>
							<td>
								<!-- Modifier --> <a
								href="modContact.jsp?id_conM=<%=contact.getIdC()%>" class="edit"
								data-toggle="modal"><i class="material-icons"
									data-toggle="tooltip" title="Edit">&#xE254;</i></a> <!-- Delete -->
								<a href="deleteContact?id_conD=<%=contact.getIdC()%>"
								class="delete" data-toggle="modal"><i class="material-icons"
									data-toggle="tooltip" title="Delete">&#xE872;</i></a>
							</td>
						</tr>
						<%
						}
						%>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<%
	}
	%>
</body>
</html>