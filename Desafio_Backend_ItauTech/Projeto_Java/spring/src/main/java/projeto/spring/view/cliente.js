var textoContas;
var textoClientes;

axios.get('http://localhost:8080/conta')
    .then(response => {
        textoContas = JSON.stringify(response.data)
        textoContas = JSON.parse(textoContas)
    })


axios.get('http://localhost:8080/cliente')
    .then(response => {
        textoClientes = JSON.stringify(response.data)
        textoClientes = JSON.parse(textoClientes)
    })

document.getElementsByClassName("button")[0].addEventListener("click", function () {

    document.getElementsByClassName("dados")[0].innerHTML = "";

    for (var i = 0; i < textoContas.length; i++) {
        document.getElementsByClassName("dados")[0].innerHTML +=

           
            `<div class="titular">` +
            `<span>Titular</span>` +
            `<br>` +
            `<br>` +
            `<span>Código: </span>${textoContas[i]['cliente']['codigo']}` +
            `<br>` +
            `<span>Nome: </span>${textoContas[i]['cliente']['nome']}` +
            `<br>` +
            `<span>CPF: </span>${textoContas[i]['cliente']['cpf']}` +
            `<br>` +
            `<span>Telefone: </span>${textoContas[i]['cliente']['telefone']}` +
            `<br>` +
            `<span>E-mail: </span>${textoContas[i]['cliente']['email']}` +
            `</div>` +

            `</div>`;
    }
})

