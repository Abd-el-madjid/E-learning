/**
 * 
 */
function submitmoduleName(name){
    //
    let modulename= document.getElementById("module-name");
    let moduleSubmit = document.getElementById("module-submit");

    modulename.value = name ;
    moduleSubmit.click();
    
  console.log(modulename.value = name )



}