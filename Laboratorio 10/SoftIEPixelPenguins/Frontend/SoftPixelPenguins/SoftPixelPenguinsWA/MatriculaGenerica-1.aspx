<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="MatriculaGenerica-1.aspx.cs" Inherits="SoftPixelPenguinsWA.MatriculaGenerica_1" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Proceso de Matrícula</title>
    <style>
    * {
        box-sizing: border-box;
        font-family: Arial, sans-serif;
    }

    .header {
        background-color: #000072; /* Color de fondo azul */
        display: flex; /* Flexbox para alineación */
        left: 0;
        padding: 15px; /* Espaciado interno */
        color: white; /* Color de texto blanco */
        position: fixed; /* Fija el div en la parte superior */
        top: 0; /* Ubica el header en la parte superior */
        width: 100%; /* Ancho completo */
        z-index: 1000; /* Asegura que esté por encima de otros elementos */
        align-items: center; /* Centra verticalmente el contenido */
        justify-content: flex-start; /* Espacia el contenido de izquierda a derecha */
        margin-right: 10px;
    }

    /* Estilo para la imagen en el header */
    .header img {
        height: 40px; /* Altura de la imagen del logo */
        margin-right: 10px; /* Espacio a la derecha del logo */
        
    }

    /* Estilo para el título del header */
    .header h1 {
        font-size: 24px; /* Tamaño de fuente */
        margin: 0; /* Sin margen por defecto */
    }

    /* Navegación en el header */
    .nav {
        margin-left: auto;
        margin-right: 30px;
        display: flex; /* Flexbox para navegación */
        gap: 20px; /* Espacio entre los enlaces */
    }

    /* Estilos para los enlaces de navegación */
    .nav a {
        text-decoration: none; /* Sin subrayado */
        color: white; /* Color de texto blanco */
        font-weight: bold; /* Texto en negrita */
    }
    
    .container {
        width: 80%;
        margin: auto;
        margin-top: 100px;
        background-color: #e8f0ff;
        padding: 15px;
        border-radius: 8px;
    }

    h2 {
        text-align: left;
        color: #333;
    }

    .progress-bar {
        display: flex;
        justify-content: center;
        margin: 20px 0;
    }

    .step {
        width: 30px;
        height: 30px;
        margin: 0 10px;
        border-radius: 50%;
        background-color: #ccc;
    }

    .step.active {
        background-color: #4caf50;
    }

    .section {
        display: none;
    }

    .section.active {
        display: block;
    }

    .form-section {
        background-color: #cfe2f3;
        padding: 15px;
        padding-top: 5px;
        margin: 15px;
        border-radius: 8px;
    }

    .form-group{
        display: flex;
        width: 100%;
        gap: 10px;
        margin-bottom: 15px;
    }

    .form-row{
        flex: 1;
        min-width: 160px;
    }

    label {
        display: block;
        margin: 10px 0;
        color: black;
    }

    input[type="text"], input[type="date"], input[type="email"], input[type="file"] {
        width: 100%;
        padding: 8px;
        border: none;
        border-radius: 4px;
    }

    .button-group {
        text-align: center;
        margin-top: 20px;
    }

    button, .button-style {
        padding: 10px 20px;
        margin: 0 5px;
        background-color: #666;
        background-color: #007bff;
        color: #fff;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }

    button:hover {
        background-color: #0056b3;
    }

    .file-upload {
        display: inline-block;
        width: 100%;
        padding: 10px;
        font-size: 14px;
        color: #555;
        background-color: #f5f5f5;
        border: 1px solid #ccc;
        border-radius: 5px;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }

    #section-3{
        text-align: center;
        padding: 20px;
    }

    </style>
</head>
<body>
<div class="header">
    <img src="Images/PIXEL.png" alt="Logo" />
    <h1>Pixel Penguins</h1>
    <div class="nav">
        <a href="Login.aspx">Intranet</a>
        <a href="Matricularce.aspx">Matrícula</a>
    </div>
