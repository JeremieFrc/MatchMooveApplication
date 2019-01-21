<#import "/spring.ftl" as spring/>


  <div class="list-message">
                    <h2>Messages relatifs aux trajets</h2>
                    <div class="messages-content">
                        <ul>
                            <li class="contents"> 
                                <input id="id-mess" type="hidden" name="id" value="">
                                    <div class="ct sender-user">
                                        <div class="sender">Nom de l'expéditeur</div>
                                    </div>
                                    <div class="ct title">Numéro du trajet</div>
                                    <div class="ct content-descriptions">
                                       <p>Ecrivez ici votre message !</p>
                                    </div>
                                     <div class="btn btn-seen-delete deleteMess">
                                        <a  id="delMessage" href="#">Supprimer</a>
                                    </div>
                            </li>
                        </ul>
                    </div>
   </div>