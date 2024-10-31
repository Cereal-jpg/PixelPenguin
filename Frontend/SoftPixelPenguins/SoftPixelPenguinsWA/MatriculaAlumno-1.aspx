<%@ Page Language="C#" MasterPageFile="~/SoftPixelPenguins.Master" AutoEventWireup="true" CodeBehind="MatriculaAlumno-1.aspx.cs" Inherits="SoftPixelPenguinsWA.MatriculaAlumno_1" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Matrícula - Alumno
</asp:Content>

<asp:Content ContentPlaceHolderID="menuItem1" runat="server">
    <a href="IndexAlumno.aspx"><i class="fa-solid fa-home"></i>Inicio</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem2" runat="server">
    <a href="ListarCursos.aspx"><i class="fa-solid fa-book"></i>Mis cursos</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem3" runat="server">
    <a href="ListarCursos.aspx"><i class="fa-solid fa-bar-chart"></i>Reporte de Notas</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem4" runat="server">
    <a href="MatriculaALumno-0.aspx"><i class="fa-solid fa-archive"></i>Matrícula Online</a>
</asp:Content>

<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <link rel="stylesheet" href="Content/Estilos-Alumno.css" />
    <script src="Scripts/BarraProgreso.js" type="text/javascript"></script>

    <h2 style="text-align: left; color: #000f; border-bottom: 2px solid #808080;">Matrícula Online</h2>
    <div id="container-proceso" class="container-proceso">
        <div class="matricula-section" style="padding: 5px;">
            <h3 style="border-bottom: 2px solid #ccc">Proceso de matrícula - Actualizar y Validar Datos Personales</h3>
            <div class="progress-wrapper">
                <div class="progress-container">
                    <div class="progress-bar" id="progress-bar"></div>
                    <div class="progress-step active">1</div>
                    <div class="progress-step">2</div>
                    <div class="progress-step">3</div>
                    <div class="progress-step">4</div>
                </div>
            </div>
            <p>Actualiza los datos personales de <nombre> y del apoderado:</p>

            <div class="datos-container">
                <div class="form-Datos-container">
                    <h4 style="width: 100%; font-size: 17px; border-bottom: 2px solid #808080">Datos del Alumno</h4>

                    <!-- Fila con tres campos alineados horizontalmente -->
                    <div class="form-row">
                        <div class="form-group">
                            <label for="nombre">Nombre:</label>
                            <input type="text" id="nombre" name="nombre" required />
                        </div>
                        <div class="form-group">
                            <label for="apellido-paterno">Apellido Paterno:</label>
                            <input type="text" id="apellido-paterno" name="apellidoPaterno" required />
                        </div>
                        <div class="form-group">
                            <label for="apellido-materno">Apellido Materno:</label>
                            <input type="text" id="apellido-materno" name="apellidoMaterno" required />
                        </div>
                    </div>

                    <!-- Fila con cuatro campos alineados horizontalmente -->
                    <div class="form-row">
                        <div class="form-group">
                            <label for="dni">DNI:</label>
                            <input type="text" id="dni" name="dni" required />
                        </div>
                        <div class="form-group">
                            <label for="fecha-nacimiento">Fecha de Nacimiento:</label>
                            <input type="date" id="fecha-nacimiento" name="fechaNacimiento" required />
                        </div>
                        <div class="form-group">
                            <label for="sexo">Sexo:</label>
                            <input type="text" id="sexo" name="sexo" required />
                        </div>
                        <div class="form-group">
                            <label for="email">Email:</label>
                            <input type="email" id="email" name="email" required />
                        </div>
                    </div>
                </div>
            </div>

            <div class="buttons">
                <button>Anterior</button>
                <button>Guardar</button>
                <button>Editar</button>
                <button onclick="nextStep2()">Grabar y Continuar</button>
            </div>
        </div>
    </div>

    <script>
        let formData = {
            nombre: '',
            apellidoPaterno: '',
            apellidoMaterno: '',
            dni: '',
            fechaNacimiento: '',
            sexo: '',
            email: ''
        };
        function nextStep4() {
            const container = document.getElementById('container-proceso');

            // Cambia el contenido del contenedor al siguiente paso
            container.innerHTML = `
                <div class="matricula-section" style="padding: 5px;">
                    <h3 style="border-bottom: 2px solid #ccc; width:100%">
                        Proceso de matrícula - Terminar Proceso
                    </h3>
                    <div class="progress-wrapper">
                        <div class="progress-container">
                            <div class="progress-bar" id="progress-bar"></div>
                            <div class="progress-step active">1</div>
                            <div class="progress-step active">2</div>
                            <div class="progress-step active">3</div>
                            <div class="progress-step active">4</div>
                        </div>
                    </div>
                    <p style="text-align:center;">
                        Gracias por concluir con los pasos correspondientes para el proceso de matrícula.
                        Usted ha sido matriculado en el periodo 2025 con éxito. Se le enviará un correo
                        con toda la información de su matrícula.
                    </p>
                    <div class="buttons">
                        <asp:Button ID="btnTerminarProceso" runat="server" Text="Terminar proceso de matrícula"
                            OnClick="btnTerminarProceso_Click"
                            style="background-color: #87CEEB; color: white; padding: 10px 20px; border: none; border-radius: 5px; cursor: pointer; margin: 10px auto;" />
                    </div>
                </div>
            `;
        }

    </script>
</asp:Content>
