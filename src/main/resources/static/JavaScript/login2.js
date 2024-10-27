let button1 = document.getElementById("button1-chooser");
let button2 = document.getElementById("button2-chooser");
let loginDiv = document.getElementById("login-div");
let registerDiv = document.getElementById("register-div");

registerDiv.style.display = 'none';

const showSection = (value) => {

    if (value == 'log') {
        loginDiv.style.display = 'block'
        registerDiv.style.display = 'none';
        button1.style.backgroundColor = 'var(--primary-color)';
        button1.style.color = '#000';
        button2.style.backgroundColor = '#fff';
        button2.style.color = '#000';
    }

    if (value == 'reg') {
        loginDiv.style.display = 'none'
        registerDiv.style.display = 'block';
        button1.style.backgroundColor = '#fff';
        button1.style.color = '#000';
        button2.style.backgroundColor = 'var(--primary-color)';
        button2.style.color = '#000';
    }

}