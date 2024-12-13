document.addEventListener('DOMContentLoaded', function() {
    // Obtén referencias a los elementos
    const btnEncurso = document.getElementById('Encurso');
    const btnEntregados = document.getElementById('Entregados');
    const containerPendings = document.getElementById('card-container-pendings');
    const containerFinished = document.getElementById('card-container-finished');

    // Función para manejar el cambio de vista
    function showSection(sectionToShow) {
        // Mostrar la sección seleccionada
        if (sectionToShow === 'card-container-pendings') {
            containerPendings.style.display = 'flex';
            containerFinished.style.display = 'none';
            btnEncurso.classList.add('active');
            btnEntregados.classList.remove('active');
        } else if (sectionToShow === 'card-container-finished') {
            containerFinished.style.display = 'flex';
            containerPendings.style.display = 'none';
            btnEntregados.classList.add('active');
            btnEncurso.classList.remove('active');
        }
    }

    // Asignar eventos a los botones
    btnEncurso.addEventListener('click', function() {
        showSection('card-container-pendings');
    });

    btnEntregados.addEventListener('click', function() {
        showSection('card-container-finished');
    });

    // Mostrar la sección por defecto (puedes cambiar la sección por defecto si lo deseas)
    showSection('card-container-pendings');
});
