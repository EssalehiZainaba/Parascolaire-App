const clubsContainer=document.querySelector("#clubsContainer");
const creerButton=document.querySelector("#creerButton");
const addClubForm=document.querySelector("#addClub");
const closeAddForm=document.querySelector("#addClub .close");


creerButton.addEventListener("click",()=>{
    addClubForm.style.transform="translateY(0)";
    clubsContainer.classList.add("blur");
})

closeAddForm.addEventListener("click",()=>{
    addClubForm.style.transform="translateY(-100vh)";
  	clubsContainer.classList.remove("blur");
})

/***********************************************POPUP CONFIRMATION************************************************** */

const clubsTrach=document.querySelectorAll(".club i");
const popUpDelete=document.querySelector("#confirmDelete");
const closeDeletePopUp=document.querySelector("#closeConfirm");
const cancelButton=document.querySelector("#cancelDelete")
const confirmButton=document.querySelector("#confirm");
const link=document.querySelector("#link");

let clubId;

let cancelDeleteHandler=()=>{
    popUpDelete.classList.remove("showConfirm");
    popUpDelete.classList.add("hideConfirm");
    clubsContainer.classList.remove("blur");
}

clubsTrach.forEach(club=>{
    club.addEventListener("click",(evt)=>{
        clubId=evt.target.parentElement.id;
        popUpDelete.classList.add("showConfirm");
        popUpDelete.classList.remove("hideConfirm");
        clubsContainer.classList.add("blur");
        link.setAttribute("href","SupprimerClub?clubName="+clubId+"");
    })
})

closeDeletePopUp.addEventListener("click",cancelDeleteHandler);
cancelButton.addEventListener("click",cancelDeleteHandler);


