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
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Se connecter et S'inscrire </title>
    <!-- Meta tags -->
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords" content="Se connecter et s'inscrire"
    />
    <script>
        addEventListener("load", function () {
            setTimeout(hideURLbar, 0);
        }, false);

        function hideURLbar() {
            window.scrollTo(0, 1);
        }
    </script>
    <!-- Meta tags -->
    <!-- font-awesome icons -->
    <link rel="stylesheet" href="css/font-awesome.min.css"/>
    <!-- //font-awesome icons -->
    <!--stylesheets-->
    <link href="css/style.css" rel='stylesheet' type='text/css' media="all">
    <!--//style sheet end here-->

    <link href="//fonts.googleapis.com/css?family=Montserrat:300,400,500,600" rel="stylesheet">
</head>

<body>
<h1 class="header-w3ls">
    rechercher un trajet & proposer un trajet</h1>
<div class="mid-cls">
    <div class="swm-left-w3ls">
        <form action="/trajets" method="post">
           <input type="hidden" name="action" value="search">
            <div class="main">
                <div class="icon-head-wthree">

                    <h4>Rechercher un trajet </h4>
                </div>
                <div class="form-left-to-w3l">
					<select size="1" name="depart" id="" >
						<option selected>D�part</option>
                    	<%
                    		for(int i=0;i<villes.size();i++)
                    		{
                    	%>
                    	<option value="<%=villes.get(i).getName()%>"><%=villes.get(i).getName()%></option>   
                    	<%
                    		} 
                    	%>  
                	</select>
                	<div class="clear"></div>
                </div>
                <div class="form-left-to-w3l">
					<select size="1" name="arrivee" id="" >
						<option selected>Arriv�e</option>
						<%
                    		for(int i=0;i<villes.size();i++)
                    		{
                    	%>
                    	<option value="<%=villes.get(i).getName()%>"><%=villes.get(i).getName()%></option>   
                    	<%
                    		} 
                    	%>                  	
                    </select>  
                    <div class="clear"></div>
                </div>
                <div class="form-right-w3ls ">
                    <input type="date" name="date" placeholder="date" required="">
                    <div class="clear"></div>
                </div>
                <div class="form-right-w3ls ">
                    <input type="time" name="time" placeholder="heure" required="">
                    <div class="clear"></div>
                </div>
                <div class="btnn">
                    <button type="submit"> Rechercher</button>
                    <br>
                    <div class="clear"></div>
                </div>
            </div>

        </form>
        <div class="col-md-2 header-side">

            <div class="buttom-social-grids">


            </div>
        </div>
    </div>

    <div class="swm-right-w3ls">
        <form action="/trajets" method="post">
          <input type="hidden" name="action" value="add">
            <div class="main">
                <div class="icon-head-wthree">
                    <h4> Proposer un trajet </h4>
                </div>
                <div class="form-left-to-w3l">
					<select size="1" name="depart" id="" >
                    	<option selected">D�part</option>
                    	<%
                    		for(int i=0;i<villes.size();i++)
                    		{
                    	%>
                    	<option value="<%=villes.get(i).getName()%>"><%=villes.get(i).getName()%></option>   
                    	<%
                    		} 
                    	%>  
                	</select>  
                    <div class="clear"></div>
                </div>
                <div class="form-left-to-w3l">
					<select size="1" name="arrivee" id="" >
					    <option selected">Arriv�e</option>
						<%
                    		for(int i=0;i<villes.size();i++)
                    		{
                    	%>
                    	<option value="<%=villes.get(i).getName()%>"><%=villes.get(i).getName()%></option>   
                    	<%
                    		} 
                    	%>                  	
                    </select>  
                    <div class="clear"></div>
                </div>
            </div>
            <div class="form-left-to-w3l">
                <input type="text" name="prix" placeholder="Prix" required="">
                <div class="clear"></div>
            </div>
            <div class="form-left-to-w3l">
                <input type="text" name="places" placeholder="Nombre de places" required="">
                <div class="clear"></div>
            </div>
            <div class="form-left-to-w3l">
                <select size="1" name="type" id="" >
                    <option selected>Type de v�hicule</option>
                    <option value="automobile">Automobile </option>
                	<option value="autocar">Autocar</option>  
                	<option value="autobus">Autobus</option>
                	<option value="camion">Camion</option>                              
                </select>  
                <div class="clear"></div>
            </div>
            <div class="form-right-w3ls ">
                <input type="date" name="date" placeholder="Date" required="">
                <div class="clear"></div>
            </div>
            <div class="form-right-w3ls ">
                <input type="time" name="time" placeholder="Heure" required="">
                <div class="clear"></div>
            </div>
            <div class="btnn">

                <button type="submit">proposer</button>
                <br>


            </div>
        </form>
    </div>

    <div class=" header-side">

        <div class="buttom-social-grids">


        </div>
    </div>
</div>


</body>
</html>