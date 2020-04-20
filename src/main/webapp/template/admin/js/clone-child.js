cloneDetail();
function cloneDetail() {
  var itm = document.getElementsByClassName("clone-child")[0];
  var cln = itm.cloneNode(true);
  cln.removeAttribute("hidden");
  document.getElementById("detail").appendChild(cln);
}