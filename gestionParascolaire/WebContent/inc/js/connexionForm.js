//logIn
let logInButton=document.querySelector(".LogIn");
//X button to close logIn popUp
let closeButton=document.querySelector(".close");




logInButton.addEventListener("click",()=>{
    document.querySelector("form.sticky").style.transform="translateX(0px)";
    document.querySelector(".container").classList.add("blur");
})

closeButton.addEventListener("click",()=>{
    document.querySelector("form.sticky").style.transform=null;
    document.querySelector(".container").classList.remove("blur");
})