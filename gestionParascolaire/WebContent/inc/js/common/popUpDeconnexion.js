const containerElement=document.querySelector("#container");
const deconnexionButton=document.querySelector("#deconnexion");

const cancelDeconnexion=document.querySelector("#cancel");
const closeDeconnexion=document.querySelector("#closeDeconnexion");

const sideBar=document.querySelector(".side-bar");

const popUpDeconnexion=document.querySelector("#popUpDeconnexion");

let cancelDeconnexionHandler=()=>{
    popUpDeconnexion.classList.add("hideDeconnexion");    
    popUpDeconnexion.classList.remove("showDeconnexion");
    containerElement.classList.remove("blur");
    sideBar.classList.remove("blur");  
}

deconnexionButton.addEventListener("click",()=>{
    popUpDeconnexion.classList.remove("hideDeconnexion");    
    popUpDeconnexion.classList.add("showDeconnexion");
    containerElement.classList.add("blur");
    sideBar.classList.add("blur");
});

cancelDeconnexion.addEventListener("click",cancelDeconnexionHandler);
closeDeconnexion.addEventListener("click",cancelDeconnexionHandler);

