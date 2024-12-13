document.addEventListener('DOMContentLoaded', function() {
    // Seleccionar todos los labels en la sección de notificaciones
    const labels = document.querySelectorAll('.info-container label');

    // Función para alternar el texto del label basado en el estado del checkbox
    function toggleLabelText(label) {
        const labelText = label.childNodes[0]; // Asumiendo que el texto es el primer nodo hijo del label

        // Alternar entre "Activadas" y "Desactivadas"
        if (labelText.textContent.trim() === 'Activadas') {
            labelText.textContent = 'Desactivadas';
        } else {
            labelText.textContent = 'Activadas';
        }
    }

    // Añadir eventos de clic en el checkbox para alternar el texto del label
    labels.forEach(label => {
        const checkbox = label.querySelector('input[type="checkbox"]');
        if (checkbox) {
            // Añadir el listener al checkbox
            checkbox.addEventListener('change', function() {
                toggleLabelText(label);
            });
        }
    });
});



