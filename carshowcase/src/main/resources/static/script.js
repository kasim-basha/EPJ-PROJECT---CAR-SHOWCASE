document.addEventListener("DOMContentLoaded", function() {
  
  const heading = document.querySelector("h2");
  heading.style.opacity = "0";
  heading.style.transform = "translateY(-20px)";
  setTimeout(() => {
    heading.style.transition = "all 1s ease";
    heading.style.opacity = "1";
    heading.style.transform = "translateY(0)";
  }, 300);
});
