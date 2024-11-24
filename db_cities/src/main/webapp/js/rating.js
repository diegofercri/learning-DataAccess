document.addEventListener("DOMContentLoaded", () => {
  // Select all card containers (card-image)
  const cardImages = document.querySelectorAll(".card-image");

  cardImages.forEach((cardImage) => {
      const stars = cardImage.querySelectorAll(".rating-star");

      // Function to handle the hover within the specific card
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

      // Function to clean the hover styles inside the specific card
      const clearHover = () => {
          stars.forEach((star) => {
              star.classList.add("black");
              star.classList.remove("yellow");
          });
      };

      // Add events to the stars within the specific card
      stars.forEach((star) => {
          star.addEventListener("mouseover", handleMouseOver);
          star.addEventListener("mouseout", clearHover);
      });
  });
});
