package com.societe.project.security.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.societe.project.database.CompteRepository;
import com.societe.project.models.Article;
import com.societe.project.models.Compte;
import com.societe.project.models.Profil;
import com.societe.project.models.Role;
import com.societe.project.services.ArticleService;
import com.societe.project.services.CompteService;
import com.societe.project.services.PTService;
import com.societe.project.services.ProfilService;
import com.societe.project.services.RoleService;

@Service
public class FirstService {

	@Autowired
	private RoleService roleService;

	@Autowired
	private CompteService compteService;

	@Autowired
	private CompteRepository compteRepository;

	@Autowired
	private ProfilService profilService;
	
//	@Autowired
//	private PTService ptService;
	@Autowired
	private ArticleService articleService;

	public void createFirstAdminAndFirstUser(String initRole) {
        if(!isExistAdminOrUser("admin@gmail.com")) {
            Compte compte = initElementTable(initRole,"admin","admin","0122334455","admin@gmail.com","admin");
            Date date = new Date(); 
//            Article article = new Article("Ecologie : il est encore temps!", "En France, cette journÃ©e prend une signification toute particuliÃ¨re : il sâ€™agit de la premiÃ¨re mobilisation de la sociÃ©tÃ© civile depuis la dÃ©mission de Nicolas Hulot. Comme lâ€™explique ClÃ©mence Dubois, porte parole de 350.org, la dÃ©mission de Nicolas Hulot nous rappelle que la France nâ€™est pas une exception : partout dans le monde, les dirigeants politiques continuent de tergiverser, voire ont renoncÃ© Ã  agir pour le climat. Pourtant, il est encore temps dâ€™agir, et nous le faisons, partout dans le monde, comme nous lâ€™avons dÃ©montrÃ© aujourdâ€™hui.La marche pour le climat parisienne, qui a rÃ©uni plus de 50 000 personnes Ã©tait ouverte par deux banderoles. Le cortÃ¨ge a ainsi rappelÃ© que lâ€™action pour le climat est indissociable dâ€™une rupture avec les politiques nÃ©olibÃ©rales.Pour Maxime Combes dâ€™Attac, â€œce succÃ¨s montre que le sursaut citoyen est lÃ  ! Il ne manque que le sursaut politique ! Des mesures courageuses et visionnaires doivent Ãªtre imposÃ©es Ã  des lobbys qui nâ€™en veulent pas : en matiÃ¨re dâ€™Ã©cologie, le â€œEn mÃªme tempsâ€� dâ€™Emmanuel Macron ne fonctionne pas ! Il est justement temps dâ€™Ã©carter durablement les vieilles recettes libÃ©rales et productivistes qui aggravent la situation et de soutenir, avec enthousiasme, les voies alternatives qui sâ€™expÃ©rimentent dÃ©jÃ  Plus de 130 actions se sont tenues partout en France, autour de revendications communes : stopper lâ€™extraction des combustibles fossiles, afin dâ€™engager la transition juste vers un avenir 100% renouvelable pour toutes et tous. Ces actions ont mis lâ€™accent sur la responsabilitÃ© des collectivitÃ©s locales.Des organisations syndicales ont Ã©galement pris part aux dÃ©filÃ©s : la transition vers un futur renouvelable doit se faire avec pour horizon la justice sociale : câ€™est le meilleur moyen de crÃ©er des emplois durables, non-dÃ©localisables et de qualitÃ©, explique Didier AubÃ© pour lâ€™Union syndicale Solidaires.", date, compte);
//            articleService.save(article);
//            Article article2 = new Article("Taxe carbone : on vous dit tout ! ", "Lâ€™idÃ©e de Â« donner un prix au carbone Â» pour limiter les Ã©missions de gaz responsables du changement climatique a Ã©tÃ© Ã©voquÃ©e lors du protocole de Kyoto en 1997. La Â« taxe carbone Â» sur les Ã©nergies fossiles, comme le gaz, le pÃ©trole et leurs dÃ©rivÃ©s, qui Ã©mettent beaucoup de CO2, faisait partie du pacte Ã©cologique que Nicolas Hulot avait fait signer aux candidats Ã  la prÃ©sidentielle en 2007.Il sâ€™agissait de crÃ©er une contribution dâ€™un montant dâ€™abord symbolique, qui augmenterait progressivement et rÃ©guliÃ¨rement pour inciter les particuliers et entreprises le temps de sâ€™adapter (par exemple en changeant de voiture, en isolant les bÃ¢timents, en sâ€™Ã©quipant de machines moins consommatricesâ€¦)nDepuis quand existe-t-elle en France ? La taxe actuelle a vu le jour en 2014, aprÃ¨s deux tentatives ratÃ©es : en 2000, le gouvernement de Lionel Jospin avait voulu Ã©tendre aux produits Ã©nergÃ©tiques la taxe gÃ©nÃ©rale sur les activitÃ©s polluantes (TGAP, rÃ©servÃ©e aux dÃ©chets) avec le double objectif de lutter contre le changement climatique et financer les 35 heures. Mais la mesure avait Ã©tÃ© censurÃ©e par le Conseil constitutionnel, parce que sa portÃ©e Ã©cologique Ã©tait peu claire, et parce quâ€™elle sâ€™Ã©tendait Ã  lâ€™Ã©lectricitÃ©, qui Ã©met pourtant peu de CO2 â€“ le nuclÃ©aire Ã©tant, en France, la principale source de production dâ€™Ã©lectricitÃ©en 2009, aprÃ¨s le Grenelle de lâ€™environnement, Nicolas Sarkozy avait instaurÃ© une contribution climat-Ã©nergie (CCE)â€¦ qui a Ã©tÃ© Ã  son tour censurÃ©e par les Â« sages Â», au motif que les multiples exceptions sectorielles qui lâ€™accompagnaient crÃ©aient une rupture de lâ€™Ã©galitÃ© devant lâ€™impÃ´t.", date, compte);
//            articleService.save(article2);
//            Article article3 = new Article("Covoiturage : Ã©conomique, Ã©cologie et convivial !", "Le covoiturage rÃ©duit votre bilan carbone. Le Bilan Carbone des Ã©missions dâ€™un trajet est pris en charge par le conducteur. Les passagers voyagent donc sans Ã©mettre de CO2. Sur une vision globale, la quantitÃ© de CO2 Ã©mise est constante pour un trajet, et plus le nombre de voyageurs dans lâ€™auto sera grand, moins la quantitÃ© de CO2 Ã©mise par voyageur sera Ã©levÃ©e. Dans le cas dâ€™une personne faisant de longs trajets chaque week-end, les Ã©conomies de CO2 peuvent donc Ãªtre importantes et permettent de recevoir un bonus CO2 sur votre compte CO2.Le covoiturage fait gagner du temps et de lâ€™argent. Le covoiturage est aussi un excellent moyen de se dÃ©placer lÃ  oÃ¹ dâ€™autres transports en commun (train, car) ne le peuvent pas. Câ€™est trÃ¨s souvent le cas lorsque vous ne bougez pas sur un axe central bien desservi par la SNCF. Par exemple pour aller de Brest Ã  Nantes, câ€™est trÃ¨s long et incommode en train, tandis que câ€™est pratique et pas cher en covoiturage. Le covoiturage permet dÃ©sormais une grande variÃ©tÃ© de destinations, compte tenu du grand nombre dâ€™utilisateurs et de la possibilitÃ© de sâ€™arrÃªter sur le chemin lors dâ€™un trajet plus long. Plus vous covoiturez, plus vous rÃ©duisez vos Ã©missions de CO2, et plus votre bonus CO2 sera Ã©levÃ©.Rappelons aussi lâ€™avantage Ã©conomique Ã©norme de cette nouvelle approche de dÃ©placement : par exemple un gain de 4 000 â‚¬ pour quelquâ€™un qui le pratique rÃ©guliÃ¨rement sur son trajet domicile travail. Quels autres bÃ©nÃ©fices ? Avoir le rÃ©flexe covoiturage, câ€™est rendre sa voiture et le trajet rÃ©alisÃ© plus Ã©cologique, mais câ€™est aussi un moyen de dÃ©couvrir et de crÃ©er des liens sociaux avec des personnes le temps dâ€™un trajet. Premier exemple :AmÃ©dÃ©e habite Paris et doit se rendre tous les quinze jours Ã  Nantes pour voir sa petite amie. Ses horaires de travail et sa situation gÃ©ographique font quâ€™il est difficile pour lui dâ€™y aller en train une fois le week-end arrivÃ© : lâ€™Amour nâ€™attend pas !. AmÃ©dÃ©e est bien dÃ©cidÃ© Ã  prendre sa voiture mais il fait le calcul : Ã  raison de deux aller-retours par mois (2Ã—400 km), il se retrouve Ã  parcourir 9600 km par an pour ces trajets. Suivant le vÃ©hicule et sa consommation, cela fait quand mÃªme entre 500 et 800 litres de carburant par an, soit entre 1,2 et 2 tonnes de CO2 par an. Cependant, AmÃ©dÃ©e sâ€™est inscrit sur un site de covoiturage. Chaque semaine, il rÃ©ussit Ã  prendre entre 2 et 3 personnes pour chaque trajet. En plus de faire des Ã©conomies et de rÃ©duire son empreinte carbone, il dÃ©couvre chaque semaine de nouveaux individus et se dÃ©couvrent des passions secrÃ¨tes pour la vie de ces personnes quâ€™il cÃ´toie le temps le temps de quelques heures. Lors du dernier trajet, une personne lui a parlÃ© du Compte Ã‰pargne CO2 qui lui permettrait de valoriser encore plus ses covoiturages car il rÃ©alisait sans le savoir des rÃ©ductions de CO2 qui mÃ¨nent Ã  une prime climat !", date, compte);
//            articleService.save(article3);
        }else if(!isExistAdminOrUser("user@gmail.com")) {
                initElementTable(initRole,"user","user","0122334455","user@gmail.com","user");
        }
    }
	
//	public void createFirstAdminAndFirstUser(String initRole) {
//        if(!isExistAdminOrUser("admin@gmail.com")) {
//            initElementTable(initRole,"admin","admin","0122334455","admin@gmail.com","admin");
//            ptService.insertTrajetDur("admin@gmail.com",0);
//        }else if(!isExistAdminOrUser("user@gmail.com")) {
//                initElementTable(initRole,"user","user","0122334455","user@gmail.com","user");
//                ptService.insertTrajetDur("user@gmail.com",1);
//        }else if(!isExistAdminOrUser("jerem@gmail.com")) {
//            initElementTable(initRole,"jerem","frc","0122334455","jerem@gmail.com","user");
//            ptService.insertTrajetDur("jerem@gmail.com",2);
//        }
//	}
        
      //recuperation de la list des trajets		




    public boolean isExistAdminOrUser(String mail) {
        Compte compte = compteRepository.findByEmail(mail);
        return (compte != null) ? true : false;
    }
	
	public Compte initElementTable(String Role,String nom, String prenom, String phoneNumber, String mail,String pass) {

        Profil profil = new Profil(nom,prenom,pass);
        profil.setPhoneNumber("02 97 01 95 22");
        Role role = new Role(Role);	

        profilService.save(profil);
        role.setProfil(profil);
        
       
        Compte compte = new Compte(mail,pass,1);
        roleService.save(role);
        compte.setRole(role);
        compte.setProfil(profil);
        compteService.save(compte);
        profil.setCompte(compte);
        profilService.save(profil);
        
        return compte;
    }
	
}
