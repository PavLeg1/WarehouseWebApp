// Get the carousel element
        var carousel = document.querySelector('#myCarousel');

        // Get the carousel buttons
        var prevBtn = document.querySelector('#prev-btn');
        var nextBtn = document.querySelector('#next-btn');

        // Get the carousel indicators
        var indicators = carousel.querySelectorAll('.carousel-indicators button');

        // Get the number of slides
        var totalSlides = carousel.querySelectorAll('.carousel-item').length;

        // Set the initial slide index
        var slideIndex = 0;

        // Add event listeners to the buttons
        prevBtn.addEventListener('click', function () {
          slideIndex--;
          if (slideIndex < 0) {
            slideIndex = totalSlides - 1;
          }
          updateCarousel();
        });

        nextBtn.addEventListener('click', function () {
          slideIndex++;
          if (slideIndex >= totalSlides) {
            slideIndex = 0;
          }
          updateCarousel();
        });

        // Add event listeners to the indicators
        indicators.forEach(function (indicator, index) {
          indicator.addEventListener('click', function () {
            slideIndex = index;
            updateCarousel();
          });
        });

        // Change the active slide and the automatic slide change
        function updateCarousel() {
          // Remove the active class from all indicators
          indicators.forEach(function (indicator) {
            indicator.classList.remove('active');
          });

          // Add the active class to the current indicator
          indicators[slideIndex].classList.add('active');

          // Change the active slide
          carousel.querySelector('.carousel-item.active').classList.remove('active');
          carousel.querySelectorAll('.carousel-item')[slideIndex].classList.add('active');

          // Reset the automatic slide change
          clearInterval(intervalId);
          intervalId = setInterval(function () {
            slideIndex++;
            if (slideIndex >= totalSlides) {
              slideIndex = 0;
            }
            updateCarousel();
          }, carousel.dataset.bsInterval);
        }

        // Set the automatic slide change
        var intervalId = setInterval(function () {
          slideIndex++;
          if (slideIndex >= totalSlides) {
            slideIndex = 0;
          }
          updateCarousel();
        }, carousel.dataset.bsInterval);