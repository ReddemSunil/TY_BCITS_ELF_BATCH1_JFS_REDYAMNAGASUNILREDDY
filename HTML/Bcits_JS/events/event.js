var ele = document.createElement('p')


function showAlert() {
    alert("hi welcome to cinema hall.......")
}
function elementCreation() {

    ele.textContent = 'hello'
    ele.style.fontSize = '40px'
    document.body.appendChild(ele)
}
function displayElement() {
    var dispElement = document.getElementById('disp')
    var element = document.getElementById('element')
    if (dispElement.style.display === '' || dispElement.style.display === 'none') {
        dispElement.style.display = 'block'
        element.textContent = 'Click this to hiden h1 element'
    } else {
        dispElement.style.display = 'none'
        element.textContent = 'click this to show h1 element'
    }


}
function mouseIn(){
    var mousei=document.getElementById('mouse')
    mousei.style.color='red'
    mousei.style.fontSize='40px'
    mousei.style.backgroundColor='yellow'
}
function mouseOut(){
    var mousei=document.getElementById('mouse')
    mousei.style.color='green'
    mousei.style.fontSize='18px'
    mousei.style.backgroundColor='blue'
}
function showData(){
    document.getElementById('myinput')
    console.log('working!!!!');

    
}
function showDetail(){
    console.log('excuted!!!');
    
}
function getInputValue(){
    var val=document.getElementById('input')
    console.log(val.value);
    var dis=document.getElementById('p') 
    dis.textContent=val.value
     
}