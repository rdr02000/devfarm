var OvertimeModal = (function($){
	var _table = null
	var _modalBtn= null
	var _dataTable = null;
	var _this = this;
	
	var _init = function(table, modalBtn) {
		_table = $(table);
		_modalBtn = $(modalBtn);
		_dataTable = _table.DataTable({responsive:true});
	}
	
	var _bindEvent =function() {
		_modalBtn.on("click",_clickEvent);
	}
	
	var _reRenderTable = function() {
		$("#overtime-modal").find("tr td input.payroll-textfield").css("width","70px")
		$("#overtime-modal").find(".modal-sm").css("width","1150px");
		
		$("#overtime-table-id").css("width","100%");
		
		_dataTable.columns.adjust().draw();
	}
	
	var _clickEvent = function(event){
		var id = PayrollWeekDetails.getEmployeeId(event.target);
		var from = PayrollWeekDetails.getPayrollDateFrom();
		var to = PayrollWeekDetails.getPayrollDateTo();
		
		if (PayrollWeekDetails.isPayrollWeekHasValue(_modalBtn,from, to, event)) {
			if ($.fn.DataTable.isDataTable("#" + _table.attr("id"))) {
				_dataTable.clear();
				
				$.ajax({
					type: "GET",
					url: "/employee-ws/employee/overtime/" + id+ "/" + from + "/" + to + ".json",
					success: function(record) {
						$("#overtime-modal .modal-content .modal-body span#span-employee-name").text("");
						$("#overtime-modal .modal-content .modal-body span#span-employee-name").append("Name: " + record.firstName + " " + record.lastName + "<br/>");
						
						$.each(record, function(key,value){
							if (key == "overtimeList") {
								$.each(value, function(index) {
									var obj = value[index];
									
									_dataTable.row.add([
										  obj.dateRendered,
										  obj.renderedHour,
										  obj.description,
										  obj.status    
									]).draw();
								})
							}
						})
						 
						_reRenderTable();
					}
				})
			}
		}
	}
	
	return {
		init : _init,
		bindEvent : _bindEvent
	}
})(jQuery);