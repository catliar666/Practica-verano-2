
    // Obtén referencias a los elementos
    const btnConductor = document.getElementById('crearConductor');
    const btnAdmin = document.getElementById('crearAdmin');
    const containerDriver = document.getElementById('driverContainer'); // Asegúrate de que el ID sea 'driverContainer'
    const containerAdmin = document.getElementById('adminContainer');

    // Función para manejar el cambio de vista
    function showSection(sectionToShow) {
        if (sectionToShow === 'driverContainer') {
            containerDriver.style.display = 'block';
            containerAdmin.style.display = 'none';
            btnConductor.classList.add('active');
            btnAdmin.classList.remove('active');
        } else if (sectionToShow === 'adminContainer') {
            containerAdmin.style.display = 'block';
            containerDriver.style.display = 'none';
            btnAdmin.classList.add('active');
            btnConductor.classList.remove('active');
        }
    }

    // Asignar eventos a los botones
    btnConductor.addEventListener('click', function() {
        showSection('driverContainer');
    });

    btnAdmin.addEventListener('click', function() {
        showSection('adminContainer');
    });

    showSection('driverContainer');

