$(document).ready(function() {
	$('#employee-list-id').DataTable({
		responsive: true
	});
});

$("#dtr-file-upload").on("click", function(event){
	event.preventDefault();
	
	var form = $('#dtrUploadForm')[0]; 
	var dat = new FormData(form);
	
	$.ajax({
		type: "POST",
		enctype:"multipart/form-data",
		url:"/employee-ws/fileupload",
		data : dat,
		processData: false,
		contentType: false,
		cache: false,
		timeout:600000,
		success: function(data) {
			$("#dtr-file-upload-result").text(data);
		}
	})
})