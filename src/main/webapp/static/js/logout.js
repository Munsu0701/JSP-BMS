window.addEventListener("DOMContentLoaded", function() {

  const logout = this.document.getElementById("logout");

  logout.addEventListener("click", function() {

   const session = window.sessionStorage.getItem("member");
   console.log(window.sessionStorage);
   if(session != null) {
	sessionStorage.removeItem("member");
}

  })

})

const deleteCookie = function(name) {
  document.cookie = name + '=; expires=Thu, 01 Jan 1999 00:00:10 GMT;';
}

 const cookie = document.cookie;
    if(cookie.indexOf("id") != -1) {
      const strId = cookie.substring(cookie.indexOf("id"), cookie.indexOf("id") + 2);
      deleteCookie(strId);
      window.location.href = "/bms/main";
    }