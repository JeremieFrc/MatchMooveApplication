<#import "/spring.ftl" as spring/>
<script src="https://www.gstatic.com/firebasejs/5.5.8/firebase.js"></script>

<script src="https://www.gstatic.com/firebasejs/5.5.8/firebase-app.js"></script>
<script src="https://www.gstatic.com/firebasejs/5.5.8/firebase-database.js"></script>
<script src="https://www.gstatic.com/firebasejs/5.5.8/firebase-functions.js"></script>

<script>
  var config = {
    
  };
  firebase.initializeApp(config);
  
    var updateStarCount = function(element, value) {
        console.log(value);
        document.getElementById(element).innerHTML = value.name + " " + value.clicks;
    };
    
    var starCountRef = firebase.database().ref('/notifications/');
    starCountRef.on('value', function(snap) {
        console.log(JSON.stringify(snap.val()));
        updateStarCount("notification", snap.val());
    });
  
  function sayClicked(){
    firebase.database().ref('/notifications/').once('value', function(snap){
            console.log(JSON.stringify(snap.val()));
            firebase.database().ref('/notifications/').set({
                name: snap.val().name,
                clicks: snap.val().clicks + 1
            });
        });
    }
</script>

<div id='notification' onclick='sayClicked()'>
${notification.getName()} clicked ${notification.getClicks()}
</div>