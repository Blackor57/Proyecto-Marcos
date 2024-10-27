const masas = {
    tradicional: {
        imagen: {
            mediana: 'img/masatradicional350.png',
            grande: 'img/masatradicional400.png',
            familiar: 'img/masatradicional450.png',
            gigante: 'img/masatradicional500.png'
        },
        tamanos: ['mediana', 'grande', 'familiar', 'gigante']
    },
    italiana: {
        imagen: {
            mediana: 'img/masaitaliana350.png',
            grande: 'img/masaitaliana400.png',
            familiar: 'img/masaitaliana450.png',
            gigante: 'img/masaitaliana500.png'
        },
        tamanos: ['mediana', 'grande', 'familiar', 'gigante']
    },
    queso: {
        imagen: {
            mediana: 'img/masaqueso350.png',
            grande: 'img/masaqueso400.png',
            familiar: 'img/masaqueso450.png',
            gigante: 'img/masaqueso500.png'
        },
        tamanos: ['mediana', 'grande', 'familiar', 'gigante']
    },
    pizza: {
        imagen: {
            mediana: 'img/masapizza350.png',
            grande: 'img/masapizza400.png',
            familiar: 'img/masapizza450.png',
            gigante: 'img/masapizza500.png'
        },
        tamanos: ['mediana', 'grande', 'familiar', 'gigante']
    }
};

const elementos = {
    inputMasa : document.getElementById("pizza_masa"),
    inputTamano : document.getElementById("pizza_tamano"),
    inputSalsa : document.getElementById("pizza_salsa"),
    inputQueso : document.getElementById("pizza_queso"),

    inputMolida : document.getElementById("input_molida"),
    inputPollo : document.getElementById("input_pollo"),
    inputJamon : document.getElementById("input_jamon"),
    inputTocino : document.getElementById("input_tocino"),
    inputPepperoni : document.getElementById("input_pepperoni"),
    inputItaliana : document.getElementById("input_italiana"),

    inputCheddar : document.getElementById("input_cheddar"),
    inputPimiento : document.getElementById("input_pimiento"),
    inputChampinon : document.getElementById("input_champinon"),
    inputPina : document.getElementById("input_pina"),
    inputCebolla : document.getElementById("input_cebolla"),
    inputAceituna : document.getElementById("input_aceituna")
}

// elementos.inputMolida.value = "0"
// elementos.inputPollo.value = "0"
// elementos.inputJamon.value = "0"
// elementos.inputTocino.value = "0"
// elementos.inputPepperoni.value = "0"
// elementos. inputItaliana.value = "0"
// elementos.inputCheddar.value = "0"
// elementos.inputPimiento.value = "0"
// elementos.inputChampinon.value = "0"
// elementos.inputPina.value = "0"
// elementos.inputCebolla.value = "0"
// elementos.inputAceituna.value = "0"

Object.keys(elementos).forEach(key => {
    if( elementos[key] == elementos.inputTamano ||
        elementos[key] == elementos.inputQueso ||
        elementos[key] == elementos.inputSalsa ||
        elementos[key] == elementos.inputMasa) {
        console.log(elementos[key])
        console.log("esquivados");
    } else {
        elementos[key].value = "0"
    }
})


function actualizarFormularioOculto(campo, valor) {

    switch(campo){
        case "pizza_masa":
            elementos.inputMasa.value = valor;
            break;
        case "pizza_tamano":
            elementos.inputTamano.value = valor;
            break;
        case "pizza_queso":
            elementos.inputQueso.value = valor;
    }

    elementos.inputSalsa.value = "natural";

}


function actualizarCarnes(name){
    switch (name) {
        case "molida":
            elementos.inputMolida.checked = !elementos.inputMolida.checked;
            elementos.inputMolida.value = elementos.inputMolida.checked ? "1" : "0";
            break;
        case "pollo":
            elementos.inputPollo.checked = !elementos.inputPollo.checked;
            elementos.inputPollo.value = elementos.inputPollo.checked ? "1" : "0";
            break;
        case "jamon":
            elementos.inputJamon.checked = !elementos.inputJamon.checked;
            elementos.inputJamon.value = elementos.inputJamon.checked ? "1" : "0";
            break;
        case "tocino":
            elementos.inputTocino.checked = !elementos.inputTocino.checked;
            elementos.inputTocino.value = elementos.inputTocino.checked ? "1" : "0";
            break;
        case "pepperoni":
            elementos.inputPepperoni.checked = !elementos.inputPepperoni.checked;
            elementos.inputPepperoni.value = elementos.inputPepperoni.checked ? "1" : "0";
            break;
        case "italiana":
            elementos.inputItaliana.checked = !elementos.inputItaliana.checked;
            elementos.inputItaliana.value = elementos.inputItaliana.checked ? "1" : "0";
            break;
    }
}

