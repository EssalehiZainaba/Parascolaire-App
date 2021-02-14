const clubsContainer=document.querySelector("#clubsContainer");
const creerButton=document.querySelector("#creerButton");
const addClubForm=document.querySelector("#addClub");
const closeAddForm=document.querySelector("#addClub .close");


creerButton.addEventListener("click",()=>{
    addClubForm.style.transform="translateY(0)";
    clubsContainer.style.filter="blur(15px)";
    clubsContainer.style.pointerEvents="none";
})

closeAddForm.addEventListener("click",()=>{
    addClubForm.style.transform="translateY(-100vh)";
    clubsContainer.style.filter="";
    clubsContainer.style.pointerEvents="";
})


