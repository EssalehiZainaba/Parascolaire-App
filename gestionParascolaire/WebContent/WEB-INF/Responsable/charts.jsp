<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
 <head>
    <title>Parascolaire Ensa Agadir | Statistiques</title>
    <link rel="icon" href="./images/logo.png">
    <script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    
	<link rel="stylesheet" href="inc/css/common/header-footer.css">
	<link rel="stylesheet" href="inc/css/sideBarRespo.css">
	<link rel="stylesheet" href="inc/css/Responsable/charts.css">
	<link rel="stylesheet" href="inc/css/common/popUpDeconnexion.css">
  	<script src="https://kit.fontawesome.com/5bf11eee96.js" crossorigin="anonymous"></script>	
 
	
</head>

<body> 

	<%@ include file="inc/header.jsp" %>
	
	<%@ include file="inc/sideBar.jsp" %> 	
	
	<div id="container">
		<canvas id="myLineChart" class="myLineChart" width="1000" height="350" ></canvas>
		<div class="charts">
		    <canvas id="myChart" class="myBarChart" width="600" height="300" ></canvas>
		    <canvas id="myPieChart" class="myPieChart" width="600" height="200" ></canvas>
	    </div>
    </div>
	    
    
     <script>
     
//barChart
     
    let ctx = document.getElementById('myChart').getContext('2d');  
     
   // Chart.defaults.global.defaultFontFamily='Lato'; 
    Chart.defaults.global.defaultFontSize=10;
    Chart.defaults.global.defaultFontColor='#B0B0B0';

    let myChart = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: [
            	
       	        <c:forEach var="year" items="${tabYear}" >
              	 ${year},
     	         </c:forEach>
       	            ],
            datasets: [{
                label: 'Activitées',               
                data: [
                	<c:forEach var="numberEtd" items="${tabNumberAct}" >
        	           ${numberEtd},
                	</c:forEach>0],
                backgroundColor: [
                    'rgba(255, 99, 132,0.8)',
                    'rgba(54, 162, 235, 0.8)',
                    'rgba(255, 206, 86, 0.8)',
                    'rgba(75, 192, 192, 0.8)',
                    'rgba(153, 102, 255, 0.8)',
                    'rgba(255, 159, 64, 0.8)'
                ],
                borderColor: [
                    'rgba(255, 99, 132, 1)',
                    'rgba(54, 162, 235, 1)',
                    'rgba(255, 206, 86, 1)',
                    'rgba(75, 192, 192, 1)',
                    'rgba(153, 102, 255, 1)',
                    'rgba(255, 159, 64, 1)'
                ],
                borderWidth: 4
            }]
        },
        
        options: {
            responsive: false,
            maintainAspectRatio: false,
            title:{
            	display:true,
            	text:'Total Activitées ',
            	fontSize:15	
            	
            },
        	legend:{
            	display: false
            }
        }
       
    });
    
    

      
//lineChart
      
      let ctxLine = document.getElementById('myLineChart').getContext('2d');  
 

      let myLineChart = new Chart(ctxLine, {
          type: 'line',
          data: {
              labels: [
              	
         	        <c:forEach var="yearAct" items="${tabYears}" >
                	 ${yearAct},
       	         </c:forEach>
         	            ],
              datasets: [{
                  label: 'adhérants',               
                  data: [
                  	<c:forEach var="numberAct" items="${tabNumberEtd}" >
          	           ${numberAct},
                  	</c:forEach>0],
                  backgroundColor: [
                	   'rgba(255, 99, 132, 0.8)',
                       'rgba(54, 162, 235, 0.8)',                     
                       'rgba(75, 192, 192, 0.8)',
                       'rgba(153, 102, 255, 0.8)',                     
                       'rgba(255, 206, 86, 0.8)',
                       'rgba(255, 159, 64, 0.8)'
                  ],
                  borderColor: [
                      'rgba(255, 99, 132, 1)',
                      'rgba(54, 162, 235, 1)',
                      'rgba(255, 206, 86, 1)',
                      'rgba(75, 192, 192, 1)',
                      'rgba(153, 102, 255, 1)',
                      'rgba(255, 159, 64, 1)'
                  ],
                  borderWidth: 4
              }]
          },
          
          options: {
              responsive: false,
              maintainAspectRatio: false,
              title:{
              	display:true,
              	text:'Total Adhérants',
              	fontSize:15	
              },
          	legend:{
              	display: false
              }
          }
         
      });  
      
      
      
