//drop down
let dropDown=document.querySelector(".dropDown");
let dropDownContainer=document.querySelector(".clubs");
let dropDownLi=document.querySelectorAll(".dropDown li");

//add css properties to our dropdown when we mouseover it 
dropDownContainer.addEventListener("mouseover",()=>{
     let l = dropDownLi.length;
     dropDown.classList.add("dropDownHover"); 
     dropDown.style.height=(60*l+"px");
     for(let i=0;i<dropDownLi.length;i++){
         dropDownLi[i].style.opacity="1";
     }
});

//Return 
dropDownContainer.addEventListener("mouseout",()=>{
    dropDown.classList.remove("dropDownHover");
        dropDown.style.height=("inherit");
    for(let i=0;i<dropDownLi.length;i++){
        dropDownLi[i].style.opacity="0";
    }
  
});

