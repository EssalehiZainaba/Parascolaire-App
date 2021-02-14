<div class="container">
        <div class="content">
            <div class="cover">
                <img src='<c:url value="images/${club.getLogoPath()}"/>' class="logo">
                
                <button> Join Us</button>
            </div>
            <div class="presentation">
                <h1>Presentation</h1>
                <p>${club.getParagraphe()}</p>
            </div>
            <!-- Slideshow container -->
            <div class="slide" >
            <div class="slideshow-container">

                  <!-- Full-width images with number and caption text -->
                  <div class="mySlides fade">
                    <img src="images/${club.getImg1Path()}" style="width:100%;">
                  </div>

                 <div class="mySlides fade">
                    <img src="images/${club.getImg2Path()}" style="width:100%;">
                  </div>

                  <div class="mySlides fade">
                    <img src="images/${club.getImg3Path()}" style="width:100%;">
                  </div>

                  <!-- Next and previous buttons -->
                  <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
                  <a class="next" onclick="plusSlides(1)">&#10095;</a>
            </div>
            <br>

                <!-- The dots/circles -->
            <div style="text-align:center">
                <span class="dot" onclick="currentSlide(1)"></span>
                <span class="dot" onclick="currentSlide(2)"></span>
                <span class="dot" onclick="currentSlide(3)"></span>
            </div>
        </div>
        </div>
    </div>