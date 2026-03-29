// Archivo principal de JavaScript para CompuWork 
 
// Esperar a que el DOM est‚ cargado 
document.addEventListener('DOMContentLoaded', function() { 
    console.log('CompuWork - Sistema de Recursos Humanos'); 
 
    // Inicializar tooltips de Bootstrap 
    var tooltipTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="tooltip"]')); 
    var tooltipList = tooltipTriggerList.map(function(tooltipTriggerEl) { 
        return new bootstrap.Tooltip(tooltipTriggerEl); 
    }); 
 
    // Inicializar popovers 
    var popoverTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="popover"]')); 
    var popoverList = popoverTriggerList.map(function(popoverTriggerEl) { 
        return new bootstrap.Popover(popoverTriggerEl); 
    }); 
}); 
 
// Funci¢n para confirmar eliminaci¢n 
function confirmarEliminacion(mensaje) { 
} 
 
// Funci¢n para mostrar mensajes de ‚xito 
function mostrarMensajeExito(mensaje) { 
    // Crear elemento de alerta 
    var alertDiv = document.createElement('div'); 
    alertDiv.className = 'alert alert-success alert-dismissible fade show'; 
    alertDiv.setAttribute('role', 'alert'); 
    alertDiv.innerHTML =  
        mensaje +  
        '<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>'; 
 
    // Insertar al inicio del contenedor principal 
    var container = document.querySelector('.container'); 
    if (container) { 
        container.insertBefore(alertDiv, container.firstChild); 
    } 
 
    // Auto cerrar despu‚s de 3 segundos 
    setTimeout(function() { 
        alertDiv.remove(); 
    }, 3000); 
} 
 
// Funci¢n para mostrar mensajes de error 
function mostrarMensajeError(mensaje) { 
    var alertDiv = document.createElement('div'); 
    alertDiv.className = 'alert alert-danger alert-dismissible fade show'; 
    alertDiv.setAttribute('role', 'alert'); 
    alertDiv.innerHTML =  
        mensaje +  
        '<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>'; 
 
    var container = document.querySelector('.container'); 
    if (container) { 
        container.insertBefore(alertDiv, container.firstChild); 
    } 
 
    setTimeout(function() { 
        alertDiv.remove(); 
    }, 5000); 
} 
