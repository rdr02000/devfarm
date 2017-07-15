<!-- DTR Modal -->
<div id="dtr-modal" class="modal fade " tabindex="-1" role="dialog" aria-labelledby="classInfo" aria-hidden="true">
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
      		<div class="modal-header modal-header-primary">
        		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        		<h4 class="modal-title" id="classModalLabel">
        			Payroll Detail
        		</h4>
      		</div>
      		<div class="modal-body">
      			<div class="container">
      				<div class="row col-sm-12 ">
			      		<h4 class="modal-title">Daily Time Records</h4>
			      	</div>
			      	<br/>
			      	<br/>
			      	<span id='span-employee-name'></span>
			      	<br/>
	      			<div class="row col-sm-12 " >
	      				<table id="dtr-table-id" class="table table-striped table-bordered">
	        				<thead>
	            				<tr>
	                				<th>Time In</th>
	                				<th>Time Out</th>
	               					<th>Late(in Min)</th>
	                				<th>Undertime(in Min)</th>
	                				<th>Night Shift(in Min)</th>
	                				<th>Action</th>
	            				</tr>
	        				</thead>
	        				
	    				</table>
      				</div>

  				</div>
			</div>
			<div class="modal-footer">
				<button id="add-button" type="button" class="btn btn-primary" >
   					Add
  				</button>
  				<button type="button" class="btn btn-primary" data-dismiss="modal">
   					Close
  				</button>
		 	</div>
		</div>
	</div>
</div>