<%@ page import="model.beans.Ville" %>
<%@ page import="model.db.dao.VillesDAO" %>
<%@ page import="java.util.LinkedList" %>

<%@
        page language="java" contentType="text/html; charset=ISO-8859-1"
             pageEncoding="ISO-8859-1"
%>
<%!
    LinkedList<Ville> villes;
%>
<%
    villes = new VillesDAO().getAll();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Espace Admin | Ty trips </title>
    <link rel="stylesheet" type="text/css" href="/espace_admin/style.css"/>
    <script type="text/javascript" src="/espace_admin/clockp.js"></script>
    <script type="text/javascript" src="/espace_admin/clockh.js"></script>
    <script type="text/javascript" src="/espace_admin/jquery.min.js"></script>
    <script type="text/javascript" src="/espace_admin/ddaccordion.js"></script>
    <script type="text/javascript">
        ddaccordion.init({
            headerclass: "submenuheader", //Shared CSS class name of headers group
            contentclass: "submenu", //Shared CSS class name of contents group
            revealtype: "click", //Reveal content when user clicks or onmouseover the header? Valid value: "click", "clickgo", or "mouseover"
            mouseoverdelay: 200, //if revealtype="mouseover", set delay in milliseconds before header expands onMouseover
            collapseprev: true, //Collapse previous content (so only one open at any time)? true/false
            defaultexpanded: [], //index of content(s) open by default [index1, index2, etc] [] denotes no content
            onemustopen: false, //Specify whether at least one header should be open always (so never all headers closed)
            animatedefault: false, //Should contents open by default be animated into view?
            persiststate: true, //persist state of opened contents within browser session?
            toggleclass: ["", ""], //Two CSS classes to be applied to the header when it's collapsed and expanded, respectively ["class1", "class2"]
            togglehtml: ["suffix", "<img src='/espace_admin/images/plus.gif' class='statusicon' />", "<img src='/espace_admin/images/minus.gif' class='statusicon' />"], //Additional HTML added to the header when it's collapsed and expanded, respectively  ["position", "html1", "html2"] (see docs)
            animatespeed: "fast", //speed of animation: integer in milliseconds (ie: 200), or keywords "fast", "normal", or "slow"
            oninit: function (headers, expandedindices) { //custom code to run when headers have initalized
                //do nothing
            },
            onopenclose: function (header, index, state, isuseractivated) { //custom code to run whenever a header is opened or closed
                //do nothing
            }
        })
    </script>

    <script type="text/javascript" src="/espace_admin/jconfirmaction.jquery.js"></script>
    <script type="text/javascript">

        $(document).ready(function () {
            $('.ask').jConfirmAction();
        });

    </script>

    <script language="javascript" type="text/javascript" src="/espace_admin/niceforms.js"></script>
    <link rel="stylesheet" type="text/css" media="all" href="/espace_admin/niceforms-default.css"/>

</head>
<body>
<div id="main_container">

    <div class="header">


        <div class="right_header"><a href="/logout" class="logout">Déconnexion</a></div>
        <div id="clock_a"></div>
    </div>

    <div class="main_content">

        <div class="menu">
            <ul>
                <li><a class="current" href="/accueilAdmin">Espace Admin </a></li>

            </ul>
        </div>


        <div class="center_content">


            <div class="left_content">

                <div class="sidebarmenu">
                    <a class="menuitem" href="/ajouterVille">Ajouter villes</a>
                    <a class="menuitem" href="/ajouterPrix">Ajouter prix</a>
                    <a class="menuitem" href="/ListePrix">Liste de prix</a>
                    <a class="menuitem" href="/ListeVilles">Liste de villes </a>
                    <a class="menuitem" href="/ListeClients">Liste d'utilisateurs</a>
                    <a class="menuitem" href="/profil">Profil</a>
                </div>
                    </div>   
                     <div class="right_content">            
                        <div class="showback">
                            <h4><i class="fa fa-angle-right"></i> Les statistiques :</h4>
                            <h5> Les voyageurs  :</h5>
                            <div class="progress">
                            <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
                              <span class="sr-only">40% Complete (success)</span>
                            </div>
                          </div>
                          <h5> Les conducteurs :</h5>
                          <div class="progress">
                            <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: 20%">
                              <span class="sr-only">20% Complete</span>
                            </div>
                          </div>
                          <h5> Vehicules disponibles  : </h5>
                          <div class="progress">
                            <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
                              <span class="sr-only">60% Complete (warning)</span>
                            </div>
                          </div>
                          <h5> Trajets effectu�s :</h5>
                          <div class="progress">
                            <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%">
                              <span class="sr-only">80% Complete</span>
                            </div>
                          </div>
                        </div><!--/showback -->
                     </div>
                 </div> 
                 <div class="clear"></div> 
            </div><!-- end of right content-->
        </div>   <!--end of center content -->               
    		
</body>
</html>