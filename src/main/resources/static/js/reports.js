// Funcionalidades para la generaci¢n de reportes 
 
document.addEventListener('DOMContentLoaded', function() { 
    // Bot¢n para exportar reporte a PDF 
    const exportPdfBtn = document.getElementById('exportPdf'); 
    if (exportPdfBtn) { 
        exportPdfBtn.addEventListener('click', function() { 
            exportToPDF(); 
        }); 
    } 
 
    // Bot¢n para imprimir reporte 
    const printReportBtn = document.getElementById('printReport'); 
    if (printReportBtn) { 
        printReportBtn.addEventListener('click', function() { 
            window.print(); 
        }); 
    } 
}); 
 
// Funci¢n para exportar a PDF 
function exportToPDF() { 
    const reportContent = document.querySelector('.report-content'); 
    if (!reportContent) { 
        console.error('No se encontr¢ contenido para exportar'); 
        return; 
    } 
 
    // Guardar el t¡tulo original 
    const originalTitle = document.title; 
    document.title = 'Reporte_CompuWork_' + new Date().toISOString().slice(0,19); 
 
    // Abrir ventana de impresi¢n 
    window.print(); 
 
    // Restaurar t¡tulo 
    setTimeout(function() { 
        document.title = originalTitle; 
    }, 1000); 
} 
