const images = ["image1.jpg", "image2.jpg", "image3.jpg"];
const slideshow = document.querySelector(".slideshow");

let currentIndex = 0;

function changeSlide() {
    slideshow.style.backgroundImage = `url("${images[currentIndex]}")`;
    currentIndex = (currentIndex + 1) % images.length;
}

setInterval(changeSlide, 5000); // Change slide every 5 seconds
