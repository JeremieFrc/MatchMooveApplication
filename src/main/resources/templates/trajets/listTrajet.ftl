<#import "/spring.ftl" as spring/>
   
   <#if error?has_content>
   		<div>${error}</div>
   </#if>
   
   <div class="container-map">

   <!--////////////////////////////////////////////////////-->
   <!--             MAP                                    -->
   <!--////////////////////////////////////////////////////-->

   <div class="box">
       <div id="map"></div>
   </div>
   
  
  
    <!--////////////////////////////////////////////////////-->
    <!--             liste des trajet user                  -->
    <!--////////////////////////////////////////////////////-->
<div class="listuser">
            <div class="listuser-title">
                <span>Listes des trajets</span>    
            </div>

             <div class="trajet-list">
                     <ul class="ul-list">
                       
                       
                  <#if listPt?has_content>
              <#list listPt as pt> 
                <li class="list-content">
                         <input type="hidden" name="id" value="${pt.getId()}">
                            <div class="content-cube">
                              <div class="cube"></div>
                            </div>
                            <div class="trajet-description">
                               <div id="id" class="user user-trajet">
                                  <p>Trajet</p>
                                  <div>${pt.getTrajet().getNom()}</div>
                               </div>
                               <div id="firstName" class="user user-mail">       
                                    <p>Nom</p>
                                    <div>${pt.getProfil().getFirstname()}</div>
                                </div>
                               <div id="phoneNumber" class="user user-nom">           
                                    <p>telephone</p>
                                    <div><#if pt.getProfil().getPhoneNumber()?has_content>${pt.getProfil().getPhoneNumber()}</#if></div>
                               </div>

                     <#assign id= 0>    
                   <#list pt.getProfil().getAdresses() as adr>
                     
                        <#assign depart = adr.getStringAdr()>
                        <#assign arrive = adr.getStringAdr()>
                        
                        <#if id == 0>
                          <div class="user user-prenom">
                            <p> adresse de depart </p>
                              <div id="depart" class="adr">
                                ${pt.getTrajet().getIsDirection()? then(depart,arrive)}       
                              </div>
                          </div> 
                        <#else>
                          <div class="user user-prenom">
                            <p> adresse de arrivee </p>
                              <div id="arrivied" class="adr">
                                ${pt.getTrajet().getIsDirection()? then(depart,arrive)}       
                              </div>
                          </div> 
                        </#if>
                        <#assign id++>
                   </#list>
                   
                                <div class="user duree">
                                    <p>heure depart<p>
                                    <div>${pt.getTrajet().getHeureDepart()}h ${pt.getTrajet().getMinuteDepart()}</div>
                                </div>                                                                                            
                                <div class="user user-phone"> 
                                    <p>date de depart : </p>
                                    <div>${pt.getTrajet().getDateDepart()}</div>
                                </div>
                               <div class="user user-adress"> 
                                    <p>nombre de places : </p>
                                    <div id="place">${pt.getNbrePlace()}</div>
                                </div>
                               <div class="user user-adress "> 
                                    <p>perimetre  :</p> 
                                    <div>${pt.getTrajet().getPerimetre()}</div> 
                               </div>
                               <div class="user user-adress "> 
                                    <p>Duree  :</p> 
                                    <div>${pt.getTrajet().getPerimetre()}</div> 
                               </div>
                        
                                  <a title="voir" href="#">Voir le trajet</a>
                            
                              
                              
                              
                                  <a title="match" href="/user/validTrajet/${pt.getId()}">Je match !</a>
                           

                             <div class="file-detail"><span class="btn-detail"></span></div>
                             <div class="br"></div>
                        </li>
                      </#list>
                </#if>
               </ul>
             </div>
             <div class="user-foot">
                  <div class="maxsize-user">
                        <div class="maxsize-title">
                            <strong class="infos">Total</strong>
                            <strong class="infos infos-request">
                                Trajet en cours
                            </strong>
                        </div>
                    </div>   
             </div>
        </div>

  
  
 