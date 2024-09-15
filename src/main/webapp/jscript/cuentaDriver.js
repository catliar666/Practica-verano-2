document.addEventListener("DOMContentLoaded", function() {

    const sections = ["infoPerfil", "showMessage", "enviosPending",
        "enviosFinished", "modifyEnvio", "zonaEntrega", "modifyPerfil"];
    const buttons = document.querySelectorAll('.list-vertical .list-button');

    function hideAllSections() {
        sections.forEach(function (sectionId) {
            const section = document.getElementById(sectionId);
            if (section) {
                section.style.display = "none";
            }
        });
    }

    function setActiveButton(buttonId) {
        buttons.forEach(button => {
            button.classList.remove('active');
        });
        const button = document.getElementById(buttonId);
        if (button) {
            button.classList.add('active');
        }
    }

    function showSection(sectionId) {
        hideAllSections();
        const section = document.getElementById(sectionId);
        if (section) {
            section.style.display = "block";
        }
    }

    function handleButtonClick(buttonId, sectionId) {
        const button = document.getElementById(buttonId);
        if (button) {
            button.addEventListener("click", function () {
                showSection(sectionId);
                setActiveButton(buttonId);
                sessionStorage.setItem('activeSection', sectionId);
            });
        }
    }

    // Set up event listeners for all buttons
    handleButtonClick("verPerfil", "infoPerfil");
    handleButtonClick("verMensajes", "showMessage");
    handleButtonClick("enviosPendientes", "enviosPending");
    handleButtonClick("enviosEntregados", "enviosFinished");
    handleButtonClick("modificarEnvio", "modifyEnvio");
    handleButtonClick("añadirZona", "zonaEntrega");
    handleButtonClick("modificarPerfil", "modifyPerfil");

    // Restore the active section when the page loads
    const activeSection = sessionStorage.getItem('activeSection');
    if (activeSection) {
        showSection(activeSection);
        setActiveButton(getButtonIdForSection(activeSection));
    } else {
        // Default to the first section if no active section is stored
        showSection("infoPerfil");
        setActiveButton("verPerfil");
    }

    function getButtonIdForSection(sectionId) {
        switch (sectionId) {
            case "infoPerfil":
                return "verPerfil";
            case "showMessage":
                return "verMensajes";
            case "enviosPending":
                return "enviosPendientes";
            case "enviosFinished":
                return "enviosEntregados";
            case "modifyEnvio":
                return "modificarEnvio";
            case "zonaEntrega":
                return "añadirZona";
            case "modifyPerfil":
                return "modificarPerfil";
            default:
                return "";
        }
    }


});