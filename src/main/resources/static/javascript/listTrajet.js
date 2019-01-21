(function($){
	

/**********************************************\
		Constantes
\**********************************************/

	const  resizeHeight = 260;
	const path ='${detailPath}';

/**********************************************\
		variables
\**********************************************/
	var containerMap = document.querySelector('.container-map');
	var listuser = document.querySelector('.listuser');
	
	var li = document.querySelectorAll('.list-content');
	var btn_detail = document.querySelectorAll('.file-detail');
	
	var mtrajet = document.querySelector('#formmess');
	var place = document.querySelector('#place');
	
	
	
	
	
	//var sendMess = document.querySelectorAll('#mess-trajet');
	
	
	var offsetHeight = listuser.offsetHeight;
	var offsetHeightContainerMap = containerMap.offsetHeight;

	var bntTrajet = document.querySelector('.trajet-match');
	var claque = document.querySelector('.claque');
	
/**********************************************\
	Request
\**********************************************/	
	
	var xhr = new XMLHttpRequest();
	

/**********************************************\
		method resize
\**********************************************/

	function resizeListUser(listuser,resultContain){

		console.log("function resizeHeight");

		if(resultContain){
			offsetHeight = offsetHeight + resizeHeight;
			offsetHeightContainerMap = offsetHeightContainerMap + 90;
			
			listuser.style.height = offsetHeight+'px' ;
			containerMap.style.height = offsetHeightContainerMap+'px' ;
			
		}else{
			offsetHeight = offsetHeight - resizeHeight;
			offsetHeightContainerMap = offsetHeightContainerMap - 90;
			
			listuser.style.height = offsetHeight+'px' ;
			containerMap.style.height = offsetHeightContainerMap+'px' ;
		}
	}
	
/**********************************************\
		method calcNbli
\**********************************************/

	function calcNbli(){
		console.log('calcNbli');
		if(li.length>1){
			offsetHeight = li.length*150;
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

			var parentLi = this.parentNode.parentNode;
			console.log(parentLi);

			if(parentLi.classList.contains('hidden-detail')){
				parentLi.classList.remove('hidden-detail');
				resizeListUser(listuser,false);
			}else{
				parentLi.classList.add('hidden-detail');
				resizeListUser(listuser,true);
			}
		});
	}
	
	
	//@Query(value = "insert into pt t (t.nbre_place, t.volume_max) VALUES (:insertLink,?#{principal.id})", nativeQuery = true)
/**************************************\
	0..event listener btn-request
\**************************************/	
	
	sendMess.addEventListener('click',function(e){
		e.preventDefault();
		
		console.log('btn send message');

		console.log('event btn send mess request');
		initXhrPost('POST','/user/sendMessTrajet',true);
		insertFormdataAppend();
		
		
	});	
/*****************************************\
	0.0.2.3 function readKeyValueFormData
\*****************************************/
	var readKeyValueFormData = function(formdat){

		console.log('readKeyValueFormData');

		//var existance value

		var exist = false;


		//parcour des keys and values

		for(var pairs of formdat.entries()){
			console.log(pairs);
			console.log('key '+pairs[0]);
			console.log('value '+pairs[1]); //entries read match pair array
			exist = true;
		}

		if(exist){console.log('exist');}else{console.log('not exist')}
	}
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

		var textarea = document.querySelector('#mess-trajet');
		var id = document.querySelector('#message #id').value;
		var sec = document.querySelector('#message #secu').value;
		
		console.log(textarea.innerHTML);
		
	
			//insert in formdata with method append()
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
/**********************************************\
	Event Click sendMess
\**********************************************/
var swap_id_message = 0;

$('#sendMess').click(function(e){
	e.stopPropagation();
	console.log('validate send message');
	
	console.log(this);
})	
	
	
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
/**********************************************\
		Event Click seenTrajet
\**********************************************/	
	
	
		$('.seenTrajet').click(function(e){
			e.stopPropagation();
			console.log('sendTrajet pour sendMess');
			console.log(this);
			
			var id = this.parentNode.parentNode.parentNode.querySelector('input').value;
			
			console.log(this.parentNode.parentNode.parentNode.querySelector('input'));
			
			document.querySelector('#message input').value = id;
			document.querySelector('#mess-trajet').innerText = "Message pour le trajet courant "+id;
			swap_id_message = id;
		})
		
	document.querySelector('#mess-trajet').addEventListener('click',function(e){
		
		console.log('enter textarea');
		console.log(this.parentNode);
		 
		for(var i=0 ;i<li.length;i++){
			
			if(li[i].querySelector('input').value != swap_id_message){
				console.log(li[i].querySelector('input').value);
					
				if(li[i].classList.contains('hidden-detail')){
						
						li[i].classList.remove('hidden-detail');
						resizeListUser(listuser,false);
					
					}
			}
		} 
	})
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

})(jQuery);
