document.addEventListener('DOMContentLoaded', function() {
    // Obtén referencias a los elementos
    const btnConductor = document.getElementById('crearConductor');
    const btnAdmin = document.getElementById('crearAdministrador');
    const containerDriver = document.getElementById('drivercontainer');
    const containerAdmin = document.getElementById('admincontainer');

    // Función para manejar el cambio de vista
    function showSection(sectionToShow) {
        // Mostrar la sección seleccionada
        if (sectionToShow === 'drivercontainer') {
            containerDriver.style.display = 'block';
            containerAdmin.style.display = 'none';
            btnConductor.classList.add('active');
            btnAdmin.classList.remove('active');
        } else if (sectionToShow === 'admincontainer') {
            containerAdmin.style.display = 'block';
            containerDriver.style.display = 'none';
            btnAdmin.classList.add('active');
            btnConductor.classList.remove('active');
        }
    }

    // Asignar eventos a los botones
    btnConductor.addEventListener('click', function() {
        showSection('crearConductor');
    });

    btnAdmin.addEventListener('click', function() {
        showSection('admincontainer');
    });

    // Mostrar la sección por defecto (puedes cambiar la sección por defecto si lo deseas)
    showSection('crearConductor');
});
