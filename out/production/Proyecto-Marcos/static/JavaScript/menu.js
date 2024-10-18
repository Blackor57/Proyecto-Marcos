document.addEventListener('DOMContentLoaded', function() {
    const menuCheckbox = document.getElementById('menu');
    const menuContainer = document.querySelector('.menu-container');

    menuCheckbox.addEventListener('click', function() {
        menuContainer.classList.toggle('menu-hidden');
    });
});

