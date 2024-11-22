document.addEventListener("DOMContentLoaded", () => {
    const stars = document.querySelectorAll(".rating-star");
  
    // Función para manejar el hover
    const handleMouseOver = (event) => {
      const hoverValue = parseInt(event.target.dataset.value, 10);
      stars.forEach((star) => {
        const starValue = parseInt(star.dataset.value, 10);
        if (starValue <= hoverValue) {
          star.classList.add("yellow");
          star.classList.remove("black");
        } else {
          star.classList.add("black");
          star.classList.remove("yellow");
        }
      });
    };
  
    // Función para limpiar los estilos de hover
    const clearHover = () => {
      stars.forEach((star) => {
        star.classList.add("black");
        star.classList.remove("yellow");
      });
    };
  
    // Agregar eventos a las estrellas
    stars.forEach((star) => {
      star.addEventListener("mouseover", handleMouseOver);
      star.addEventListener("mouseout", clearHover);
    });
  });
  