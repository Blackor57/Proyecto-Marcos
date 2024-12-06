// Función para inicializar el filtrado por categoría
function inicializarFiltradoPorCategoria() {
    var categoriaButtons = document.getElementsByClassName('categoria-btn');

    for (var i = 0; i < categoriaButtons.length; i++) {
        categoriaButtons[i].addEventListener('click', function(event) {
            var categoriaSeleccionada = event.target.getAttribute('data-categoria');
            filtrarProductosPorCategoria(categoriaSeleccionada);
        });
    }
}

// Función para filtrar los productos por la categoría seleccionada
function filtrarProductosPorCategoria(categoria) {
    var items = document.getElementsByClassName('item');

    for (var i = 0; i < items.length; i++) {
        var item = items[i];
        var categoriaItem = item.getAttribute('data-categoria');

        if (categoria === 'todos' || categoriaItem === categoria) {
            item.style.display = 'block';
        } else {
            item.style.display = 'none';
        }
    }
}

// Función para mostrar todos los productos
function mostrarTodosLosProductos() {
    var items = document.getElementsByClassName('item');
    for (var i = 0; i < items.length; i++) {
        var item = items[i];
        item.style.display = 'block';
    }
}

document.querySelectorAll('.categoria-btn').forEach(button => {
    button.addEventListener('click', () => {
        const categoria = button.getAttribute('data-categoria');
        document.querySelectorAll('.item').forEach(item => {
            if (item.getAttribute('data-categoria') === categoria || categoria === 'todos') {
                item.style.display = 'block';
            } else {
                item.style.display = 'none';
            }
        });
    });
});