// Funcionalidades para la gesti¢n de empleados 
 
document.addEventListener('DOMContentLoaded', function() { 
    // Buscar empleados en tiempo real 
    const searchInput = document.getElementById('searchEmployee'); 
    if (searchInput) { 
        searchInput.addEventListener('keyup', function(e) { 
            const searchTerm = e.target.value.toLowerCase(); 
            const tableRows = document.querySelectorAll('#employeesTable tbody tr'); 
 
            tableRows.forEach(row =
 
                    row.style.display = ''; 
                } else { 
                    row.style.display = 'none'; 
                } 
            }); 
        }); 
    } 
 
    // Filtrar por tipo de empleado 
    const filterType = document.getElementById('filterEmployeeType'); 
    if (filterType) { 
        filterType.addEventListener('change', function(e) { 
            const filterValue = e.target.value; 
            const tableRows = document.querySelectorAll('#employeesTable tbody tr'); 
 
            tableRows.forEach(row =
                    row.style.display = ''; 
                } else { 
                    row.style.display = 'none'; 
                } 
            }); 
        }); 
    } 
 
    // Validar formulario de empleado 
    const employeeForm = document.getElementById('employeeForm'); 
    if (employeeForm) { 
        employeeForm.addEventListener('submit', function(e) { 
            const nombre = document.getElementById('nombre')?.value.trim(); 
            const apellido = document.getElementById('apellido')?.value.trim(); 
            const email = document.getElementById('email')?.value.trim(); 
 
            if (!nombre) { 
                e.preventDefault(); 
                mostrarMensajeError('El nombre es obligatorio'); 
                return false; 
            } 
 
            if (!apellido) { 
                e.preventDefault(); 
                mostrarMensajeError('El apellido es obligatorio'); 
                return false; 
            } 
 
                e.preventDefault(); 
                mostrarMensajeError('El email no es v lido'); 
                return false; 
            } 
        }); 
    } 
}); 
 
// Funci¢n para validar email 
function isValidEmail(email) { 
    const emailRegex = /[\s@]+@[\s@]+\.[\s@]+$/; 
    return emailRegex.test(email); 
} 
