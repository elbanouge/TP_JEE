<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/html/header.html"%>
</head>
<body>

	<!-- Add Modal HTML -->
	<div id="addContactModal" class="">
		<div class="modal-dialog">
			<div class="modal-content">
				<form action="contact" method="post">
					<div class="modal-header">
						<h4 class="modal-title">Add Contact</h4>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label>Name</label> <input name="name" type="text"
								class="form-control" required>
						</div>
						<div class="form-group">
							<label>Email</label> <input name="email" type="email"
								class="form-control" required>
						</div>
						<div class="form-group">
							<label>Address</label>
							<textarea name="adresse" class="form-control" required></textarea>
						</div>
						<div class="form-group">
							<label>Phone</label> <input name="tel" type="text"
								class="form-control" required>
						</div>
					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-default" data-dismiss="modal"
							value="Cancel"> <input type="submit"
							class="btn btn-success" value="Add">
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>