var element=document.getElementById('demo')
console.log(element);

console.log(element.textContent);


element.textContent='content changed'
console.log(element.textContent);

var pelement=document.createElement('p')
pelement.textContent='hi'
document.body.p.appendChild(pelement)
pelement.style.fontSize='40px'
pelement.style.color='red'