//pieChart
      
      let ctxPie = document.getElementById('myPieChart').getContext('2d');  
 

      let myPieChart = new Chart(ctxPie, {
          type: 'pie',
          data: {
              labels: [
            	  <c:forEach var="activite" items="${activites}" > 
            	  '<c:out value="${ activite.nom }" />',
            	  </c:forEach> 
            	  ],
              datasets: [{
                  label: 'étudiants',               
                  data: [
                	  <c:forEach var="activite" items="${activites}" > 
                	  <c:out value="${ activite.size }" />,
            	  </c:forEach> 
            	      ],
                  backgroundColor: [
                      'rgba(255, 99, 132, 0.8)',
                      'rgba(54, 162, 235, 0.8)',
                      'rgba(255, 206, 86, 0.8)',
                      'rgba(75, 192, 192, 0.8)',
                      'rgba(153, 102, 255, 0.8)',
                      'rgba(255, 159, 64, 0.8)',
                      'rgba(255, 99, 132, 0.8)',
                      'rgba(54, 162, 235, 0.8)',
                      'rgba(255, 206, 86, 0.8)',
                      'rgba(75, 192, 192, 0.8)',
                      'rgba(153, 102, 255, 0.8)',
                      'rgba(255, 99, 132, 0.8)',
                      'rgba(54, 162, 235, 0.8)',
                      'rgba(255, 206, 86, 0.8)',
                      'rgba(75, 192, 192, 0.8)',
                      'rgba(153, 102, 255, 0.8)',
                      'rgba(255, 159, 64, 0.8)',
                      'rgba(255, 99, 132, 0.8)',
                      'rgba(54, 162, 235, 0.8)',
                      'rgba(255, 206, 86, 0.8)',
                      'rgba(75, 192, 192, 0.8)',
                      'rgba(153, 102, 255, 0.8)',
                      'rgba(255, 99, 132, 0.8)',
                      'rgba(54, 162, 235, 0.8)',
                      'rgba(255, 206, 86, 0.8)',
                      'rgba(75, 192, 192, 0.8)',
                      'rgba(153, 102, 255, 0.8)',
                      'rgba(255, 159, 64, 0.8)',
                      'rgba(255, 99, 132, 0.8)',
                      'rgba(54, 162, 235, 0.8)',
                      'rgba(255, 206, 86, 0.8)',

                  ],
                  borderColor: [
                      'rgba(255, 99, 132, 1)',
                      'rgba(54, 162, 235, 1)',
                      'rgba(255, 206, 86, 1)',
                      'rgba(75, 192, 192, 1)',
                      'rgba(153, 102, 255, 1)',
                      'rgba(255, 159, 64, 1)',
                      'rgba(255, 99, 132, 1)',
                      'rgba(54, 162, 235, 1)',
                      'rgba(255, 206, 86, 1)',
                      'rgba(75, 192, 192, 1)',
                      'rgba(153, 102, 255, 1)',
                      'rgba(255, 159, 64, 1)',
                      'rgba(255, 99, 132, 1)',
                      'rgba(54, 162, 235, 1)',
                      'rgba(255, 206, 86, 1)',
                      'rgba(75, 192, 192, 1)',
                      'rgba(153, 102, 255, 1)',
                      'rgba(255, 159, 64, 1)',
                      'rgba(255, 99, 132, 1)',
                      'rgba(54, 162, 235, 1)',
                      'rgba(255, 206, 86, 1)',
                      'rgba(75, 192, 192, 1)',
                      'rgba(153, 102, 255, 1)',
                      'rgba(255, 159, 64, 1)',
                      'rgba(255, 99, 132, 1)',
                      'rgba(54, 162, 235, 1)',
                      'rgba(255, 206, 86, 1)',
                      'rgba(75, 192, 192, 1)',
                      'rgba(153, 102, 255, 1)',
                      'rgba(255, 159, 64, 1)'
                  ],
                  borderWidth: 1
              }]
          },
          
          options: {
              responsive: false,
              maintainAspectRatio: false,
           title:{
              	display:true,
              	text:'Total participants aux activitées',
              	fontSize:15	
              },
          	legend:{
              	display: false,
              	position: 'bottom',
              },
              
              
          }
         
      });            
    
    
    
    </script>


		 <%@ include file="../common/popUpDeconnexion.jsp" %> 
	     <%@ include file="../common/footer.jsp" %>
	     
</body>
	<script type="text/javascript" src="./inc/js/common/header.js"></script>
	<script type="text/javascript" src="./inc/js/common/popUpDeconnexion/popUpDeconnexion.js"></script>
	

</html>
