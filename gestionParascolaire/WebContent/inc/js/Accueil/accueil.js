//myButtons

const nextButton=document.querySelector("#buttonRight");
const prevButton=document.querySelector("#buttonLeft");

//slide work
const slide=document.querySelector(".Slider-images");
const slideImages=document.querySelectorAll(".Slider-images img");
const cercles=document.querySelectorAll(".cercle");
const size=slide.clientWidth;
let counter=0;



//initialising the back ground Color of the first circle
cercles[0].style.backgroundColor=" rgb(226, 159, 71)";

//Slide right functiom
nextButton.addEventListener("click",()=>{
    if(counter<slideImages.length-1){
    counter++;
    cercles[counter-1].style.backgroundColor="";
    cercles[counter].style.backgroundColor=" rgb(226, 159, 71)";
    slide.style.transform="translateX(" + (-size*counter) +"px)";
}
});

//slide left function
prevButton.addEventListener("click",()=>{  
    
    if(counter>0){
    counter--;
    cercles[counter+1].style.backgroundColor="";
    cercles[counter].style.backgroundColor=" rgb(226, 159, 71)";
    slide.style.transform="translateX(" + (-size*counter) +"px)";
}
});

