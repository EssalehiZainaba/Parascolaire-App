<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stlesheet" href="css/presentation.css">

</head>
<body onload="currentSlide(1)">
	<%@ include file="header.jsp" %>
	<div class="container">
        <div class="content">
            <div class="cover">
                <img src="images/social.jpg">
                <button> Join Us</button>
            </div>
            <div class="presentation">
                <h1>Presentation</h1>
                <p>
                    Tyrion Lannister needed answers. That was his nature.

                    Tyrion Lannister is a highly intelligent, thinking man. After the agony of being victimized by his nephew, accused by his sister, and arrested by his father, it became pretty obvious that Lannister internal family politics were in deadly play. This played out in slow motion agony with the trial that had one liar after another come up and testify against him. Tyrion knew that his father had a lot to do with this. Additionally, he was particularly victimized by Shae when she stood up and lied. I am sure he wondered about that.

                    When he was free to secretly move about, it was perfectly natural for him to seek answers. He knew where his father could be, so he went there. He needed answers.

                    In my opinion, he did not necessarily expect to find Shae there. But the betrayal could go only so far before he sought blood. It started with her. He then noticed the crossbow mounted on the wall. That was how he was going to “talk” to his father -- armed. The humiliation of a public farce of a trial -– and taking Shae –- was the last straw. His answers might well come in the form of an arrow tip.

                    In the book where this scene took place, he was particularly sensitive to his father's use of the word whore. After Tyrion asked where his first love (not Shae) was sent, his father said something to the effect of “Where do all whores go”. That prompted the patricidal shot. In this world, having the woman Tyrion once trusted there, combined with his father's attitude, was a very bad thing for the father’s health.
                </p>
            </div>
            <!-- Slideshow container -->
            <div class="slide" >
            <div class="slideshow-container">

                  <!-- Full-width images with number and caption text -->
                  <div class="mySlides fade">
                    <img src="images/img1.jpg" style="width:100%;">
                  </div>

                 <div class="mySlides fade">
                    <img src="images/img2.jpg" style="width:100%;">
                  </div>

                  <div class="mySlides fade">
                    <img src="images/img3.jpg" style="width:100%;">
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
	<%@ include file="footer.jsp" %>
</body>
<script src="./js/presentation.js"></script>
</html>