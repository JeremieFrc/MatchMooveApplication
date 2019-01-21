(function(){
	console.log('formCompte');
	
	var errors = document.querySelectorAll('.errors');
	var inputs =document.querySelectorAll('.form-control')
	
for(var i=0 ;i<inputs.length ;i++){
		
		inputs[i].addEventListener('blur',function(e){
			e.preventDefault();
			
			console.log('value '+this.value);
			console.log('taille '+this.value.trim().length);

			if(this.value.trim().length >= 3  && this.value.trim().length < 32){
				if(this.classList.contains('input-error')){
					this.classList.remove('input-error');
				}
				this.classList.add('input-validate');	
				
				if(this.name = "email"){
					errors[0].innerText = "";
				}
				if (this.name = "password"){
					errors[1].innerText = "";
				}
			}else{
				if(this.classList.contains('input-validate')){
					this.classList.remove('input-validate');
				}
				this.classList.add('input-error');
				
				if(this.name = "email"){
					errors[0].innerText = "errror de saisie email";
				}
				if (this.name = "password"){
					errors[1].innerText = "errror de saisie password";
				}
			}
		})
	}
	
})();