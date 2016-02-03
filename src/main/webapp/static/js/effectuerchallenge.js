

$(document).ready(function() {
	
	
	var solution_temp = $.cookie('solution_temp');
	$('#code').val(solution_temp);
		
	
	
	function enregistrerSolutionTemp()
	{
		$.cookie('solution_temp', $('#code').val(), { expires: 7});
	}
	
	setInterval(enregistrerSolutionTemp, 10000);

	
	function readSingleFile(evt) {
	    var f = evt.target.files[0]; 

	    if (f) {
	      var r = new FileReader();
	      r.onload = function(e) { 
		      var contents = e.target.result;
		      $('#code').val(contents);  
	      }
	      r.readAsText(f);
	    } else { 
	      alert("Failed to load file");
	    }
	  }

	  document.getElementById('file').addEventListener('change', readSingleFile, false);
	
	$('.compile').click(
			function(event) {
				
				var code = $('#code').val();
				
				var data = 'code='
					+ encodeURIComponent(code)
					+ '&id_challenge='
					+ encodeURIComponent(id_challenge);
				
				
				
				$.ajax({
					url : action_compile,
					data : data,
					type : "GET",
	 
					success : function(response) {
						
						var res = response['res'];
						var time = response['time'];
						var cmpinfo =  response['cmpinfo'];
						var date = response['date'];
						var memory = response['memory'];
						var msgErreur = response['msgErreur'];
						
						
						if(msgErreur != null)
						{	
						if(msgErreur != "" )
						{
							$("#success").css("display","none");
							$("#error").css("display","block");
							$("#msgerror").html("<p>connexion erreur.</p>");
						}
						}
						else if( cmpinfo != "" )
						{
							$("#success").css("display","none");
							$("#error").css("display","block");
							$("#msgerror").html("<p>"+cmpinfo+"</p>");
						}
						else if(res == "true")
					    {
							$("#success").css("display","block");
							$("#error").css("display","none");
							$("#date").html(date);
							$("#time").html(time);
							$("#memory").html(memory);
							$("#msgsuccess").html("<p>Votre algorithme est correcte.</p>");
							
							
							
					    }
						else if(res == "false")
						{
							$("#success").css("display","none");
							$("#error").css("display","block");
							$("#msgerror").html("<p>Votre algorithme est incorrecte.</p>");
						}
						
						
					},
					error : function(xhr, status, error) {
						
						
						
						alert(xhr.responseText);
					}
				});
				
				
			});
	
	
	
	$('.envoyer').click(
			function(event) {
				
				var code = $('#code').val();
				
				var data = 'code='
					+ encodeURIComponent(code)
					+ '&id_challenge='
					+ encodeURIComponent(id_challenge);
				
				
				
				$.ajax({
					url : envoyer_solution,
					data : data,
					type : "GET",
	 
					success : function(response) {
						
						var msgErreur = response['msgSolution'];
						
						alert(msgErreur);
					},
					error : function(xhr, status, error) {
						
						alert(xhr.responseText);
					}
				});
				
				
			});
	
	
});