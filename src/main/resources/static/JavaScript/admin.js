document.addEventListener("DOMContentLoaded", () => {
    const counters = document.querySelectorAll('.card-text[data-target]');
  
    counters.forEach(counter => {
      const updateCounter = () => {
        const target = +counter.getAttribute('data-target');
        const current = +counter.innerText.replace(/\D/g, ''); 
        const increment = target / 100; 

        if (current < target) {
          counter.innerText = `$${Math.ceil(current + increment)}`;
          setTimeout(updateCounter, 20); // Actualización gradual
        } else {
          counter.innerText = `$${target}`; // Mostrar valor final
        }
      };
  
      // Iniciar la animación de números
      counter.classList.add('is-hidden');
      setTimeout(() => {
        counter.classList.remove('is-hidden');
        counter.classList.add('is-visible');
        updateCounter();
      }, 500); 
    });
  });
  