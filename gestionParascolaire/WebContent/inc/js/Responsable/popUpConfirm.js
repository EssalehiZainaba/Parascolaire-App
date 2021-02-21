const container=document.querySelector("#container");

const demandesSuppression=document.querySelectorAll(".demande .remove");
const demandesAccept=document.querySelectorAll(".demande .add");

const popUpDelete=document.querySelector("#confirmDelete");
const popUpAccept=document.querySelector("#confirmAccept");

const closeDeletePopUp=document.querySelector("#closeDelete");
const closeAcceptPopUp=document.querySelector("#closeAccept");

const cancelDelete=document.querySelector("#cancelDelete");
const cancelAccept=document.querySelector("#cancelAccept");

const confirmButton=document.querySelector("#confirm");

const deleteButton=document.querySelector("#delete");
const acceptButton=document.querySelector("#accept");

let demandeId;

let cancelDeleteHandler=()=>{
    popUpDelete.classList.remove("showConfirm");
    popUpDelete.classList.add("hideConfirm");
    container.classList.remove("blur");
}

let cancelAcceptHandler=()=>{
    popUpAccept.classList.remove("showConfirm");
    popUpAccept.classList.add("hideConfirm");
    container.classList.remove("blur");
}

demandesSuppression.forEach(demande=>{
    demande.addEventListener("click",(evt)=>{
        demandeId=evt.target.parentElement.id;
        console.log(evt.target.parentElement);
        console.log(demandeId);
        popUpDelete.classList.add("showConfirm");
        popUpDelete.classList.remove("hideConfirm");
        container.classList.add("blur");
        deleteButton.setAttribute("value",demandeId);
    })
})

demandesAccept.forEach(demande=>{
    demande.addEventListener("click",(evt)=>{
        demandeId=evt.target.parentElement.id;
        console.log(evt.target.parentElement);
        console.log(demandeId);
        popUpAccept.classList.add("showConfirm");
        popUpAccept.classList.remove("hideConfirm");
        container.classList.add("blur");
        acceptButton.setAttribute("value",demandeId);
    })
})


closeDeletePopUp.addEventListener("click",cancelDeleteHandler);
closeAcceptPopUp.addEventListener("click",cancelAcceptHandler);

cancelDelete.addEventListener("click",cancelDeleteHandler);
cancelAccept.addEventListener("click",cancelAcceptHandler);