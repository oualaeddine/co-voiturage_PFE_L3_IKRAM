<%@ page import="model.beans.Trajet" %>
<%@ page import="java.util.LinkedList" %>
<%@
        page language="java" contentType="text/html; charset=ISO-8859-1"
             pageEncoding="ISO-8859-1"
%>

<%!
    LinkedList<Trajet> trajets;
%>

<%
    session = request.getSession();
    trajets = (LinkedList<Trajet>) request.getAttribute("trajets");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>IN ADMIN PANEL | Powered by INDEZINER</title>
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
                    <a class="menuitem_red" href="/ListePrix">Liste de trajets</a>
                    <a class="menuitem" href="/ListeVilles">Liste de villes </a>
                    <a class="menuitem" href="/ListeClients">Liste d'utilisateurs</a>
                    <a class="menuitem" href="/profil">Profil</a>
                </div>
            </div>
            <div class="right_content">
                <h2>Liste des trajets :</h2>
                <table id="rounded-corner" summary="2007 Major IT Companies' Profit">
                    <thead>
                    <tr>
                        <th scope="col" class="rounded">id</th>
                        <th scope="col" class="rounded">Ville de d�part</th>
                        <th scope="col" class="rounded">Ville d'arriv�e</th>
                        <th scope="col" class="rounded">Date</th>
                        <th scope="col" class="rounded">Heure</th>
                        <th scope="col" class="rounded">Prix</th>
                        <th scope="col" class="rounded">Modifier </th>
                        <th scope="col" class="rounded-q4">Supprimer</th>
                    </tr>
                    </thead>

                    <tbody>
                    <%
                        for (Trajet trajet : trajets) {
                            System.out.println(trajet);
                    %>
                    <tr>
                        <td><%=trajet.getId() %></td>
                        <td><%=trajet.getDepart().getName() %></td>
                        <td><%=trajet.getArrive().getName() %></td>
                        <td><%=trajet.getDate() %></td>
                        <td>lzm nr�cup�rer l'heure hna</td>
                        <td><%=trajet.getPrix() %></td>
                        <td><a href="#"><img src="images/user_edit.png" alt="" title="" border="0" /></a></td>
                        <td><a href="#" class="ask"><img src="images/trash.png" alt="" title="" border="0" /></a></td>
                    </tr>

                    <%
                        }
                    %>

                    </tbody>
                </table>
            </div>
        </div>
        <div class="clear"></div>
    </div><!-- end of right content-->


</div>   <!--end of center content -->


</body>
</html>