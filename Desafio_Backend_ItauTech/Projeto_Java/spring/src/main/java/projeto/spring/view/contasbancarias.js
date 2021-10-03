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

            `<div class="conta">` +

            `<span>Número da conta: </span>${textoContas[i]['numero']}` +
            `<br>` +
            `<span>Agência: </span>${textoContas[i]['agencia']}` +
            `<br>` +
            `<span>Tipo de conta: </span>${textoContas[i]['ContaTipo']}` +
            `<br>` +
            `<span>Saldo: </span>${textoContas[i]['saldo']}` +
            `</div>`;
    }
})
