<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<div class="container">
<div class="row">
	<div class="row">
		<div class="col-sm-12">
			<h4 class="page-header">Payroll Worklist</h4>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			ID Number: ${client.id} <br/>
	    	Company Name : ${client.clientName}
	    </div>
	</div>
</div>
<br/>
<div class="row">
<div class="panel panel-primary" style="width:100%">
	<div class="panel-heading">
		Daily Time Record File Uploads
	</div>
	<div class="panel-body">
		<div class="row">
			<form method="POST" enctype="multipart/form-data" id="dtrUploadForm">
				<div class="col-sm-4">
					<input type='file' name="file" class="form-control" />
				</div>
				<div class="col-sm-3">
					<button type="submit" id="dtr-file-upload" class="btn btn-primary btn-sm">Upload DTR&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>
				</div>
			</form>
			<div class="col-sm-3">
					<span id="dtr-file-upload-result"></span>
				</div>
		</div>
		<br/>
		<div class="row">
			<form method="POST" enctype="multipart/form-data" id="leaveUploadForm">
				<div class="col-sm-4">
					<input type='text' class="form-control" />
				</div>
				<div class="col-sm-3">
					<button type="submit" id="leave-file-upload" class="btn btn-primary btn-sm">Upload Leave&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>
				</div>
			</form>
		</div>
		<br/>
		<div class="row">
			<form method="POST" enctype="multipart/form-data" id="overtimeUploadForm">
				<div class="col-sm-4">
					<input type='text' class="form-control" />
				</div>
				<div class="col-sm-3">
					<button type="submit" id="overtime-file-upload" class="btn btn-primary btn-sm">Upload Overtime</button>
				</div>
			</form>
		</div>
	</div>
</div>
</div>

<div class="row">
	<div id="message-alert"></div>
	<div class="row">
	<div class="col-sm-2" style="width: 10%;">Payroll Week:</div>
	<div class='col-sm-3'>
   		<div class="form-group">
       		<div class='input-group date' id='date-time-picker-from'>
           		<input type='text' id="date-time-picker-input-from" class="form-control" placeholder="Start date:" data-date-format="MM-DD-YYYY HH:mm:ss"/>
           		<span class="input-group-addon">
               		<span class="glyphicon glyphicon-calendar"></span>
           		</span>
       		</div>
   		</div>
	</div>
 	<script>
 		$('#date-time-picker-from').datetimepicker();
   	</script>
   	<div class='col-sm-3'>
	 	<div class="form-group">
	     	<div class='input-group date' id='date-time-picker-to'>
	         	<input type='text' id="date-time-picker-input-to" class="form-control" placeholder="End date:" data-date-format="MM-DD-YYYY HH:mm:ss" />
	             <span class="input-group-addon">
	             	<span class="glyphicon glyphicon-calendar"></span>
	            	</span>
	         </div>
	     </div>
 	</div>
 	<script>
		$('#date-time-picker-to').datetimepicker();
	</script>
	</div>
	
</div>
<div class="row">
	<div class="row">
    	<div class="col-sm-12">
	        <div class="panel panel-primary">
	            <div class="panel-heading" >
	                List of Employees
	            </div>
	            <div class="panel-body">
	                <table style="width:100%;" class="table table-striped table-bordered table-hover" id="employee-list-id">
	                    <thead>
	                        <tr>
	                            <th width="15%">Employee Number</th>
	                            <th width="20%">Employee Name</th>
	                            <th width="20%">Position</th>
	                            <th width="45%">Edit Payroll</th>
	                         
	                        </tr>
	                    </thead>
	                    <tbody>
	                       	<c:forEach items="${employeeList}" var="employee">                       
		                       
		                        <tr>
		                            <td>${employee.id}</td>
		                            <td>${employee.firstName} ${employee.lastName}</td>
		                            <td>${employee.position}</td>
		                            <td>
		                            	<button type="button" class="dtr-event btn btn-primary btn-sm" data-toggle="modal" data-target="#dtr-modal">Time Record</button>
		                            	<button type="button" class="leave-event btn btn-primary btn-sm" data-toggle="modal" data-target="#leave-modal">Leaves</button>
		                            	<button type="button" class="overtime-event btn btn-primary btn-sm" data-toggle="modal" data-target="#overtime-modal">Overtimes</button>
										<button type="button" class="dtr-event btn btn-primary btn-sm" data-toggle="modal" data-target="#dtr-modal">Night Shift</button>
		                            	<button type="button" class="dtr-event btn btn-primary btn-sm" data-toggle="modal" data-target="#dtr-modal">Allowance</button>
		                            	<button type="button" class="dtr-event btn btn-primary btn-sm" data-toggle="modal" data-target="#dtr-modal">Adjustment</button>
		                            </td>
		                        </tr>
		                         
	                        </c:forEach>
	                    </tbody>
	                </table>
	            </div>
	        </div>
    	</div>
	</div>
</div>
</div>
<jsp:include page="/WEB-INF/views/jsp/dtrmodal.jsp" />
<jsp:include page="/WEB-INF/views/jsp/leavemodal.jsp" />
<jsp:include page="/WEB-INF/views/jsp/overtimemodal.jsp" />