(function($){
	console.log("test");
/**********************************************\
		Constantes
\**********************************************/

	const  resizeHeight = 200;
	const path ='${detailPath}';

/**********************************************\
		variables
\**********************************************/

	var li = document.querySelectorAll('.list-content');
	var btn_detail = document.querySelectorAll('.file-detail');
	var listuser = document.querySelector('.listuser');
	var offsetHeight = listuser.offsetHeight;

	var bntModified = document.querySelector('.btn-modified');
	var claque = document.querySelector('.claque');

/**********************************************\
	  class Profil;
\**********************************************/

	class Profil {

		constructor(){
			this.id = id;
			this.nom = nom;
			this.prenom = prenom;
			this.email = email;
		}

		getId(){
			return this.id;
		}

		 getNom(){
			return this.nom;
		}
		getPrenom(){
			return this.prenom;
		}
		getEmail(){
			return this.email;
		}

		setId(id){
			this.id =id;
		}
		setNom(nom){
			this.nom = nom;
		}
		setPrenom(prenom){
			this.prenom = prenom;
		}
		setEmail(email){
			this.email = email;
		}
	}

/**********************************************\
		method getInfosProfil
\**********************************************/

	function getInfosProfil(btn){

		console.log(btn);
		const profil = new Profil();
		var li = btn.parentNode.parentNode;
		console.log(li);
		var getInfos = li.querySelector('.user-description');
		console.log(getInfos);

		console.log(getInfos.id);	
		
		
			profil.setId(getInfos.children[0].innerText);
			profil.setEmail(getInfos.children[1].innerText);
			profil.setNom(getInfos.children[2].innerText);
			profil.setPrenom(getInfos.children[3].innerText);

		/*console.log(profil.getId());
		console.log(profil.getEmail());
		console.log(profil.getNom());
		console.log(profil.getPrenom());
	*/
		setUpdateUser(profil);
	}

/**********************************************\
		method setUpdateUser
\**********************************************/

	function setUpdateUser(profil){
		var inputFormUpadate = document.querySelectorAll('.form-creat input '); 
		console.log(profil);
		console.log(inputFormUpadate);

		var i = 0;

		for (var key in profil) {
  				inputFormUpadate[i].value = profil[key];
  				i = i+1;
		}
	}

/**********************************************\
		method resize
\**********************************************/

	function resizeListUser(listuser,resultContain){

		console.log("function resizeHeight");

		if(resultContain){
			offsetHeight = offsetHeight + resizeHeight;
			listuser.style.height = offsetHeight+'px' ;
		}else{
			offsetHeight = offsetHeight - resizeHeight;
			listuser.style.height = offsetHeight+'px' ;
		}
	}

/**********************************************\
		method calcNbli
\**********************************************/

	function calcNbli(){
		console.log('calcNbli');
		if(li.length>1){
			offsetHeight = li.length*120;
			listuser.style.height = offsetHeight+'px' ;
		}	
	}	

	calcNbli();  //lancement au looder de la page

/**********************************************\
		Event Click
\**********************************************/
	
	for(var i=0;i< li.length;i++){

		btn_detail[i].addEventListener('click',function(e){
			e.preventDefault();
			console.log("event click");
			console.log(this);

			var parentLi = this.parentNode;

			if(parentLi.classList.contains('hidden-detail')){
				parentLi.classList.remove('hidden-detail');
				resizeListUser(listuser,false);
			}else{
				parentLi.classList.add('hidden-detail');
				resizeListUser(listuser,true);
			}
		});
	}

/**********************************************\
		Event Click modified
\**********************************************/
	
	$('.btn-modified').click(function(e){
		e.preventDefault();
		console.log('clicker btn-modified');
			
		if($('#claque').hasClass('fadein')){
			setTimeout(function(){
					$('#claque').removeClass('fadein');		 
			},1000);
		}else{
			$('#claque').addClass('fadein');
		}
		getInfosProfil(this);	
	})

function changeActionForm(){
		
		console.log("read new action form");
		
		//var clientAction = document.querySelector('#f-client');	
//		var recup_path = $('#f-client').attr('action');
//
//		recup_path.replace('edit','${detailPath}');
//		console.log("recup_path0"+recup_path);
//		
//		console.log(recup_path);
//		
//		$('#f-client').attr('action',recup_path);
		console.log($('#f-client').attr('action','/admin/edit'));
	}
	
	changeActionForm();



/**********************************************\
		Event Click close
\**********************************************/
	
	$('.btn-close').click(function(e){
		e.preventDefault();
		console.log('clicker claque');
			
		if($('#claque').hasClass('fadein')){
					$('#claque').removeClass('fadein');		 
		}else{
			$('#claque').addClass('fadein');
		}	
	})

/**********************************************\
		Event Click ignore
\**********************************************/

   $('#ignorePass').click(function(e){
		e.preventDefault();
		console.log('clicker ignorePass');
		var pass = document.querySelector('#password');
		var confirm = document.querySelector('#confirm');

		if(pass.disabled == false ){
			pass.disabled = true;
			confirm.disabled = true;
					
		}else{
			pass.disabled = false;
			confirm.disabled = false;
		}	
	})

})(jQuery);