var DtrModal = (function($) {
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
	
	var _getDataTable = function() {
		return _dataTable;
	}
	
	var _getModalBtn = function() {
		return _modalBtn;
	}
	
	var _getTable = function() {
		return _table;
	}
	
	var _reRenderTable = function() {
		$("#dtr-modal").find("tr td input.payroll-textfield").css("width","70px")
		$("#dtr-modal").find(".modal-sm").css("width","1150px");
		$("#dtr-table-id").css("width","100%");
		_dataTable.columns.adjust().draw();
	}
	
	var _addTableData = function(dataTable,index,obj) {
		dataTable.row.add([
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
	} 
	
	var _clickEvent = function(event){
		var id = PayrollWeekDetails.getEmployeeId(event.target);
		var from = PayrollWeekDetails.getPayrollDateFrom();
		var to = PayrollWeekDetails.getPayrollDateTo();
			
		if(PayrollWeekDetails.isPayrollWeekHasValue(_modalBtn,from, to, event)) {
			if ($.fn.DataTable.isDataTable("#" + _table.attr("id"))) {
				_dataTable.clear();
				
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
									_addTableData(_dataTable,index, obj);
									
								})
							}	
						});
						
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