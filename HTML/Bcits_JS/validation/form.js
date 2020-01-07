function validateForm(){
    var loginForm=document.forms['loginForm']
    var userMail=loginForm['userEmail'].value;
    var pwd=loginForm['userPwd'].value;
    
    console.log(loginForm);
    console.log('user mail '+userMail)
    console.log('userpwd ',pwd);
    if(userMail.trim().length>6){
        document.getElementById('emailErr').style.display='none'
        console.log('user mail is valid')
    }else{
        document.getElementById('emailErr').style.display='block'
        console.log('user mail is invalid');
        
    }
    if(pwd.trim().length>5){
        console.log('password is valid');
        
    }else{
        console.log('password is invalid');
        
    }
}