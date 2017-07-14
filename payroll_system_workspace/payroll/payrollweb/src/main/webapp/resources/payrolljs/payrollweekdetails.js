var PayrollWeekDetails = function(){};

PayrollWeekDetails.isPayrollWeekHasValue = function(element, from, to,event) {
	if (from == "" || to == "") {
		event.stopPropagation();
		
		$("#message-alert").append("<div class=\"alert alert-warning alert-dismissable\">" +
			"<a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a>" +
			"<strong>Please fill up the Payroll Week!</strong>.</div>");
		
		return false;
	} else {
		return true;
	}
}

PayrollWeekDetails.getPayrollDateFrom = function() {
	var from = $("#date-time-picker-input-from").val().replace(/:|-|\s/g , "");
	
	return from;
}

PayrollWeekDetails.getPayrollDateTo = function() {
	var to = $("#date-time-picker-input-to").val().replace(/:|-|\s/g , "");
	
	return to;
}

PayrollWeekDetails.getEmployeeId = function(element){
	var id = $(element).parent().parent().find("td:first").text();
	
	return id;
}