<table>
				<tr>
					<td></td>
					<td><form:hidden path="patientID" /></td>
				</tr>

				<tr>
					<td><label></label></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td><label>Contact :</td>
					<td></td>
				</tr>
				<tr>
					<td><label>City:</td>
					<td></td>
				</tr>
				<tr>
					<td><label>Doctor Name :</td>
					<td><form:select class="form-control" path="doctorName">
							<%-- <form:option value="NONE" label="Select" /> --%>
							<form:options items="${doctorList}" />
						</form:select></td>
				</tr>
				<tr>
					<td><label>Date :</td>
					<td></td>
				</tr>
				<tr>
					<td><form:label path="patientType">Patient Type</form:label></td>
					<td><form:radiobutton class="form-control" path="patientType"
				value="OPD" label="OPD" /> <form:radiobutton path="patientType"
				value="IPD" label="IPD" /> <form:radiobutton path="patientType"
				value="ICU" label="ICU" /></td>
				</tr>
				<tr>
					<td><form:label path="appTime">
							<label>Time</label>
						</form:label></td>
					<td><form:select class="form-control" path="appTime">
							<form:option value="NONE" label="Select" />
							<form:options items="${freeTimeSlots}" />
						</form:select></td>
				</tr>
				<tr>
					<td><form:label path="bloodGroup">
							<label><label>Blood Group</label>
						</form:label></td>
					<td><form:select class="form-control" path="bloodGroup">
							<form:option value="NONE" label="Select" />
							<form:options items="${bloodGroups}" />
						</form:select></td>

				</tr>
				<tr>
					<td><label>Weight :</label></td>
					<td><form:input class="form-control" path="weight" /></td>
				</tr>
				<tr>
					<td><label>Height :</label></td>
					<td><form:input class="form-control" path="height" /></td>
				</tr>
				<tr>
					<td><label>BP:</label></td>
					<td><form:input class="form-control" path="bp" /></td>
				</tr>
				<tr>
					<td><label>Sugar:</label></td>
					<td><form:input class="form-control" path="sugar" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Create New Patient" /></td>
				</tr>
			</table>