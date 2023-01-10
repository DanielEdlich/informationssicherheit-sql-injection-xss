import "./style.css";

// document.querySelector('#app').innerHTML = `
//   <div>
//     <a href="https://vitejs.dev" target="_blank">
//       <img src="/vite.svg" class="logo" alt="Vite logo" />
//     </a>
//     <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript" target="_blank">
//       <img src="${javascriptLogo}" class="logo vanilla" alt="JavaScript logo" />
//     </a>
//     <h1>Hello Vite!</h1>
//     <div class="card">
//       <button id="counter" type="button"></button>
//     </div>
//     <p class="read-the-docs">
//       Click on the Vite logo to learn more
//     </p>
//   </div>
// `

// setupCounter(document.querySelector('#counter'))

document.getElementById("login").addEventListener('submit', login)
document.getElementById("register").addEventListener('submit', register)

export function login() {
  console.log("submitting login");
  const login = document.querySelector("#login");
  console.log(login);
  const name = login.querySelector("#name").value;
  const password = login.querySelector("#password").value;

  console.log(name + ' ' + password);

  if (name.lenth <3 || password.lenth === 0){
    return
  }

  const data = {
    name: name,
    password: password,
  };

  fetch("http://localhost:8080/users/auth", {
    method: "POST",
    body: JSON.stringify(data),
    headers: { "Content-Type": "application/json" },
  })
    .then(async response => response.json())
    .then((json) => printResponse(json))
    .catch((e) => console.log(e));


    return false
}

export function register() {
  console.log("sumitting register");
  const register = document.querySelector("#register");
  console.log(register);
  const name = register.querySelector("#name").value;
  const password = register.querySelector("#password").value;

  console.log(name + ' ' + password);

  if (name.lenth <3 || password.lenth === 0){
    return 
  }

  const data = {
    name: name,
    password: password,
  };

  fetch("http://localhost:8080/users", {
    method: "POST",
    body: JSON.stringify(data),
    headers: { "Content-Type": "application/json" },
  })
    .then((response) => response.json())
    .then((json) => console.log(json))
    .catch((e) => console.log(e));


  return false
}

function printResponse(json){
  const out = document.querySelector(".output");
  const user = `
    <div> 
    <span> Hello </span> ${json.name} 

    <span> Your id is: ${json.id} </span>
    </div>
  `
  
  out.innerHTML = user

  console.log(json);
}