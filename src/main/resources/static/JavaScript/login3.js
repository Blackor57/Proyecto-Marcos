let button1 = document.getElementById("button1-chooser");
let button2 = document.getElementById("button2-chooser");
let loginDiv = document.getElementById("login-div");
let registerDiv = document.getElementById("register-div");

// Inicializa la vista mostrando solo el registro
registerDiv.style.display = 'none';

// Función para mostrar la sección correspondiente
const showSection = (value) => {
    if (value === 'log') {
        loginDiv.style.display = 'block';
        registerDiv.style.display = 'none';
        resetRegisterFields();

        button1.style.backgroundColor = 'var(--primary-color)';
        button1.style.color = '#000';
        button2.style.backgroundColor = '#fff';
        button2.style.color = '#000';
    }

    if (value === 'reg') {
        loginDiv.style.display = 'none';
        registerDiv.style.display = 'block';
        resetLoginFields();

        button1.style.backgroundColor = '#fff';
        button1.style.color = '#000';
        button2.style.backgroundColor = 'var(--primary-color)';
        button2.style.color = '#000';
    }

    // Actualiza la URL sin refrescar la página
    history.replaceState(null, null, '/registro');
};

// Función para resetear los campos del formulario de registro
const resetRegisterFields = () => {
    document.getElementById("nombre").value = '';
    document.getElementById("apellido").value = '';
    document.getElementById("dni").value = '';
    document.getElementById("birthdate").value = '';
    document.getElementById("phone").value = '';
    document.getElementById("email").value = '';
    document.getElementById("password").value = '';
};

// Función para resetear los campos del formulario de inicio de sesión
const resetLoginFields = () => {
    document.getElementById("emails").value = '';
    document.getElementById("passwords").value = '';
};