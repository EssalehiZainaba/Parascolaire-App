<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
 <head>
 
    <script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
 
	
</head>

<body> 
 	

    <canvas id="myChart" width="900" height="130" ></canvas>
    <canvas id="myLineChart" width="900" height="130" ></canvas>
    <canvas id="myPieChart" width="800" height="200" ></canvas>
	    
    
     <script>
     
//barChart
     
    let ctx = document.getElementById('myChart').getContext('2d');  
     
   // Chart.defaults.global.defaultFontFamily='Lato'; 
    Chart.defaults.global.defaultFontSize=10; 

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
                	<c:forEach var="numberEtd" items="${tabNumberEtd}" >
        	           ${numberEtd},
                	</c:forEach>],
                backgroundColor: [
                    'rgba(255, 99, 132, 0.2)',
                    'rgba(54, 162, 235, 0.2)',
                    'rgba(255, 206, 86, 0.2)',
                    'rgba(75, 192, 192, 0.2)',
                    'rgba(153, 102, 255, 0.2)',
                    'rgba(255, 159, 64, 0.2)'
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
            	text:'Nombre des Activitées club par années',
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
                  	<c:forEach var="numberAct" items="${tabNumberAct}" >
          	           ${numberAct},
                  	</c:forEach>],
                  backgroundColor: [
                      'rgba(255, 99, 132, 0.2)',
                      'rgba(54, 162, 235, 0.2)',
                      'rgba(255, 206, 86, 0.2)',
                      'rgba(75, 192, 192, 0.2)',
                      'rgba(153, 102, 255, 0.2)',
                      'rgba(255, 159, 64, 0.2)'
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
              	text:'Nombre des adhérants par années',
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
                      'rgba(255, 99, 132, 0.2)',
                      'rgba(54, 162, 235, 0.2)',
                      'rgba(255, 206, 86, 0.2)',
                      'rgba(75, 192, 192, 0.2)',
                      'rgba(153, 102, 255, 0.2)',
                      'rgba(255, 159, 64, 0.2)'
                  ],
                  borderColor: [
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
              	text:'Nombre des participants aux activitées années',
              	fontSize:15	
              },
          	legend:{
              	display: true	
              }
          }
         
      });            
    
    
    
    </script>
    
    
</body>


</html>
