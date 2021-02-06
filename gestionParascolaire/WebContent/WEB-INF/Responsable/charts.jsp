<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>charts</title>

 <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load("current", {packages:["corechart"]});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([        
          ['Activitées', 'Nombre de participants (in millions)'],
    	  <c:forEach var="activite" items="${activites}" >         
          [ '${ activite.nom }' ,<c:out value="${ activite.size }" />],
          </c:forEach> 

        ]);
  

        var options = {
          title: 'Nombre des etudiants participants aux activités',
          legend: 'none',
          pieSliceText: 'label',
          slices: {  3: {offset: 0.2},
                    12: {offset: 0.3},
                    14: {offset: 0.4},
                    15: {offset: 0.5},
          },
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));
        chart.draw(data, options);
      }
    </script>


</head>
<body>

<div id="piechart" style="width: 900px; height: 500px;"></div>
	
	
</body>
</html>