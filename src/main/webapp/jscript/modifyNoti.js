document.addEventListener('DOMContentLoaded', function() {
    // Seleccionar todos los labels en la sección de notificaciones
    const labels = document.querySelectorAll('.info-container label');

    // Función para actualizar el texto basado en el estado del checkbox
    function updateLabelText() {
        labels.forEach(label => {
            const checkbox = label.querySelector('input[type="checkbox"]');
            const labelText = label.childNodes[0]; // Asumiendo que el texto es el primer nodo hijo del label

            if (checkbox) {
                // Cambiar el texto del label según el estado del checkbox
                if (checkbox.checked) {
                    labelText.textContent = 'Desactivadas';
                } else {
                    labelText.textContent = 'Activadas';
                }
            }
        });
    }


    // Añadir eventos para actualizar el texto cuando el estado del checkbox cambie
    labels.forEach(label => {
        const checkbox = label.querySelector('input[type="checkbox"]');
        if (checkbox) {
            checkbox.addEventListener('change', updateLabelText);
            // Añadir un evento de clic en el label para alternar el estado del checkbox
            label.addEventListener('click', () => {
                checkbox.checked = !checkbox.checked; // Alternar el estado del checkbox
                updateLabelText(); // Actualizar el texto del label
            });
        }
    });
});


