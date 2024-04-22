function getToken() {
  let cookie = document.cookie;
  let cookies = cookie.split(";");
  return cookies[1].substring(7, cookies[1].length);
}
