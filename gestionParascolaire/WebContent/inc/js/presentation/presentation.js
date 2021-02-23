/**
 * 
 */
var slideIndex = 1;
var timer = null;
showSlides(slideIndex);

function plusSlides(n) {
  clearTimeout(timer);
  showSlides(slideIndex += n);
}

function currentSlide(n) {
  clearTimeout(timer);
  showSlides(slideIndex = n);
}

function showSlides(n) {
  var i;
  var slides = document.getElementsByClassName("mySlides");
  var dots = document.getElementsByClassName("dot");
  if (n==undefined){n = ++slideIndex}
  if (n > slides.length) {slideIndex = 1}
  if (n < 1) {slideIndex = slides.length}
  for (i = 0; i < slides.length; i++) {
      slides[i].style.display = "none";
  }
  for (i = 0; i < dots.length; i++) {
      dots[i].className = dots[i].className.replace(" active", "");
  }
  slides[slideIndex-1].style.display = "block";
  dots[slideIndex-1].className += " active";
  timer = setTimeout(showSlides, 2000);
} 




//logIn
let logInButton=document.querySelector(".LogIn");
let logIn = document.getElementById("log-in");


logInButton.addEventListener("click",()=>{
    document.querySelector("form.sticky").style.transform="translateX(0px)";
    document.querySelector("#container").classList.add("blur");
})


logIn.addEventListener("click",()=>{
    document.querySelector("form.sticky").style.transform="translateX(0px)";
    document.querySelector("#container").classList.add("blur");
})





let closeButton=document.querySelector(".close");


closeButton.addEventListener("click",()=>{
    document.querySelector("form.sticky").style.transform=null;
    document.querySelector("#container").classList.remove("blur");
})


closeButton.addEventListener("click",()=>{
    document.querySelector("form.sticky").style.transform=null;
    document.querySelector("#container").classList.remove("blur");
})
