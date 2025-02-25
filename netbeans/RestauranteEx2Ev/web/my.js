document.addEventListener('DOMContentLoaded', () => {
    console.log('ready')
    init()
});

function addToCart(platoId) {
    fetch(`Controller?op=addToCart&plato=${platoId}`)
        .then(response => response.redirected ? window.location.reload() : null);
}