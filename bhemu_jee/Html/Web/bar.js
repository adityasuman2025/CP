let logo = '<a href="home.html" id="logo"><img src="logo.png" alt="Error" height="50px"><div><span id="adarsh">Adarsh </span>Suman</div></a>';
let desktopMenu = '<div id="desktopMenu"><div><a href="home.html">Home</a></div><div><a href="about.html">About</a></div><div><a href=""> Contact</a></div></div>';
let social = '<div id="social"><a href="https://www.instagram.com/_adarsh.s/" target="_blank"><img src="insta.png" alt="Error" height="26px"></a><a href="https://www.youtube.com/channel/UCkdSVbjY4sS1I7hw9ZJMdew" target="_blank"><img src="youtube.png" alt="Error" height="20px"></a></div>';
let mobileMenu = '<div id="mobileMenu"><img src="menu.png" /></div>';
document.getElementById('bar').innerHTML = logo + desktopMenu + social + mobileMenu;