function actualizarIngredientes(name) {
    switch (name) {
        case "cheddar":
            elementos.inputCheddar.checked = !elementos.inputCheddar.checked;
            elementos.inputCheddar.value = elementos.inputCheddar.checked ? "1" : "0";
            break;
        case "pimiento":
            elementos.inputPimiento.checked = !elementos.inputPimiento.checked;
            elementos.inputPimiento.value = elementos.inputPimiento.checked ? "1" : "0";
            break;
        case "champinon":
            elementos.inputChampinon.checked = !elementos.inputChampinon.checked;
            elementos.inputChampinon.value = elementos.inputChampinon.checked ? "1" : "0";
            break;
        case "pina":
            elementos.inputPina.checked = !elementos.inputPina.checked;
            elementos.inputPina.value = elementos.inputPina.checked ? "1" : "0";
            break;
        case "cebolla":
            elementos.inputCebolla.checked = !elementos.inputCebolla.checked;
            elementos.inputCebolla.value = elementos.inputCebolla.checked ? "1" : "0";
            break;
        case "aceituna":
            elementos.inputAceituna.checked = !elementos.inputAceituna.checked;
            elementos.inputAceituna.value = elementos.inputAceituna.checked ? "1" : "0";
            break;
    }
}

function mostrarElementos(){
    console.log(elementos);
}

function limpiarSeleccionQueso() {
    const quesoSelect = document.querySelector('#seccion-queso select');
    const quesoImagen = document.getElementById('queso-imagen');

    // Limpiar selección de queso y ocultar su imagen
    quesoSelect.value = ''; // Asumiendo que tienes una opción vacía como predeterminada
    quesoImagen.src = '';
    quesoImagen.style.display = 'none'; // Ocultar la imagen de queso
}

function actualizarMasaYTamanos() {
    const masaSelect = document.getElementById('masa-select');
    const tamanoSelect = document.getElementById('tamano-select');
    const imagenMasa = document.getElementById('imagen-masa');
    const mensajeMasa = document.getElementById('mensaje-masa');

    const masaSeleccionada = masaSelect.value;

    // Limpiar las opciones de tamaño
    tamanoSelect.innerHTML = '';

    // Agregar la opción predeterminada
    const defaultOption = document.createElement('option');
    defaultOption.value = 'select';
    defaultOption.textContent = 'Seleccione un Tamaño';
    tamanoSelect.appendChild(defaultOption);

    tamanoSelect.disabled = true; // Desactivar el select de tamaño

    // Reiniciar imagen de masa y queso
    imagenMasa.src = '';
    imagenMasa.style.display = 'none';

    limpiarSeleccionQueso();
    limpiarSeleccionIngredientes();

    if (masaSeleccionada === 'select') {
        mensajeMasa.style.display = 'block';
        setTimeout(() => {
            mensajeMasa.style.display = 'none';
        }, 3000);
        return;
    }

    // Agregar nuevas opciones de tamaño si hay una masa seleccionada
    if (masas[masaSeleccionada]) {
        masas[masaSeleccionada].tamanos.forEach(tamano => {
            const option = document.createElement('option');
            option.value = tamano;
            option.textContent = tamano.charAt(0).toUpperCase() + tamano.slice(1);
            tamanoSelect.appendChild(option);
        });
        tamanoSelect.disabled = false; // Activar el select de tamaño
        mensajeMasa.style.display = 'none'; // Ocultar mensaje si hay selección válida
        console.log("Desplegable habilitado");
    } else {
        console.log("No se encontró la masa seleccionada");
    }

    const tamanoSeleccionado = tamanoSelect.value || tamanoSelect.options[0].value;
    imagenMasa.src = masas[masaSeleccionada]?.imagen[tamanoSeleccionado] || '';
}
// Nueva función para limpiar selecciones de ingredientes
function limpiarSeleccionIngredientes() {
    const checkboxes = document.querySelectorAll('#seccion-carnes input[type="checkbox"], #seccion-ingredientes input[type="checkbox"]');

    checkboxes.forEach(checkbox => {
        checkbox.checked = false; // Desmarcar checkbox
        const imagen = document.getElementById(`${checkbox.value}-imagen`);
        if (imagen) {
            imagen.style.display = 'none'; // Ocultar la imagen del ingrediente
        }
    });
}

function actualizarTamano() {
    const masaSelect = document.getElementById('masa-select');
    const tamanoSelect = document.getElementById('tamano-select');
    const imagenMasa = document.getElementById('imagen-masa');

    // Obtener la masa seleccionada y el tamaño seleccionado
    const masaSeleccionada = masaSelect.value;
    const tamanoSeleccionado = tamanoSelect.value;

    // Actualizar la imagen de la masa según el tamaño seleccionado
    if (masaSeleccionada !== "select" && tamanoSeleccionado !== "select") {
        imagenMasa.src = masas[masaSeleccionada].imagen[tamanoSeleccionado];
        imagenMasa.style.display = 'block'; // Mostrar la imagen ahora que hay una selección válida

        // Ajustar el tamaño de los ingredientes según el tamaño seleccionado
        ajustarTamanoIngredientes(tamanoSeleccionado);

        // Llamar a actualizarQueso para ajustar el tamaño del queso si ya fue seleccionado
        actualizarQueso();
    }
}

