<#import "/spring.ftl" as spring/>


<div class="container vostrajet">

   <!--////////////////////////////////////////////////////-->
   <!--            vos message 			                  -->
   <!--////////////////////////////////////////////////////-->
   			<div id="claque"  class="claque">  

                <div id="btn-close" class="btn-close">
                    <span></span>
                 </div>
    			<#include "/trajets/vosMessTrajet.ftl"/>
   			</div>

   <!--////////////////////////////////////////////////////-->
   <!--             list de vos trajet                     -->
   <!--////////////////////////////////////////////////////-->
   
   
     <div class="list-trajet-user">
                <div class="list-trajet">
                    <h2>trajet user</h2>
                </div>
                <div class="trajet-content">
                    <ul>
                        <li class="content">
                            <div class="title">trajet num</div>
                            <div class="content-description">
                                <div id="date" class="date">date : 12/12/12</div>
                                <div id="depart" class="depart">vannes</div>
                                <div>a </div>
                                <div id="arrivied" class="arrivied">rennes</div>
                            </div>
                            <div class="listUser">
                                <h3>users du trajet</h3>
                                <ul>
                                    <li> federic larcher</li>
                                    <li> julien larcher</li>
                                </ul>
                            </div>


                            <div class="btn btn-delete deleteTrajet">
                                <a href="">delete</a></div>
                            <div id="deleteMessage" class="btn btn-seen-mess">
                                <a href="">messages</a>
                            </div>

                            <div id="voirTrajet" class="voirTrajet">
                                <p>voir le trajet</p>
                              <div class="hamb">
                                  <span></span>
                              </div>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
    </div>
   
   


</div>
  
   <!--////////////////////////////////////////////////////-->
   <!--             votre map de trajet                    -->
   <!--////////////////////////////////////////////////////-->

		<div class="container-map">
		   <div class="box">
		       <div id="map"></div>
		   </div>
		</div>   
   
   
   
   
   <!--////////////////////////////////////////////////////-->
   <!--             script                                 -->
   <!--////////////////////////////////////////////////////-->
	<script type="text/javascript" src="<@spring.url '/javascript/mapVosTrajet.js'/>"></script>
    <script type="text/javascript" src="<@spring.url 'https://maps.googleapis.com/maps/api/js?key=AIzaSyDixKXD0laxdblzB7LZpzGk5U-AhQEH4SY&libraries=places&callback=initMap'/>"></script>
	<script type="text/javascript" src="<@spring.url '/javascript/jquery-3.2.1.min.js'/>"></script>
	 <script type="text/javascript" src="<@spring.url '/javascript/vosTrajet.js'/>"></script>