// package com.compuwork.config;

// import com.compuwork.model.Department;
// import com.compuwork.model.PermanentEmployee;
// import com.compuwork.model.TemporaryEmployee;
// import com.compuwork.service.DepartmentService;
// import com.compuwork.service.EmployeeService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.CommandLineRunner;
// import org.springframework.stereotype.Component;

// @Component
// public class DataInitializer implements CommandLineRunner {

//     @Autowired
//     private DepartmentService departmentService;

//     @Autowired
//     private EmployeeService employeeService;

//     @Override
//     public void run(String... args) throws Exception {
//         // Verificar si ya hay datos
//         if (departmentService.getAllDepartments().isEmpty()) {
            
//             // Crear departamentos de prueba
//             Department deptIT = new Department();
//             deptIT.setNombre("Tecnologias de la Informacion");
//             deptIT.setDescripcion("Departamento de TI y sistemas");
//             departmentService.createDepartment(deptIT);

//             Department deptRRHH = new Department();
//             deptRRHH.setNombre("Recursos Humanos");
//             deptRRHH.setDescripcion("Gestion de talento humano");
//             departmentService.createDepartment(deptRRHH);

//             Department deptVentas = new Department();
//             deptVentas.setNombre("Ventas");
//             deptVentas.setDescripcion("Departamento comercial");
//             departmentService.createDepartment(deptVentas);

//             // Obtener los departamentos creados
//             Department itDept = departmentService.getAllDepartments().get(0);
//             Department rrhhDept = departmentService.getAllDepartments().get(1);
//             Department ventasDept = departmentService.getAllDepartments().get(2);

//             // Crear empleados de prueba
//             PermanentEmployee emp1 = new PermanentEmployee();
//             emp1.setNombre("Juan");
//             emp1.setApellido("Perez");
//             emp1.setEmail("juan.perez@compuwork.com");
//             emp1.setTelefono("123456789");
//             emp1.setPuntuacionDesempeno(8.5);
//             emp1.setDepartment(itDept);
//             emp1.setSalarioBase(3500.0);
//             emp1.setFechaContratacion("2023-01-15");
//             employeeService.createEmployee(emp1);

//             PermanentEmployee emp2 = new PermanentEmployee();
//             emp2.setNombre("Maria");
//             emp2.setApellido("Gomez");
//             emp2.setEmail("maria.gomez@compuwork.com");
//             emp2.setTelefono("987654321");
//             emp2.setPuntuacionDesempeno(9.2);
//             emp2.setDepartment(rrhhDept);
//             emp2.setSalarioBase(3800.0);
//             emp2.setFechaContratacion("2022-06-20");
//             employeeService.createEmployee(emp2);

//             TemporaryEmployee emp3 = new TemporaryEmployee();
//             emp3.setNombre("Carlos");
//             emp3.setApellido("Lopez");
//             emp3.setEmail("carlos.lopez@compuwork.com");
//             emp3.setTelefono("555666777");
//             emp3.setPuntuacionDesempeno(7.8);
//             emp3.setDepartment(ventasDept);
//             emp3.setDuracionContrato(6);
//             emp3.setTarifaPorHora(25.0);
//             emp3.setAgenciaContratante("Agencia Temporal SA");
//             employeeService.createEmployee(emp3);

//             System.out.println("=== Datos de prueba cargados correctamente ===");
//             System.out.println("Departamentos creados: 3");
//             System.out.println("Empleados creados: 3");
//         } else {
//             System.out.println("=== Los datos ya existen, no se cargaron datos de prueba ===");
//         }
//     }
// }

package com.compuwork.config;

import com.compuwork.model.PermanentEmployee;
import com.compuwork.model.TemporaryEmployee;
import com.compuwork.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private EmployeeService employeeService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("=== DataInitializer ejecutandose ===");
        
        // Verificar si ya hay empleados
        if (employeeService.getAllEmployees().isEmpty()) {
            System.out.println("Creando empleados de prueba...");
            
            // Empleado 1 - Permanente
            PermanentEmployee emp1 = new PermanentEmployee();
            emp1.setNombre("Juan");
            emp1.setApellido("Perez");
            emp1.setEmail("juan.perez@compuwork.com");
            emp1.setTelefono("123456789");
            emp1.setPuntuacionDesempeno(8.5);
            employeeService.createEmployee(emp1);
            System.out.println("  - Creado: Juan Perez (ID: " + emp1.getId() + ")");

            // Empleado 2 - Permanente
            PermanentEmployee emp2 = new PermanentEmployee();
            emp2.setNombre("Maria");
            emp2.setApellido("Gomez");
            emp2.setEmail("maria.gomez@compuwork.com");
            emp2.setTelefono("987654321");
            emp2.setPuntuacionDesempeno(9.2);
            employeeService.createEmployee(emp2);
            System.out.println("  - Creado: Maria Gomez (ID: " + emp2.getId() + ")");

            // Empleado 3 - Temporal
            TemporaryEmployee emp3 = new TemporaryEmployee();
            emp3.setNombre("Carlos");
            emp3.setApellido("Lopez");
            emp3.setEmail("carlos.lopez@compuwork.com");
            emp3.setTelefono("555666777");
            emp3.setPuntuacionDesempeno(7.8);
            emp3.setDuracionContrato(6);
            emp3.setTarifaPorHora(25.0);
            emp3.setAgenciaContratante("Agencia Temporal SA");
            employeeService.createEmployee(emp3);
            System.out.println("  - Creado: Carlos Lopez (ID: " + emp3.getId() + ")");
            
            System.out.println("=== Total empleados creados: " + employeeService.getAllEmployees().size() + " ===");
        } else {
            System.out.println("Ya existen " + employeeService.getAllEmployees().size() + " empleados");
        }
        
        // Mostrar todos los empleados
        System.out.println("=== Lista de empleados en memoria ===");
        for (var e : employeeService.getAllEmployees()) {
            System.out.println("  ID: " + e.getId() + " - " + e.getNombre() + " " + e.getApellido() + " - Puntuacion: " + e.getPuntuacionDesempeno());
        }
    }
}