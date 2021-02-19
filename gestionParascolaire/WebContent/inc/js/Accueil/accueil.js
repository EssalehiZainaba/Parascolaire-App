 //myButtons

const nextButton=document.querySelector("#buttonRight");
const prevButton=document.querySelector("#buttonLeft");

//slide work
let slide=document.querySelector(".Slider-images");

let wrappers=document.querySelectorAll(".wrapper");

let descriptions=document.querySelectorAll(".description");

const slideImages=document.querySelectorAll(".Slider-images img");

const cercles=document.querySelectorAll(".cercle");

let size=wrappers[0].clientWidth;

let counter=0;

//resize screen Slide problem
window.addEventListener("resize",()=>{
    size=wrappers[0].clientWidth;
});


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

//hover Effect
for(let i=0;i<wrappers.length;i++){
    wrappers[i].addEventListener("mouseover",()=>{
        descriptions[i].classList.remove("hideDescription");
        descriptions[i].classList.add("showDescription");
    })
    wrappers[i].addEventListener("mouseout",()=>{
        descriptions[i].classList.remove("showDescription");
        descriptions[i].classList.add("hideDescription");
    })
    
}

