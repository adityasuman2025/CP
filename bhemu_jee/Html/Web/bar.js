let logo = '<a href="home.html" id="logo"><img src="logo.png" alt="Error" height="50px"><div><span id="adarsh">Adarsh </span>Suman</div></a>';
let desktopMenu = '<div id="desktopMenu">  <a href="home.html">Home</a> <a href="about.html">About</a> <a href=""> Contact</a>  </div>';
let social = '<div id="social"><a href="https://www.instagram.com/_adarsh.s/" target="_blank"><img src="insta.png" alt="Error" height="26px"></a><a href="https://www.youtube.com/channel/UCkdSVbjY4sS1I7hw9ZJMdew" target="_blank"><img src="youtube.png" alt="Error" height="20px"></a></div>';
let mobileIcon = '<div id="mobileIcon" onclick="handleMenuClick()"><img src="menu.png" /></div>';
let mobileMenu = '<div id="mobileMenu"><a href="home.html">Home</a><a href="about.html">About</a><a href=""> Contact</a></div>'
document.getElementById('bar').innerHTML = '<div id="topBar">' + logo + desktopMenu + social + mobileIcon + '</div>' + mobileMenu;

let flag = true;
function handleMenuClick() {  
    flag = !flag;
    
    if (flag == true) {
        document.getElementById("mobileMenu").classList.add("show");
    } else {
        document.getElementById("mobileMenu").classList.remove("show");
    }
}
