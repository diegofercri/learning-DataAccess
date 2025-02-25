document.addEventListener('DOMContentLoaded', () => {
    console.log('ready')
    init()
});

function init() {
    onshowmovies()
}

body

function onshowmovies() {
    const modalmovies = document.getElementById('modalmovies')
    if (modalmovies) {
        modalmovies.addEventListener('show.bs.modal', (event) => {
            const button = event.relatedTarget
            const personajeid = button.getAttribute('data-bs-personajeid')

            const url = "Controller?op=moviestheperson&personajeid=" + personajeid
            const body = modalmovies.querySelector('.modal-body')
            body.innerHTML = "<p>Cargando...</p>"
            // default method get
            fetch(url)
                    .then(promise => {
                        return promise.text()
                    })
                    .then(result => {
                        body.innerHTML = result.trim()
                    })

        })
    }
}

