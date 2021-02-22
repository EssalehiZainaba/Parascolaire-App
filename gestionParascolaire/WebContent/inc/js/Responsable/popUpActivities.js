const deleteActivitieButtons=document.querySelectorAll(".remove");
const popUpDelete=document.querySelector("#confirmDelete");

const cancelDelete=document.querySelector("#closeConfirm");
const cancel=document.querySelector("#cancelButton");

const container=document.querySelector("#container");
const confirmDelete=document.querySelector("#confirmButton");

let activitieId;

let cancelDeleteHandler=()=>{
    popUpDelete.classList.add("hideConfirm");
    popUpDelete.classList.remove("showConfirm");
    container.classList.remove("blur");
}

deleteActivitieButtons.forEach(deleteButton =>{
    deleteButton.addEventListener("click",(evt)=>{
		console.log(evt.target.parentElement);
        activitieId=evt.target.parentElement.id;
        popUpDelete.classList.remove("hideConfirm");
        popUpDelete.classList.add("showConfirm");
        container.classList.add("blur");  
        confirmDelete.setAttribute("href","supprimerActivite?id="+activitieId);
    })
})


cancel.addEventListener("click",cancelDeleteHandler);
cancelDelete.addEventListener("click",cancelDeleteHandler);