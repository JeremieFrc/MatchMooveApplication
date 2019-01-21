(function($){
/**********************************************\
	Event Click ignore
\**********************************************/

$('#ignorePass').click(function(e){
	e.preventDefault();
	console.log('clicker ignorePass');
	var marque = document.querySelector('#marque');
	var modele = document.querySelector('#modele');
	var nbrePlace = document.querySelector('#nbrePlace');
	var immatriculation = document.querySelector('#immatriculation');
	
	//var confirm = document.querySelector('#confirm');

	if(marque.disabled == false ){
		marque.disabled = true;
		modele.disabled = true;
		nbrePlace.disabled = true;	
		immatriculation.disabled = true;	
	}else{
		marque.disabled = false;
		modele.disabled = false;
		nbrePlace.disabled = false;
		immatriculation.disabled = false;
	}	
})
})(jQuery)

