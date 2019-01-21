(function($){

	console.log("test vos trajet");

/**********************************************\
	variables
\**********************************************/	

	var voirMessage = document.querySelector('.btn-seen-delete');
	var delMess = document.querySelector('.deleteMessage')

/**********************************************\
		Event Click "voir mess"    ok  xhr
\**********************************************/
	
	$('.btn-seen-mess').click(function(e){
		e.preventDefault();
		e.stopPropagation();
	
			
		if($('#claque').hasClass('fadein')){
			setTimeout(function(){
					$('#claque').removeClass('fadein');		 
			},1000);
		}else{
			$('#claque').addClass('fadein');
		}


		console.log(' 1 event btn voir mess request');
			//initXhrPost('GET','/user/deleteMessTrajet/'+idmess,true);
			//initXhr('GET','/user/delmessage',true);
			//insertFormdataAppend();
				//xhr.send();	
			
	})
/**********************************************\
		Event Click message delete id  xhr
\**********************************************/



$('.deleteMess').click(function(e){
		e.preventDefault();
		e.stopPropagation();
		console.log(' 2 clicker delete message trajet en request');
		
		console.log('');

			//initXhrPost('GET','/user/deleteMessTrajet/'+idmess,true);
			//initXhr('GET','/user/delmessage',true);
			//insertFormdataAppend();
				//xhr.send();		
	})



/**********************************************\
	Event Click  delete votre trajet id  xhr
\**********************************************/



$('.deleteTrajet').click(function(e){
		e.preventDefault();
		e.stopPropagation();

		console.log(' 2 clicker delete votre trajet request');
		
			//initXhrPost('GET','/user/deleteMessTrajet/'+idmess,true);
			//initXhr('GET','/user/delmessage',true);
			//insertFormdataAppend();
				//xhr.send();		
	})


/**********************************************\
		Event Click close message
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
	Request
\**********************************************/	
	
	var xhr = new XMLHttpRequest();

/**************************************\
	2..function initXhrPost()
\**************************************/
	var initXhrPost = function(method,action,type){
		/*******************lié xhr à url httrequest*/
		xhr.open(method,action,type);
	}

	
/*****************************************\
	0.0.1 function insertFormdataAppend
\*****************************************/
	var insertFormdataAppend = function(){
		
		var formdat = new FormData();

		//ici je  recupere id message 
		//and recupere  id trajet

			formdat.append('id',id);
			formdat.append('_csrf',sec);
			xhr.setRequestHeader("_csrf", secu);
			formdat.append('messages',textarea.innerHTML);
		   
			console.log(formdat);
			
			readKeyValueFormData(formdat);
			
			XrhSendForm(formdat);	
		}	
/**************************************\
	3.2.function XrhSendFormPOST()
\**************************************/
	var XrhSendForm = function(formdat){
				
				xhr.send(formdat);		
	}



/**************************************\
	4..event readystatechange on xhr
\**************************************/
	xhr.addEventListener('readystatechange',function(e){

		console.log('event readystatechange');
		//debugger;

		console.log('status : '+this.status);
		console.log('readyState : '+this.readyState);
		
		//verication requete reussi
		if(this.status === 200 ){
			console.log('requete validate');

			if(this.readyState === 4){
				console.log('full data recept');
				console.log(this.readyState);
				
				//insert dans le dom si message envoyer
				
				alert('message a bien été recu');

			}
		}
	});	



})(jQuery)