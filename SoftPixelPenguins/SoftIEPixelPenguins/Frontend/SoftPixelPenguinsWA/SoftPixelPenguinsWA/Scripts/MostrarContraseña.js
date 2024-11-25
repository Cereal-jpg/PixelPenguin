document.addEventListener("DOMContentLoaded", function () {
    const togglePassword = document.querySelector('#togglePassword');
    const passwordField = document.querySelector('#txtContrasena');

    togglePassword.addEventListener('click', function () {
        // Cambia el atributo 'type' del campo contraseña
        const type = passwordField.getAttribute('type') === 'password' ? 'text' : 'password';
        passwordField.setAttribute('type', type);
        // Cambia el ícono
        this.classList.toggle('fa-eye-slash');
    });
});
