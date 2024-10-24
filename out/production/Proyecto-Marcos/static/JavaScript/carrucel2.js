document.addEventListener('DOMContentLoaded', function () {
    const cat25Btn = document.getElementById('cat25');
    const cat50Btn = document.getElementById('cat50');
    const cat100Btn = document.getElementById('cat100');
    const cat200Btn = document.getElementById('cat200');
    const cat300Btn = document.getElementById('cat300');
    const cat25Line = document.getElementById('cat25Line');
    const cat50Line = document.getElementById('cat50Line');
    const cat100Line = document.getElementById('cat100Line');
    const cat200Line = document.getElementById('cat200Line');
    const cat300Line = document.getElementById('cat300Line');
    const categoryContent = document.getElementById('categoryContent');

    const showCategoryContent = (category) => {
        categoryContent.innerHTML = "";

        [cat25Btn, cat50Btn, cat100Btn, cat200Btn, cat300Btn].forEach(btn => {
            btn.classList.remove('active');
        });
        [cat25Line, cat50Line, cat100Line, cat200Line, cat300Line].forEach(line => {
            line.classList.remove('active');
        });

        switch (category) {
            case '25':
                categoryContent.innerHTML = `
          <div class="category-card">
            <div class="card-image">
              <img src="/img/pizza-4-quesos-g-1.png" alt="Gatitos">
            </div>
            <div class="card-content">
              <div class="title">
                <h3>Personaliza tu pizza</h3>
              </div>
              <div class="description">
                <p>Añádele a tu pizza un sabor extra a tu gusto.</p>
              </div>
            </div>
          </div>`;
                cat25Btn.classList.add('active');
                cat25Line.classList.add('active');
                break;
            case '50':
                categoryContent.innerHTML = `
          <div class="category-card">
            <div class="card-image">
              <img src="/img/pizza-4-quesos-g-1.png" alt="Gatitos">
            </div>
            <div class="card-content">
              <div class="title">
                <h3>Desde pizzas hasta bebidas</h3>
              </div>
              <div class="description">
                <p>Disfruta de una promoción de pizza gratis.</p>
              </div>
            </div>
          </div>`;
                cat50Btn.classList.add('active');
                cat50Line.classList.add('active');
                break;
            case '100':
                categoryContent.innerHTML = `
          <div class="category-card">
            <div class="card-image">
              <img src="/img/pizza-4-quesos-g-1.png" alt="Gatitos">
            </div>
            <div class="card-content">
              <div class="title">
                <h3>Tu bebida y pizza favorita te espera</h3>
              </div>
              <div class="description">
                <p>Obten un combo de pizza y refresco gratis</p>
              </div>
            </div>
          </div>`;
                cat100Btn.classList.add('active');
                cat100Line.classList.add('active');
                break;
            case '200':
                categoryContent.innerHTML = `
          <div class="category-card">
            <div class="card-image">
              <img src="/img/pizza-4-quesos-g-1.png" alt="Gatitos">
            </div>
            <div class="card-content">
              <div class="title">
                <h3>Refescos, combos, pizzas y más</h3>
              </div>
              <div class="description">
                <p>Nutre tu día junto un pedido de tu elección</p>
              </div>
            </div>
          </div>`;
                cat200Btn.classList.add('active');
                cat200Line.classList.add('active');
                break;
            case '300':
                categoryContent.innerHTML = `
          <div class="category-card">
            <div class="card-image">
              <img src="/img/pizza-4-quesos-g-1.png" alt="Gatitos">
            </div>
            <div class="card-content">
              <div class="title">
                <h3>Tu merch favorito</h3>
              </div>
              <div class="description">
                <p>Llévate a casa una seramica en forma de tu pizza favorita.<br>
                * Canje válido para modelos de merchandising seleccionados. <br>No válido para artículos de filtrado de edición Collector.</p>
              </div>
            </div>
          </div>`;
                cat300Btn.classList.add('active');
                cat300Line.classList.add('active');
                break;
            default:
                break;
        }
    };

    cat25Btn.addEventListener('click', () => {
        showCategoryContent('25');
    });

    cat50Btn.addEventListener('click', () => {
        showCategoryContent('50');
    });

    cat100Btn.addEventListener('click', () => {
        showCategoryContent('100');
    });

    cat200Btn.addEventListener('click', () => {
        showCategoryContent('200');
    });

    cat300Btn.addEventListener('click', () => {
        showCategoryContent('300');
    });

    showCategoryContent('25');
});