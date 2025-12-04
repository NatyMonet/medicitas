// Archivo: js/app.js
// Autor: Nataia Mejia
// Descripción: funciones javaScript para el sistema MediCitas

//Esperamos a que el documento HTML esté completamente cargado
// Esto evita errores si el JavaScript se ejecuta antes que el HTML
document.addEventListener('DOMContentLoaded', function() {
    
// INTERACCIÓN 1: Manejo del formulario de citas
// Buscamos el formulario por su ID 'formCitas'
// addEventListener significa "escuchar cuando algo pase"
// 'submit' es el evento cuando el usuario envía el formulario
document.getElementById('formCitas').addEventListener('submit', function(evento) {
        
// preventDefault() evita que el formulario se envíe de verdad
// Sin esto, la página se recargaría
// evento.preventDefault();

// Obtenemos los valores que el usuario escribió
// getElementById busca elementos por su atributo id=""
// .value obtiene lo que escribió el usuario
var nombrePaciente = document.getElementById('nombre').value;
var cedulaPaciente = document.getElementById('cedula').value;
var especialidadSeleccionada = document.getElementById('especialidad').value;
var fechaSeleccionada = document.getElementById('fecha').value;
        
// Creamos objetos Date para comparar fechas
// new Date() crea un objeto fecha
var fechaCita = new Date(fechaSeleccionada);
var fechaHoy = new Date();
        
// Validación: la fecha de la cita debe ser futura
// Si la fecha seleccionada es menor que hoy, está mal
if (fechaCita < fechaHoy) {
// alert() muestra un mensaje emergente al usuario
alert('Error: No puede agendar citas en fechas pasadas');
// return detiene la función aquí
return;
}
        
// Si llegamos aquí, todo está bien
// Construimos el mensaje de confirmación
// var mensaje = 'Cita agendada exitosamente\n';
// mensaje = mensaje + '\nPaciente: ' + nombrePaciente;
// mensaje = mensaje + '\nCédula: ' + cedulaPaciente;
// mensaje = mensaje + '\nEspecialidad: ' + especialidadSeleccionada;
// mensaje = mensaje + '\nFecha: ' + fechaSeleccionada;
        
// Mostramos el mensaje
// alert(mensaje);
        
// this.reset() limpia todos los campos del formulario
// this.reset();
 });
});


// INTERACCIÓN 2: Efecto visual en el menú de navegación
// querySelectorAll busca TODOS los elementos que coincidan
// 'nav a' significa: todos los enlaces <a> dentro de <nav>
var enlaces = document.querySelectorAll('nav a');

// forEach recorre cada enlace uno por uno
// Es como decir "para cada enlace, haz esto:"
enlaces.forEach(function(enlace) {
// Cuando alguien hace clic en un enlace
enlace.addEventListener('click', function(evento) {
// Evitamos que el enlace navegue (por ahora)
evento.preventDefault();
        
// Mostramos en la consola del navegador qué enlace se presionó
// console.log escribe mensajes en la consola (F12)
console.log('El usuario hizo clic en: ' + this.textContent);
});
});

// INTERACCIÓN 3: Verificación de que el sistema cargó
// Esto ayuda a debuggear si algo no funciona
console.log('Sistema MediCitas iniciado correctamente');
console.log('Versión: 1.0');
console.log('Módulo: Gestión de citas médicas');