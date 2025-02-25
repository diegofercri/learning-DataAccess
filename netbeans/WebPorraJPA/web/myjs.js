document.addEventListener('DOMContentLoaded', () => {
    console.log('ready')
    init()
});

function init() {
    console.log('estoy en init1')
    onshowapostar()
    console.log('estoy en init2')
    onshowresumen()
}

function onshowapostar() {
    const modalApuesta = document.getElementById('modalApuesta')
    if (modalApuesta) {
        modalApuesta.addEventListener('show.bs.modal', (event) => {
            const button = event.relatedTarget
            const partido = button.getAttribute('data-bs-partido')
            const local = button.getAttribute('data-bs-local')
            const visitante = button.getAttribute('data-bs-visitante')
            

            modalApuesta.querySelector('h5').textContent = local + ' - ' + visitante
            modalApuesta.querySelector('form').setAttribute('action', 'Controller?op=apuesta&partido=' + partido)
        })
    }
}

function onshowresumen() {
    const modalResumen = document.getElementById('modalResumen')
    if (modalResumen) {
        modalResumen.addEventListener('show.bs.modal', (event) => {
            
            console.log('estoy en resumen')
            const button = event.relatedTarget
            const partido = button.getAttribute('data-bs-partido')

            const url = "Controller?op=resumen&partido=" + partido
            const resumen = modalResumen.querySelector('.modal-body')
            resumen.innerHTML = "<p>Cargando...</p>"
            // default method get
            fetch(url)
                    .then(promise => {
                        return promise.text()
                    })
                    .then(result => {
                        resumen.innerHTML = result.trim()
                    })

        })
    }
}


