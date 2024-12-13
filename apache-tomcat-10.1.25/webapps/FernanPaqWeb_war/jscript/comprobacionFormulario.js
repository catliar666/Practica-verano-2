document.getElementById('registroForm').addEventListener('submit', function(event) {
            const provincia = document.getElementById('province').value;
            const email = document.getElementById("email").value;
            const nombre = document.getElementById("name").value;
            const telefono = document.getElementById("phone").value;
            const direccion = document.getElementById("address").value;
            const numero = document.getElementById("number").value;
            const postal = document.getElementById("postal").value;
            const ciudad = document.getElementById("city").value;
            const pass = document.getElementById("password").value;
            const pass2 = document.getElementById("password2").value;
            const regex = /<[^>]*>/g;

            if (regex.test(provincia)) {
                alert('El campo no puede contener etiquetas HTML.');
                event.preventDefault();  // Detiene el envío del formulario
            }
            if (regex.test(email)) {
                alert('El campo no puede contener etiquetas HTML.');
                event.preventDefault();  // Detiene el envío del formulario
            }
            if (regex.test(nombre)) {
                alert('El campo no puede contener etiquetas HTML.');
                event.preventDefault();  // Detiene el envío del formulario
            }
            if (regex.test(telefono)) {
                alert('El campo no puede contener etiquetas HTML.');
                event.preventDefault();  // Detiene el envío del formulario
            }
            if (regex.test(direccion)) {
                alert('El campo no puede contener etiquetas HTML.');
                event.preventDefault();  // Detiene el envío del formulario
            }
            if (regex.test(numero)) {
                alert('El campo no puede contener etiquetas HTML.');
                event.preventDefault();  // Detiene el envío del formulario
            }
            if (regex.test(postal)) {
                alert('El campo no puede contener etiquetas HTML.');
                event.preventDefault();  // Detiene el envío del formulario
            }
            if (regex.test(ciudad)) {
                alert('El campo no puede contener etiquetas HTML.');
                event.preventDefault();  // Detiene el envío del formulario
            }
            if (regex.test(pass)) {
                alert('El campo no puede contener etiquetas HTML.');
                event.preventDefault();  // Detiene el envío del formulario
            }
            if (regex.test(pass2)) {
                alert('El campo no puede contener etiquetas HTML.');
                event.preventDefault();  // Detiene el envío del formulario
            }
        });