</div>
<form id="form1" runat="server">
    <div class="container">
        <h2>Proceso de matrícula - <span id="section-title">Datos Personales</span></h2><hr>

        <!-- Barra de progreso lateral -->
        <div class="sidebar-progress">
            <div class="progress-bar">
                <span class="step active"></span>
                <span class="step"></span>
                <span class="step"></span>
                <span class="step"></span>
            </div>
        </div>

        <!-- Contenido Principal -->
        <div class="main-content">
            <!-- Sección de Datos Personales -->
            <div id="section-1" class="section active">
                <div class="form-section">
                    <h3>Datos del alumno</h3><hr>
                    <div class="form-group">
                        <div class="form-row">
                            <label>Nombres:</label>
                            <asp:TextBox ID="txtNombreAlumno" runat="server" placeholder="Nombres"></asp:TextBox>
                        </div>
                        <div class="form-row">
                            <label>Apellido Paterno:</label>
                            <asp:TextBox ID="txtApellidoPaterno" runat="server" placeholder="Apellido Paterno"></asp:TextBox>
                        </div>
                        <div class="form-row">
                            <label>Apellido Materno:</label>
                            <asp:TextBox ID="txtApellidoMaterno" runat="server" placeholder="Apellido Materno"></asp:TextBox>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="form-row">
                            <label>DNI:</label>
                            <asp:TextBox ID="txtDNIAlumno" runat="server" placeholder="DNI"></asp:TextBox>
                        </div>
                        <div class="form-row">
                            <label>Fecha de Nacimiento:</label>
                            <asp:TextBox ID="dtpFechaNacimiento" runat="server" placeholder="Fecha de Nacimiento" CssClass="date-picker" TextMode="Date"></asp:TextBox>
                        </div>
                        <div class="form-row">
                            <label>Sexo:</label>
                            <asp:TextBox ID="txtSexo" runat="server" placeholder="Sexo"></asp:TextBox>
                        </div>
                        <div class="form-row">
                            <label>Email:</label>
                            <asp:TextBox ID="txtEmail" runat="server" placeholder="Email"></asp:TextBox>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="form-row">
                            <label>Direccion:</label>
                            <asp:TextBox ID="txtDireccion" runat="server" placeholder="Direccion"></asp:TextBox>
                        </div>
                    </div>
                </div>
                <div class="form-section">
                    <h3>Datos del Apoderado</h3><hr>
                    <div class="form-group">
                        <div class="form-row">
                            <label>DNI:</label>
                            <asp:TextBox ID="txtDNIApoderado" runat="server" placeholder="DNI"></asp:TextBox>
                        </div>
                        <div class="form-row">
                            <label>Nombre Completo:</label>
                            <asp:TextBox ID="txtNombreApoderado" runat="server" placeholder="Nombre completo"></asp:TextBox>
                        </div>
                        <div class="form-row">
                            <label>Teléfono:</label>
                            <asp:TextBox ID="txtTelefonoApoderado" runat="server" placeholder="Teléfono"></asp:TextBox>
                        </div>
                        <div class="form-row">
                            <label>Relacion:</label>
                            <asp:TextBox ID="txtRelacionApoderado" runat="server" placeholder="Relacion"></asp:TextBox>
                        </div>
                    </div>
                </div>
                <div class="button-group">
                    <button onclick="prevSection(event)" CssClass="button-style">Regresar</button>
                    <button onclick="nextSection(event)">Grabar y Continuar</button>
                </div>
            </div>

            <!-- Sección de Adjuntar Certificados -->
            <div id="section-2" class="section">
                <div class="form-section">
                    <h3>Adjuntar Certificados</h3><hr>
                    <div class="form-row">
                        <label for="fileCertificadoEstudios">Certificado de Estudios:</label>
                        <asp:FileUpload ID="fileCertificadoEstudios" runat="server" CssClass="file-upload" />
                    </div>
                    <div class="form-row">
                        <label for="fileCertificadoSalud">Certificado de Salud:</label>
                        <asp:FileUpload ID="fileCertificadoSalud" runat="server" CssClass="file-upload" />
                    </div>
                </div>
                <div class="button-group">
                    <button onclick="prevSection(event)">Regresar</button>
                    <asp:Button ID="btnGuardar" runat="server" Text="Guardar" OnClick="btnGuardar_Click" CssClass="button-style" />
                </div>
            </div>

            <!-- Sección de Confirmación -->
            <div id="section-3" class="section">
                <p>Sus datos personales y certificados han sido enviados a revisión. En un periodo de 24 horas podrá ver, por este medio, el estado de su proceso de matrícula.</p>
                <button>Volver al Inicio</button>
            </div>
        </div>
    </div>
</form>
<script>
    let currentSection = 1;

    function nextSection(event) {
        if (event) event.preventDefault();
        document.getElementById(`section-${currentSection}`).classList.remove('active');
        document.querySelector(`.progress-bar .step:nth-child(${currentSection})`).classList.remove('active');
        currentSection += 1;
        document.getElementById(`section-${currentSection}`).classList.add('active');
        document.querySelector(`.progress-bar .step:nth-child(${currentSection})`).classList.add('active');
        updateSectionTitle();
    }

    function prevSection() {
        document.getElementById(`section-${currentSection}`).classList.remove('active');
        document.querySelector(`.progress-bar .step:nth-child(${currentSection})`).classList.remove('active');
        currentSection -= 1;
        document.getElementById(`section-${currentSection}`).classList.add('active');
        document.querySelector(`.progress-bar .step:nth-child(${currentSection})`).classList.add('active');
        updateSectionTitle();
    }

    function volverInicio() {
        currentSection = 1;
        document.querySelectorAll('.section').forEach(section => section.classList.remove('active'));
        document.getElementById('section-1').classList.add('active');
        document.querySelectorAll('.progress-bar .step').forEach(step => step.classList.remove('active'));
        document.querySelector('.progress-bar .step:nth-child(1)').classList.add('active');
        updateSectionTitle();
    }

    function updateSectionTitle() {
        const titles = {
            1: "Datos Personales",
            2: "Certificados",
            3: "Confirmación"
        };
        document.getElementById('section-title').textContent = titles[currentSection];
    }

</script>
</body>
</html>
