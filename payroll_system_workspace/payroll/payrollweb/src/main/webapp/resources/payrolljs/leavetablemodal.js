var LeaveModal = (function($){
	var _table = null
	var _modal = null
	var _modalBtn= null
	
	var _dataTable = null;
	var _this = this;
	
	var _init = function(table, modalBtn,modal) {
		_table = table;
		_modal = modal;
		_modalBtn = modalBtn;
		_dataTable = $(_table).DataTable({responsive:true});
	}
	
	var _bindEvent =function() {
		$(_modalBtn).on("click",_clickEvent);
	}
	
	var _reRenderTable = function() {
		$(_modal).find("tr td input.payroll-textfield").css("width","70px")
		$(_modal).find(".modal-sm").css("width","1150px");
		
		$(_table).css("width","100%");
	}
	var _clickEvent = function(event){
		var id = PayrollWeekDetails.getEmployeeId(event.target);
		var from = PayrollWeekDetails.getPayrollDateFrom();
		var to = PayrollWeekDetails.getPayrollDateTo();
		
		if (PayrollWeekDetails.isPayrollWeekHasValue(_modalBtn,from, to, event)) {
			if ($.fn.DataTable.isDataTable("#leave-table-id")) {
				_dataTable.clear();
				_reRenderTable();
				
				$.ajax({
					type: "GET",
					url: "/employee-ws/employee/leaves/" + id+ "/" + from + "/" + to + ".json",
					success: function(record) {
						
						$(_modal).find(".modal-content .modal-body span#span-employee-name").text("");
						
						if (record.length > 0) {
							$(_modal).find(".modal-content .modal-body span#span-employee-name").append("Name: " + record[0].firstName + " " + record[0].lastName + "<br/>");
							
							$.each(record, function(index){
								var obj = record[index];
								
								_dataTable.row.add([
									  obj.renderedDate,
									  obj.renderedHour,
									  obj.leaveType,
									  obj.status    
								]).draw();
							})
						} else {
							$(_modal).find(".modal-content .modal-body span#span-employee-name").append("NO FOUND RECORD<br/>");
							_dataTable.clear().draw();
							
						}
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