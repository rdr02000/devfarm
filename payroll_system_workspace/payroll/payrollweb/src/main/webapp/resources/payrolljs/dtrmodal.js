var dtrTable = $("#dtr-table-id").DataTable({
	responsive : true,	
});

var leaveTable = $("#leave-table-id").DataTable({
	responsive : true
});

var overtimeTable = $("overtime-table-id").DataTable({
	responsive : true
});

$(".leave-event").on("click", function(event){
	var id = PayrollWeekDetails.getEmployeeId(this);
	var from = PayrollWeekDetails.getPayrollDateFrom();
	var to = PayrollWeekDetails.getPayrollDateTo();
	
	if (PayrollWeekDetails.isPayrollWeekHasValue(this,from, to, event)) {
		if ($.fn.DataTable.isDataTable("#leave-table-id")) {
			leaveTable.clear();
			
			$.ajax({
				type: "GET",
				url: "/employee-ws/employee/leaves/" + id+ "/" + from + "/" + to + ".json",
				success: function(record) {
					console.log(record);
					$("#leave-modal .modal-content .modal-body span#span-employee-name").text("");
				    $("#leave-modal .modal-content .modal-body span#span-employee-name").append("Name: " + record[0].firstName + " " + record[0].lastName + "<br/>");
					
				    $.each(record, function(index){
				    	var obj = record[index];
				    	
				    	leaveTable.row.add([
				    	      obj.renderedDate,
				    	      obj.renderedHour,
				    	      obj.leaveType,
				    	      obj.status    
				    	]).draw();
				    })
				}
			})
			
			$("#leave-modal").find("tr td input.payroll-textfield").css("width","70px")
			$("#leave-modal").find(".modal-sm").css("width","1150px");
			
			$("#leave-table-id").css("width","100%");
			
			leaveTable.columns.adjust().draw();
			
		}
	}
})

$(".dtr-event").on("click", function(event){
	var id = PayrollWeekDetails.getEmployeeId(this);
	var from = PayrollWeekDetails.getPayrollDateFrom();
	var to = PayrollWeekDetails.getPayrollDateTo();
	
	if(PayrollWeekDetails.isPayrollWeekHasValue(this,from, to, event)) {
	
	    if ($.fn.DataTable.isDataTable("#dtr-table-id")) {
	    	dtrTable.clear();
			
			$.ajax({
				type : "GET",
				url: "/employee-ws/employee/timerecords/" + id+ "/" + from + "/" + to + ".json",
				success : function(record){
					$("#dtr-modal .modal-content .modal-body span#span-employee-name").text("");
				    $("#dtr-modal .modal-content .modal-body span#span-employee-name").append("Name: " + record.firstName + " " + record.lastName + "<br/>");
					$.each(record, function(key, value){
						
						if (key === 'employeeTimeRecordList') {
							
							$.each(value,function(index){
								var obj = value[index];
								
								dtrTable.row.add([
								    "<input type='text' class='form-control date' id='datetimepicker" + index + "1' value='" + obj.timeIn + "'/> " +
		   							"<script>" +
		   								"$('#datetimepicker" + index + "1').datetimepicker({" + 
		  										"format:  'YYYY-MM-DD HH:mm'," +
												"widgetPositioning: {" +
													"horizontal: 'auto'," +
												    "vertical: 'auto' " +
												"}," +
												"toolbarPlacement: 'bottom'," +
												"showTodayButton: true," +
												"showClear: true," +
												"stepping: 1" +
					        				"});" +
						        					
				        					"$('#datetimepicker" + index + "1').on('dp.show', function(){" +
				        						"$(this).parent().find('.bootstrap-datetimepicker-widget')." +
				        							"find('table thead > tr > th').css('padding-right','0');" +
				        						"$(this).parent().find('.bootstrap-datetimepicker-widget')." +
				        							"find('table thead > tr > th').css('padding-left','0');" +
				        					"});" +
					           		"<\/script>",
					           		
					           		"<input type='text' class='form-control date' id='datetimepicker" + index + "2' value='" + obj.timeOut + "'/> " +
	    							"<script>" +
	    								"$('#datetimepicker" + index + "2').datetimepicker({" + 
	   										"format:  'YYYY-MM-DD HH:mm'," +
											"widgetPositioning: {" +
												"horizontal: 'auto'," +
											    "vertical: 'auto' " +
											"}," +
											"toolbarPlacement: 'bottom'," +
											"showTodayButton: true," +
											"showClear: true," +
											"stepping: 1" +
				        				"});" +
				        					
			        					"$('#datetimepicker" + index + "2').on('dp.show', function(){" +
			        						"$(this).parent().find('.bootstrap-datetimepicker-widget')." +
			        							"find('table thead > tr > th').css('padding-right','0');" +
			        						"$(this).parent().find('.bootstrap-datetimepicker-widget')." +
			        							"find('table thead > tr > th').css('padding-left','0');" +
			        					"});" +
					           		"<\/script>",
					  
					           		"<input type='text' class='payroll-textfield form-control' value='" + obj.late + "'/>",
					           		"<input type='text' class='payroll-textfield form-control' value='" + obj.underTime + "'/>",
					           		
								]).draw();
							})
						}	
					});
					
					
				    $("#dtr-modal").find("tr td input.payroll-textfield").css("width","70px")
					$("#dtr-modal").find(".modal-sm").css("width","1150px");
					
					$("#dtr-table-id").css("width","100%");
					
					dtrTable.columns.adjust().draw();
				}
			})
	    }
	}
})