  /***************************************
      variables  globle at function
   *****************************************/
  var map;
  
  var directionsService;
  var directionsDisplay;
  
  var btnTrajet = document.querySelectorAll('#voirTrajet');

  /***************************************
     init my map
  *****************************************/
  function initMap() {

    /***************************************
      variables 
    *****************************************/

    directionsService = new google.maps.DirectionsService();
    directionsDisplay = new google.maps.DirectionsRenderer();

    /***************************************
      chargement map
    *****************************************/
       
         map = new google.maps.Map(document.getElementById('map'), {
          center: {lat: 48.108815, lng: -1.715279},
          zoom: 8
        });

 /*******************************************
           gestion des trajet and handler
    *****************************************/

        directionsDisplay.setMap(map);

        var onChangeHandler = function() {
          calculateAndDisplayRoute(directionsService, directionsDisplay);
        };
        
        var onChangeHandler2 = function() {
              
              console.log('------------------------------------------------------------');
              console.log(this);
              
              
              var depart = this.parentNode.querySelector('#depart');
              var arrivied = this.parentNode.querySelector('#arrivied');
              
              console.log(depart.innerText);
              console.log(arrivied.innerText);
   
              console.log('------------------------------------------------------------');
            calculateAndDisplayRoute2(directionsService, directionsDisplay,depart.innerText,arrivied.innerText);
          };
          
         for(var i = 0 ;i<btnTrajet.length;i++){
        	btnTrajet[i].addEventListener('click',onChangeHandler2);
         } 
}


/*************************************************************
          calcul des trajet coller connecting and handler
*************************************************************/

 function calculateAndDisplayRoute2(directionsService, directionsDisplay,depart,arrivied) {
        directionsService.route({
          origin: depart,
          destination: arrivied,
          travelMode: 'DRIVING'
        }, function(response, status) {
          if (status === 'OK') {
            directionsDisplay.setDirections(response);
          } else {
            window.alert('Directions request failed due to ' + status);
          }
        });
      }