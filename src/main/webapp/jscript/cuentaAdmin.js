document.addEventListener("DOMContentLoaded", function() {

    const sections = ["infoPerfil", "infoEmpresa", "sinAsignar",
        "resumenUsuarios", "resumenConductores", "createDriver", "configProperties", "modifyPerfil", "copySecurity"];
    const buttons = document.querySelectorAll('.list-vertical .list-button');

    function hideAllSections() {
        sections.forEach(function (sectionId) {
            const section = document.getElementById(sectionId);
            if (section) {
                section.style.display = "none";
                console.log(`Mostrando sección: ${sectionId}`);
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
            console.log(`Mostrando sección: ${sectionId}`);
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
    handleButtonClick("infoApp", "infoEmpresa");
    handleButtonClick("enviosSinAsignar", "sinAsignar");
    handleButtonClick("resumenUsers", "resumenUsuarios");
    handleButtonClick("resumenDriver", "resumenConductores");
    handleButtonClick("crearCuentas", "createDriver");
    handleButtonClick("configWeb", "configProperties");
    handleButtonClick("modificarPerfil", "modifyPerfil");
    handleButtonClick("copiaSeguridad", "copySecurity");

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
            case "infoEmpresa":
                return "infoApp";
            case "sinAsignar":
                return "enviosSinAsignar";
            case "resumenUsuarios":
                return "resumenUsers";
            case "resumenConductores":
                return "resumenDriver";
            case "createDriver":
                return "crearCuentas";
            case "configProperties":
                return "configWeb";
            case "modifyPerfil":
                return "modificarPerfil";
            case "copySecurity":
                return "copiaSeguridad";
            default:
                return "";
        }
    }


});
