<%@ page import="model.beans.Ville" %>
<%@ page import="model.db.dao.VillesDAO" %>
<%@ page import="java.util.LinkedList" %>

<%@ 
	page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"    
%>
<%!
	LinkedList<Object> villes;
%>
<% 
	villes= new VillesDAO().getAll();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Espace Admin | Ty trips </title>
    <link rel="stylesheet" type="text/css" href="style.css"/>
    <script type="text/javascript" src="clockp.js"></script>
    <script type="text/javascript" src="clockh.js"></script>
    <script type="text/javascript" src="jquery.min.js"></script>
    <script type="text/javascript" src="ddaccordion.js"></script>
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
            togglehtml: ["suffix", "<img src='images/plus.gif' class='statusicon' />", "<img src='images/minus.gif' class='statusicon' />"], //Additional HTML added to the header when it's collapsed and expanded, respectively  ["position", "html1", "html2"] (see docs)
            animatespeed: "fast", //speed of animation: integer in milliseconds (ie: 200), or keywords "fast", "normal", or "slow"
            oninit: function (headers, expandedindices) { //custom code to run when headers have initalized
                //do nothing
            },
            onopenclose: function (header, index, state, isuseractivated) { //custom code to run whenever a header is opened or closed
                //do nothing
            }
        })
    </script>

    <script type="text/javascript" src="jconfirmaction.jquery.js"></script>
    <script type="text/javascript">

        $(document).ready(function () {
            $('.ask').jConfirmAction();
        });

    </script>

    <script language="javascript" type="text/javascript" src="niceforms.js"></script>
    <link rel="stylesheet" type="text/css" media="all" href="niceforms-default.css"/>

</head>
<body>
<div id="main_container">

    <div class="header">


        <div class="right_header"><a href="#" class="logout">D�connexion</a></div>
        <div id="clock_a"></div>
    </div>

    <div class="main_content">

        <div class="menu">
            <ul>
                <li><a class="current" href="administrateur.jsp">Espace Admin </a></li>

            </ul>
        </div>


        <div class="center_content">


            <div class="left_content">

                <div class="sidebarmenu">
                    <a class="menuitem" href="ajouter ville.html">Ajouter villes</a>
                    <a class="menuitem" href="ajouter prix.jsp">Ajouter prix</a>
                    <a class="menuitem" href="<%=request.getContextPath()+"/ListePrix"%>">Liste de prix</a>
                    <a class="menuitem" href="<%=request.getContextPath()+"/ListeVilles"%>">Liste de villes </a>
                    <a class="menuitem" href="<%=request.getContextPath()+"/ListeClients"%>">Liste d'utilisateurs</a>
                    <a class="menuitem" href="profil.jsp">Profil</a>
                </div>


                <div class="sidebar_box">

                </div>


            </div>

            <div class="right_content">


                <h2></h2>

                <div class="form">
                    <form action="/accueilAdmin" method="post" class="niceform">

                        <fieldset>


                            <dl>
                                <dt><label for="depart">ville de d�part:</label></dt>
                                <dd>
                                    <select size="1" name="depart" id="">
                                        <option value=""></option>
                                        <%
                                        	if (villes.size() > 0) {
                                        		for(int i=0;i<villes.size();i++){
										%>
                                        <option value="<%=villes.get(i).getName()%>"><%=villes.get(i).getName()%></option>
                                        <% 
                    							} 
                                        	}
                    					%>
                                    </select>
                                </dd>
                            </dl>


                            <dl>
                                <dt><label for="arrive">ville d'arriv�e:</label></dt>
                                <dd>
                                    <select size="1" name="arrive" id="">
                                            <option value=""></option>
                                            <%
                                        		if (villes.size() > 0) {
                                        			for(int i=0;i<villes.size();i++){
											%>
                                            <option value="<%=villes.get(i).getName()%>"> <%=villes.get(i).getName()%></option>
                                            <% 
                    								} 
                                        		}
                    						%>
                                   </select>
                                </dd>
                            </dl>

                            <dl>
                                <dt><label for="prix">Prix:</label></dt>
                                <dd><input type="text" name="prix" placeholder="prix" required=""/></dd>
                            </dl>

                            <dl>
                                <dt><label for="places">Nombres de places:</label></dt>
                                <dd><input type="text" name="places" placeholder="Nombres de places" required=""/></dd>
                            </dl>

                            <dl>
                                <dt><label for="type">Type de vehicule:</label></dt>
                                <dd>
                                    <input type="checkbox" name="type" id="" value="automobile"/><label
                                        class="check_label">Automobile</label>
                                    <input type="checkbox" name="type" id="" value="autobus"/><label
                                        class="check_label">Autobus</label>
                                    <input type="checkbox" name="type" id="" value="autocar"/><label
                                        class="check_label">Autocar</label>
                                    <input type="checkbox" name="type" id="" value="Camion"/><label
                                        class="check_label">Camion</label>
                                </dd>
                            </dl>


                            <dl>
                                <dt><label for="upload">Importer un fichier:</label></dt>
                                <dd><input type="file" name="upload" required=""id="upload"/></dd>
                            </dl>


                            <dl>
                                <dt><label></label></dt>

                            </dl>

                            <dl class="submit">
                                <input type="submit" name="submit" id="submit" value="Valider"/>
                            </dl>


                        </fieldset>

                    </form>
                </div>


            </div><!-- end of right content-->


        </div>   <!--end of center content -->


        <div class="clear"></div>
    </div> <!--end of main content-->


</div>
</body>
</html>