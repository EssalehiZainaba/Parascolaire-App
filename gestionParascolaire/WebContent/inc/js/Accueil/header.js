//sticky navbar
let header=document.querySelector("header");


window.addEventListener("scroll",()=>{
    let header=document.querySelector("header");
    header.classList.toggle("transparentHeader",window.scrollY>0);
    dropDown.classList.toggle("transparentDropDown",window.scrollY>0);
});