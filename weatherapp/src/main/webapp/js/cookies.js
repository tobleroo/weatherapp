
document.getElementById("acceptBtn").addEventListener("click", acceptCookies);
document.getElementById("declineBtn").addEventListener("click", declineCookies);

function acceptCookies(){
    document.getElementById('acceptCookiesBool').value = "true";
    document.getElementById('cookies-box').style.display = "none";
}

function declineCookies(){
    document.getElementById('cookies-box').style.display = "none";
}
