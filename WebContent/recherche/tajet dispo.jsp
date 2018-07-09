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

<!DOCTYPE html>
<html lang="en">

<head>
    <title>Reservation</title>
    <!-- Meta tags -->
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords"
          content="Stunning sign up & login Form Responsive Widget, Audio and Video players, Login Form Web Template, Flat Pricing Tables, Flat Drop-Downs, Sign-Up Web Templates, Flat Web Templates, Login Sign-up Responsive Web Template, Smartphone Compatible Web Template, Free Web Designs for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design"
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

    <link href="//fontsRV.googleapis.com/css?family=Montserrat:300,400,500,600" rel="stylesheet">
</head>

<body>
<h1 class="header-w3ls">
</h1>
<div class="mid-cls">
    <div class="swm-left-w3ls">
        <form action="#" method="post">
            <div class="main">
                <div class="icon-head-wthree">
                    <h2><span class="fa fa-diamond t-w3" aria-hidden="true"></span></h2>
                    <h4>Liste de trajets disponibles </h4>
                    <h2></h2>
                    <table id="rounded-corner" summary="2007 Major IT Companies' Profit">
                        <thead>
                        <tr>
                            <th scope="col" class="rounded">id</th>
                            <th scope="col" class="rounded">Ville de départ</th>
                            <th scope="col" class="rounded">Ville d'arrivée</th>
                            <th scope="col" class="rounded">Date</th>
                            <th scope="col" class="rounded">Heure</th>
                            <th scope="col" class="rounded">Prix</th>
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
                        	<td>lzm nrécupérer l'heure hna</td>
                        	<td><%=trajet.getPrix() %></td>
                        	<td><button type="submit">Reserver </button><br></td>
                    	</tr>

                    	<%
                        	}
                    	%>
                        </tbody>
                    </table>
                </div>


            </div>
        </form>
    </div>
</div>
<div class="copy">
    <p><a href="http://www.W3Layouts.com" target="_blank"></a></p>
</div>
</body>
</html>