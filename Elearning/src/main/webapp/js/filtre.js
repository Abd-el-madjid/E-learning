function showInputs(select) {
  var choix = select.value;
  var div = document.getElementsByClassName("inputDiv");
  div.style.display = "none";



  switch (choix) {
    case "M1 RSD":
     
      div.style.display = "block";
      break;
    case "M1 GL":
    
      div.style.display = "block";
      break;
          case "M1 SITW":
      
      div.style.display = "block";
      break;
          case "M1 STIC":
      
      div.style.display = "block";
      break;
  
          case "M2 GL":
       div.style.display = "block";
      break;
          case "M2 RSD":
      div.style.display = "block";
      break;
          case "M2 SITW":
      div.style.display = "block";
      break;
           case "M2 STIC":
      div.style.display = "block";
      break;
      
      
             case "L3 SI":
      div.style.display = "block";
      break;
          case "L3 SCI":
      div.style.display = "block";
      break;
            case "L3 TI":
      div.style.display = "block";
      break;
            case "L3 GL":
      div.style.display = "block";
      break;
      
          case "L1 MI":
      div.style.display = "block";
      break;
          case "L2 MI":
      div.style.display = "block";
      break;
    // Add cases for the other 11 options
    default:
      div.innerHTML = '';
      break;
  }
}