// Nueva función para ajustar el tamaño de los ingredientes
function ajustarTamanoIngredientes(tamanoSeleccionado) {
    let scaleFactor;

    switch (tamanoSeleccionado) {
        case 'mediana':
            scaleFactor = 0.5;
            break;
        case 'grande':
            scaleFactor = 0.6;
            break;
        case 'familiar':
            scaleFactor = 0.7;
            break;
        case 'gigante':
            scaleFactor = 1;
            break;
        default:
            scaleFactor = 1;
            break;
    }

    const ingredientesImages = document.querySelectorAll('.ingrediente-imagen');

    ingredientesImages.forEach(imagen => {
        imagen.style.width = `${scaleFactor * 500}px`; // Ajusta según sea necesario, asumiendo que 500px es el tamaño base para gigante
        imagen.style.height = 'auto'; // Mantiene proporciones
    });
}

// Nueva función para ajustar el tamaño de los ingredientes
function ajustarTamanoIngredientes(tamanoSeleccionado) {
    let scaleFactor;

    switch (tamanoSeleccionado) {
        case 'mediana':
            scaleFactor = 0.5;
            break;
        case 'grande':
            scaleFactor = 0.6;
            break;
        case 'familiar':
            scaleFactor = 0.7;
            break;
        case 'gigante':
            scaleFactor = 0.8;
            break;
        default:
            scaleFactor = 1;
            break;
    }

    const ingredientesImages = document.querySelectorAll('.ingrediente-imagen');

    ingredientesImages.forEach(imagen => {
        imagen.style.width = `${scaleFactor * 500}px`; // Ajusta según sea necesario, asumiendo que 500px es el tamaño base para gigante
        imagen.style.height = 'auto'; // Mantiene proporciones
    });
}
function actualizarQueso() {
    const quesoSelect = document.querySelector('#seccion-queso select');
    const quesoImagen = document.getElementById('queso-imagen');

    // Ocultar inicialmente
    quesoImagen.style.display = 'none';

    // Obtener cantidad seleccionada
    const cantidadSeleccionada = quesoSelect.value;

    // Mostrar imagen correspondiente solo si hay una selección válida
    if (cantidadSeleccionada === 'normal') {
        quesoImagen.src = 'img/quesonormal500.png';
    } else if (cantidadSeleccionada === 'poco') {
        quesoImagen.src = 'img/quesopoco500.png';
    } else if (cantidadSeleccionada === 'extra') {
        quesoImagen.src = 'img/quesoextra500.png';
    }

    // Obtener tamaño seleccionado
    const tamanoSelect = document.getElementById('tamano-select');
    const tamanoSeleccionado = tamanoSelect.value;

    // Ajustar tamaño según selección
    let scaleFactor;

    switch (tamanoSeleccionado) {
        case 'mediana':
            scaleFactor = 0.6;
            break;
        case 'grande':
            scaleFactor = 0.68;
            break;
        case 'familiar':
            scaleFactor = 0.78;
            break;
        case 'gigante':
            scaleFactor = 0.88;
            break;
        default:
            scaleFactor = 1; // Sin cambio
            break;
    }

    // Aplicar escala a la imagen del queso
    quesoImagen.style.width = `${scaleFactor * 500}px`; // Asumiendo que 500px es el tamaño base
    quesoImagen.style.height = 'auto'; // Mantiene proporciones

    // Mostrar la imagen del queso si hay selección válida
    if (cantidadSeleccionada) {
        quesoImagen.style.display = 'block';
    }
}

function actualizarCheckbox(tipo, valor, estado) {
    const imagen = document.getElementById(`${valor}-imagen`); // Suponiendo que las imágenes tienen IDs como 'cheddar-imagen'

    if (estado) {
        // Si el checkbox está marcado, mostrar la imagen
        imagen.style.display = 'block';

        // Ajustar tamaño según el tamaño seleccionado
        const tamanoSelect = document.getElementById('tamano-select');
        const tamanoSeleccionado = tamanoSelect.value;
        let scaleFactor;

        switch (tamanoSeleccionado) {
            case 'mediana':
                scaleFactor = 0.5; // Ajusta según sea necesario
                break;
            case 'grande':
                scaleFactor = 0.6;
                break;
            case 'familiar':
                scaleFactor = 0.7;
                break;
            case 'gigante':
                scaleFactor = 0.8; // Este es el tamaño original
                break;
            default:
                scaleFactor = 1; // Sin cambio
                break;
        }

        // Ajustar el tamaño de la imagen
        imagen.style.width = `${scaleFactor * 500}px`; // Asumiendo que 500px es el tamaño base para gigante
        imagen.style.height = 'auto'; // Mantiene proporciones
    } else {
        // Si el checkbox está desmarcado, ocultar la imagen
        imagen.style.display = 'none';
    }
}

function enviarFormulario(){
    document.getElementById("formularioPizza").submit();
}